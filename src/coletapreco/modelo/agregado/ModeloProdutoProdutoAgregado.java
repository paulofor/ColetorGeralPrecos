package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ModeloProdutoProdutoAgregado implements ModeloProdutoProdutoAgregadoI
	{
		
		private ModeloProdutoProdutoCarregador carregador = null;
		private ModeloProdutoProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ModeloProdutoProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getModeloProdutoReferenteA(false) != null)
				vo.getModeloProdutoReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getProdutoReferenteA(false) != null)
				vo.getProdutoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private ModeloProdutoProduto vo;
		public ModeloProdutoProdutoAgregado(ModeloProdutoProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ModeloProduto modeloProdutoReferenteA;
		// Montador Tradicional
		public ModeloProduto getModeloProdutoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && modeloProdutoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemModeloProduto_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return modeloProdutoReferenteA;
		} 
		public void setModeloProdutoReferenteA(ModeloProduto value) 
		{	
			modeloProdutoReferenteA = value;
		} 
		/*
		public void setModeloProdutoReferenteAComReversao(ModeloProduto value) 
		{	
			modeloProdutoReferenteA = value;
			System.out.println("Alteracao:" + modeloProdutoReferenteA);
			if (modeloProdutoReferenteA!=null)
				modeloProdutoReferenteA.addListaModeloProdutoProduto_ReferenteA(vo);
		} 
		*/
		
		public void addListaModeloProduto_ReferenteA(ModeloProduto  value) 
		{	
			modeloProdutoReferenteA = value;
		} 
		public ModeloProduto getCorrenteModeloProduto_ReferenteA()
		{	
			return modeloProdutoReferenteA;
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
				produtoReferenteA.addListaModeloProdutoProduto_ReferenteA(vo);
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
