package lite.transaction.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LeoLee
 * @since 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LiteTransactionUndoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 事务分支id
     */
    private Long branchId;

    /**
     * 事务全局id
     */
    private String xid;

    /**
     * 事务上下文
     */
    private String context;

    /**
     * 回滚信息
     */
    private Blob rollbackInfo;

    /**
     * 状态
     */
    private Integer logStatus;

    /**
     * 创建时间
     */
    private LocalDateTime logCreated;

    /**
     * 最后修改时间
     */
    private LocalDateTime logModified;

    /**
     * 扩展字段
     */
    private String ext;


}
