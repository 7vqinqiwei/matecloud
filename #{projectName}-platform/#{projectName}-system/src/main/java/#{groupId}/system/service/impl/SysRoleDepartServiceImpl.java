package #{groupId}.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.database.util.PageUtil;
import #{groupId}.system.entity.SysRoleDepart;
import #{groupId}.system.mapper.SysRoleDepartMapper;
import #{groupId}.system.service.ISysRoleDepartService;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class SysRoleDepartServiceImpl extends ServiceImpl<SysRoleDepartMapper, SysRoleDepart> implements ISysRoleDepartService {

		@Override
		public IPage<SysRoleDepart> listPage(Search search) {
			LambdaQueryWrapper<SysRoleDepart> queryWrapper = new LambdaQueryWrapper<>();
			if (StrUtil.isNotBlank(search.getStartDate())) {
				queryWrapper.between(SysRoleDepart::getCreateTime, search.getStartDate(), search.getEndDate());
			}
			if (StrUtil.isNotBlank(search.getKeyword())) {
				queryWrapper.like(SysRoleDepart::getId, search.getKeyword());
			}
			queryWrapper.orderByDesc(SysRoleDepart::getCreateTime);
			return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
		}
}
