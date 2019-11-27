package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class DispositivoUsuarioAgregado implements DispositivoUsuarioAgregadoI
	{
		
		private DispositivoUsuarioCarregador carregador = null;
		private DispositivoUsuarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new DispositivoUsuarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getUsuarioReferenteA(false) != null)
				vo.getUsuarioReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getAppProdutoUsa(false) != null)
				vo.getAppProdutoUsa(false).setConexaoCarregador(conexao);
			
		}
		
		
		private DispositivoUsuario vo;
		public DispositivoUsuarioAgregado(DispositivoUsuario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Usuario usuarioReferenteA;
		// Montador Tradicional
		public Usuario getUsuarioReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && usuarioReferenteA==null)
			{
				try {
					getCarregador().CarregaItemUsuario_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return usuarioReferenteA;
		} 
		public void setUsuarioReferenteA(Usuario value) 
		{	
			usuarioReferenteA = value;
		} 
		/*
		public void setUsuarioReferenteAComReversao(Usuario value) 
		{	
			usuarioReferenteA = value;
			System.out.println("Alteracao:" + usuarioReferenteA);
			if (usuarioReferenteA!=null)
				usuarioReferenteA.addListaDispositivoUsuario_Usa(vo);
		} 
		*/
		
		public void addListaUsuario_ReferenteA(Usuario  value) 
		{	
			usuarioReferenteA = value;
		} 
		public Usuario getCorrenteUsuario_ReferenteA()
		{	
			return usuarioReferenteA;
		} 
		
 		
		private AppProduto appProdutoUsa;
		// Montador Tradicional
		public AppProduto getAppProdutoUsa(boolean lazyloader) 
		{	
			if (lazyloader && appProdutoUsa==null)
			{
				try {
					getCarregador().CarregaItemAppProduto_Usa(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return appProdutoUsa;
		} 
		public void setAppProdutoUsa(AppProduto value) 
		{	
			appProdutoUsa = value;
		} 
		/*
		public void setAppProdutoUsaComReversao(AppProduto value) 
		{	
			appProdutoUsa = value;
			System.out.println("Alteracao:" + appProdutoUsa);
			if (appProdutoUsa!=null)
				appProdutoUsa.addListaDispositivoUsuario_UsadoPor(vo);
		} 
		*/
		
		public void addListaAppProduto_Usa(AppProduto  value) 
		{	
			appProdutoUsa = value;
		} 
		public AppProduto getCorrenteAppProduto_Usa()
		{	
			return appProdutoUsa;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
