
package #{groupId}.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.core.database.entity.BaseEntity;

/**
 * 字典表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_dict")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysDict对象", description = "字典表")
public class SysDict extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 父主键
	*/
	@ApiModelProperty(value = "父主键")
	private Long parentId;
	/**
	* 字典码
	*/
	@ApiModelProperty(value = "字典码")
	private String code;
	/**
	* 字典值
	*/
	@ApiModelProperty(value = "字典值")
	private String dictKey;
	/**
	* 字典名称
	*/
	@ApiModelProperty(value = "字典名称")
	private String dictValue;
	/**
	* 排序
	*/
	@ApiModelProperty(value = "排序")
	private Integer sort;
	/**
	* 字典备注
	*/
	@ApiModelProperty(value = "字典备注")
	private String remark;


}
