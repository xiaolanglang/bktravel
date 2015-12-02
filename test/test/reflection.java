package test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.bktravel.modules.position.entity.Nation;
import com.bkweb.common.utils.Reflections;

public class reflection {
	@Test
	public void test() {
		Nation nation = new Nation();
		nation.setName("12312321");

		for (Class<?> clazz = nation.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				Field[] fields = clazz.getDeclaredFields();

				fields(nation, fields);

			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
	}

	private void fields(Nation nation, Field[] fields) {
		for (Field field : fields) {
			try {
				Object value = Reflections.invokeGetter(nation, field.getName());
				System.out.println(field.getName() + ">>>>" + value);
			} catch (IllegalArgumentException e) {
				// TODO: handle exception
			}
		}
	}
}
