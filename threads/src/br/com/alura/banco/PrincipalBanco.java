package br.com.alura.banco;

public class PrincipalBanco {

	public static void main(String[] args) {

		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
		PoolDeConexao pool = new PoolDeConexao();
		
		new Thread(new TarefaAcessoBanco(pool, tx)).start();
		new Thread(new TarefaAcessoBancoProcedimento(pool, tx)).start();
	}
}
