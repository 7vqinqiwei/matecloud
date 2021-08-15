package vip.mate.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.mate.core.database.entity.Search;
import vip.mate.core.database.util.PageUtil;
import vip.mate.system.entity.SysRole;
import vip.mate.system.entity.SysRolePermission;
import vip.mate.system.mapper.SysRoleMapper;
import vip.mate.system.poi.SysRolePOI;
import vip.mate.system.service.ISysRolePermissionService;
import vip.mate.system.service.ISysRoleService;
import vip.mate.system.vo.SysRoleVO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xuzf
 * @since 2020-06-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    private final static String NULL = "null";
    @Autowired
    private ISysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysRoleVO> tree() {
        return this.baseMapper.tree();
    }

    @Override
    public IPage<SysRole> listPage(Search search) {
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(search.getStartDate()) && !search.getStartDate().equals(NULL)) {
            lambdaQueryWrapper.between(SysRole::getCreateTime, search.getStartDate(), search.getEndDate());
        }
        if (StrUtil.isNotEmpty(search.getKeyword())) {
            lambdaQueryWrapper.and(i -> i
                    .or().like(SysRole::getRoleName, search.getKeyword())
                    .or().like(SysRole::getId, search.getKeyword()));
        }
        return this.baseMapper.selectPage(PageUtil.getPage(search), lambdaQueryWrapper);
    }

    @Override
    public List<SysRole> listSearch(Map<String, String> search) {
        String keyword = String.valueOf(search.get("keyword"));
        String startDate = String.valueOf(search.get("startDate"));
        String endDate = String.valueOf(search.get("endDate"));
        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(startDate) && !startDate.equals(NULL)) {
            lambdaQueryWrapper.between(SysRole::getCreateTime, startDate, endDate);
        }
        if (StrUtil.isNotEmpty(keyword) && !keyword.equals(NULL)) {
            lambdaQueryWrapper.and(i -> i
                    .or().like(SysRole::getRoleName, keyword)
                    .or().like(SysRole::getId, keyword));
        }
        return this.baseMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<String> getPermission(String id) {
        LambdaQueryWrapper<SysRolePermission> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRolePermission::getRoleId, id);
        List<SysRolePermission> sysRolePermissions = sysRolePermissionService.list(lambdaQueryWrapper);
        List<String> list = sysRolePermissions.stream().map(sysRolePermission -> {
            String menuId = sysRolePermission.getMenuId().toString();
            return menuId;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<SysRolePOI> export() {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRole::getIsDeleted, 0);
        List<SysRole> sysRoles = this.baseMapper.selectList(queryWrapper);
        return sysRoles.stream().map(sysRole -> {
            SysRolePOI sysRolePOI = new SysRolePOI();
            BeanUtils.copyProperties(sysRole, sysRolePOI);
            return sysRolePOI;
        }).collect(Collectors.toList());
    }


}
