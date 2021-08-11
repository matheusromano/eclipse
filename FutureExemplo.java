package br.com.digital.innovation.one.aula3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExemplo {
	private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException {
		Casa casa = new Casa(new Quarto());
		List<? extends Future<String>> futuros = 
				new CopyOnWriteArrayList<>(casa.obterTarefasDeCasa().stream()
						.map( atividade -> pessoasParaExecutarAtividade.submit(() -> {
								try {
									return atividade.realizar();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								return null;
							})
						)			
								.collect(Collectors.toList()));


				while (true) {
					int numeroDeAtividadesNaoRealizadas = 0;
					for (Future<?> futuro : futuros) {
						if(futuro.isDone()) {
							try {
								System.out.println("Parabéns você terminou de "+futuro.get());
								futuros.remove(futuro);
							} catch (InterruptedException e) {
								e.printStackTrace();
							} catch (ExecutionException e) {
								e.printStackTrace();
							}
						}
						else {
							numeroDeAtividadesNaoRealizadas++;
						}
					}
					if (futuros.stream().allMatch(Future::isDone)) {
						break;	
					}

					System.out.println("Número de atividades não realiozadas: "+numeroDeAtividadesNaoRealizadas);
					Thread.sleep(500);

				}
				pessoasParaExecutarAtividade.shutdown();
	}
}








class Casa {
	private List<Comodo> comodos;

	Casa(Comodo... comodos) { this.comodos = Arrays.asList(comodos); }

	List<Atividade> obterTarefasDeCasa() {
		return this.comodos.stream().map(Comodo::obterTarefasDoComodo)
				.reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
					pivo.addAll(atividades);

					return pivo;
				});
	} 
}

interface Atividade {
	String realizar() throws InterruptedException;

}

abstract class Comodo {
	abstract List<Atividade> obterTarefasDoComodo();
}

class Quarto extends Comodo {
	@Override
	List<Atividade> obterTarefasDoComodo() {
		return Arrays.asList(
				this::getArrumarACama,
				this::varrerOQuarto,
				this::arrumarGuardaRoupa
				);
	}

	private String arrumarGuardaRoupa() throws InterruptedException { 
		Thread.sleep(5000);
		String arrumar_o_guarda_roupa = "arrumar o guarda roupa";
		System.out.println("Arrumar o guarda roupa"); 
		return arrumar_o_guarda_roupa;

	}

	private String varrerOQuarto() throws InterruptedException { 
		Thread.sleep(7000);
		String varrer_o_quarto = "varrer o quarto";
		System.out.println("varrer o quarto"); 
		return varrer_o_quarto;
	}

	private String getArrumarACama() throws InterruptedException {
		Thread.sleep(10000);
		String arrumar_a_cama = "Arrumar a cama";
		System.out.println("Arrumar a cama");
		return arrumar_a_cama;	
	} 

}









