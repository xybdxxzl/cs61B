package game2048;

import ucb.gui2.TopLevel;
import ucb.gui2.LayoutSpec;

import java.util.Observable;
import java.util.Observer;

import java.util.concurrent.ArrayBlockingQueue;

import java.awt.event.KeyEvent;


/** 2048 棋盘和按钮的 GUI 控制器。
 *  @author P. N. Hilfinger
 */
class GUI extends TopLevel implements Observer {

    /** 棋盘的最小尺寸（以像素为单位）。 */
    private static final int MIN_SIZE = 500;

    /** 一个具有给定 TITLE、提供 MODEL 视图的新窗口。 */
    GUI(String title, Model model) {
        super(title, true);
        addMenuButton("Game->New", this::newGame);
        addMenuButton("Game->Quit", this::quit);

        addLabel("", "Score", new LayoutSpec("y", 1));

        _model = model;
        _model.addObserver(this);

        _widget = new BoardWidget(model.size());
        add(_widget,
            new LayoutSpec("y", 0,
                           "height", "REMAINDER",
                           "width", "REMAINDER"));

        _widget.requestFocusInWindow();
        _widget.setKeyHandler("keypress", this::keyPressed);
        setPreferredFocus(_widget);
        setScore(0, 0);
    }

    /** 对 "Quit" 按钮点击的响应。 */
    public void quit(String dummy) {
        _pendingKeys.offer("Quit");
        _widget.requestFocusInWindow();
    }

    /** 对 "New Game" 按钮点击的响应。 */
    public void newGame(String dummy) {
        _pendingKeys.offer("New Game");
        _widget.requestFocusInWindow();
    }

    /** 响应用户按下按键 E，将该按键加入我们的
     *  待处理按键队列。*/
    public void keyPressed(String unused, KeyEvent e) {
        _pendingKeys.offer(e.getKeyText(e.getKeyCode()));
    }

    /** 返回下一个待处理事件，必要时等待它。
     *  普通按键以所按下字符的键码形式报告。此外，
     *  菜单按钮点击会产生消息 "Quit" 或 "New Game"。 */
    String readKey() {
        try {
            return _pendingKeys.take();
        } catch (InterruptedException excp) {
            throw new Error("unexpected interrupt");
        }
    }

    /** 将当前显示的分数设为 SCORE，将当前的
     *  最高分设为 MAXSCORE。 */
    public void setScore(int score, int maxScore) {
        setLabel("Score", String.format("Score: %6d / Max score: %6d",
                                        score, maxScore));
    }

    /** 当 model 的 notifyObservers 方法被调用时，model 会通知我它
     *  已改变，因为我的构造器已将我注册为该 model 的
     *  Observer。 */
    @Override
    public void update(Observable model, Object arg) {
        _widget.update(_model);
        setScore(_model.score(), _model.maxScore());
    }

    /** 棋盘小部件。 */
    private BoardWidget _widget;
    /** 正在查看的游戏 model。 */
    private Model _model;

    /** 待处理按键的队列。 */
    private ArrayBlockingQueue<String> _pendingKeys =
        new ArrayBlockingQueue<>(5);

}
