package #{groupId}.seata.point.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 积分实体类
 *
 * @author #{version}
 */
@Data
@TableName("#{projectName}_demo_point")
public class Point {
	@TableId(type = IdType.AUTO)
	Integer id;

	Integer count;
}
