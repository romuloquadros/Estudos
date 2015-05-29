package com.estudos.refactor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class LoggerProxy implements InvocationHandler {

	private Object obj;

	public LoggerProxy(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Long initialTime = new Date().getTime();
		Object invoke = method.invoke(obj, args);
		Long finalTime = new Date().getTime();

		Long totalTime = finalTime - initialTime;

		System.out.println("Total time in Millis: " + totalTime);
		return invoke;
	}

	public static Object createProxy(Object obj) {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new LoggerProxy(obj));
	}

}
