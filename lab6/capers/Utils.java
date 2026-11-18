package capers;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;


/** 各种实用工具（utilities）。
 *  @author P. N. Hilfinger
 */
class Utils {

    /* 读取和写入文件内容 */

    /** 以字节数组形式返回 FILE 的全部内容。FILE 必须
     *  是一个普通文件。若出现问题
     *  则抛出 IllegalArgumentException。 */
    static byte[] readContents(File file) {
        if (!file.isFile()) {
            throw new IllegalArgumentException("must be a normal file");
        }
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException excp) {
            throw new IllegalArgumentException(excp.getMessage());
        }
    }

    /** 以字符串形式返回 FILE 的全部内容。FILE 必须
     *  是一个普通文件。若出现问题
     *  则抛出 IllegalArgumentException。 */
    static String readContentsAsString(File file) {
        return new String(readContents(file), StandardCharsets.UTF_8);
    }

    /** 将 CONTENTS 中各字节拼接的结果写入 FILE，
     *  按需创建或覆盖它。CONTENTS 中的每个对象
     *  可以是 String 或字节数组。若出现问题
     *  则抛出 IllegalArgumentException。 */
    static void writeContents(File file, Object... contents) {
        try {
            if (file.isDirectory()) {
                throw
                        new IllegalArgumentException("cannot overwrite directory");
            }
            BufferedOutputStream str =
                    new BufferedOutputStream(Files.newOutputStream(file.toPath()));
            for (Object obj : contents) {
                if (obj instanceof byte[]) {
                    str.write((byte[]) obj);
                } else {
                    str.write(((String) obj).getBytes(StandardCharsets.UTF_8));
                }
            }
            str.close();
        } catch (IOException | ClassCastException excp) {
            throw new IllegalArgumentException(excp.getMessage());
        }
    }

    /** 返回从 FILE 读取并转换为 EXPECTEDCLASS 的 T 类型对象。
     *  若出现问题则抛出 IllegalArgumentException。 */
    static <T extends Serializable> T readObject(File file,
                                                 Class<T> expectedClass) {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(file));
            T result = expectedClass.cast(in.readObject());
            in.close();
            return result;
        } catch (IOException | ClassCastException
                | ClassNotFoundException excp) {
            throw new IllegalArgumentException(excp.getMessage());
        }
    }

    /** 将 OBJ 写入 FILE。 */
    static void writeObject(File file, Serializable obj) {
        writeContents(file, serialize(obj));
    }


    /* 其他文件实用工具 */

    /** 将 FIRST 与 OTHERS 拼接为一个 File 指示符，
     *  类似于 {@link java.nio.file.Paths.#get(String, String[])}
     *  方法。 */
    static File join(String first, String... others) {
        return Paths.get(first, others).toFile();
    }

    /** 将 FIRST 与 OTHERS 拼接为一个 File 指示符，
     *  类似于 {@link java.nio.file.Paths.#get(String, String[])}
     *  方法。 */
    static File join(File first, String... others) {
        return Paths.get(first.getPath(), others).toFile();
    }


    /* 序列化实用工具 */

    /** 返回包含 OBJ 序列化内容的字节数组。 */
    static byte[] serialize(Serializable obj) {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(stream);
            objectStream.writeObject(obj);
            objectStream.close();
            return stream.toByteArray();
        } catch (IOException excp) {
            throw error("Internal error serializing commit.");
        }
    }



    /* 消息与错误报告 */

    /**
     * 打印 MESSAGE 并以错误码 -1 退出。
     * 注意：
     *     在 Gitlet 中报错/退出码的功能有所不同，
     *     因此不要将此作为参考。
     *     更多信息请参阅 spec（作业说明）。
     * @param message 要打印的消息
     */
    public static void exitWithError(String message) {
        if (message != null && !message.equals("")) {
            System.out.println(message);
        }
        System.exit(-1);
    }

    /** 返回一个 RuntimeException，其消息由 MSG 和 ARGS 按照
     *  String.format 方法的方式组合而成。 */
    static RuntimeException error(String msg, Object... args) {
        return new RuntimeException(String.format(msg, args));
    }

}
