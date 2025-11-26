package #{groupId}.code.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import #{groupId}.code.entity.SysDataSource;
import #{groupId}.code.mapper.SysDataSourceMapper;
import #{groupId}.code.service.ISysDataSourceService;
import #{groupId}.code.vo.SysDataSourceVO;
import #{groupId}.core.common.vo.BaseListVO;
import #{groupId}.core.web.util.CollectionUtil;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据源表 服务实现类
 * </p>
 *
 * @author #{author}
 */
@Service
public class SysDataSourceServiceImpl extends ServiceImpl<SysDataSourceMapper, SysDataSource> implements ISysDataSourceService {

    @Override
    public IPage<SysDataSource> listPage(Map<String, String> query) {
        long current = CollectionUtil.strToLong(query.get("current"), 0L);
        long size = CollectionUtil.strToLong(query.get("size"), 0L);
        IPage<SysDataSource> page = new Page<>(current, size);
        String keyword = String.valueOf(query.get("keyword"));
        String startDate = String.valueOf(query.get("startDate"));
        String endDate = String.valueOf(query.get("endDate"));
        LambdaQueryWrapper<SysDataSource> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(startDate) && !startDate.equals("null")) {
            lambdaQueryWrapper.between(SysDataSource::getCreateTime, startDate, endDate);
        }
        if (StrUtil.isNotBlank(keyword) && !keyword.equals("null")) {
            lambdaQueryWrapper.like(SysDataSource::getName, keyword);
            lambdaQueryWrapper.or();
            lambdaQueryWrapper.like(SysDataSource::getId, keyword);
        }
        return this.baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public List<BaseListVO> optionList() {
        return this.baseMapper.optionList();
    }
}
