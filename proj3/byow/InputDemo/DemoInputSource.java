package byow.InputDemo;

/**
 * 由 hug 创建。
 * 演示如何用单个接口来提供来自键盘、来自随机序列、
 * 来自字符串或来自其他任何来源的输入。
 */
public class DemoInputSource {
    private static final int KEYBOARD = 0;
    private static final int RANDOM = 1;
    private static final int STRING = 2;

    public static void main(String[] args) {
        int inputType = KEYBOARD;

        InputSource inputSource;

        if (inputType == KEYBOARD) {
            inputSource = new KeyboardInputSource();
        } else if (inputType == RANDOM) {
            inputSource = new RandomInputSource(50L);
        } else { // inputType == STRING（字符串）
            inputSource = new StringInputDevice("HELLO MY FRIEND. QUACK QUACK");
        }

        int totalCharacters = 0;

        while (inputSource.possibleNextInput()) {
            totalCharacters += 1;
            char c = inputSource.getNextKey();
            if (c == 'M') {
                System.out.println("moo");
            }
            if (c == 'Q') {
                System.out.println("done.");
                break;
            }
        }

        System.out.println("Processed " + totalCharacters + " characters.");
    }
}
