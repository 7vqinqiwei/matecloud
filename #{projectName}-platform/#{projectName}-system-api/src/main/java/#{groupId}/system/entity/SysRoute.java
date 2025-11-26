
package #{groupId}.system.entity;

import #{groupId}.core.database.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统路由表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_route")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysRoute对象", description = "系统路由表")
public class SysRoute extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 接口名称
	*/
	@ApiModelProperty(value = "接口名称")
	private String name;
	/**
	* 路径前缀
	*/
	@ApiModelProperty(value = "路径前缀")
	private String path;
	/**
	* 地址
	*/
	@ApiModelProperty(value = "地址")
	private String url;
	/**
	* 服务ID
	*/
	@ApiModelProperty(value = "服务ID")
	private String serviceId;
	/**
	* API状态:0:禁用 1:启用
	*/
	@ApiModelProperty(value = "API状态:0:禁用 1:启用")
	private String status;
	/**
	* 删除标识
	*/
	@ApiModelProperty(value = "删除标识")
	private String isDeleted;
	/**
	* 租户ID
	*/
	@ApiModelProperty(value = "租户ID")
	private Integer tenantId;


}
