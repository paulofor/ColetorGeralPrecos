package coletapreco.modelo.derivadas;

import java.text.DecimalFormat;

import coletapreco.modelo.OportunidadeDia;

public class OportunidadeDiaDerivada implements OportunidadeDiaDerivadaI {
	private OportunidadeDia principal;

	public OportunidadeDiaDerivada(OportunidadeDia itemPrincipal) {
		principal = itemPrincipal;
	}

	@Override
	public String getCodigoImagemLocal() {
		return "img-" + String.format("%09d", principal.getIdProdutoRa()) + ".jpg";
	}

	@Override
	public void setCodigoImagemLocal(String dado) {
		throw new RuntimeException("Implementar metodo");
	}

	@Override
	public String getMensagemFacebook() {
		return getMensagem(this.principal);
	}

	@Override
	public void setMensagemFacebook(String dado) {
		throw new UnsupportedOperationException();
	}

	private String getMensagem2(OportunidadeDia oportunidade) {
		String marca = (oportunidade.getNomeMarca() != null ? oportunidade.getNomeMarca() + " - " : "");
		if ("null".equals(oportunidade.getNomeMarca().trim()))
			marca = "";
		String tituloProduto = oportunidade.getNomeProduto();
		String precoMedio = "Preco medio (60 dias) : R$ " + oportunidade.getPrecoMedioFormatada();
		String precoMinimo = "Preco minimo (60 dias) : R$ " + oportunidade.getPrecoMinimoFormatada();
		String precoAtual = "Oportunidade : (" + datas(oportunidade.getDataInicioPrecoAtual()) + ") : R$ "
				+ oportunidade.getPrecoVendaAtualFormatada();
		String loja = "Loja: " + oportunidade.getNomeLojaVirtual();
		// String link = "Baixe o aplicativo:
		// https://play.google.com/store/apps/details?id=br.com.lojadigicom.coletorprecocliente";
		// String link = "Baixa o aplicativo: " + this.getLinkAplicativo();
		String mensagem = precoAtual + "\n\n" + marca + tituloProduto + "\n" + precoMedio + "\n" + precoMinimo + "\n\n"
				+ loja;
		// link;
		return mensagem;
	}

	private String getMensagem(OportunidadeDia oportunidade) {
		String linha1 = "Acompanhe produtos com reducao de preco no dia.";
		String linha2 = "\n";
		String linha3 = "Preço em " + datas(oportunidade.getDataInicioPrecoAtual()) + " : R$ "
				+ oportunidade.getPrecoVendaAtualFormatada();
		String linha4 = "Preço médio (60 dias) : R$ " + oportunidade.getPrecoMedioFormatada();
		String linha5 = "Loja: " + oportunidade.getNomeLojaVirtual();

		return linha1 + "\n" + linha2 + "\n" + linha3 + "\n" + linha4 + "\n" + linha5;

	}

	/*
	 * private String getMensagem(OportunidadeDia oportunidade) { String preco =
	 * "Em " + datas(oportunidade.getDataUltimaPrecoAnterior()) + ": " +
	 * oportunidade.getQuantidadeParcelaAnterior() + " x R$ " +
	 * oportunidade.getPrecoParcelaAnteriorFormatada() + " = R$ " +
	 * oportunidade.getPrecoVendaAnteriorFormatada() + "\nEm " +
	 * datas(oportunidade.getDataInicioPrecoAtual()) + ": " +
	 * oportunidade.getQuantidadeParcelaAtual() + " x R$ " +
	 * oportunidade.getPrecoParcelaAtualFormatada() + " = R$ " +
	 * oportunidade.getPrecoVendaAtualFormatada(); String mensagem =
	 * (oportunidade.getNomeMarca()!=null?oportunidade.getNomeMarca() +
	 * "\n":""); mensagem = mensagem + oportunidade.getNomeProduto() + "\n\n" +
	 * preco; mensagem = mensagem + "\n\n Loja: " +
	 * oportunidade.getNomeLojaVirtual(); //String link =
	 * oportunidade.getUrlAfiliado(); //mensagem = mensagem + "\n\n" +
	 * "Compre na Dafiti => " + link; //mensagem = mensagem + "\n\n" +
	 * "Compre na Dafiti => "; return mensagem; }
	 */
	private String decimal(float valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(valor);
	}

	private String datas(String dataEnt) {
		return dataEnt.replaceAll("-", "/");
	}

	@Override
	public String getLinkAplicativo() {
		return this.principal.getCorrenteNaturezaProduto_PertenceA().getAppProdutoAtendidoPor(true).getUrlInstalacao();
	}

	@Override
	public void setLinkAplicativo(String dado) {
		// TODO Auto-generated method stub

	}

	private float precoSugestao;

	@Override
	public float getPrecoSugestao() {
		return precoSugestao;
	}

	@Override
	public void setPrecoSugestao(float preco) {
		this.precoSugestao = preco;
	}

	@Override
	public void calculaSugestaoPreco() {
		this.precoSugestao = 1.2f * this.principal.getPrecoVendaAnterior();
	}
	
	
	@Override
	public boolean aprovadaEnvio() {
		return (this.principal.getPercentualAjusteVenda() <= 50f);
	}
}
