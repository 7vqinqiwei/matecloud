package #{groupId}.system.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import #{groupId}.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 忽略租户信息
     * @param sysUser
     * @return
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser selectOneIgnoreTenant(SysUser sysUser);
}
