package Dog;

public class Dog {
    private int size;

    public Dog(int s) {
        size = s;
    }

    /** 发出叫声。 */
    public String noise() {
        if (size < 10) {
            return "yip";
        } 
        return "bark";
    }
}
