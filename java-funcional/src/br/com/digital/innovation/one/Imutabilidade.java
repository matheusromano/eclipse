package br.com.digital.innovation.one;

import java.util.function.UnaryOperator;

public class Imutabilidade {
	public static void main(String[] args) {
	int valor = 20;
	UnaryOperator<Integer> retornaDobro = v -> v * 2;
	System.out.println(retornaDobro.apply(valor));
	System.out.println(valor);
	}

}
