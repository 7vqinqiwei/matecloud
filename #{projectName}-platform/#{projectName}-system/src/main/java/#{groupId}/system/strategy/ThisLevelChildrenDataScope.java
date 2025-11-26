package #{groupId}.system.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import #{groupId}.core.auth.util.MineAuthUser;
import #{groupId}.core.common.exception.BaseException;
import #{groupId}.core.database.enums.DataScopeTypeEnum;
import #{groupId}.system.dto.RoleDTO;
import #{groupId}.system.service.ISysDepartService;

import java.util.List;

/**
 * 本级及以下级别的数据权限
 *
 * @author #{version}
 */
@Component("3")
@AllArgsConstructor
public class ThisLevelChildrenDataScope implements AbstractDataScopeHandler {

	private final ISysDepartService sysDepartService;

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		String deptId = MineAuthUser.getUser().getDeptId();
		if (deptId == null) {
			throw new BaseException("部门信息为空！");
		}
		return sysDepartService.selectDeptIds(Long.valueOf(deptId));
	}
}
