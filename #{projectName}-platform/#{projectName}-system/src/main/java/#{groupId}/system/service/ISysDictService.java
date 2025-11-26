package #{groupId}.system.service;

import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import #{groupId}.core.common.api.Result;
import #{groupId}.core.common.constant.SystemConstant;
import #{groupId}.core.database.entity.Search;
import #{groupId}.system.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 根据编码和键获取值
     *
     * @param code
     * @param dictKey
     * @return
     */
    @Cached(name = SystemConstant.SYS_DICT_CACHE, expire = 3600)
    Result<String> getValue(String code, String dictKey);

    /**
     * 根据编码查询字典列表
     *
     * @param code
     * @return
     */
    @Cached(name = SystemConstant.SYS_DICT_CACHE, key = "#code", expire = 3600)
    Result<List<SysDict>> getList(String code);

    /**
     * 字典分页查询
     *
     * @param page
     * @param search
     * @return
     */
    IPage<SysDict> listPage(Page page, Search search);

}
