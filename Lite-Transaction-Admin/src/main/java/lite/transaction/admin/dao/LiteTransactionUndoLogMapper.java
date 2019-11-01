package lite.transaction.admin.dao;

import lite.transaction.admin.domain.entity.LiteTransactionUndoLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LeoLee
 * @since 2019-11-01
 */
public interface LiteTransactionUndoLogMapper extends BaseMapper<LiteTransactionUndoLog> {

}
