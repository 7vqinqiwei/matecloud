package #{groupId}.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import #{groupId}.core.database.entity.Search;
import #{groupId}.system.entity.SysBlacklist;

/**
 * <p>
 * 系统黑名单表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface ISysBlacklistService extends IService<SysBlacklist> {

	/**
	 * 黑名单分页列表
	 *
	 * @param search 搜索关键词
	 * @return 分页列表
	 */
	IPage<SysBlacklist> listPage(Search search);

	boolean status(String ids, String status);
}
