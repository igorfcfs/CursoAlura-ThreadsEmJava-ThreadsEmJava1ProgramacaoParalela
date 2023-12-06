package br.com.alura.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() { // este metodo realiza uma operacao atomica: cuja execucao nao pode ser
								// interrompida pela metade
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this/* "chave que tranca o banheiro" - Mutex */) { // "trancar o banheiro"
			// esse bloco pode ser executado por uma thread apenas
			System.out.println(nome + " entrando no banheiro");

			while(ehSujo) {
				esperaLaFora(nome);
			}

			System.out.println(nome + " fazendo coisa rapida");

			dormeUmPouco(5000);
			
			this.ehSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	public void fazNumero2() { // este metodo realiza uma operacao atomica: cuja execucao nao pode ser
								// interrompida pela metade
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized (this/* "chave que tranca o banheiro" - Mutex */) { // "trancar o banheiro"
			// esse bloco pode ser executado por uma thread apenas
			System.out.println(nome + " entrando no banheiro");
			
			while(ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa demorada");
			
			dormeUmPouco(10000);
			
			this.ehSujo = true;

			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as maos");
			System.out.println(nome + " saindo do banheiro");
		}
	}

	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void limpa() { //a pessoa que limpa o banheiro so pode entrar quando alguem terminar de usa-lo, por isso a palavra chave synchronized
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			System.out.println(nome + " entrando no banheiro");
			
			if(!ehSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return; // termina o metodo
			}
			
			System.out.println(nome + " limpando banheiro");
			this.ehSujo = false;
			
			dormeUmPouco(13000);
			
			this.notifyAll();
			
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro tá sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
