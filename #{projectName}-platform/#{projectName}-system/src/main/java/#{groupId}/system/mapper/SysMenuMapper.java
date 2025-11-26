package #{groupId}.system.mapper;

import #{groupId}.system.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> routes(String roleId);

}
