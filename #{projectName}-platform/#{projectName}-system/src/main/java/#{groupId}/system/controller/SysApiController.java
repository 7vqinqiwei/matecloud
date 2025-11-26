package #{groupId}.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import #{groupId}.core.auth.annotation.PreAuth;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.constant.MineConstant;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.log.annotation.Log;
import #{groupId}.core.redis.core.RedisService;
import #{groupId}.core.web.controller.BaseController;
import #{groupId}.core.web.util.CollectionUtil;
import #{groupId}.system.entity.SysApi;
import #{groupId}.system.service.ISysApiService;

import javax.annotation.Nullable;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * API管理 前端控制器
 * </p>
 *
 * @author #{author}
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Api(value = "API管理")
public class SysApiController extends BaseController {

    private final ISysApiService sysApiService;

    private final RedisService redisService;

    /**
     * 分页列表
     *
     * @param page   分页信息
     * @param search 　搜索关键词
     * @return Result
     */
    @PreAuth
    @Log(value = "API分页")
    @GetMapping("/page")
    @ApiOperation(value = "API分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", required = true, value = "当前页", paramType = "form"),
            @ApiImplicitParam(name = "size", required = true, value = "每页显示数据", paramType = "form"),
            @ApiImplicitParam(name = "keyword", required = true, value = "模糊查询关键词", paramType = "form"),
            @ApiImplicitParam(name = "startDate", required = true, value = "创建开始日期", paramType = "form"),
            @ApiImplicitParam(name = "endDate", required = true, value = "创建结束日期", paramType = "form"),
    })
    public Result<?> page(Page<?> page, Search search, @Nullable @RequestParam String serviceId) {
        return Result.data(sysApiService.listPage(page, search, serviceId));
    }

    /**
     * API管理信息
     *
     * @param id Id
     * @return Result
     */
    @PreAuth
    @Log(value = "API信息")
    @GetMapping("/get")
    @ApiOperation(value = "API信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "ID", paramType = "form"),
    })
    public Result<?> get(@RequestParam String id) {
        return Result.data(sysApiService.getById(id));
    }

    /**
     * API管理设置
     *
     * @param sysApi SysApi 对象
     * @return Result
     */
    @PreAuth
    @Log(value = "API设置")
    @PostMapping("/set")
    @ApiOperation(value = "API设置")
    public Result<?> set(@Valid @RequestBody SysApi sysApi) {
        return Result.condition(sysApiService.saveOrUpdate(sysApi));
    }

    /**
     * API管理删除
     *
     * @param ids id字符串，根据,号分隔
     * @return Result
     */
    @PreAuth
    @Log(value = "API删除")
    @PostMapping("/del")
    @ApiOperation(value = "API删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个用,号隔开", paramType = "form")
    })
    public Result<?> del(@RequestParam String ids) {
        return Result.condition(sysApiService.removeByIds(CollectionUtil.stringToCollection(ids)));
    }

    /**
     * API状态
     *
     * @param ids    多个Id，用,号分隔
     * @param status 状态：启用、禁用
     * @return Result
     */
    @PreAuth
    @Log(value = "API状态")
    @PostMapping("/set-status")
    @ApiOperation(value = "API状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", required = true, value = "多个id用,号隔开", paramType = "form"),
            @ApiImplicitParam(name = "status", required = true, value = "状态", paramType = "form")
    })
    public Result<?> setStatus(@RequestParam String ids, @RequestParam String status) {
        return Result.condition(sysApiService.status(ids, status));
    }

    /**
     * 从redis同步api至数据库
     *
     * @return Boolean
     */
    @PreAuth
    @PostMapping("/sync")
    @ApiOperation(value = "API同步")
    @Log(value = "API同步")
    public Result<?> sync() {
        Set<Object> serviceIds = redisService.sGet(MineConstant.CLOUD_SERVICE_RESOURCE);
        for (Object service : serviceIds) {
            if (redisService.hHasKey(MineConstant.CLOUD_API_RESOURCE, service.toString())) {
                Map<String, Object> apiMap = (Map<String, Object>) redisService.hget(MineConstant.CLOUD_API_RESOURCE, service.toString());
                List<Map<String, String>> list = (List<Map<String, String>>) apiMap.get("list");
                list.forEach(item -> {
                    SysApi sysApi = new SysApi();
                    sysApi.setAuth(item.get("auth"));
                    sysApi.setClassName(item.get("className"));
                    sysApi.setCode(item.get("code"));
                    sysApi.setContentType(item.get("contentType"));
                    sysApi.setMethod(item.get("method"));
                    sysApi.setMethodName(item.get("methodName"));
                    sysApi.setName(item.get("name"));
                    sysApi.setNotes(item.get("notes"));
                    sysApi.setPath(item.get("path"));
                    sysApi.setServiceId(item.get("serviceId"));
                    SysApi exist = sysApiService.getByCode(sysApi.getCode());
                    if (ObjectUtils.isEmpty(exist)) {
                        sysApiService.save(sysApi);
                    } else {
                        LambdaQueryWrapper<SysApi> queryWrapper = new LambdaQueryWrapper<>();
                        queryWrapper.eq(SysApi::getCode, sysApi.getCode());
                        sysApiService.update(sysApi, queryWrapper);
                    }
                });
            }
            redisService.hdel(MineConstant.CLOUD_API_RESOURCE, service.toString());
        }
        redisService.del(MineConstant.CLOUD_SERVICE_RESOURCE);
        return Result.condition(true);
    }
}

