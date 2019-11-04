package lite.transaction.server.handler;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端处理器
 * 具体实现接口，可以自己定义
 * @author: LeoLee
 * @date: 2019/11/4 13:04
 */
@ChannelHandler.Sharable
@Slf4j
public class ServerHandler  extends ChannelInboundHandlerAdapter {


    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 当有客户端连接时，handlerAdded会执行,就把该客户端的通道记录下来，加入队列
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获得客户端通道
        Channel inComing = ctx.channel();
        //加入队列
        channels.add(inComing);
    }

    /**
     * 断开连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 获得客户端通道
        Channel outComing = ctx.channel();
        // TODO
        channels.remove(outComing);
    }

    /**
     * 当服务器监听到客户端活动时
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        // TODO
    }

    /**
     * 离线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel inComing = ctx.channel();
        // TODO
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel inComing = ctx.channel();
        // TODO 记录异常信息
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext chc, Object message) throws Exception {
        Channel channel=chc.channel();
        // TODO 处理业务
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
