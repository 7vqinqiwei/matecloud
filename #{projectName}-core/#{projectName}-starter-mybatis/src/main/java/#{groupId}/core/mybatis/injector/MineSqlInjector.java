
package #{groupId}.core.mybatis.injector;

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

/**
 * 自定义的 sql 注入
 *
 * @author L.cm
 */
public class MineSqlInjector extends DefaultSqlInjector {

//	@Override
//	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
//		List<AbstractMethod> methodList = new ArrayList<>();
//		methodList.add(new InsertBatch());
//		methodList.add(new InsertIgnore());
//		methodList.add(new InsertIgnoreBatch());
//		methodList.add(new Replace());
//		methodList.add(new ReplaceBatch());
//		methodList.addAll(super.getMethodList(mapperClass));
//		return Collections.unmodifiableList(methodList);
//	}
}
