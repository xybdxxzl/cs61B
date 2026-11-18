package byow.Networking;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 由 Boren Tsai 和 Arjun Sahai 创建。
 */

public class BYOWClient {
    private int width;
    private int height;

    private Socket clientStringSocket;
    private Socket clientReadSocket;
    private BufferedWriter out;
    private BufferedReader in;
    private DataInputStream dis;

    static public final String CANVAS_FILE = ".client_canvas";

    static final String canvasPath = join(new File(System.getProperty("user.dir")), CANVAS_FILE).getAbsolutePath();
    static int magic = Integer.MIN_VALUE;

    /*
    打开 socket、输入/输出流，并创建带缓冲的 writer 与 data input stream。
     */
    public void startConnection(String ip, int port) throws IOException {
        clientReadSocket = new Socket(ip, port);
        clientStringSocket = new Socket(ip, port);
        dis = new DataInputStream(clientReadSocket.getInputStream());
        out = new BufferedWriter(new OutputStreamWriter(clientStringSocket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(clientStringSocket.getInputStream()));
    }

    /*
    以非阻塞方式检查服务器是否已确认它正在退出
     */
    private boolean shouldClose() throws IOException {
        if (in.ready()) {
            char[] buf = new char[4];
            in.read(buf, 0, 4); // 阻塞客户端
            System.out.println(String.copyValueOf(buf));
            return true;
        }
        return false;
    }

    /*
    关闭 reader 和 writer，然后关闭 socket。
     */
    private void stopConnection() throws IOException {
        dis.close();
        out.close();
        clientReadSocket.close();
        clientStringSocket.close();
    }

    /*
    非阻塞
    向服务器发送一个字符串命令，例如 W、A、S、D 等。
     */
    private void sendCommand(String msg) throws IOException {
        out.write(msg);
        out.flush();
    }

    /*
    阻塞
    如果服务器向客户端发送了可供读取的内容，则显示画布
    即服务器已向客户端发送了一个 png 文件
     */
    private void showCanvas() throws IOException {
        if (dis.available() > 0) {
            boolean configure = dis.readBoolean();
            if (configure) {
                System.out.println("CONFIGURING CANVAS");
                width = dis.readInt();
                height = dis.readInt();
                StdDraw.setCanvasSize(width, height);
                StdDraw.setXscale(0, width);
                StdDraw.setYscale(0, height);
                StdDraw.clear(new Color(0, 0, 0));
                StdDraw.enableDoubleBuffering();
                StdDraw.show();
            }

            StdDraw.clear();

            File newFile = new File(canvasPath + magic + ".png");
            File oldFile = new File(canvasPath + (magic - 1) + ".png");

            FileOutputStream fos = new FileOutputStream(newFile);

            // 等待传入的文件大小
            long size = dis.readLong();

            int bytes;
            byte[] buffer = new byte[4 * 1024];
            while (size > 0 && (bytes = dis.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                fos.write(buffer, 0, bytes);
                size -= bytes;
            }
            // 将所有缓冲的字节写入文件
            fos.flush();

            StdDraw.picture(width / 2, height / 2, canvasPath + magic + ".png");
            magic = magic + 1;

            oldFile.delete();
            StdDraw.show();
        }
    }

    private static File join(File first, String... others) {
        return Paths.get(first.getPath(), others).toFile();
    }


    public static void main(String[] args) throws IOException {
        System.out.println("BYOW Client. Please Enter the following information to connect to a server...");
        Scanner scanner = new Scanner(System.in);
        System.out.print("IP Address: ");
        String ip = scanner.next();
        System.out.print("Port (this must be a number): ");
        int port = scanner.nextInt();

        BYOWClient client = new BYOWClient();
        client.startConnection(ip, port); //ip 端口会根据 ngrok 提供的链接而变化
        client.showCanvas();
        char command;

        try {
            while (true) {
                if (StdDraw.hasNextKeyTyped()) {
                    command = StdDraw.nextKeyTyped();
                    client.sendCommand(Character.toString(command));
                }
                client.showCanvas();
                StdDraw.clear();
                if (client.shouldClose()) {
                    client.stopConnection();
                    System.exit(0);
                }
            }
        } catch (java.net.SocketException e) {
            client.stopConnection();
            System.out.println("Disconnected from server");
            System.exit(0);
        }
        client.stopConnection();
        System.out.println("Disconnected from server");
        System.exit(0);
    }
}
