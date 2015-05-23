package com.estudos.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InformacaoHierarquicaDaClasse {

	public static void main(String[] args) {
		System.out.println("Entre com o nome da classe que deseja informação:");

		Scanner in = new Scanner(System.in);
		String nomeClasse = in.nextLine();
		
		try {
			Class<?> forName = Class.forName(nomeClasse);
			imprimeHierarquia(forName, 1);
		} catch(ClassNotFoundException e) {
			System.out.println("A classe " +nomeClasse+ " não foi encontada" );
		}
		in.close();
	}

	private static void imprimeHierarquia(Class<?> forName, int nivel) {
		List<Class<?>> superclassEInterfaces = getSuperclassEInterfaces(forName);
		String tabulacao = "";
		for (int i = 0; i < nivel; i++) {
			tabulacao+="	";
		}
		
		for (Class<?> clazz : superclassEInterfaces) {
			System.out.println(tabulacao+"|-> "+clazz.getName());
			if (clazz != Object.class) {
				imprimeHierarquia(clazz, nivel+1);
			}
		}
		
	}

	private static List<Class<?>> getSuperclassEInterfaces(Class<?> clazz) {
		List<Class<?>>  lista = new ArrayList<>();
		if (clazz.getSuperclass() != null) {
			lista.add(clazz.getSuperclass());
		}
		lista.addAll(Arrays.asList(clazz.getInterfaces()));
		return lista;
	}
	
}
