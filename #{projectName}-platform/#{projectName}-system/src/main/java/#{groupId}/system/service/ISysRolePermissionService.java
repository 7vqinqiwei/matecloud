package #{groupId}.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.system.entity.SysRolePermission;

import java.util.List;

/**
 * <p>
 * 角色权限表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysRolePermissionService extends IService<SysRolePermission> {

    /**
     * 根据角色查询菜单ID列表
     *
     * @param roleId 角色ID
     * @return 菜单ID列表
     */
    List<String> getMenuIdByRoleId(String roleId);

}
