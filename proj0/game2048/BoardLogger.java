package game2048;

import java.util.Observer;
import java.util.Observable;

/** 一个观察者（observer），用于打印 Model 的变化。
 *  @author P. N. Hilfinger
 */
class BoardLogger implements Observer {

    /** 用于分隔每次移动的一条线。 */
    private static final String LINE = "---------------------";

    @Override
    /** 在每次移动后打印棋盘状态及其变化方式。 */
    public void update(Observable obs, Object arg) {
        Model model = (Model) obs;
        String direction;
        if (arg == null) {
            direction = "Randomly generated tiles placed on board";
        } else {
            direction = String.format("Board tilted %s", arg);
        }
        System.out.printf("%n%s%n%s%s", LINE, direction, model);
    }

}
