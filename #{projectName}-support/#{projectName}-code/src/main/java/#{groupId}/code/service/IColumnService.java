
package #{groupId}.code.service;

import #{groupId}.code.entity.Column;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import #{groupId}.core.database.entity.Search;

/**
 * <p>
 * 代码生成字段表 服务类
 * </p>
 *
 * @author #{author}
 */
public interface IColumnService extends IService<Column> {

	/**
     * 分页业务方法
     * @param search　搜索参数
     * @return IPage
     */
	IPage<Column> listPage(Search search);

}
