package com.bkweb.common.entity.json;

import java.lang.annotation.Annotation;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.Annotated;

public class MyAnnotationIntrospector extends AnnotationIntrospector {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyAnnotationIntrospector() {
	}

	@Override
	public Version version() {
		return com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION;
	}

	@Override
	public boolean isAnnotationBundle(Annotation ann) {
		return false;
	}

	@Override
	public String[] findPropertiesToIgnore(Annotated ac) {
		String[] strs = { "hibernateLazyInitializer", "handler", "fieldHandler" };
		return strs;
	}

}
