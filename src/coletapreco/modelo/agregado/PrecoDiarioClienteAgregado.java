package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PrecoDiarioClienteAgregado implements PrecoDiarioClienteAgregadoI
	{
		
		private PrecoDiarioClienteCarregador carregador = null;
		private PrecoDiarioClienteCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PrecoDiarioClienteCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoClientePertenceA(false) != null)
				vo.getProdutoClientePertenceA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private PrecoDiarioCliente vo;
		public PrecoDiarioClienteAgregado(PrecoDiarioCliente item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProdutoCliente produtoClientePertenceA;
		// Montador Tradicional
		public ProdutoCliente getProdutoClientePertenceA(boolean lazyloader) 
		{	
			if (lazyloader && produtoClientePertenceA==null)
			{
				try {
					getCarregador().CarregaItemProdutoCliente_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoClientePertenceA;
		} 
		public void setProdutoClientePertenceA(ProdutoCliente value) 
		{	
			produtoClientePertenceA = value;
		} 
		/*
		public void setProdutoClientePertenceAComReversao(ProdutoCliente value) 
		{	
			produtoClientePertenceA = value;
			System.out.println("Alteracao:" + produtoClientePertenceA);
			if (produtoClientePertenceA!=null)
				produtoClientePertenceA.addListaPrecoDiarioCliente_Possui(vo);
		} 
		*/
		
		public void addListaProdutoCliente_PertenceA(ProdutoCliente  value) 
		{	
			produtoClientePertenceA = value;
		} 
		public ProdutoCliente getCorrenteProdutoCliente_PertenceA()
		{	
			return produtoClientePertenceA;
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
				usuarioSincroniza.addListaPrecoDiarioCliente_Sincroniza(vo);
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
