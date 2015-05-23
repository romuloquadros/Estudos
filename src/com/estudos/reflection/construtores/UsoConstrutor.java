package com.estudos.reflection.construtores;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UsoConstrutor {

	public UsoConstrutor(String value) {
		System.out.println("Construtor chamado com o valor: " + value);
	}	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<UsoConstrutor> clazz = UsoConstrutor.class;
		Constructor<UsoConstrutor> constructor = clazz.getConstructor(String.class);
		
			try {
				constructor.newInstance("ABC123");
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("Erro do construtor: " + e.getTargetException());
			}
		
	}
	
}
