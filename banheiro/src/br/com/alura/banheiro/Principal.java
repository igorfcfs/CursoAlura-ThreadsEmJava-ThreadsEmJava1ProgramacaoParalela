package br.com.alura.banheiro;

// Problema: os dois threads compartilham o mesmo objeto
// Solucao: sincronizar o acesso ao objeto - "trancar o banheiro"; fazer com que o codigo nao seja executado em paralelo
public class Principal {
	
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();
		
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Ana");
		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Maria");
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
		convidado4.start();
	}
}
