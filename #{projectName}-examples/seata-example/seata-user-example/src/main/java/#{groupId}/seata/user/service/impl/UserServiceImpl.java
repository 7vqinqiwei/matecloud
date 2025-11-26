package #{groupId}.seata.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import #{groupId}.seata.user.entity.User;
import #{groupId}.seata.user.mapper.UserMapper;
import #{groupId}.seata.user.service.IUserService;

/**
 * 用户业务实现类
 *
 * @author #{version}
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
