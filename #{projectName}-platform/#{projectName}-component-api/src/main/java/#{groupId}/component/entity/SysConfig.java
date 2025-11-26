
package #{groupId}.component.entity;

import #{groupId}.core.database.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 配置表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_config")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysConfig对象", description = "配置表")
public class SysConfig extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 父主键
	*/
	@ApiModelProperty(value = "父主键")
	private Long parentId;
	/**
	* 码
	*/
	@ApiModelProperty(value = "码")
	private String code;
	/**
	* 值
	*/
	@ApiModelProperty(value = "值")
	private String cKey;
	/**
	* 名称
	*/
	@ApiModelProperty(value = "名称")
	private String value;
	/**
	* 排序
	*/
	@ApiModelProperty(value = "排序")
	private Integer sort;
	/**
	* 备注
	*/
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 租户ID
	 */
	@ApiModelProperty(value = "租户ID")
	private Integer tenantId;
	/**
	* 是否已删除
	*/
	@ApiModelProperty(value = "是否已删除")
	private Integer isDeleted;


}
