package coletapreco.dao;

import  coletapreco.dao.*;

// versao templates

public  class DBB   {


	private static DBB _instancia =  null;
	public static DBB getInstancia() {
		if (_instancia==null) _instancia = new DBB();
		return _instancia;
	}
	public DBB() {
	
		_UsuarioDao = null;
	
		_DispositivoUsuarioDao = null;
	
		_ProdutoDao = null;
	
		_PrecoProdutoDao = null;
	
		_ModeloProdutoDao = null;
	
		_ModeloProdutoProdutoDao = null;
	
		_LojaVirtualDao = null;
	
		_MarcaDao = null;
	
		_CategoriaLojaDao = null;
	
		_CategoriaLojaProdutoDao = null;
	
		_NaturezaProdutoDao = null;
	
		_OportunidadeDiaDao = null;
	
		_LojaNaturezaDao = null;
	
		_PalavraDao = null;
	
		_PalavraProdutoDao = null;
	
		_UsuarioPesquisaDao = null;
	
		_PrecoDiarioDao = null;
	
		_ContagemProdutoDao = null;
	
		_FacebookPerfilDao = null;
	
		_ProdutoClienteDao = null;
	
		_FacebookFanpageDao = null;
	
		_AppProdutoDao = null;
	
		_PalavraChavePesquisaDao = null;
	
		_FacebookPostDao = null;
	
		_FacebookPostPerformanceDao = null;
	
		_InteresseProdutoDao = null;
	
		_PrecoDiarioClienteDao = null;
	
		_CompartilhamentoProdutoDao = null;
	
		_OportunidadeInteresseClienteDao = null;
	
	}


	private  UsuarioDao _UsuarioDao;
	public  UsuarioDao getUsuarioDao() {
		if (_UsuarioDao==null) _UsuarioDao = new UsuarioDaoExtendida();
		return _UsuarioDao;
	}

	private  DispositivoUsuarioDao _DispositivoUsuarioDao;
	public  DispositivoUsuarioDao getDispositivoUsuarioDao() {
		if (_DispositivoUsuarioDao==null) _DispositivoUsuarioDao = new DispositivoUsuarioDaoExtendida();
		return _DispositivoUsuarioDao;
	}

	private  ProdutoDao _ProdutoDao;
	public  ProdutoDao getProdutoDao() {
		if (_ProdutoDao==null) _ProdutoDao = new ProdutoDaoExtendida();
		return _ProdutoDao;
	}

	private  PrecoProdutoDao _PrecoProdutoDao;
	public  PrecoProdutoDao getPrecoProdutoDao() {
		if (_PrecoProdutoDao==null) _PrecoProdutoDao = new PrecoProdutoDaoExtendida();
		return _PrecoProdutoDao;
	}

	private  ModeloProdutoDao _ModeloProdutoDao;
	public  ModeloProdutoDao getModeloProdutoDao() {
		if (_ModeloProdutoDao==null) _ModeloProdutoDao = new ModeloProdutoDaoExtendida();
		return _ModeloProdutoDao;
	}

	private  ModeloProdutoProdutoDao _ModeloProdutoProdutoDao;
	public  ModeloProdutoProdutoDao getModeloProdutoProdutoDao() {
		if (_ModeloProdutoProdutoDao==null) _ModeloProdutoProdutoDao = new ModeloProdutoProdutoDaoExtendida();
		return _ModeloProdutoProdutoDao;
	}

	private  LojaVirtualDao _LojaVirtualDao;
	public  LojaVirtualDao getLojaVirtualDao() {
		if (_LojaVirtualDao==null) _LojaVirtualDao = new LojaVirtualDaoExtendida();
		return _LojaVirtualDao;
	}

	private  MarcaDao _MarcaDao;
	public  MarcaDao getMarcaDao() {
		if (_MarcaDao==null) _MarcaDao = new MarcaDaoExtendida();
		return _MarcaDao;
	}

	private  CategoriaLojaDao _CategoriaLojaDao;
	public  CategoriaLojaDao getCategoriaLojaDao() {
		if (_CategoriaLojaDao==null) _CategoriaLojaDao = new CategoriaLojaDaoExtendida();
		return _CategoriaLojaDao;
	}

	private  CategoriaLojaProdutoDao _CategoriaLojaProdutoDao;
	public  CategoriaLojaProdutoDao getCategoriaLojaProdutoDao() {
		if (_CategoriaLojaProdutoDao==null) _CategoriaLojaProdutoDao = new CategoriaLojaProdutoDaoExtendida();
		return _CategoriaLojaProdutoDao;
	}

	private  NaturezaProdutoDao _NaturezaProdutoDao;
	public  NaturezaProdutoDao getNaturezaProdutoDao() {
		if (_NaturezaProdutoDao==null) _NaturezaProdutoDao = new NaturezaProdutoDaoExtendida();
		return _NaturezaProdutoDao;
	}

	private  OportunidadeDiaDao _OportunidadeDiaDao;
	public  OportunidadeDiaDao getOportunidadeDiaDao() {
		if (_OportunidadeDiaDao==null) _OportunidadeDiaDao = new OportunidadeDiaDaoExtendida();
		return _OportunidadeDiaDao;
	}

	private  LojaNaturezaDao _LojaNaturezaDao;
	public  LojaNaturezaDao getLojaNaturezaDao() {
		if (_LojaNaturezaDao==null) _LojaNaturezaDao = new LojaNaturezaDaoExtendida();
		return _LojaNaturezaDao;
	}

	private  PalavraDao _PalavraDao;
	public  PalavraDao getPalavraDao() {
		if (_PalavraDao==null) _PalavraDao = new PalavraDaoExtendida();
		return _PalavraDao;
	}

	private  PalavraProdutoDao _PalavraProdutoDao;
	public  PalavraProdutoDao getPalavraProdutoDao() {
		if (_PalavraProdutoDao==null) _PalavraProdutoDao = new PalavraProdutoDaoExtendida();
		return _PalavraProdutoDao;
	}

	private  UsuarioPesquisaDao _UsuarioPesquisaDao;
	public  UsuarioPesquisaDao getUsuarioPesquisaDao() {
		if (_UsuarioPesquisaDao==null) _UsuarioPesquisaDao = new UsuarioPesquisaDaoExtendida();
		return _UsuarioPesquisaDao;
	}

	private  PrecoDiarioDao _PrecoDiarioDao;
	public  PrecoDiarioDao getPrecoDiarioDao() {
		if (_PrecoDiarioDao==null) _PrecoDiarioDao = new PrecoDiarioDaoExtendida();
		return _PrecoDiarioDao;
	}

	private  ContagemProdutoDao _ContagemProdutoDao;
	public  ContagemProdutoDao getContagemProdutoDao() {
		if (_ContagemProdutoDao==null) _ContagemProdutoDao = new ContagemProdutoDaoExtendida();
		return _ContagemProdutoDao;
	}

	private  FacebookPerfilDao _FacebookPerfilDao;
	public  FacebookPerfilDao getFacebookPerfilDao() {
		if (_FacebookPerfilDao==null) _FacebookPerfilDao = new FacebookPerfilDaoExtendida();
		return _FacebookPerfilDao;
	}

	private  ProdutoClienteDao _ProdutoClienteDao;
	public  ProdutoClienteDao getProdutoClienteDao() {
		if (_ProdutoClienteDao==null) _ProdutoClienteDao = new ProdutoClienteDaoExtendida();
		return _ProdutoClienteDao;
	}

	private  FacebookFanpageDao _FacebookFanpageDao;
	public  FacebookFanpageDao getFacebookFanpageDao() {
		if (_FacebookFanpageDao==null) _FacebookFanpageDao = new FacebookFanpageDaoExtendida();
		return _FacebookFanpageDao;
	}

	private  AppProdutoDao _AppProdutoDao;
	public  AppProdutoDao getAppProdutoDao() {
		if (_AppProdutoDao==null) _AppProdutoDao = new AppProdutoDaoExtendida();
		return _AppProdutoDao;
	}

	private  PalavraChavePesquisaDao _PalavraChavePesquisaDao;
	public  PalavraChavePesquisaDao getPalavraChavePesquisaDao() {
		if (_PalavraChavePesquisaDao==null) _PalavraChavePesquisaDao = new PalavraChavePesquisaDaoExtendida();
		return _PalavraChavePesquisaDao;
	}

	private  FacebookPostDao _FacebookPostDao;
	public  FacebookPostDao getFacebookPostDao() {
		if (_FacebookPostDao==null) _FacebookPostDao = new FacebookPostDaoExtendida();
		return _FacebookPostDao;
	}

	private  FacebookPostPerformanceDao _FacebookPostPerformanceDao;
	public  FacebookPostPerformanceDao getFacebookPostPerformanceDao() {
		if (_FacebookPostPerformanceDao==null) _FacebookPostPerformanceDao = new FacebookPostPerformanceDaoExtendida();
		return _FacebookPostPerformanceDao;
	}

	private  InteresseProdutoDao _InteresseProdutoDao;
	public  InteresseProdutoDao getInteresseProdutoDao() {
		if (_InteresseProdutoDao==null) _InteresseProdutoDao = new InteresseProdutoDaoExtendida();
		return _InteresseProdutoDao;
	}

	private  PrecoDiarioClienteDao _PrecoDiarioClienteDao;
	public  PrecoDiarioClienteDao getPrecoDiarioClienteDao() {
		if (_PrecoDiarioClienteDao==null) _PrecoDiarioClienteDao = new PrecoDiarioClienteDaoExtendida();
		return _PrecoDiarioClienteDao;
	}

	private  CompartilhamentoProdutoDao _CompartilhamentoProdutoDao;
	public  CompartilhamentoProdutoDao getCompartilhamentoProdutoDao() {
		if (_CompartilhamentoProdutoDao==null) _CompartilhamentoProdutoDao = new CompartilhamentoProdutoDaoExtendida();
		return _CompartilhamentoProdutoDao;
	}

	private  OportunidadeInteresseClienteDao _OportunidadeInteresseClienteDao;
	public  OportunidadeInteresseClienteDao getOportunidadeInteresseClienteDao() {
		if (_OportunidadeInteresseClienteDao==null) _OportunidadeInteresseClienteDao = new OportunidadeInteresseClienteDaoExtendida();
		return _OportunidadeInteresseClienteDao;
	}

}