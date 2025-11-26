package #{groupId}.system.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import #{groupId}.core.auth.util.MineAuthUser;
import #{groupId}.core.common.exception.BaseException;
import #{groupId}.core.database.enums.DataScopeTypeEnum;
import #{groupId}.system.dto.RoleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 本级数据权限
 *
 * @author #{version}
 */
@Component("2")
@AllArgsConstructor
public class ThisLevelDataScope implements AbstractDataScopeHandler {

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		// 用于存储部门id
		List<Long> deptIds = new ArrayList<>();
		String deptId = MineAuthUser.getUser().getDeptId();
		if (deptId == null) {
			throw new BaseException("部门信息为空！");
		}
		deptIds.add(Long.valueOf(MineAuthUser.getUser().getDeptId()));
		return deptIds;
	}
}
