package #{groupId}.code.test;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import #{groupId}.code.service.ITableService;
import #{groupId}.code.service.TableInfoService;
import #{groupId}.code.vo.ColumnInfoVO;
import #{groupId}.code.vo.TableInfoVO;

import java.util.List;

@Slf4j
@SpringBootTest
public class TableInfoTest {

    @Autowired
    private TableInfoService tableInfoService;

    @Autowired
    private ITableService tableService;

    /**
     * 测试指定数据源的分页表数据
     */
    @Test
    void getTableInfoPageTest() {
        IPage page = new Page();
        IPage<TableInfoVO> localdb = tableInfoService.queryPage(page, "", "localdb");

        log.info("tableInfo: {}", JSONObject.toJSONString(localdb));
    }

    @Test
    void getColumnInfoTest() {
        List<ColumnInfoVO> columnInfoVOS = tableInfoService.listColumnInfo("#{projectName}_sys_user", "master");
        log.info("columnInfo: {}", JSONObject.toJSONString(columnInfoVOS));
    }

    @Test
    void getTableTest() {
        tableService.initTable("#{projectName}_sys_user", "master");
    }
}
