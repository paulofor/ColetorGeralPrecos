package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class CompartilhamentoProdutoAgregado implements CompartilhamentoProdutoAgregadoI
	{
		
		private CompartilhamentoProdutoCarregador carregador = null;
		private CompartilhamentoProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new CompartilhamentoProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getUsuarioPertenceA(false) != null)
				vo.getUsuarioPertenceA(false).setConexaoCarregador(conexao);
			if (vo.getProdutoReferenteA(false) != null)
				vo.getProdutoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private CompartilhamentoProduto vo;
		public CompartilhamentoProdutoAgregado(CompartilhamentoProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Usuario usuarioPertenceA;
		// Montador Tradicional
		public Usuario getUsuarioPertenceA(boolean lazyloader) 
		{	
			if (lazyloader && usuarioPertenceA==null)
			{
				try {
					getCarregador().CarregaItemUsuario_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return usuarioPertenceA;
		} 
		public void setUsuarioPertenceA(Usuario value) 
		{	
			usuarioPertenceA = value;
		} 
		/*
		public void setUsuarioPertenceAComReversao(Usuario value) 
		{	
			usuarioPertenceA = value;
			System.out.println("Alteracao:" + usuarioPertenceA);
			if (usuarioPertenceA!=null)
				usuarioPertenceA.addListaCompartilhamentoProduto_Possui(vo);
		} 
		*/
		
		public void addListaUsuario_PertenceA(Usuario  value) 
		{	
			usuarioPertenceA = value;
		} 
		public Usuario getCorrenteUsuario_PertenceA()
		{	
			return usuarioPertenceA;
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
				produtoReferenteA.addListaCompartilhamentoProduto_Gerou(vo);
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
