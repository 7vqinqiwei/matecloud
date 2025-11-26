package #{groupId}.core.common.constant;

/**
 * 多租户常量
 * @author #{version}
 * @date 2020-9-7
 */
public interface TenantConstant {

    /**
     * header 中租户ID
     */
    String SYS_TENANT_ID = "tenantId";

    /**
     * 租户id参数
     */
    String SYS_TENANT_ID_PARAM = "tenantId";

    /**
     * 租户ID
     */
    String TENANT_ID_DEFAULT = "1";

}
