package capers;

import java.io.File;
import java.io.Serializable;
import static capers.Utils.*;

/** 表示一只可被序列化的狗。
 * @author TODO
*/
public class Dog { // TODO

    /** 狗所存放的文件夹。 */
    static final File DOG_FOLDER = null; // TODO（提示：查看 Utils 中的
                                         //      `join` 函数）

    /** 狗的年龄。 */
    private int age;
    /** 狗的品种。 */
    private String breed;
    /** 狗的名字。 */
    private String name;

    /**
     * 使用指定的参数创建一个狗对象。
     * @param name 狗的名字
     * @param breed 狗的品种
     * @param age 狗的年龄
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * 从 DOG_FOLDER 中名为 NAME 的文件读取并反序列化一只狗。
     *
     * @param name 要加载的狗的名字
     * @return 从文件读取的狗
     */
    public static Dog fromFile(String name) {
        // TODO（提示：查看 Utils 文件）
        return null;
    }

    /**
     * 增加一只狗的年龄并庆祝！
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * 将一只狗保存到文件以供将来使用。
     */
    public void saveDog() {
        // TODO（提示：别忘了狗的名字是唯一的）
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            name, breed, age);
    }

}
