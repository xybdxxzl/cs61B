package capers;

import java.io.File;

import static capers.Utils.*;

/** Canine Capers：Gitlet 的前奏。
 * @author TODO
*/
public class Main {
    /**
     * 运行以下三条命令之一：
     * story [text] -- 将 "text" 加一个换行符追加到
     *                 .capers 目录中的 story 文件。此外，打印出
     *                 当前的故事。
     *
     * dog [name] [breed] [age] -- 持久地创建一只具有
     *                             指定参数的狗；还应打印
     *                             该狗的 toString()。假设狗的名字
     *                             是唯一的。
     *
     * birthday [name] -- 持久地增加一只狗的年龄
     *                    并打印一条庆祝消息。
     *
     * 所有持久化数据都应存储在
     * 当前工作目录下的 ".capers" 目录中。
     *
     * 推荐的结构（你不必遵循）：
     *
     * *你不应手动创建这些，
     *  你的程序应该创建这些文件夹/文件*
     *
     * .capers/ -- 存放你 lab12 文件夹中所有持久化数据的顶层文件夹
     *    - dogs/ -- 包含所有狗的持久化数据的文件夹
     *    - story -- 包含当前故事的文件
     *
     * @param args 来自命令行的参数
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            Utils.exitWithError("Must have at least one argument");
        }

        CapersRepository.setupPersistence();
        String text;
        switch (args[0]) {
        case "story":
            /* 这个调用已经为你处理好。其余的将与之类似。 */
            validateNumArgs("story", args, 2);
            text = args[1];
            CapersRepository.writeStory(text);
            break;
        case "dog":
            validateNumArgs("dog", args, 4);
            // TODO: 创建一只狗
            break;
        case "birthday":
            validateNumArgs("birthday", args, 2);
            // TODO: 为这只狗庆祝生日
            break;
        default:
            exitWithError(String.format("Unknown command: %s", args[0]));
        }
        return;
    }

    /**
     * 检查参数数量与预期数量是否相符，
     * 如果不匹配则抛出 RuntimeException。
     *
     * @param cmd 你正在校验的命令名称
     * @param args 来自命令行的参数数组
     * @param n 预期的参数个数
     */
    public static void validateNumArgs(String cmd, String[] args, int n) {
        if (args.length != n) {
            throw new RuntimeException(
                String.format("Invalid number of arguments for: %s.", cmd));
        }
    }
}
