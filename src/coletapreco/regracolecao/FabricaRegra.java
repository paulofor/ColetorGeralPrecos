package coletapreco.regracolecao;

import  coletapreco.regracolecao.impl.*;

// versao templates

public  class FabricaRegra   {

	private static FabricaRegra _instancia =  null;
	public static FabricaRegra getInstancia() {
		if (_instancia==null) _instancia = new FabricaRegra();
		return _instancia;
	}

	//private  UsuarioRegraColecao _usuarioRegraColecao;
	public  UsuarioRegraColecao getUsuarioRegraColecao() {
		//if (_usuarioRegraColecao==null) _usuarioRegraColecao = new UsuarioRegraColecaoImpl();
		//return _usuarioRegraColecao;
		return new UsuarioRegraColecaoImpl();
	}
	//private  DispositivoUsuarioRegraColecao _dispositivoUsuarioRegraColecao;
	public  DispositivoUsuarioRegraColecao getDispositivoUsuarioRegraColecao() {
		//if (_dispositivoUsuarioRegraColecao==null) _dispositivoUsuarioRegraColecao = new DispositivoUsuarioRegraColecaoImpl();
		//return _dispositivoUsuarioRegraColecao;
		return new DispositivoUsuarioRegraColecaoImpl();
	}
	//private  ProdutoRegraColecao _produtoRegraColecao;
	public  ProdutoRegraColecao getProdutoRegraColecao() {
		//if (_produtoRegraColecao==null) _produtoRegraColecao = new ProdutoRegraColecaoImpl();
		//return _produtoRegraColecao;
		return new ProdutoRegraColecaoImpl();
	}
	//private  PrecoProdutoRegraColecao _precoProdutoRegraColecao;
	public  PrecoProdutoRegraColecao getPrecoProdutoRegraColecao() {
		//if (_precoProdutoRegraColecao==null) _precoProdutoRegraColecao = new PrecoProdutoRegraColecaoImpl();
		//return _precoProdutoRegraColecao;
		return new PrecoProdutoRegraColecaoImpl();
	}
	//private  ModeloProdutoRegraColecao _modeloProdutoRegraColecao;
	public  ModeloProdutoRegraColecao getModeloProdutoRegraColecao() {
		//if (_modeloProdutoRegraColecao==null) _modeloProdutoRegraColecao = new ModeloProdutoRegraColecaoImpl();
		//return _modeloProdutoRegraColecao;
		return new ModeloProdutoRegraColecaoImpl();
	}
	//private  ModeloProdutoProdutoRegraColecao _modeloProdutoProdutoRegraColecao;
	public  ModeloProdutoProdutoRegraColecao getModeloProdutoProdutoRegraColecao() {
		//if (_modeloProdutoProdutoRegraColecao==null) _modeloProdutoProdutoRegraColecao = new ModeloProdutoProdutoRegraColecaoImpl();
		//return _modeloProdutoProdutoRegraColecao;
		return new ModeloProdutoProdutoRegraColecaoImpl();
	}
	//private  LojaVirtualRegraColecao _lojaVirtualRegraColecao;
	public  LojaVirtualRegraColecao getLojaVirtualRegraColecao() {
		//if (_lojaVirtualRegraColecao==null) _lojaVirtualRegraColecao = new LojaVirtualRegraColecaoImpl();
		//return _lojaVirtualRegraColecao;
		return new LojaVirtualRegraColecaoImpl();
	}
	//private  MarcaRegraColecao _marcaRegraColecao;
	public  MarcaRegraColecao getMarcaRegraColecao() {
		//if (_marcaRegraColecao==null) _marcaRegraColecao = new MarcaRegraColecaoImpl();
		//return _marcaRegraColecao;
		return new MarcaRegraColecaoImpl();
	}
	//private  CategoriaLojaRegraColecao _categoriaLojaRegraColecao;
	public  CategoriaLojaRegraColecao getCategoriaLojaRegraColecao() {
		//if (_categoriaLojaRegraColecao==null) _categoriaLojaRegraColecao = new CategoriaLojaRegraColecaoImpl();
		//return _categoriaLojaRegraColecao;
		return new CategoriaLojaRegraColecaoImpl();
	}
	//private  CategoriaLojaProdutoRegraColecao _categoriaLojaProdutoRegraColecao;
	public  CategoriaLojaProdutoRegraColecao getCategoriaLojaProdutoRegraColecao() {
		//if (_categoriaLojaProdutoRegraColecao==null) _categoriaLojaProdutoRegraColecao = new CategoriaLojaProdutoRegraColecaoImpl();
		//return _categoriaLojaProdutoRegraColecao;
		return new CategoriaLojaProdutoRegraColecaoImpl();
	}
	//private  NaturezaProdutoRegraColecao _naturezaProdutoRegraColecao;
	public  NaturezaProdutoRegraColecao getNaturezaProdutoRegraColecao() {
		//if (_naturezaProdutoRegraColecao==null) _naturezaProdutoRegraColecao = new NaturezaProdutoRegraColecaoImpl();
		//return _naturezaProdutoRegraColecao;
		return new NaturezaProdutoRegraColecaoImpl();
	}
	//private  OportunidadeDiaRegraColecao _oportunidadeDiaRegraColecao;
	public  OportunidadeDiaRegraColecao getOportunidadeDiaRegraColecao() {
		//if (_oportunidadeDiaRegraColecao==null) _oportunidadeDiaRegraColecao = new OportunidadeDiaRegraColecaoImpl();
		//return _oportunidadeDiaRegraColecao;
		return new OportunidadeDiaRegraColecaoImpl();
	}
	//private  LojaNaturezaRegraColecao _lojaNaturezaRegraColecao;
	public  LojaNaturezaRegraColecao getLojaNaturezaRegraColecao() {
		//if (_lojaNaturezaRegraColecao==null) _lojaNaturezaRegraColecao = new LojaNaturezaRegraColecaoImpl();
		//return _lojaNaturezaRegraColecao;
		return new LojaNaturezaRegraColecaoImpl();
	}
	//private  PalavraRegraColecao _palavraRegraColecao;
	public  PalavraRegraColecao getPalavraRegraColecao() {
		//if (_palavraRegraColecao==null) _palavraRegraColecao = new PalavraRegraColecaoImpl();
		//return _palavraRegraColecao;
		return new PalavraRegraColecaoImpl();
	}
	//private  PalavraProdutoRegraColecao _palavraProdutoRegraColecao;
	public  PalavraProdutoRegraColecao getPalavraProdutoRegraColecao() {
		//if (_palavraProdutoRegraColecao==null) _palavraProdutoRegraColecao = new PalavraProdutoRegraColecaoImpl();
		//return _palavraProdutoRegraColecao;
		return new PalavraProdutoRegraColecaoImpl();
	}
	//private  UsuarioPesquisaRegraColecao _usuarioPesquisaRegraColecao;
	public  UsuarioPesquisaRegraColecao getUsuarioPesquisaRegraColecao() {
		//if (_usuarioPesquisaRegraColecao==null) _usuarioPesquisaRegraColecao = new UsuarioPesquisaRegraColecaoImpl();
		//return _usuarioPesquisaRegraColecao;
		return new UsuarioPesquisaRegraColecaoImpl();
	}
	//private  PrecoDiarioRegraColecao _precoDiarioRegraColecao;
	public  PrecoDiarioRegraColecao getPrecoDiarioRegraColecao() {
		//if (_precoDiarioRegraColecao==null) _precoDiarioRegraColecao = new PrecoDiarioRegraColecaoImpl();
		//return _precoDiarioRegraColecao;
		return new PrecoDiarioRegraColecaoImpl();
	}
	//private  ContagemProdutoRegraColecao _contagemProdutoRegraColecao;
	public  ContagemProdutoRegraColecao getContagemProdutoRegraColecao() {
		//if (_contagemProdutoRegraColecao==null) _contagemProdutoRegraColecao = new ContagemProdutoRegraColecaoImpl();
		//return _contagemProdutoRegraColecao;
		return new ContagemProdutoRegraColecaoImpl();
	}
	//private  FacebookPerfilRegraColecao _facebookPerfilRegraColecao;
	public  FacebookPerfilRegraColecao getFacebookPerfilRegraColecao() {
		//if (_facebookPerfilRegraColecao==null) _facebookPerfilRegraColecao = new FacebookPerfilRegraColecaoImpl();
		//return _facebookPerfilRegraColecao;
		return new FacebookPerfilRegraColecaoImpl();
	}
	//private  ProdutoClienteRegraColecao _produtoClienteRegraColecao;
	public  ProdutoClienteRegraColecao getProdutoClienteRegraColecao() {
		//if (_produtoClienteRegraColecao==null) _produtoClienteRegraColecao = new ProdutoClienteRegraColecaoImpl();
		//return _produtoClienteRegraColecao;
		return new ProdutoClienteRegraColecaoImpl();
	}
	//private  FacebookFanpageRegraColecao _facebookFanpageRegraColecao;
	public  FacebookFanpageRegraColecao getFacebookFanpageRegraColecao() {
		//if (_facebookFanpageRegraColecao==null) _facebookFanpageRegraColecao = new FacebookFanpageRegraColecaoImpl();
		//return _facebookFanpageRegraColecao;
		return new FacebookFanpageRegraColecaoImpl();
	}
	//private  AppProdutoRegraColecao _appProdutoRegraColecao;
	public  AppProdutoRegraColecao getAppProdutoRegraColecao() {
		//if (_appProdutoRegraColecao==null) _appProdutoRegraColecao = new AppProdutoRegraColecaoImpl();
		//return _appProdutoRegraColecao;
		return new AppProdutoRegraColecaoImpl();
	}
	//private  PalavraChavePesquisaRegraColecao _palavraChavePesquisaRegraColecao;
	public  PalavraChavePesquisaRegraColecao getPalavraChavePesquisaRegraColecao() {
		//if (_palavraChavePesquisaRegraColecao==null) _palavraChavePesquisaRegraColecao = new PalavraChavePesquisaRegraColecaoImpl();
		//return _palavraChavePesquisaRegraColecao;
		return new PalavraChavePesquisaRegraColecaoImpl();
	}
	//private  FacebookPostRegraColecao _facebookPostRegraColecao;
	public  FacebookPostRegraColecao getFacebookPostRegraColecao() {
		//if (_facebookPostRegraColecao==null) _facebookPostRegraColecao = new FacebookPostRegraColecaoImpl();
		//return _facebookPostRegraColecao;
		return new FacebookPostRegraColecaoImpl();
	}
	//private  FacebookPostPerformanceRegraColecao _facebookPostPerformanceRegraColecao;
	public  FacebookPostPerformanceRegraColecao getFacebookPostPerformanceRegraColecao() {
		//if (_facebookPostPerformanceRegraColecao==null) _facebookPostPerformanceRegraColecao = new FacebookPostPerformanceRegraColecaoImpl();
		//return _facebookPostPerformanceRegraColecao;
		return new FacebookPostPerformanceRegraColecaoImpl();
	}
	//private  InteresseProdutoRegraColecao _interesseProdutoRegraColecao;
	public  InteresseProdutoRegraColecao getInteresseProdutoRegraColecao() {
		//if (_interesseProdutoRegraColecao==null) _interesseProdutoRegraColecao = new InteresseProdutoRegraColecaoImpl();
		//return _interesseProdutoRegraColecao;
		return new InteresseProdutoRegraColecaoImpl();
	}
	//private  PrecoDiarioClienteRegraColecao _precoDiarioClienteRegraColecao;
	public  PrecoDiarioClienteRegraColecao getPrecoDiarioClienteRegraColecao() {
		//if (_precoDiarioClienteRegraColecao==null) _precoDiarioClienteRegraColecao = new PrecoDiarioClienteRegraColecaoImpl();
		//return _precoDiarioClienteRegraColecao;
		return new PrecoDiarioClienteRegraColecaoImpl();
	}
	//private  CompartilhamentoProdutoRegraColecao _compartilhamentoProdutoRegraColecao;
	public  CompartilhamentoProdutoRegraColecao getCompartilhamentoProdutoRegraColecao() {
		//if (_compartilhamentoProdutoRegraColecao==null) _compartilhamentoProdutoRegraColecao = new CompartilhamentoProdutoRegraColecaoImpl();
		//return _compartilhamentoProdutoRegraColecao;
		return new CompartilhamentoProdutoRegraColecaoImpl();
	}
	//private  OportunidadeInteresseClienteRegraColecao _oportunidadeInteresseClienteRegraColecao;
	public  OportunidadeInteresseClienteRegraColecao getOportunidadeInteresseClienteRegraColecao() {
		//if (_oportunidadeInteresseClienteRegraColecao==null) _oportunidadeInteresseClienteRegraColecao = new OportunidadeInteresseClienteRegraColecaoImpl();
		//return _oportunidadeInteresseClienteRegraColecao;
		return new OportunidadeInteresseClienteRegraColecaoImpl();
	}

}