package #{groupId}.seata.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户表
 *
 * @author #{version}
 */
@Data
@TableName("#{projectName}_demo_user")
public class User {
	@TableId
	Integer id;
	String name;
	int age;
}
