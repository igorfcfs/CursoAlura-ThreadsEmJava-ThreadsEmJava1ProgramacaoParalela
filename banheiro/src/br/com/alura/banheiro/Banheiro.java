package br.com.alura.banheiro;

public class Banheiro {
	
	public void fazNumero1() { //este metodo realiza uma operacao atomica: cuja execucao nao pode ser interrompida pela metade
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized(this/*"chave que tranca o banheiro" - Mutex*/) { //"trancar o banheiro"
			//esse bloco pode ser executado por uma thread apenas
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa rapida");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}
	public void fazNumero2() { //este metodo realiza uma operacao atomica: cuja execucao nao pode ser interrompida pela metade
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized(this/*"chave que tranca o banheiro" - Mutex*/) { //"trancar o banheiro"
			//esse bloco pode ser executado por uma thread apenas
			System.out.println(nome + " entrando no banheiro");
			System.out.println(nome + " fazendo coisa demorada");
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

}
