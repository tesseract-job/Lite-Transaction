package lite.transaction.exception;

import lite.transaction.constant.CommonConstant;
import lombok.Data;
import lombok.Getter;

/**
 * 封装异常
 *
 * @author nickle
 */
@Getter
public class LiteTransactionException extends RuntimeException {
    private String msg;
    private Integer code;

    public LiteTransactionException(String msg, Integer code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public LiteTransactionException(String msg) {
        this(msg, CommonConstant.ERROR);
    }

}
