package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class InteresseProdutoAgregado implements InteresseProdutoAgregadoI
	{
		
		private InteresseProdutoCarregador carregador = null;
		private InteresseProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new InteresseProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoClienteReferenteA(false) != null)
				vo.getProdutoClienteReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private InteresseProduto vo;
		public InteresseProdutoAgregado(InteresseProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProdutoCliente produtoClienteReferenteA;
		// Montador Tradicional
		public ProdutoCliente getProdutoClienteReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && produtoClienteReferenteA==null)
			{
				try {
					getCarregador().CarregaItemProdutoCliente_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoClienteReferenteA;
		} 
		public void setProdutoClienteReferenteA(ProdutoCliente value) 
		{	
			produtoClienteReferenteA = value;
		} 
		/*
		public void setProdutoClienteReferenteAComReversao(ProdutoCliente value) 
		{	
			produtoClienteReferenteA = value;
			System.out.println("Alteracao:" + produtoClienteReferenteA);
			if (produtoClienteReferenteA!=null)
				produtoClienteReferenteA.addListaInteresseProduto_Possui(vo);
		} 
		*/
		
		public void addListaProdutoCliente_ReferenteA(ProdutoCliente  value) 
		{	
			produtoClienteReferenteA = value;
		} 
		public ProdutoCliente getCorrenteProdutoCliente_ReferenteA()
		{	
			return produtoClienteReferenteA;
		} 
		
 		
		private Usuario usuarioSincroniza;
		// Montador Tradicional
		public Usuario getUsuarioSincroniza(boolean lazyloader) 
		{	
			if (lazyloader && usuarioSincroniza==null)
			{
				try {
					getCarregador().CarregaItemUsuario_Sincroniza(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return usuarioSincroniza;
		} 
		public void setUsuarioSincroniza(Usuario value) 
		{	
			usuarioSincroniza = value;
		} 
		/*
		public void setUsuarioSincronizaComReversao(Usuario value) 
		{	
			usuarioSincroniza = value;
			System.out.println("Alteracao:" + usuarioSincroniza);
			if (usuarioSincroniza!=null)
				usuarioSincroniza.addListaInteresseProduto_Sincroniza(vo);
		} 
		*/
		
		public void addListaUsuario_Sincroniza(Usuario  value) 
		{	
			usuarioSincroniza = value;
		} 
		public Usuario getCorrenteUsuario_Sincroniza()
		{	
			return usuarioSincroniza;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
