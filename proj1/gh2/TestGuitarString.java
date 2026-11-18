package gh2;

/* 从 edu.princeton.cs.introcs 包中导入所需的
 * 音频库。 */
import edu.princeton.cs.introcs.StdAudio;

import org.junit.Test;
import static org.junit.Assert.*;

/** 测试 GuitarString 类。
 *  @author Josh Hug
 */
public class TestGuitarString  {

    @Test
    public void testPluckTheAString() {
        GuitarString aString = new GuitarString(GuitarHeroLite.CONCERT_A);
        aString.pluck();
        for (int i = 0; i < 50000; i += 1) {
            StdAudio.play(aString.sample());
            aString.tic();
        }
    }

    @Test
    public void testSample() {
        GuitarString s = new GuitarString(100);
        assertEquals(0.0, s.sample(), 0.0);
        assertEquals(0.0, s.sample(), 0.0);
        assertEquals(0.0, s.sample(), 0.0);
        s.pluck();
        double sample = s.sample();
        assertNotEquals("After plucking, your samples should not be 0.", 0.0, sample);

        assertEquals("Sample should not change the state of your string.", sample, s.sample(), 0.0);
        assertEquals("Sample should not change the state of your string.", sample, s.sample(), 0.0);
    }


    @Test
    public void testTic() {
        GuitarString s = new GuitarString(100);
        assertEquals(0.0, s.sample(), 0.0);
        assertEquals(0.0, s.sample(), 0.0);
        assertEquals(0.0, s.sample(), 0.0);
        s.pluck();
        double sample1 = s.sample();
        assertNotEquals("After plucking, your samples should not be 0.", 0.0, sample1);

        s.tic();
        assertNotEquals("After tic(), your samples should not stay the same.", sample1, s.sample());
    }


    @Test
    public void testTicCalculations() {
        // 创建一个频率为 11025 的 GuitarString，它对应
        // 一个长度为 4 的 Deque。
        GuitarString s = new GuitarString(11025);
        s.pluck();

        // 记录前四个值，每记录一个就调用一次 tic。
        double s1 = s.sample();
        s.tic();
        double s2 = s.sample();
        s.tic(); 
        double s3 = s.sample();
        s.tic();
        double s4 = s.sample();

        // 如果我们再调用一次 tic，它应该等于 0.996*0.5*(s1 + s2)
        s.tic();

        double s5 = s.sample();
        double expected = 0.996 * 0.5 * (s1 + s2);

        // 使用 0.001 的容差检查新样本是否正确。
        // 关于 assertEquals(double, double) 中容差如何工作的说明，
        // 请参见 JUnit 文档
        assertEquals("Wrong tic value. Try running the testTic method.", expected, s5, 0.001);
    }
}

