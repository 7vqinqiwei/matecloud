
package #{groupId}.system.mapper;

import #{groupId}.system.entity.SysRoute;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import #{groupId}.system.vo.SysRouteVO;

import java.util.List;

/**
 * <p>
 * 系统路由表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysRouteMapper extends BaseMapper<SysRoute> {

	/**
	 * 微服务视图列表
	 *
	 * @return List<SysRouteVO>
	 */
	List<SysRouteVO> listItem();

}
