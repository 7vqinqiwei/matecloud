package #{groupId}.seata.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 订单实体类
 *
 * @author #{version}
 */
@Data
@TableName("#{projectName}_demo_order")
public class Order {

	@TableId(type = IdType.AUTO)
	Integer id;
	@TableField("money")
	Integer money;
}
