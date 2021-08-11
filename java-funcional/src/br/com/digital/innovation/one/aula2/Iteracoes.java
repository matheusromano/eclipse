package br.com.digital.innovation.one.aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
	public static void main(String[] args) {
		String[] nomes = {"Matheus","Romano","Braga", "Desenvolvedor","Java"};
		Integer[] numeros = {1,2,3,4,5};
//		imprimirNomesFiltrados(nomes);
//		imprimirTodosOsNomes(nomes);
//		imprimirODobroDeCadaNumeroDaLista(numeros);
		
		List<String> profissoes = new ArrayList<>();
		profissoes.add("Desenvolvedor");
		profissoes.add("Testador");
		profissoes.add("Gerente de Projetos");
		profissoes.add("Gerente de Qualidade");
		
		profissoes.stream()
			.filter(profissao -> profissao.startsWith("Gerente"))
			.forEach(System.out::println);
		
		
		 
	}
	
	public static void imprimirNomesFiltrados(String... nomes) {
		
		String nomesParaImprimir = "";
		for (int i = 0; i < nomes.length ; i++) {
			if (nomes[i].equals("Matheus")) {
				nomesParaImprimir+=" "+nomes[i];
			}
		}
		
		System.out.println("Nomes de for: " + nomesParaImprimir);
		
		
		
		String nomesParaImprimirDaStream = Stream.of(nomes)
				.filter(nome -> nome.equals("Matheus"))				
				.collect(Collectors.joining());
		System.out.println("Nomes do Stream: " + nomesParaImprimirDaStream);
		
	}
		
		
	public static void imprimirTodosOsNomes(String... nomes){
		for (String nome : nomes) {
			System.out.println("Impresso pelo for: " + nome);
		}
		
		Stream.of(nomes)
				.forEach(nome -> System.out.println("impresso pelo forEach: " + nome));
	}
	
	public static void imprimirODobroDeCadaNumeroDaLista(Integer... numeros) {
		for(Integer numero : numeros) {
			System.out.println(numero*2);
		}
		Stream.of(numeros).map(numero -> numero*2)
							.forEach(System.out::println);
		
	}
		
}
		

