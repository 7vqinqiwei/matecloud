package #{groupId}.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.database.util.PageUtil;
import #{groupId}.system.entity.SysRoute;
import #{groupId}.system.mapper.SysRouteMapper;
import #{groupId}.system.service.ISysRouteService;
import #{groupId}.system.vo.SysRouteVO;

import java.util.List;

/**
 * <p>
 * 系统路由表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class SysRouteServiceImpl extends ServiceImpl<SysRouteMapper, SysRoute> implements ISysRouteService {

	@Override
	public IPage<SysRoute> listPage(Search search) {
		LambdaQueryWrapper<SysRoute> queryWrapper = Wrappers.<SysRoute>query().lambda()
				.between(StrUtil.isNotBlank(search.getStartDate()), SysRoute::getCreateTime, search.getStartDate(), search.getEndDate());
		boolean isKeyword = StrUtil.isNotBlank(search.getKeyword());
		queryWrapper.like(isKeyword, SysRoute::getServiceId, search.getKeyword())
				.or(isKeyword)
				.like(isKeyword, SysRoute::getName, search.getKeyword());
		queryWrapper.orderByDesc(SysRoute::getCreateTime);
		return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
	}

	@Override
	public List<SysRouteVO> listItem() {
		return this.baseMapper.listItem();
	}
}
