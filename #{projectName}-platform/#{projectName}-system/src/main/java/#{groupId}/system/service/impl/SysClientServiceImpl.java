package #{groupId}.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import #{groupId}.core.database.entity.Search;
import #{groupId}.core.database.util.PageUtil;
import #{groupId}.core.web.util.CollectionUtil;
import #{groupId}.system.entity.SysClient;
import #{groupId}.system.mapper.SysClientMapper;
import #{groupId}.system.poi.SysClientPOI;
import #{groupId}.system.service.ISysClientService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 客户端表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class SysClientServiceImpl extends ServiceImpl<SysClientMapper, SysClient> implements ISysClientService {

    @Override
    public IPage<SysClient> listPage(Search search) {
        LambdaQueryWrapper<SysClient> queryWrapper = Wrappers.<SysClient>query().lambda()
                .between(StrUtil.isNotBlank(search.getStartDate()), SysClient::getCreateTime, search.getStartDate(), search.getEndDate());
        if (StrUtil.isNotBlank(search.getKeyword())) {
            queryWrapper.and(i -> i
                    .or().like(SysClient::getClientId, search.getKeyword())
                    .or().like(SysClient::getId, search.getKeyword()));
        }
        return this.baseMapper.selectPage(PageUtil.getPage(search), queryWrapper);
    }

    @Override
    public boolean status(String ids, String status) {
        Collection<? extends Serializable> collection = CollectionUtil.stringToCollection(ids);

        for (Object id : collection) {
            SysClient sysClient = this.baseMapper.selectById(CollectionUtil.objectToLong(id, 0L));
            sysClient.setStatus(status);
            this.baseMapper.updateById(sysClient);
        }
        return true;
    }

    @Override
    public List<SysClientPOI> export() {
        LambdaQueryWrapper<SysClient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysClient::getIsDeleted, 0);
        List<SysClient> sysClients = this.baseMapper.selectList(queryWrapper);
        return sysClients.stream().map(sysClient -> {
            SysClientPOI sysClientPOI = new SysClientPOI();
            BeanUtils.copyProperties(sysClient, sysClientPOI);
            return sysClientPOI;
        }).collect(Collectors.toList());
    }
}
