package #{groupId}.system.mapper;

import #{groupId}.system.entity.SysDepart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import #{groupId}.system.vo.SysDepartVO;

import java.util.List;

/**
 * <p>
 * 组织机构表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysDepartMapper extends BaseMapper<SysDepart> {

    List<SysDepartVO> tree();

}
