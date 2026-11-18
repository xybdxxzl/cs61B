package byow.Networking;

import edu.princeton.cs.introcs.StdDraw;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;

/**
 * 由 Arjun Sahai 和 Boren Tsai 创建。
 */

public class BYOWServer {

    static private final File CWD = new File(System.getProperty("user.dir"));
    static private final String CANVAS_FILE = ".server_canvas.png";

    private ServerSocket serverSocket;
    private Socket clientStringSocket;
    private Socket clientWriteSocket;

    private BufferedReader in;
    private BufferedWriter out;
    private DataOutputStream dos;

    public BYOWServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for client to connect... ");
        clientWriteSocket = serverSocket.accept(); // 阻塞，直到客户端连接
        clientStringSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientStringSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientStringSocket.getOutputStream()));
        dos = new DataOutputStream(clientWriteSocket.getOutputStream());
        System.out.println("Client connected!");
    }

    public void sendCanvasConfig(int width, int height) {
        sendCanvas(width, height, true);
    }

    public void sendCanvas() {
        sendCanvas(0, 0, false);
    }

    /*
    此方法将检查客户端是否正在向服务器发送按键
    这不会阻塞你的代码
     */
    public boolean clientHasKeyTyped() {
        try {
            return in.ready();
        } catch (IOException e) {
            stopConnection();
            return false;
        }
    }

    /*
    给出客户端发送的下一个字符。
    如果客户端尚未发送任何内容，则此方法将阻塞
     */
    public char clientNextKeyTyped() {
        try {
            return (char) in.read();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION CAUGHT");
            stopConnection();
            return 'q';
        }
    }

    /*
    关闭所有输入/输出流和 socket。
     */
    public void stopConnection() {
        try {
            out.write("QUIT");
            out.flush();
            in.close();
            dos.close();
            clientStringSocket.close();
            clientWriteSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            return;
        }
    }

    /*
    发送世界位图，以及（可选的）StdDraw 画布配置元数据。
     */
    private void sendCanvas(int width, int height, boolean sendConfig) {
        try {
            dos.writeBoolean(sendConfig);

            if (sendConfig) {
                dos.writeInt(width);
                dos.writeInt(height);
                dos.flush();
            } else {
                dos.flush();
            }


            // 将画布保存为一个 PNG 文件
            StdDraw.save(CANVAS_FILE);
            File canvas = join(CWD, CANVAS_FILE);

            // 发送文件大小，使客户端不再等待
            dos.writeLong(canvas.length());
            dos.flush();

            FileInputStream fis = new FileInputStream(canvas);

            // 将文件分成若干块并发送给客户端
            int bytes;
            byte[] buffer = new byte[4 * 1024];
            while ((bytes = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytes);
                dos.flush();
            }
            fis.close();
        } catch (IOException e) {
            stopConnection();
        }
    }

    private static File join(File first, String... others) {
        return Paths.get(first.getPath(), others).toFile();
    }
}
