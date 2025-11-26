package #{groupId}.system.mapper;

import #{groupId}.system.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import #{groupId}.system.vo.SysRoleVO;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVO> tree();

}
