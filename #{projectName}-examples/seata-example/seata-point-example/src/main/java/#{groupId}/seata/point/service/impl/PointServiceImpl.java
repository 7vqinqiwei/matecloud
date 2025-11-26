package #{groupId}.seata.point.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.seata.point.entity.Point;
import #{groupId}.seata.point.mapper.PointMapper;
import #{groupId}.seata.point.service.IPointService;

/**
 * 积分业务实现类
 *
 * @author #{version}
 */
@Service
public class PointServiceImpl extends ServiceImpl<PointMapper, Point> implements IPointService {
}
