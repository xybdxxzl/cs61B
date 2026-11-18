package gitlet;

/** 表示 Gitlet 错误的一般异常。对于致命错误，
 *  .getMessage() 的结果就是要打印的错误消息。
 *  @author P. N. Hilfinger
 */
class GitletException extends RuntimeException {


    /** 一个不带消息的 GitletException。 */
    GitletException() {
        super();
    }

    /** 一个以 MSG 作为消息的 GitletException。 */
    GitletException(String msg) {
        super(msg);
    }

}
