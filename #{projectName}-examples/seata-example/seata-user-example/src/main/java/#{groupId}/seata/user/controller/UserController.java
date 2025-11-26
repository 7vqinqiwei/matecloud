package #{groupId}.seata.user.controller;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import #{groupId}.core.common.api.Result;
import #{groupId}.seata.user.entity.User;
import #{groupId}.seata.user.feign.OrderProvider;
import #{groupId}.seata.user.feign.PointProvider;
import #{groupId}.seata.user.service.IUserService;

/**
 * 用户控制器
 *
 * @author #{version}
 */
@RestController
@RequiredArgsConstructor
public class UserController {
	private final IUserService userService;
	private final OrderProvider orderProvider;
	private final PointProvider pointProvider;

	@GlobalTransactional(rollbackFor = Exception.class)
	@PostMapping("/user")
	public Result<String> createUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
		pointProvider.createPoint();
		orderProvider.createOrder();
		return Result.condition(Boolean.TRUE);
	}
}
