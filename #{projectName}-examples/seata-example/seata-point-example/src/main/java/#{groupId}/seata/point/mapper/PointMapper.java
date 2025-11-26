package #{groupId}.seata.point.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import #{groupId}.seata.point.entity.Point;

/**
 * 积分mapper类
 *
 * @author #{version}
 */
@Mapper
public interface PointMapper extends BaseMapper<Point> {
}
