package #{groupId}.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.core.database.entity.Search;
import #{groupId}.system.entity.SysLog;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysLogService extends IService<SysLog> {

	/**
	 * 日志分页列表
	 *
	 * @param search 搜索和分页对象
	 * @return 日志分页列表
	 */
	IPage<SysLog> listPage(Search search);
}
