package game2048;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/** 一种从 GUI 接收命令的 InputSource。
 *  @author P. N. Hilfinger
 */
class GUISource implements InputSource {

    /** 从 SOURCE 提供输入，当且仅当 LOG 时记录日志。使用 RANDOMSOURCE
     *  以概率 PROBOF2 选择值为 2 的随机方块。 */
    GUISource(GUI source, Random randomSource, double probOf2,
              String logFileName) {
        _source = source;
        _randomSource = randomSource;
        _probOf2 = probOf2;

        if (logFileName != null) {

            File logFile = new File(logFileName);
            try {
                _logFileWriter = new FileWriter(logFile);
            } catch (IOException e) {
                System.err.println("Error: no such file " + logFileName);
                System.exit(1);
            }
        }
    }

    @Override
    /** 返回并记录按下了哪个方向箭头。 */
    public String getKey() {
        String command = _source.readKey();
        switch (command) {
            case "↑" :
                command = "Up";
                break;
            case "→" :
                command = "Right";
                break;
            case "↓" :
                command = "Down";
                break;
            case "←" :
                command = "Left";
                break;
            default :
                break;
        }

        String logLine = String.format("K %s%n", command);

        if (_logFileWriter != null) {
            System.out.print(logLine);
            try {
                _logFileWriter.write(logLine);
            } catch (IOException e) {
                System.err.print("Error: cannot write to log file");
                System.exit(1);
            }
        }
        return command;
    }

    @Override
     /** 在大小为 SIZE 的棋盘中返回一个随机定位的方块，
      * 其值为 2 的概率为 _probOf2，值为 4 的概率为 1 - _probOf2。 */
    public Tile getNewTile(int size) {
        int c = _randomSource.nextInt(size), r = _randomSource.nextInt(size);
        int v = _randomSource.nextDouble() <= _probOf2 ? 2 : 4;
        if (_logFileWriter != null) {
            System.out.printf("T %d %d %d%n", v, c, r);
        }
        return Tile.create(v, c, r);
    }

    /** 输入来源。 */
    private GUI _source;
    /** Tile 的随机来源。 */
    private Random _randomSource;
    /** 新 Tile 的值为 2（而非 4）的概率。 */
    private double _probOf2;
    /** 用于记录输入日志的 FileWriter（如果不需要记录日志则为 null）。 */
    private FileWriter _logFileWriter;

}
