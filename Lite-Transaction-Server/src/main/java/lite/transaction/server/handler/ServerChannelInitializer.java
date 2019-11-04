package lite.transaction.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import lite.transaction.constant.NettyServerConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Channel初始化
 * @author: LeoLee
 * @date: 2019/11/4 09:41
 */
@Slf4j
public class ServerChannelInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        log.info("客户端连接：" + channel.remoteAddress());
        // 用户定义的ChannelInitailizer加入到这个channel的pipeline上面去，这个handler就可以用于处理当前这个channel上面的一些事件
        ChannelPipeline pipeline = channel.pipeline();
        // ChannelPipeline类似于一个管道，管道中存放的是一系列对读取数据进行业务操作的ChannelHandler。
        /**
         * 发送的数据在管道里是无缝流动的，在数据量很大时，为了分割数据，采用以下几种方法
         * 定长方法
         * 固定分隔符
         * 将消息分成消息体和消息头，在消息头中用一个数组说明消息体的长度
         */
        pipeline.addLast(NettyServerConstant.IDLE_STATE_HANDLER,
                        new IdleStateHandler(NettyServerConstant.SERVER_READ_IDEL_TIME_OUT,
                                NettyServerConstant.SERVER_WRITE_IDEL_TIME_OUT,
                                NettyServerConstant.SERVER_ALL_IDEL_TIME_OUT,
                                TimeUnit.SECONDS));

        pipeline.addLast(NettyServerConstant.IDLE_STATE_TRIGGER,new ServerIdleStateTrigger());
        pipeline.addLast(NettyServerConstant.FRAME,new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        // 解码器
        pipeline.addLast(NettyServerConstant.DECODE,new StringDecoder());
        pipeline.addLast(NettyServerConstant.ENCODE,new StringEncoder());
        // TODO 根据需要自己定义相应的处理器
        pipeline.addLast(new ServerHandler());


    }
}
