package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CategoriaLojaAgregado implements CategoriaLojaAgregadoI
	{
		
		private CategoriaLojaCarregador carregador = null;
		private CategoriaLojaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaLojaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getCategoriaLojaFilho(false) != null)
				vo.getCategoriaLojaFilho(false).setConexaoCarregador(conexao);
			if (vo.getNaturezaProdutoReferenteA(false) != null)
				vo.getNaturezaProdutoReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getLojaVirtualPertenceA(false) != null)
				vo.getLojaVirtualPertenceA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private CategoriaLoja vo;
		public CategoriaLojaAgregado(CategoriaLoja item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private CategoriaLoja categoriaLojaFilho;
		// Montador Tradicional
		public CategoriaLoja getCategoriaLojaFilho(boolean lazyloader) 
		{	
			if (lazyloader && categoriaLojaFilho==null)
			{
				try {
					getCarregador().CarregaItemCategoriaLoja_Filho(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return categoriaLojaFilho;
		} 
		public void setCategoriaLojaFilho(CategoriaLoja value) 
		{	
			categoriaLojaFilho = value;
		} 
		/*
		public void setCategoriaLojaFilhoComReversao(CategoriaLoja value) 
		{	
			categoriaLojaFilho = value;
			System.out.println("Alteracao:" + categoriaLojaFilho);
			if (categoriaLojaFilho!=null)
				categoriaLojaFilho.addListaCategoriaLoja_Filho(vo);
		} 
		*/
		
		/*  AutoRelacionamento
		
		public void addListaCategoriaLoja_Filho(CategoriaLoja  value) 
		{	
			categoriaLojaFilho = value;
		} 
		public CategoriaLoja getCorrenteCategoriaLoja_Filho()
		{	
			return categoriaLojaFilho;
		} 
		
		*/
		
 		
		private NaturezaProduto naturezaProdutoReferenteA;
		// Montador Tradicional
		public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && naturezaProdutoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemNaturezaProduto_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return naturezaProdutoReferenteA;
		} 
		public void setNaturezaProdutoReferenteA(NaturezaProduto value) 
		{	
			naturezaProdutoReferenteA = value;
		} 
		/*
		public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto value) 
		{	
			naturezaProdutoReferenteA = value;
			System.out.println("Alteracao:" + naturezaProdutoReferenteA);
			if (naturezaProdutoReferenteA!=null)
				naturezaProdutoReferenteA.addListaCategoriaLoja_Possui(vo);
		} 
		*/
		
		public void addListaNaturezaProduto_ReferenteA(NaturezaProduto  value) 
		{	
			naturezaProdutoReferenteA = value;
		} 
		public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA()
		{	
			return naturezaProdutoReferenteA;
		} 
		
 		
		private LojaVirtual lojaVirtualPertenceA;
		// Montador Tradicional
		public LojaVirtual getLojaVirtualPertenceA(boolean lazyloader) 
		{	
			if (lazyloader && lojaVirtualPertenceA==null)
			{
				try {
					getCarregador().CarregaItemLojaVirtual_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return lojaVirtualPertenceA;
		} 
		public void setLojaVirtualPertenceA(LojaVirtual value) 
		{	
			lojaVirtualPertenceA = value;
		} 
		/*
		public void setLojaVirtualPertenceAComReversao(LojaVirtual value) 
		{	
			lojaVirtualPertenceA = value;
			System.out.println("Alteracao:" + lojaVirtualPertenceA);
			if (lojaVirtualPertenceA!=null)
				lojaVirtualPertenceA.addListaCategoriaLoja_Possui(vo);
		} 
		*/
		
		public void addListaLojaVirtual_PertenceA(LojaVirtual  value) 
		{	
			lojaVirtualPertenceA = value;
		} 
		public LojaVirtual getCorrenteLojaVirtual_PertenceA()
		{	
			return lojaVirtualPertenceA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaCategoriaLojaProduto_Possui() {
			return listacategoriaLojaProdutoPossui!= null;
		}
		private List<CategoriaLojaProduto> listacategoriaLojaProdutoPossui;
		public void setListaCategoriaLojaProduto_Possui(List<CategoriaLojaProduto> value) 
		{	
			listacategoriaLojaProdutoPossui = value;
		} 
		public List<CategoriaLojaProduto> getListaCategoriaLojaProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaLojaProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaCategoriaLojaProduto_Possui(vo);
            //}
			return listacategoriaLojaProdutoPossui;
			
		} 
		public void addListaCategoriaLojaProduto_Possui(CategoriaLojaProduto value)
		{	
			criaVaziaListaCategoriaLojaProduto_Possui();
			listacategoriaLojaProdutoPossui.add(value);
		} 
		public CategoriaLojaProduto getCorrenteCategoriaLojaProduto_Possui()
		{	
			if (listacategoriaLojaProdutoPossui==null || listacategoriaLojaProdutoPossui.size()==0) return null;
			return listacategoriaLojaProdutoPossui.get(listacategoriaLojaProdutoPossui.size()-1);
		} 
		public void criaVaziaListaCategoriaLojaProduto_Possui() {
			if (listacategoriaLojaProdutoPossui == null)
            {
            	listacategoriaLojaProdutoPossui = new ArrayList<CategoriaLojaProduto>();
            }
		}
 		
		public boolean existeListaCategoriaLoja_Filho() {
			return listacategoriaLojaFilho!= null;
		}
		private List<CategoriaLoja> listacategoriaLojaFilho;
		public void setListaCategoriaLoja_Filho(List<CategoriaLoja> value) 
		{	
			listacategoriaLojaFilho = value;
		} 
		public List<CategoriaLoja> getListaCategoriaLoja_Filho ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaLojaFilho == null)
			//{
            //	getCarregador().CarregaListaCategoriaLoja_Filho(vo);
            //}
			return listacategoriaLojaFilho;
			
		} 
		public void addListaCategoriaLoja_Filho(CategoriaLoja value)
		{	
			criaVaziaListaCategoriaLoja_Filho();
			listacategoriaLojaFilho.add(value);
		} 
		public CategoriaLoja getCorrenteCategoriaLoja_Filho()
		{	
			if (listacategoriaLojaFilho==null || listacategoriaLojaFilho.size()==0) return null;
			return listacategoriaLojaFilho.get(listacategoriaLojaFilho.size()-1);
		} 
		public void criaVaziaListaCategoriaLoja_Filho() {
			if (listacategoriaLojaFilho == null)
            {
            	listacategoriaLojaFilho = new ArrayList<CategoriaLoja>();
            }
		}
 		
	}
