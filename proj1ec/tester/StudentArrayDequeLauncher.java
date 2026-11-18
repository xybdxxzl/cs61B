package tester;

import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

/** 如果你的项目设置正确，本文件应该可以执行。
* 你或许可以考虑的一件事是尝试打印出操作的
* 序列 */
public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
            } else {
                sad1.addFirst(i);
            }
        }

        sad1.printDeque();
    }
} 
