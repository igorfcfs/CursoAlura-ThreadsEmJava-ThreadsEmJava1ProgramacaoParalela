package br.com.alura.banco;

public class TarefaAcessoBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessoBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized(pool) {
			System.out.println("pegue a conexão");
			pool.getConnection();
			
			synchronized(tx) {
				System.out.println("começando a tx");
				tx.begin();
			}
		}
	}

}
