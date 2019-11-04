package lite.transaction.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lite.transaction.constant.NettyServerConstant;
import lite.transaction.server.handler.ServerChannelInitializer;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 服务入口类
 * @author: LeoLee
 * @date: 2019/11/4 09:31
 */
@Slf4j
public class LiteTransactionServer {

    private int port;

    public LiteTransactionServer(int port) {
        this.port = port;
    }

    /**
     * 启动
     */
    public void start(){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerChannelInitializer())
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .option(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture future = bootstrap.bind(port).sync();
            log.info("服务器启动：");
            //使用sync方法进行阻塞，等待服务端链路关闭之后Main函数才退出
            future.channel().closeFuture().sync();
            log.info("服务器关闭：");
        }catch (InterruptedException  e){
            log.info("服务器发生错误");
            e.printStackTrace();
        }finally {
            //优雅退出，释放线程池资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new LiteTransactionServer(NettyServerConstant.PORT).start();
    }

}
