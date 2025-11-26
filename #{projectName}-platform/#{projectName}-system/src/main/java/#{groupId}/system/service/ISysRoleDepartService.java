
package #{groupId}.system.service;

import #{groupId}.system.entity.SysRoleDepart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import #{groupId}.core.database.entity.Search;

/**
 * <p>
 * 角色和部门关联表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysRoleDepartService extends IService<SysRoleDepart> {

	/**
     * 分页业务方法
     * @param search　搜索参数
     * @return IPage
     */
	IPage<SysRoleDepart> listPage(Search search);

}
