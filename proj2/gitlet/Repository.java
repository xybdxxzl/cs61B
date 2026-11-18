package gitlet;

import java.io.File;
import static gitlet.Utils.*;

// TODO: 在此处填写你需要的任何 import

/** 表示一个 gitlet 仓库（repository）。
 *  TODO: 在这里从高层描述一下这个类还做了
 *  哪些事，是个好主意。
 *
 *  @author TODO
 */
public class Repository {
    /**
     * TODO: 在此处添加实例变量。
     *
     * 在此列出 Repository 类的所有实例变量，并在每个变量上方附上一段
     * 有用的注释，描述该变量代表什么以及如何
     * 使用。我们已经为你提供了两个示例。
     */

    /** 当前工作目录。 */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** .gitlet 目录。 */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: 填写本类的其余部分。 */
}
