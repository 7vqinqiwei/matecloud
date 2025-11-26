package #{groupId}.core.database.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import #{groupId}.core.database.entity.Search;

/**
 * 分页工具类
 *
 * @author #{version}
 */
public class PageUtil {

	public static <T> IPage<T> getPage(Search search) {
		return new Page<T>(search.getCurrent(), search.getSize());
	}
}
