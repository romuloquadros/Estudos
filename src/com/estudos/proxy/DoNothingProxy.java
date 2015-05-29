package com.estudos.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DoNothingProxy implements InvocationHandler {

	private Object obj;

	public DoNothingProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			return method.invoke(obj, args);
		} catch (InvocationTargetException e) {
			throw e;
		}
	}

}
