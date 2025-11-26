
package #{groupId}.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.core.database.entity.Search;
import #{groupId}.system.entity.SysApi;

/**
 * <p>
 * 系统接口表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysApiService extends IService<SysApi> {

	/**
	 * 分页业务方法
	 *
	 * @param page   　分页参数
	 * @param search 　搜索参数
	 * @return IPage
	 */
	IPage<SysApi> listPage(Page page, Search search, String serviceId);

	/**
	 * 根据code查询对象
	 *
	 * @param code 编码
	 * @return SysApi
	 */
	SysApi getByCode(String code);


	/**
	 * 设置API状态
	 *
	 * @param ids    id串
	 * @param status 　状态标识
	 * @return Boolean
	 */
	boolean status(String ids, String status);
}
