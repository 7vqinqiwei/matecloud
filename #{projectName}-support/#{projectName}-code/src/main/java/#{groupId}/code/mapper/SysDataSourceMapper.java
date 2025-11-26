package #{groupId}.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import #{groupId}.code.entity.SysDataSource;
import #{groupId}.code.vo.SysDataSourceVO;
import #{groupId}.core.common.vo.BaseListVO;

import java.util.List;

/**
 * <p>
 * 数据源表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysDataSourceMapper extends BaseMapper<SysDataSource> {

    List<BaseListVO> optionList();

}
