package com.epam.jmp.classloading.utils;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class MethodCaller {

	private static final Logger log = Logger.getLogger(MethodCaller.class);	
	
	private static final Class[] DEFAULT_ARGS_TYPES = { String[].class };
	private static final Object[] DEFAULT_ARGS_VALUES = { new String[] {} };

	public static void callVoidMethod(Class c, String methodName, Class[] argsTypes, Object[] argsValues) {

		try {
			
			Method method = c.getMethod(methodName, argsTypes);
			method.invoke(null, argsValues);
		
		} catch (Exception e) {
			log.error("Method Invocation error:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static void callVoidMethod(Class c, String methodName) {
		callVoidMethod(c, methodName, DEFAULT_ARGS_TYPES, DEFAULT_ARGS_VALUES);
	}
}
