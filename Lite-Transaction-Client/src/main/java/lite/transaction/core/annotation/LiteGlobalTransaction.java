package lite.transaction.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 事务注解
 *
 * @author nickle
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LiteGlobalTransaction {
    /**
     * 事务超时时间
     *
     * @return
     */
    long timeOut();

    /**
     * 分支事务名
     *
     * @return
     */
    String transactionName();
}
