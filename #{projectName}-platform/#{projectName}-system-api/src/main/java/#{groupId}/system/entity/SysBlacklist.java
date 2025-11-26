
package #{groupId}.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.core.database.entity.BaseEntity;

/**
 * 系统黑名单表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_blacklist")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysBlacklist对象", description = "系统黑名单表")
public class SysBlacklist extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* IP地址
	*/
	@ApiModelProperty(value = "IP地址")
	private String ip;
	/**
	* 请求地址
	*/
	@ApiModelProperty(value = "请求地址")
	private String requestUri;
	/**
	* 请求方法
	*/
	@ApiModelProperty(value = "请求方法")
	private String requestMethod;
	/**
	* 开始时间
	*/
	@ApiModelProperty(value = "开始时间")
	private String startTime;
	/**
	* 结束时间
	*/
	@ApiModelProperty(value = "结束时间")
	private String endTime;
	/**
	* 状态：0:关闭 1:开启
	*/
	@ApiModelProperty(value = "状态：0:关闭 1:开启")
	private String status;

}
