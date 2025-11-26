package #{groupId}.component.entity;

import #{groupId}.core.database.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 附件表实体类
 *
 * @author #{author}
 */
@Data
@TableName("#{projectName}_sys_attachment")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysAttachment对象", description = "附件表")
public class SysAttachment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 存储ID
	*/
	@ApiModelProperty(value = "存储ID")
	private Long storageId;
	/**
	* 组ID
	*/
	@ApiModelProperty(value = "组ID")
	private Integer attachmentGroupId;
	/**
	* 文件名称
	*/
	@ApiModelProperty(value = "文件名称")
	private String name;
	/**
	* 文件大小
	*/
	@ApiModelProperty(value = "文件大小")
	private long size;
	/**
	* 文件地址
	*/
	@ApiModelProperty(value = "文件地址")
	private String url;

	/**
	 * 上传文件名
	 */
	@ApiModelProperty(value = "上传文件名")
	private String fileName;

	/**
	* 缩略图地址
	*/
	@ApiModelProperty(value = "缩略图地址")
	private String thumbUrl;
	/**
	* 类型
	*/
	@ApiModelProperty(value = "类型")
	private Integer type;
	/**
	* 创建人
	*/
	@ApiModelProperty(value = "创建人")
	private String createBy;
	/**
	* 更新人
	*/
	@ApiModelProperty(value = "更新人")
	private String updateBy;
	/**
	* 创建时间
	*/
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;
	/**
	* 修改时间
	*/
	@ApiModelProperty(value = "修改时间")
	private LocalDateTime updateTime;
	/**
	* 删除标识
	*/
	@ApiModelProperty(value = "删除标识")
	private String isDeleted;
	/**
	* 是否加入回收站 0.否|1.是
	*/
	@ApiModelProperty(value = "是否加入回收站 0.否|1.是")
	private Boolean isRecycle;


}
