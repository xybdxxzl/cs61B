package capers;

import java.io.File;
import static capers.Utils.*;

/** Capers 的仓库（repository）。
 * @author TODO
 * Capers 仓库的结构如下：
 *
 * .capers/ -- 存放你 lab12 文件夹中所有持久化数据的顶层文件夹
 *    - dogs/ -- 包含所有狗的持久化数据的文件夹
 *    - story -- 包含当前故事的文件
 *
 * TODO: 如果你采用了不同的做法，请修改上述结构。
 */
public class CapersRepository {
    /** 当前工作目录（Current Working Directory）。 */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** 主元数据文件夹。 */
    static final File CAPERS_FOLDER = null; // TODO 提示：查看 Utils 中的
                                            //      `join` 函数

    /**
     * 执行所需的文件系统操作以支持持久化。
     * （创建任何必要的文件夹或文件）
     * 记住：推荐的结构（你不必遵循）：
     *
     * .capers/ -- 存放你 lab12 文件夹中所有持久化数据的顶层文件夹
     *    - dogs/ -- 包含所有狗的持久化数据的文件夹
     *    - story -- 包含当前故事的文件
     */
    public static void setupPersistence() {
        // TODO
    }

    /**
     * 将 args 中第一个非命令参数追加到
     * .capers 目录中名为 `story` 的文件。
     * @param text 要追加到故事中的文本字符串
     */
    public static void writeStory(String text) {
        // TODO
    }

    /**
     * 使用 args 中前三个非命令参数（name、breed、age）
     * 创建并持久化保存一只狗。
     * 同时使用 toString() 打印出该狗的信息。
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
    }

    /**
     * 持久地增加一只狗的年龄并打印一条庆祝消息。
     * 同时使用 toString() 打印出该狗的信息。
     * 根据 args 中第一个非命令参数选择要增加年龄的狗。
     * @param name 我们要为其庆祝生日的狗的字符串名字。
     */
    public static void celebrateBirthday(String name) {
        // TODO
    }
}
