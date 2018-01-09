package Chapter17;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class SimpleAIOServer {
    static final int PORT = 30000;

    public static void main(String[] args) throws Exception {
        try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(PORT));
            while (true) {
                Future<AsynchronousSocketChannel> future = serverChannel.accept();
                AsynchronousSocketChannel socketChannel = future.get();
                socketChannel.write(ByteBuffer.wrap("欢迎来到Aio的世界".getBytes("UTF-8"))).get();
            }
        }
    }
}
