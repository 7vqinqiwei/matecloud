
package #{groupId}.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.core.database.entity.Search;
import #{groupId}.system.entity.SysRoute;
import #{groupId}.system.vo.SysRouteVO;

import java.util.List;

/**
 * <p>
 * 系统路由表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysRouteService extends IService<SysRoute> {

	/**
	 * 分页业务方法
	 *
	 * @param search 　搜索参数
	 * @return IPage
	 */
	IPage<SysRoute> listPage(Search search);

	/**
	 * 查询微服务列表
	 *
	 * @return List<SysRouteVO>
	 */
	List<SysRouteVO> listItem();

}
