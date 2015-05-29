package com.estudos.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AsyncProxy implements InvocationHandler {

	private Object obj;

	public AsyncProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getReturnType() == void.class) {
			new Thread() {
				public void run() {
					try {
						method.invoke(obj, args);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				};
			}.start();
			return null;
		} else {
			return method.invoke(obj, args);
		}
	}

	public static Object createProxy(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AsyncProxy(obj));
	}

}
