package br.com.digital.innovation.one.aula2;

public class FuncaoAltaOrdem {
	public static void main(String[] args) {
		Calculo SOMA = (a, b) -> a+b;
		Calculo SUBTRACAO = (a, b) -> a-b;
		Calculo DIVISAO = (a, b) -> a/b;
		Calculo MULT = (a, b) -> a*b;
		
			System.out.println(executarOperacao(SOMA, 2, 5)); //7
			System.out.println(executarOperacao(SUBTRACAO, 10, 5)); //5
			System.out.println(executarOperacao(DIVISAO, 25, 5)); // 5
			System.out.println(executarOperacao(MULT, 8, 5)); //40
	}
	
	public static int executarOperacao(Calculo calculo,int a, int b) {
		return calculo.calcular(a, b);
	}
}

@FunctionalInterface
interface Calculo {
	public int calcular(int a, int b);
}

//RECEBE OUTRA FUNÇÃO COMO PARÂMETRO
// OU RETORNA UMA FUNÇÃO