package br.com.alura.threads;

public class Principal {
	
	public static void main(String[] args) {
		
		String nome = "da";
		
		Thread assinaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
		Thread assinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
		Thread autores = new Thread(new TarefaBuscaTextual("autores.txt", nome));
		
		assinaturas1.start();
		assinaturas2.start();
		autores.start();
	}
}
