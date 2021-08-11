package br.com.digital.innovation.one.FatorialRecursivo;

public class FatorialTailCall {
	public static void main(String[] args) {
		System.out.println(fatorialA(10));
	}
	
	public static double fatorialA ( double value ) {
		return fatorialComTailCall(value, 1);
	}
	
	public static double fatorialComTailCall(double value, double numero) {
		if (value == 0) {
			return numero;
		}
		return fatorialComTailCall(value-1, numero*value);
	}

}
