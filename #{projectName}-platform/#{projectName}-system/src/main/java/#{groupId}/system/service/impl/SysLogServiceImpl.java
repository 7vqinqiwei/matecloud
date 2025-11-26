package #{groupId}.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.database.util.PageUtil;
import #{groupId}.system.entity.SysLog;
import #{groupId}.system.mapper.SysLogMapper;
import #{groupId}.system.service.ISysLogService;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

	@Override
	public IPage<SysLog> listPage(Search search) {
		LambdaQueryWrapper<SysLog> queryWrapper = Wrappers.lambdaQuery();
		// 查询开始日期和结束日期
		queryWrapper.between(StrUtil.isNotBlank(search.getStartDate()), SysLog::getCreateTime, search.getStartDate(), search.getEndDate());
		// 关键词查询
		if (StrUtil.isNotBlank(search.getKeyword())) {
			queryWrapper.and(i -> i
					.or().like(SysLog::getTitle, search.getKeyword())
					.or().like(SysLog::getTraceId, search.getKeyword()));
		}
		//　字段排序
		queryWrapper.orderByDesc(SysLog::getCreateTime);
		return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
	}
}
