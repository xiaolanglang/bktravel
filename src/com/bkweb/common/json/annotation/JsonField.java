package com.bkweb.common.json.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Json字段注解
 * @author Administrator
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField {

	/**
	 * 导出字段名（默认调用当前字段的“get”方法，如指定导出字段为对象，请填写“对象名.对象属性”，例：“area.name”、“office.name”）
	 */
	String value() default "";
	
	/**
	 * 导出字段标题（需要添加批注请用“**”分隔，标题**批注，仅对导出模板有效）
	 */
	String title();

	/**
	 * 导出字段字段排序（升序）
	 */
	int sort() default 0;
}
