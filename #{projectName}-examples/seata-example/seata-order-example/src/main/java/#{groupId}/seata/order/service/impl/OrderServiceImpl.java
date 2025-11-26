package #{groupId}.seata.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.seata.order.entity.Order;
import #{groupId}.seata.order.mapper.OrderMapper;
import #{groupId}.seata.order.service.IOrderService;

/**
 * 订单业务实现类
 *
 * @author #{version}
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
