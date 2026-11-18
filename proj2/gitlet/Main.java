package gitlet;

/** Gitlet 的驱动类，Gitlet 是 Git 版本控制系统的一个子集。
 *  @author TODO
 */
public class Main {

    /** 用法：java gitlet.Main ARGS，其中 ARGS 包含
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: 如果 args 为空怎么办？
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                // TODO: 处理 `init` 命令
                break;
            case "add":
                // TODO: 处理 `add [filename]` 命令
                break;
            // TODO: 填写其余部分（FILL THE REST IN）
        }
    }
}
