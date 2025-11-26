package #{groupId}.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.database.util.PageUtil;
import #{groupId}.core.rule.entity.BlackList;
import #{groupId}.core.rule.service.IRuleCacheService;
import #{groupId}.core.web.util.CollectionUtil;
import #{groupId}.system.entity.SysBlacklist;
import #{groupId}.system.mapper.SysBlacklistMapper;
import #{groupId}.system.service.ISysBlacklistService;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 系统黑名单表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
@AllArgsConstructor
public class SysBlacklistServiceImpl extends ServiceImpl<SysBlacklistMapper, SysBlacklist> implements ISysBlacklistService {

    private final IRuleCacheService ruleCacheService;

    @Override
    public IPage<SysBlacklist> listPage(Search search) {
        LambdaQueryWrapper<SysBlacklist> queryWrapper = Wrappers.<SysBlacklist>lambdaQuery()
                .between(StrUtil.isNotBlank(search.getStartDate()), SysBlacklist::getCreateTime, search.getStartDate(), search.getEndDate());
        if (StrUtil.isNotBlank(search.getKeyword())) {
            queryWrapper.and(i -> i
                    .or().like(SysBlacklist::getId, search.getKeyword())
                    .or().like(SysBlacklist::getRequestUri, search.getKeyword()));
        }
        return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
    }

    @Override
    public boolean status(String ids, String status) {
        Collection<? extends Serializable> collection = CollectionUtil.stringToCollection(ids);

        for (Object id : collection) {
            SysBlacklist sysBlacklist = this.baseMapper.selectById(CollectionUtil.objectToLong(id, 0L));
            sysBlacklist.setStatus(status);
            this.baseMapper.updateById(sysBlacklist);
            //缓存操作-----start
            BlackList blackList = new BlackList();
            BeanUtils.copyProperties(sysBlacklist, blackList);
            ruleCacheService.setBlackList(blackList);
            //缓存操作----end
        }
        return true;
    }
}
