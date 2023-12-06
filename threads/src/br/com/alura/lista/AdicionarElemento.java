package br.com.alura.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class AdicionarElemento implements Runnable {

	private Lista lista;
//	private List<String> lista;
//	private List<String> lista = Collections.synchronizedList(new ArrayList<String>()); //esta array list e synchronized, porem, e muito dificil de implementar
//	private List<String> lista = new Vector<>();
	private int numeroThread;

	public AdicionarElemento(Lista/*List<String>*/ lista, int numeroThread) {
		this.lista = lista;
		this.numeroThread = numeroThread;
	}

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			lista.adicionarElementos("Thread " + this.numeroThread + " - " + i);
//			lista.add("Thread " + this.numeroThread + " - " + i);
		}
	}
}
