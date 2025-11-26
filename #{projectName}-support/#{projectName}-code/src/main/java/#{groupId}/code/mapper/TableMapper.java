
package #{groupId}.code.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import #{groupId}.code.entity.Table;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import #{groupId}.code.vo.ColumnInfoVO;
import #{groupId}.code.vo.TableInfoVO;

import java.util.List;

/**
 * <p>
 * 代码生成基础表 Mapper 接口
 * </p>
 *
 * @author #{author}
 */
public interface TableMapper extends BaseMapper<Table> {

    /**
     * 分页查询表格
     *
     * @param page      分页参数
     * @param tableName 表名
     * @return
     */
    IPage<TableInfoVO> selectByPage(IPage<?> page, @Param("tableName") String tableName);

    /**
     * 从数据库内查询表信息
     *
     * @param tableName
     * @return
     */
    TableInfoVO queryTableInfo(@Param("tableName") String tableName);

    /**
     * 查询列信息
     * @param tableName 表名
     * @return List<ColumnInfo>
     */
    List<ColumnInfoVO> listColumnInfo(@Param("tableName") String tableName);

}
