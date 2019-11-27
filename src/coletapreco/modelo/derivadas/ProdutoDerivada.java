package coletapreco.modelo.derivadas;

import br.com.digicom.lib.*;

import coletapreco.modelo.*;

public class ProdutoDerivada implements ProdutoDerivadaI {

	private long idLojaVirtual;
	private long idNaturezaProduto;
	private long idCategoriaLoja;

	private Produto principal;

	public ProdutoDerivada(Produto itemPrincipal) {
		principal = itemPrincipal;
	}

	// private long posicao;

	@Override
	public long getPosicao() {
		return principal.getPosicaoProduto();
	}

	@Override
	public void setPosicao(long dado) {
		principal.setPosicaoProduto(dado);
	}

	@Override
	public String getCodigoImagemLocal() {
		return "img-" + String.format("%09d", principal.getIdProduto()) + ".jpg";
	}

	@Override
	public void setCodigoImagemLocal(String dado) {
		throw new RuntimeException("Implementar metodo");
	}

	// DESNORMALIZACAO - BIGDATA
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

}
