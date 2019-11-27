package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class UsuarioPesquisaAgregado implements UsuarioPesquisaAgregadoI
	{
		
		private UsuarioPesquisaCarregador carregador = null;
		private UsuarioPesquisaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new UsuarioPesquisaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getNaturezaProdutoPesquisa(false) != null)
				vo.getNaturezaProdutoPesquisa(false).setConexaoCarregador(conexao);
			
		}
		
		
		private UsuarioPesquisa vo;
		public UsuarioPesquisaAgregado(UsuarioPesquisa item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
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
				usuarioSincroniza.addListaUsuarioPesquisa_Sincroniza(vo);
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
		
 		
		private NaturezaProduto naturezaProdutoPesquisa;
		// Montador Tradicional
		public NaturezaProduto getNaturezaProdutoPesquisa(boolean lazyloader) 
		{	
			if (lazyloader && naturezaProdutoPesquisa==null)
			{
				try {
					getCarregador().CarregaItemNaturezaProduto_Pesquisa(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return naturezaProdutoPesquisa;
		} 
		public void setNaturezaProdutoPesquisa(NaturezaProduto value) 
		{	
			naturezaProdutoPesquisa = value;
		} 
		/*
		public void setNaturezaProdutoPesquisaComReversao(NaturezaProduto value) 
		{	
			naturezaProdutoPesquisa = value;
			System.out.println("Alteracao:" + naturezaProdutoPesquisa);
			if (naturezaProdutoPesquisa!=null)
				naturezaProdutoPesquisa.addListaUsuarioPesquisa_PesquisadoPor(vo);
		} 
		*/
		
		public void addListaNaturezaProduto_Pesquisa(NaturezaProduto  value) 
		{	
			naturezaProdutoPesquisa = value;
		} 
		public NaturezaProduto getCorrenteNaturezaProduto_Pesquisa()
		{	
			return naturezaProdutoPesquisa;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
