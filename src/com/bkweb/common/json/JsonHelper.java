package com.bkweb.common.json;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.bkweb.common.json.annotation.JsonField;
import com.bkweb.sys.log.entity.Log;
import com.google.common.collect.Lists;

public class JsonHelper {

	public static Field[] getBeanFields(Class<?> cls,Field[] fs){
		fs = (Field[]) ArrayUtils.addAll(fs, cls.getDeclaredFields());
		if(cls.getSuperclass()!=null){
			Class<?> clsSup = cls.getSuperclass();
			fs = getBeanFields(clsSup,fs);
		}
		return fs;
	}

	/**
	 * 获取类对象的标题列表
	 * @param cls
	 * @return
	 */
	public static List<Title> GetTitleMap(Class<?> cls)
	{
		List<Title> list=Lists.newArrayList();
		
		Field[] fields = cls.getDeclaredFields();
		if(cls.getSuperclass()!=null){
			Class<?> clsSup = cls.getSuperclass();
			fields = getBeanFields(clsSup,fields);
		}
		for (Field field : fields) {
			if(field.isAnnotationPresent(JsonField.class)==true){
				JsonField jsonField=field.getAnnotation(JsonField.class);
				Title title=new Title();
				if (jsonField.value().equals("")) {
					title.setValue(field.getName());
				}else {
					title.setValue(jsonField.value());
				}
				title.setTitle(jsonField.title());
				title.setSort(jsonField.sort());
				list.add(title);
			}
		}
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		// get field annotation   
		List<Title> list=GetTitleMap(Log.class);
		for(Title title:list)
		{
			System.out.println(title);
		}
	}

}
