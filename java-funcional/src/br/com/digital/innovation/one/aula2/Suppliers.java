package br.com.digital.innovation.one.aula2;

import java.util.function.Supplier;

public class Suppliers {
	public static void main(String[] args) {
		Supplier<Pessoa> instanciarPessoa = () -> new Pessoa();
		Supplier<Pessoa> instanciarPessoa2 = Pessoa::new;
		System.out.println(instanciarPessoa.get());
		System.out.println(instanciarPessoa2.get());
		
	}
}


class Pessoa {
	private String nome;
	private Integer idade;
	
	public Pessoa() {
		nome = "Matheus";
		idade = 20;
	}
	
	@Override
	public String toString() {
		return String.format("nome : %s, idade : %d",nome,idade) ;
	}
 }