package com.estudos.reflection;

public class ReferenciaEstaticaClasse {

	public static void main(String[] args) {
		Class<String> classe = String.class;
		
		System.out.println(classe.getName());
		imprimeNomeClass(Integer.class);
		
	}

	private static void imprimeNomeClass(Class<?> classe) {
		System.out.println("Chamado metodo com " + classe.getName());
	}
	
}
