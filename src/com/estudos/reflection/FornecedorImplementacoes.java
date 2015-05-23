package com.estudos.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FornecedorImplementacoes {

	private Map<Class<?>, Class<?>> implementacoes = new HashMap<>();

	public FornecedorImplementacoes(String nomeArquivo) throws Exception {

		Properties p = new Properties();
		p.load(new FileInputStream(nomeArquivo));
		for (Object interf : p.keySet()) {
			Class<?> interfType = Class.forName(interf.toString());
			Class<?> implType = Class.forName(p.get(interf).toString());
			if (!isAbstractAndImplementation(interfType, implType)) {
				throw new Exception("Erro na configuracao do arquivo "+ nomeArquivo + " : " + interfType.getName() + "não é abstração de " + implType.getName());
			}
			implementacoes.put(interfType, implType);
		}
	}

	public Class<?> getImplementacao(Class<?> interf) {
		return implementacoes.get(interf);
	}

	private boolean isInterfaceOrAbstract(Class<?> clazz) {
		return clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers());
	}
	
	private boolean isAbstractAndImplementation(Class<?> interf, Class<?> impl) {
		return isInterfaceOrAbstract(interf) && !isInterfaceOrAbstract(impl) && interf.isAssignableFrom(impl);
		
	}
	
	public static void main(String[] args) throws Exception {
		try {
			File file = new File("resources/implementacoes.prop");
			FornecedorImplementacoes f = new FornecedorImplementacoes(file.getAbsolutePath());
			Class<?> implementacao = f.getImplementacao(DAO.class);
			if (implementacao != null) {
				System.out.println("Implementacao recuperada: " + implementacao.getName());
			}

		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Problema ao buscar implementacoes " + e.getMessage());
		}
	}

	class DAO {

	}

}
