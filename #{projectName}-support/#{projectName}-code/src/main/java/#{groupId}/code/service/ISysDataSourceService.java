package #{groupId}.code.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.code.entity.SysDataSource;
import #{groupId}.code.vo.SysDataSourceVO;
import #{groupId}.core.common.vo.BaseListVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据源表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysDataSourceService extends IService<SysDataSource> {

    IPage<SysDataSource> listPage(Map<String, String> query);

    List<BaseListVO> optionList();
}
