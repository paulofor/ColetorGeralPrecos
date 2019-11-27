package coletapreco.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import coletapreco.dao.DBB;
import coletapreco.dao.LojaVirtualDao;
import coletapreco.dao.ProdutoDao;
import coletapreco.log.ArquivoLog;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.ContagemProduto;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.LojaNatureza;
import coletapreco.modelo.LojaVirtual;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.modelo.Produto;
import coletapreco.parse.regracolecaoadaptador.custom.CategoriaLojaAdaptador;
import coletapreco.parse.regracolecaoadaptador.custom.LojaVirtualAdaptador;
import coletapreco.regracolecao.CategoriaLojaRegraColecao;
import coletapreco.regracolecao.ContagemProdutoRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.LojaNaturezaRegraColecao;
import coletapreco.regracolecao.LojaVirtualRegraColecao;
import coletapreco.regracolecao.NaturezaProdutoRegraColecao;


public  class LojaVirtualRegraColecaoImpl  extends LojaVirtualRegraColecao {

	public static final String CODIGO_BRINQUEDO = "BRINQ";
	public static final String CODIGO_CELULAR = "CELUL";
	
	public static final String CODIGO_GELADEIRA = "GELAD";
	public static final String CODIGO_FOGAO = "FOGAO";
	public static final String CODIGO_LAVA_ROUPA = "LAVRP";
	public static final String CODIGO_MICRO_ONDA = "MICON";
	public static final String CODIGO_AR_CONDICIONADO = "ARCND";
	public static final String CODIGO_VENTILADOR = "VENTI";
	
	public static final String CODIGO_TABLET = "TABLT";
	public static final String CODIGO_NOTEBOOK = "NOTBK";
	public static final String CODIGO_TV = "TELEV";
	public static final String CODIGO_MOV_QUARTO = "MOVQT";
	public static final String CODIGO_MOV_SALA_ESTAR = "MOVSE";
	public static final String CODIGO_MOV_SALA_JANTAR = "MOVSJ";
	public static final String CODIGO_FILMADORA = "FILMA";
	public static final String CODIGO_CAMERA_DIGITAL = "CAMDG";
	
	public static final String CODIGO_PLAYSTATION3 = "PLST3";
	public static final String CODIGO_PLAYSTATION4 = "PLST4";
	public static final String CODIGO_XBOX_ONE = "XBONE";
	public static final String CODIGO_XBOX_360 = "XB360";
	public static final String CODIGO_NINTENDO_WII_U = "NINWU";
	public static final String CODIGO_SAPATO_FEMININO = "SPFEM";
	public static final String CODIGO_COMPUTADORES = "COMPT";
	
	public static final String CODIGO_COSMETICO = "COSME";
	
	
	private final NaturezaProdutoRegraColecao naturezaServ = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
	private final ContagemProdutoRegraColecao contagemSrv = FabricaRegra.getInstancia().getContagemProdutoRegraColecao();
	
	@Override
	public LojaVirtual AtualizaBrinquedo(DaoConexao conexao)
			throws DaoException {
		return atualizaNatureza(CODIGO_BRINQUEDO, conexao);
	} 
	
	private LojaVirtual atualizaNatureza(String codigoNatureza, DaoConexao conexao) throws DaoException {
		this.naturezaServ.getFiltro().setCodigoPesquisa(codigoNatureza);
		NaturezaProduto natureza = this.naturezaServ.ObtemPorCodigo(conexao);
		LojaNaturezaRegraColecao lojaNatSrv = FabricaRegra.getInstancia().getLojaNaturezaRegraColecao();
		lojaNatSrv.getFiltro().setCodigoNaturezaProdutoReferenteA(natureza.getIdNaturezaProduto());
		List<LojaNatureza> listaLoja = lojaNatSrv.ListaPorNaturezaProdutoReferenteA(natureza.getIdNaturezaProduto(), conexao);
		
		
		ContagemProduto contagem = null;
		for (LojaNatureza lojaNat : listaLoja) {
			
			LojaVirtual loja = lojaNat.getCorrenteLojaVirtual_ReferenteA();
			ArquivoLog.getInstancia().salvaObjeto("Tratando: Natureza: " + natureza.getNomeNaturezaProduto() + " Loja: " + loja.getNomeLojaVirtual());
			loja.addListaLojaNatureza_Oferece(lojaNat);
			if (loja.getIdObj()!=10) {
			//if (loja.getIdObj()==7) {
				
				lojaNat.setLojaVirtualReferenteA(loja);
				lojaNat.setNaturezaProdutoReferenteA(natureza);
				this.getFiltro().setLojaNaturezaExecucao(lojaNat);
				
				this.ExecutaNaturezaLoja(conexao);

			}
			contagem = FabricaVo.criaContagemProduto();
			contagem.setLojaVirtualReferenteA(loja);
			contagem.setNaturezaProdutoReferenteA(natureza);
			contagem.setQuantidade(0);
			contagem.setData(DCConvert.getDataDD_MM_AAAA());
			contagemSrv.insereItemLoad(contagem, conexao);
		}
		return null;
	}
	
	@Override
	public LojaVirtual ExecutaNaturezaLoja(DaoConexao conexao) throws DaoException {
		ProdutoDao daoProduto = DBB.getInstancia().getProdutoDao();
		daoProduto.setConexao(conexao);
		
		LojaVirtualAdaptador adaptador = new LojaVirtualAdaptador();
		CategoriaLojaAdaptador adaptadorCategoria = new CategoriaLojaAdaptador();
		
		LojaNatureza lojaNat = getFiltro().validaLojaNaturezaExecucao();
		LojaVirtual loja = lojaNat.getLojaVirtualReferenteA(false);
		NaturezaProduto natureza = lojaNat.getNaturezaProdutoReferenteA(false);
		
		adaptador.setNaturezaProduto(natureza);
		ArquivoLog.getInstancia().salvaLog("Loja:" + loja.getNomeLojaVirtual());
		// Parsing de Categorias
		if (lojaNat.getParseCategoria()) {
			adaptador.setItem(loja);
			adaptador.atualizaDetalhe(loja, conexao);
		}
		// Parsing no detalhe da categoria
		List<CategoriaLoja> listaCat = this.listaCategoriasNivel0(loja, natureza, conexao);
		
		for (CategoriaLoja categoria : listaCat ) {
			daoProduto.atualizaPosicao(9999,categoria.getIdCategoriaLoja(),loja.getIdLojaVirtual());
			ArquivoLog.getInstancia().salvaLog("Categoria:" + categoria.getNome());
			ArquivoLog.getInstancia().salvaObjeto("Categoria:" + categoria.getNome() + "(" + categoria.getUrl() + ")");
			System.out.println("Categoria:" + categoria.getNome());
			adaptadorCategoria.setItem(loja);
			adaptadorCategoria.atualizaDetalhe(categoria, conexao);
		}
		return null;
	}
	
	
	private List<CategoriaLoja> listaCategoriasNivel0(LojaVirtual loja, NaturezaProduto natureza, DaoConexao conexao) throws DaoException {
		CategoriaLoja template = FabricaVo.criaCategoriaLoja();
		template.setNaturezaProdutoReferenteA(natureza);
		template.setLojaVirtualPertenceA(loja);
		CategoriaLojaRegraColecao servico = FabricaRegra.getInstancia().getCategoriaLojaRegraColecao();
		servico.getFiltro().setItem(template);
		List<CategoriaLoja> listaNivel0 = servico.ListaPorLojaNaturezaNivel0(conexao);
		return listaNivel0;
	}

	@Override
	public LojaVirtual AtualizaCelular(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_CELULAR, conexao);
	}

	@Override
	public LojaVirtual AtualizaGeladeira(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_GELADEIRA, conexao);
	}

	@Override
	public LojaVirtual AtualizaFogao(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_FOGAO, conexao);
	}

	@Override
	public LojaVirtual AtualizaLavaRoupa(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_LAVA_ROUPA, conexao);
	}

	@Override
	public LojaVirtual AtualizaMicroOnda(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_MICRO_ONDA, conexao);
	}

	@Override
	public LojaVirtual AtualizaArCondicionado(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_AR_CONDICIONADO, conexao);
	}
	
	@Override
	public LojaVirtual AtualizaVentilador(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(CODIGO_VENTILADOR, conexao);
	}

	@Override
	public LojaVirtual AtualizaNotebook(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_NOTEBOOK, conexao);
	}

	@Override
	public LojaVirtual AtualizaTV(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_TV, conexao);
	}

	@Override
	public LojaVirtual AtualizaTablet(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_TABLET, conexao);
	}

	@Override
	public LojaVirtual AtualizaMoveisQuarto(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_MOV_QUARTO, conexao);
	}

	@Override
	public LojaVirtual AtualizaMoveisSalaEstar(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_MOV_SALA_ESTAR, conexao);
	}

	@Override
	public LojaVirtual AtualizaMoveisSalaJantar(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_MOV_SALA_JANTAR, conexao);
	}

	@Override
	public LojaVirtual AtualizaFilmadora(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_FILMADORA, conexao);
	}
	
	@Override
	public LojaVirtual AtualizaCamera(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_CAMERA_DIGITAL, conexao);
	}

	@Override
	public LojaVirtual CorrigeTabelas(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao(conexao);
		dao.corrigeTabelas();
		return null;
	}

	@Override
	public LojaVirtual AtualizaSapatoFeminino(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_SAPATO_FEMININO, conexao);
	}

	@Override
	public LojaVirtual AtualizaGamePS4(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_PLAYSTATION4, conexao);
	}

	@Override
	public LojaVirtual AtualizaGamePS3(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_PLAYSTATION3, conexao);
	}

	@Override
	public LojaVirtual AtualizaGameXbox360(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_XBOX_360, conexao);
	}

	@Override
	public LojaVirtual AtualizaGameXboxOne(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_XBOX_ONE, conexao);
	}

	@Override
	public LojaVirtual AtualizaGameNintendoWiiU(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_NINTENDO_WII_U, conexao);
	}

	@Override
	public LojaVirtual ObtemPorProduto(DaoConexao conexao) throws DaoException {
		LojaVirtualDao dao = getDao(conexao);
		Produto produto = this.getFiltro().validaProdutoPesquisa();
		LojaVirtual loja = dao.ObtemPorProduto(produto.getIdObj());
		return loja;
	}

	@Override
	public LojaVirtual AtualizaComputador(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_COMPUTADORES, conexao);
	}

	@Override
	public LojaVirtual AtualizaCosmetico(DaoConexao conexao) throws DaoException {
		return atualizaNatureza(this.CODIGO_COSMETICO, conexao);
	}

	
	
}
