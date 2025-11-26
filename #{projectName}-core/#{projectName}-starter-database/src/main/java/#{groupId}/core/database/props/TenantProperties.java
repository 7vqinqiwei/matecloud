package #{groupId}.core.database.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 租户属性
 * @author xuzhanfu
 * @Date 2020-9-6
 */
@Getter
@Setter
@RefreshScope
@ConfigurationProperties(prefix = "#{projectName}tenant")
public class TenantProperties {

    /**
     * 是否开启租户模式
     */
    private Boolean enable = false;

    /**
     * 需要排除的多租户的表
     */
    private List<String> ignoreTables = Arrays.asList("#{projectName}_sys_menu","#{projectName}_sys_dict","#{projectName}_sys_client",
            "#{projectName}_sys_tenant", "#{projectName}_sys_role_permission","#{projectName}_sys_config","#{projectName}_sys_data_source","#{projectName}_sys_attachment");

    /**
     * 多租户字段名称
     */
    private String column = "tenant_id";

    /**
     * 排除不进行租户隔离的sql
     * 样例全路径：#{groupId}.system.mapper.UserMapper.findList
     */
    private List<String> ignoreSqls = new ArrayList<>();
}
