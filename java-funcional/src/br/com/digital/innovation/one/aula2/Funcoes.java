package br.com.digital.innovation.one.aula2;

import java.util.function.Function;

public class Funcoes {
	public static void main(String[] args) {
		Function<String, String> retornaNomeInverso = texto -> new StringBuilder(texto).reverse().toString();
		Function<String, Integer> converterStringParaInteiroEDobrar = string -> Integer.valueOf(string) * 2;
		System.out.println(retornaNomeInverso.apply("Romano"));
		System.out.println(converterStringParaInteiroEDobrar.apply("5"));
	}
}
