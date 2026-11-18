package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * 一个客户端，使用合成器（synthesizer）包来模拟拨动吉他弦的声音
 */
public class GuitarHeroLite {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);

    public static void main(String[] args) {
        /* 创建两根吉他弦，分别对应音乐会音高 A 和 C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        while (true) {

            /* 检查用户是否按下了某个键；若有则处理它 */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                }
            }

            /* 计算样本的叠加 */
            double sample = stringA.sample() + stringC.sample();

            /* 在标准音频上播放该样本 */
            StdAudio.play(sample);

            /* 将每根吉他弦的模拟推进一步 */
            stringA.tic();
            stringC.tic();
        }
    }
}

