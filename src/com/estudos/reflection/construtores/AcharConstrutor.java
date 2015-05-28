package com.estudos.reflection.construtores;

import java.lang.reflect.Constructor;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 
 * Chamada de construtores que possuam parametros devem sempre ser com os
 * parametros na ordem correta.
 * 
 * @author romuloquadros
 *
 */
public class AcharConstrutor {

	public AcharConstrutor() {
	}

	public AcharConstrutor(String a) {
		System.out.println("Chamou construtor AcharConstrutor(String a), com valor: " + a);
	}

	public AcharConstrutor(Integer a, String b) {
		System.out.println("Chamou construtor AcharConstrutor(Integer a, String b), com valor: " + a + " / " + b);
	}

	public Constructor<?> acharConstrutor(Class<?> clazz, Object... objects) throws Exception {
		for (Constructor<?> constr : clazz.getConstructors()) {
			Class<?>[] parameterTypes = constr.getParameterTypes();
			if (parameterTypes.length == objects.length) {
				
				boolean erro = false;
				for (int i = 0; i < objects.length && !erro; i++) {
					if (!parameterTypes[i].isInstance(objects[i])) {
						erro = true;
					}
				}
				if (!erro) {
					return constr;
				}
			}
		}
		throw new Exception("Construtor não encontrado. ");
	}

	public static void main(String[] args) {

		AcharConstrutor acharConstrutor = new AcharConstrutor();

		try {
			String value = "teste";
			Constructor<?> construtor = acharConstrutor.acharConstrutor(acharConstrutor.getClass(), value);
			construtor.newInstance(value);

			Integer valor = 123;
			Constructor<?> construtor2 = acharConstrutor.acharConstrutor(acharConstrutor.getClass(), valor, value);
			construtor2.newInstance(valor, value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
