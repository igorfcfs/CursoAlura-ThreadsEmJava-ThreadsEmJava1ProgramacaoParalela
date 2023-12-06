package br.com.alura.lista;

public class Lista {
	
	private String[] elementos = new String[1000];
	private int indice;
	
	public synchronized void adicionarElementos(String elemento) {
//		synchronized(this) {
//			this.elementos[indice] = elemento;
//			this.indice++;
//		}
		this.elementos[indice] = elemento;
		this.indice++;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(this.indice == this.elementos.length) {
			System.out.println("Lista ta cheia, notificando");
			this.notify();
		}
	}
	
	public int tamanho() {
		return this.elementos.length;
	}
	
	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}
	
	public boolean estaCheia() {
		return this.indice == this.tamanho();
	}
}
