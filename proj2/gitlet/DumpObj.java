package gitlet;

import java.io.File;

/** 一个调试类，其 main 程序可按如下方式调用：
 *      java gitlet.DumpObj FILE...
 *  其中每个 FILE 是由 Utils.writeObject 生成的文件（或任何包含
 *  序列化对象的文件）。这将简单地读取 FILE、
 *  反序列化它，并对得到的 Object 调用 dump 方法。
 *  为此，该对象必须实现 gitlet.Dumpable 接口。
 *  例如，你可以像这样定义你的类：
 *
 *        import java.io.Serializable;
 *        import java.util.TreeMap;
 *        class MyClass implements Serializeable, Dumpable {
 *            ...
 *            @Override
 *            public void dump() {
 *               System.out.printf("size: %d%nmapping: %s%n", _size, _mapping);
 *            }
 *            ...
 *            int _size;
 *            TreeMap<String, String> _mapping = new TreeMap<>();
 *        }
 *
 *  如示例所示，你的 dump 方法应打印出你类中对象的有用信息。
 *  @author P. N. Hilfinger
 */
public class DumpObj {

    /** 对 FILES 中每个文件的内容进行反序列化并
     *  应用 dump。 */
    public static void main(String... files) {
        for (String fileName : files) {
            Dumpable obj = Utils.readObject(new File(fileName),
                                            Dumpable.class);
            obj.dump();
            System.out.println("---");
        }
    }
}

