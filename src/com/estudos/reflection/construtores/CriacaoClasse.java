package com.estudos.reflection.construtores;

import java.io.IOException;

public class CriacaoClasse {

	public CriacaoClasse() throws IOException {
		throw new IOException();
	}
	
	public static void main(String[] args) {
		try {
			CriacaoClasse.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
