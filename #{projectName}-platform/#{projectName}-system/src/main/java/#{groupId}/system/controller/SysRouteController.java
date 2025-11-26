
package #{groupId}.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import #{groupId}.core.auth.annotation.PreAuth;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.log.annotation.Log;
import #{groupId}.core.web.controller.BaseController;
import #{groupId}.core.web.util.CollectionUtil;
import #{groupId}.system.entity.SysRoute;
import #{groupId}.system.service.ISysRouteService;

import javax.validation.Valid;

/**
 * <p>
 * 系统路由表 前端控制器
 * </p>
 *
 * @author #{author}
 */
@RestController
@AllArgsConstructor
@RequestMapping("/route")
@Api(value = "系统路由表", tags = "系统路由表接口")
public class SysRouteController extends BaseController {

	private final ISysRouteService sysRouteService;

	/**
	 * 分页列表
	 *
	 * @param search 　搜索关键词
	 * @return Result
	 */
	@PreAuth
	@Log(value = "系统路由分页列表", exception = "系统路由分页列表请求异常")
	@GetMapping("/page")
	@ApiOperation(value = "系统路由分页", notes = "分页查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "current", required = true, value = "当前页", paramType = "form"),
			@ApiImplicitParam(name = "size", required = true, value = "每页显示数据", paramType = "form"),
			@ApiImplicitParam(name = "keyword", required = true, value = "模糊查询关键词", paramType = "form"),
			@ApiImplicitParam(name = "startDate", required = true, value = "创建开始日期", paramType = "form"),
			@ApiImplicitParam(name = "endDate", required = true, value = "创建结束日期", paramType = "form"),
	})
	public Result<?> page(Search search) {
		return Result.data(sysRouteService.listPage(search));
	}

	/**
	 * 系统路由表信息
	 *
	 * @param id Id
	 * @return Result
	 */
	@PreAuth
	@Log(value = "系统路由表信息", exception = "系统路由表信息请求异常")
	@GetMapping("/get")
	@ApiOperation(value = "系统路由表信息", notes = "根据ID查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", required = true, value = "ID", paramType = "form"),
	})
	public Result<?> get(@RequestParam String id) {
		return Result.data(sysRouteService.getById(id));
	}

	/**
	 * 系统路由表设置
	 *
	 * @param sysRoute SysRoute 对象
	 * @return Result
	 */
	@PreAuth
	@Log(value = "系统路由表设置", exception = "系统路由表设置请求异常")
	@PostMapping("/set")
	@ApiOperation(value = "系统路由表设置", notes = "系统路由表设置,支持新增或修改")
	public Result<?> set(@Valid @RequestBody SysRoute sysRoute) {
		return Result.condition(sysRouteService.saveOrUpdate(sysRoute));
	}

	/**
	 * 系统路由表删除
	 *
	 * @param ids id字符串，根据,号分隔
	 * @return Result
	 */
	@PreAuth
	@Log(value = "系统路由表删除", exception = "系统路由表删除请求异常")
	@PostMapping("/del")
	@ApiOperation(value = "系统路由表删除", notes = "系统路由表删除")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
	})
	public Result<?> del(@RequestParam String ids) {
		return Result.condition(sysRouteService.removeByIds(CollectionUtil.stringToCollection(ids)));
	}

	/**
	 * 系统路由列表
	 *
	 * @return Result<List<SysRouteVO>>
	 */
	@PreAuth
	@Log(value = "系统路由列表", exception = "系统路由列表请求异常")
	@GetMapping("/list-item")
	@ApiOperation(value = "系统路由列表", notes = "系统路由列表")
	public Result<?> listItem() {
		return Result.data(sysRouteService.listItem());
	}
}

