package #{groupId}.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.core.database.entity.BaseEntity;

/**
 * 角色和部门关联表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_role_depart")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoleDepart对象", description = "角色和部门关联表")
public class SysRoleDepart extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 角色ID
	*/
	@ApiModelProperty(value = "角色ID")
	private Long roleId;
	/**
	* 部门ID
	*/
	@ApiModelProperty(value = "部门ID")
	private Long departId;


}
