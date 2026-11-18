package gh2;

// TODO: 当你准备好开始这一部分时，取消下面 import 的注释
// import deque.Deque;
// TODO: 可能还需要更多 import

//注意：在你完成 Deque 的实现之前，本文件无法通过编译
public class GuitarString {
    /** 常量。不要修改。如果你好奇的话，关键字 final
     * 意味着这些值在运行时不能被修改。我们将在周五的课
     * 上讨论这一点以及其他话题。 */
    private static final int SR = 44100;      // 采样率（Sampling Rate）
    private static final double DECAY = .996; // 能量衰减因子

    /* 用于存储声音数据的缓冲区。 */
    // TODO: 当你准备好开始这一部分时，取消下面这一行的注释
    // private Deque<Double> buffer;

    /* 创建一根给定频率的吉他弦。  */
    public GuitarString(double frequency) {
        // TODO: 创建一个容量为 SR / frequency 的缓冲区。你需要把
        //       这个除法运算的结果强制转换为 int。为了
        //       更精确，在强制转换之前使用 Math.round() 函数。
        //       你应该先将缓冲区数组初始化为全零。
    }


    /* 通过用白噪声替换缓冲区来拨动吉他弦。 */
    public void pluck() {
        // TODO: 将缓冲区中的所有元素出队，并替换为 -0.5 到 0.5
        //       之间的随机数。你可以用如下方式得到这样的数：
        //       double r = Math.random() - 0.5;
        //
        //       确保你的随机数彼此不同。这并不意味着你需要检查这些数
        //       彼此不同。它的意思是，你应该反复调用
        //       Math.random() - 0.5 来为每个数组下标生成新的随机数。
    }

    /* 通过执行一次 Karplus-Strong 算法，将模拟推进
     * 一个时间步。
     */
    public void tic() {
        // TODO: 将前端的样本出队，并入队一个新样本，新样本是
        //       这两个样本的平均值乘以 DECAY 因子。
        //       **不要调用 StdAudio.play()。**
    }

    /* 返回缓冲区前端的那个 double。 */
    public double sample() {
        // TODO: 返回正确的东西。
        return 0;
    }
}
    // TODO: 完成后，删除所有写着 TODO 的注释。
