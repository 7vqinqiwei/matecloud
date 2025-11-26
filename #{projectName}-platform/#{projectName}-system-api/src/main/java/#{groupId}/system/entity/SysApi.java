
package #{groupId}.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.core.database.entity.BaseEntity;

/**
 * 系统接口表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_api")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysApi对象", description = "系统接口表")
public class SysApi extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 接口编码
	*/
	@ApiModelProperty(value = "接口编码")
	private String code;
	/**
	* 接口名称
	*/
	@ApiModelProperty(value = "接口名称")
	private String name;
	/**
	* 接口描述
	*/
	@ApiModelProperty(value = "接口描述")
	private String notes;
	/**
	* 请求方法
	*/
	@ApiModelProperty(value = "请求方法")
	private String method;
	/**
	* 类名
	*/
	@ApiModelProperty(value = "类名")
	private String className;
	/**
	* 方法名
	*/
	@ApiModelProperty(value = "方法名")
	private String methodName;
	/**
	* 请求路径
	*/
	@ApiModelProperty(value = "请求路径")
	private String path;
	/**
	* 响应类型
	*/
	@ApiModelProperty(value = "响应类型")
	private String contentType;
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
	* 是否认证:0:不认证 1:认证
	*/
	@ApiModelProperty(value = "是否认证:0:不认证 1:认证")
	private String auth;
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
