package br.com.alura.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();
			
		for(int i = 0; i < 10; i++) {
			new Thread(new AdicionarElemento(lista, i)).start();
		}
		
		new Thread(new TarefaImprimir(lista)).start();
		
		
		
//		List<String> lista = new ArrayList<>(); //Esta lista nao e synchronized, ou seja, ela nao e thread-safe
//		List<String> lista = Collections.synchronizedList(new ArrayList<String>()); //esta array list e synchronized, porem, e muito dificil de implementar
//		List<String> lista = new Vector<>();
//		
//		for(int i = 0; i < 10; i++) {
//			new Thread(new AdicionarElemento(lista, i)).start();
//		}
//		
//		Thread.sleep(2000);
//		
//		for(int i = 0; i < lista.size(); i++) {
//			System.out.println(i + " - " + lista.get(i));
//		}
	}
}
