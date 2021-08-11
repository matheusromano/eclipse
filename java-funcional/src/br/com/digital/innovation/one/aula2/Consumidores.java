package br.com.digital.innovation.one.aula2;

import java.util.function.Consumer;

public class Consumidores {
	public static void main(String[] args) {
		
//		- apenas consome o dado, nao gera retorno além do que foi passado;
//		- utilizar o parâmetro da forma que ele foi recebido;
		
		Consumer<String> imprimirUmaFrase = System.out::println;
		//Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
		imprimirUmaFrase.accept("Olá Mundo");
	}
}