package lite.transaction.constant;

/**
 * Netty服务端常量类
 * @author: LeoLee
 * @date: 2019/11/4 13:27
 */
public class NettyServerConstant {
    public static final int PORT = 9999;
    public static final String IDLE_STATE_HANDLER = "idleStateHandler";
    public static final String IDLE_STATE_TRIGGER = "idleStateTrigger";
    public static final String FRAME = "frame";
    public static final String DECODE = "decode";
    public static final String ENCODE = "encode";
    public static final int SERVER_READ_IDEL_TIME_OUT = 5;
    public static final int SERVER_WRITE_IDEL_TIME_OUT = 0;
    public static final int SERVER_ALL_IDEL_TIME_OUT = 0;
}
