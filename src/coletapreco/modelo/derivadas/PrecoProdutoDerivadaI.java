package coletapreco.modelo.derivadas;

import coletapreco.modelo.Produto;

public interface PrecoProdutoDerivadaI {

	// *** DESNORMALIZACAO *** BIG DATA

	public long getIdLojaVirtual();

	public void setIdLojaVirtual(long id);

	public long getIdNaturezaProduto();

	public void setIdNaturezaProduto(long id);

	public long getIdCategoraLoja();

	public void setIdCategoriaLoja(long id);
	
	public void setPosicao(long pos);
	
	public long getPosicao();
	
	// Posicao
	
	public int getPosicao1();
	public void setPosicao1(int pos);
	
	public int getPosicao2();
	public void setPosicao2(int pos);
	
	public int getPosicao3();
	public void setPosicao3(int pos);
	
	public int getPosicao4();
	public void setPosicao4(int pos);
	
	public int getPosicao5();
	public void setPosicao5(int pos);
	
	public int getPosicao6();
	public void setPosicao6(int pos);
	
	public int getPosicao7();
	public void setPosicao7(int pos);
	
	public int getDiferencaPosicao7();
	public void setDiferencaPosicao7(int pos);
	
	public float getPrecoSugestao();
	public void setPrecoSugestao(float preco);
	
	/*
	public int getPosicao8();
	public void setPosicao8(int pos);
	
	public int getPosicao9();
	public void setPosicao9(int pos);
	
	public int getPosicao10();
	public void setPosicao10(int pos);
	
	public int getPosicao11();
	public void setPosicao11(int pos);
	
	public int getPosicao12();
	public void setPosicao12(int pos);
	
	public int getPosicao13();
	public void setPosicao13(int pos);
	
	public int getPosicao14();
	public void setPosicao14(int pos);
	*/
	
	//*** Processamento BigData   ***
	public void descolaPosicao();
	public void calculaDiferencaPosicao();
	public void calculaPrecoSugestao();
	
	
	public void processaDiario(Produto produto);
	public void processaParaOportunidade(Produto produto);
}
