
package #{groupId}.code.service.impl;

import #{groupId}.core.database.entity.Search;
import #{groupId}.code.entity.Column;
import #{groupId}.code.mapper.ColumnMapper;
import #{groupId}.code.service.IColumnService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import #{groupId}.core.common.util.StringUtil;
import #{groupId}.core.database.util.PageUtil;

/**
 * <p>
 * 代码生成字段表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, Column> implements IColumnService {

		@Override
		public IPage<Column> listPage(Search search) {
			LambdaQueryWrapper<Column> queryWrapper = new LambdaQueryWrapper<>();
			if (StringUtil.isNotBlank(search.getStartDate())) {
				queryWrapper.between(Column::getCreateTime, search.getStartDate(), search.getEndDate());
			}
			if (StringUtil.isNotBlank(search.getKeyword())) {
				queryWrapper.like(Column::getId, search.getKeyword());
			}
			queryWrapper.orderByDesc(Column::getCreateTime);
			return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
		}
}
