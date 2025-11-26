package #{groupId}.system.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import #{groupId}.core.database.enums.DataScopeTypeEnum;
import #{groupId}.system.dto.RoleDTO;
import #{groupId}.system.entity.SysDepart;
import #{groupId}.system.service.ISysDepartService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 所有数据范围
 *
 * @author #{version}
 */
@Component("1")
@AllArgsConstructor
public class AllDataScope implements AbstractDataScopeHandler {

	private final ISysDepartService sysDepartService;

	@Override
	public List<Long> getDeptIds(RoleDTO roleDto, DataScopeTypeEnum dataScopeTypeEnum) {
		List<SysDepart> sysDeparts = sysDepartService.list();
		return sysDeparts.stream().map(SysDepart::getId).collect(Collectors.toList());
	}


}
