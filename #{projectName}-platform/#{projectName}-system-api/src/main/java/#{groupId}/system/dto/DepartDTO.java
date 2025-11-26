package #{groupId}.system.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.system.entity.SysDepart;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DepartDTO extends SysDepart {

	private List<DepartDTO> children;
}
