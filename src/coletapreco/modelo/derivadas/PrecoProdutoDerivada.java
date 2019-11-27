package coletapreco.modelo.derivadas;

import br.com.digicom.lib.*;

import coletapreco.modelo.*;

public class PrecoProdutoDerivada implements PrecoProdutoDerivadaI {

	private long posicao;
	
	private long idLojaVirtual;
	private long idNaturezaProduto;
	private long idCategoriaLoja;
	
	private int posicao1;
	private int posicao2;
	private int posicao3;
	private int posicao4;
	private int posicao5;
	private int posicao6;
	private int posicao7;
	private int diferencaPosicao7;
	
	private float precoSugestao;
	
	

	private PrecoProduto principal;

	public PrecoProdutoDerivada(PrecoProduto itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public long getIdLojaVirtual() {
		return idLojaVirtual;
	}

	@Override
	public void setIdLojaVirtual(long id) {
		idLojaVirtual = id;
	}

	@Override
	public long getIdNaturezaProduto() {
		return this.idNaturezaProduto;
	}

	@Override
	public void setIdNaturezaProduto(long id) {
		this.idNaturezaProduto = id;
	}

	@Override
	public long getIdCategoraLoja() {
		return this.idCategoriaLoja;
	}

	@Override
	public void setIdCategoriaLoja(long id) {
		this.idCategoriaLoja = id;
	}
	
	@Override
	public long getPosicao() {
		return this.posicao;
	}

	@Override
	public void setPosicao(long pos) {
		this.posicao = pos;
	}

	public int getPosicao1() {
		return posicao1;
	}

	public void setPosicao1(int posicao1) {
		this.posicao1 = posicao1;
	}

	public int getPosicao2() {
		return posicao2;
	}

	public void setPosicao2(int posicao2) {
		this.posicao2 = posicao2;
	}

	public int getPosicao3() {
		return posicao3;
	}

	public void setPosicao3(int posicao3) {
		this.posicao3 = posicao3;
	}

	public int getPosicao4() {
		return posicao4;
	}

	public void setPosicao4(int posicao4) {
		this.posicao4 = posicao4;
	}

	public int getPosicao5() {
		return posicao5;
	}

	public void setPosicao5(int posicao5) {
		this.posicao5 = posicao5;
	}

	public int getPosicao6() {
		return posicao6;
	}

	public void setPosicao6(int posicao6) {
		this.posicao6 = posicao6;
	}

	public int getPosicao7() {
		return posicao7;
	}

	public void setPosicao7(int posicao7) {
		this.posicao7 = posicao7;
	}

	public int getDiferencaPosicao7() {
		return diferencaPosicao7;
	}

	public void setDiferencaPosicao7(int diferencaPosicao7) {
		this.diferencaPosicao7 = diferencaPosicao7;
	}

	public void descolaPosicao() {
		this.posicao7 = this.posicao6;
		this.posicao6 = this.posicao5;
		this.posicao5 = this.posicao4;
		this.posicao4 = this.posicao3;
		this.posicao3 = this.posicao2;
		this.posicao2 = this.posicao1;
		this.posicao1 = (int) this.posicao;
	}
	public void calculaDiferencaPosicao() {
		this.diferencaPosicao7 = this.posicao7 - (int)this.posicao; // de hoje contra mesmo dia semana passada.
	}

	@Override
	public float getPrecoSugestao() {
		return precoSugestao;
	}
	@Override
	public void setPrecoSugestao(float preco) {
		this.precoSugestao = preco;
	}
	
	public void calculaPrecoSugestao() {
		this.precoSugestao = (float) (this.principal.getPrecoVenda() * 1.3);
		//this.precoSugestao = 1;
	}

	
	
	@Override
	public void processaDiario(Produto produto) {
		descolaPosicao();
		setPosicao(produto.getPosicaoProduto());
		calculaDiferencaPosicao();
		setIdCategoriaLoja(produto.getIdCategoraLoja());
		setIdLojaVirtual(produto.getIdLojaVirtual());
		setIdNaturezaProduto(produto.getIdNaturezaProduto());
		//calculaPrecoSugestao();
	}
	

	@Override
	public void processaParaOportunidade(Produto produto) {
		calculaPrecoSugestao();
	}
	
}
