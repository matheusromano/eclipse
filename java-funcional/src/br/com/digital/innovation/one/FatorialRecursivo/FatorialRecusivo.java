package br.com.digital.innovation.one.FatorialRecursivo;

public class FatorialRecusivo {
	public static void main(String[] args) {
		System.out.println(fatorial(5));
	}
	
	public static int fatorial ( int value ) {
		if ( value == 1) {
			return value;
		} else {
			return value * fatorial((value - 1));
		}
	}

}
