package #{groupId}.sso.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.entity.LoginUser;
import #{groupId}.core.common.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
public class IndexController {

	private final HttpServletRequest request;

	/**
	 * 欢迎页
	 *
	 * @return
	 */
	@GetMapping("/")
	public Result<?> index(ModelMap modelMap) {
		LoginUser user = SecurityUtil.getUsername(request);
		modelMap.put("user", user);
		return Result.data(modelMap);
	}
}
