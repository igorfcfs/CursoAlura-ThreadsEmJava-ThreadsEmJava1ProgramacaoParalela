package br.com.alura.threads;

public class PrincipalOrdemExecucao {

	public static void main(String[] args) {
		
		new Thread(new TarefaImprimeNumeros()).start();
        new Thread(new TarefaImprimeNumeros()).start();
	}
}
