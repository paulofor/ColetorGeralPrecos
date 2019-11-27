package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CategoriaLojaProdutoAgregado implements CategoriaLojaProdutoAgregadoI
	{
		
		private CategoriaLojaProdutoCarregador carregador = null;
		private CategoriaLojaProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CategoriaLojaProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getCategoriaLojaReferenteA(false) != null)
				vo.getCategoriaLojaReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getProdutoReferenteA(false) != null)
				vo.getProdutoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private CategoriaLojaProduto vo;
		public CategoriaLojaProdutoAgregado(CategoriaLojaProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private CategoriaLoja categoriaLojaReferenteA;
		// Montador Tradicional
		public CategoriaLoja getCategoriaLojaReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && categoriaLojaReferenteA==null)
			{
				try {
					getCarregador().CarregaItemCategoriaLoja_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return categoriaLojaReferenteA;
		} 
		public void setCategoriaLojaReferenteA(CategoriaLoja value) 
		{	
			categoriaLojaReferenteA = value;
		} 
		/*
		public void setCategoriaLojaReferenteAComReversao(CategoriaLoja value) 
		{	
			categoriaLojaReferenteA = value;
			System.out.println("Alteracao:" + categoriaLojaReferenteA);
			if (categoriaLojaReferenteA!=null)
				categoriaLojaReferenteA.addListaCategoriaLojaProduto_Possui(vo);
		} 
		*/
		
		public void addListaCategoriaLoja_ReferenteA(CategoriaLoja  value) 
		{	
			categoriaLojaReferenteA = value;
		} 
		public CategoriaLoja getCorrenteCategoriaLoja_ReferenteA()
		{	
			return categoriaLojaReferenteA;
		} 
		
 		
		private Produto produtoReferenteA;
		// Montador Tradicional
		public Produto getProdutoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && produtoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemProduto_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoReferenteA;
		} 
		public void setProdutoReferenteA(Produto value) 
		{	
			produtoReferenteA = value;
		} 
		/*
		public void setProdutoReferenteAComReversao(Produto value) 
		{	
			produtoReferenteA = value;
			System.out.println("Alteracao:" + produtoReferenteA);
			if (produtoReferenteA!=null)
				produtoReferenteA.addListaCategoriaLojaProduto_Possui(vo);
		} 
		*/
		
		public void addListaProduto_ReferenteA(Produto  value) 
		{	
			produtoReferenteA = value;
		} 
		public Produto getCorrenteProduto_ReferenteA()
		{	
			return produtoReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
