
package #{groupId}.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import #{groupId}.core.database.entity.BaseEntity;

/**
 * 客户端表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_client")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysClient对象", description = "客户端表")
public class SysClient extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 客户端id
	*/
	@ApiModelProperty(value = "客户端标识")
	private String clientId;
	/**
	* 客户端密钥
	*/
	@ApiModelProperty(value = "客户端密钥")
	private String clientSecret;
	/**
	* 资源集合
	*/
	@ApiModelProperty(value = "资源集合")
	private String resourceIds;
	/**
	* 授权范围
	*/
	@ApiModelProperty(value = "授权范围")
	private String scope;
	/**
	* 授权类型
	*/
	@ApiModelProperty(value = "授权类型")
	private String authorizedGrantTypes;
	/**
	* 回调地址
	*/
	@ApiModelProperty(value = "回调地址")
	private String webServerRedirectUri;
	/**
	* 权限
	*/
	@ApiModelProperty(value = "权限")
	private String authorities;
	/**
	* 令牌过期秒数
	*/
	@ApiModelProperty(value = "令牌过期秒数")
	private Integer accessTokenValidity;
	/**
	* 刷新令牌过期秒数
	*/
	@ApiModelProperty(value = "刷新令牌过期秒数")
	private Integer refreshTokenValidity;
	/**
	* 附加说明
	*/
	@ApiModelProperty(value = "附加说明")
	private String additionalInformation;
	/**
	* 自动授权
	*/
	@ApiModelProperty(value = "自动授权")
	private String autoapprove;
	/**
	* 状态
	*/
	@ApiModelProperty(value = "状态")
	private String status;
	/**
	* 是否已删除
	*/
	@ApiModelProperty(value = "是否已删除")
	private Integer isDeleted;


}
