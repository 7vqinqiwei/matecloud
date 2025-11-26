package #{groupId}.seata.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import #{groupId}.seata.user.entity.User;

/**
 * 用户mapper类
 *
 * @author #{version}
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
