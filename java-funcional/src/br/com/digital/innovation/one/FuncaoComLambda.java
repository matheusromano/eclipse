package br.com.digital.innovation.one;

public class FuncaoComLambda {
	public static void main(String[] args) {
		Funcao1 funcao1 = valor -> {
			return valor;
		};
		System.out.println(funcao1.gerar("Matheus"));
		
		
	}
}	
	
interface Funcao1 {
	String gerar(String valor);
}

