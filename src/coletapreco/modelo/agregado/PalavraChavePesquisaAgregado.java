package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PalavraChavePesquisaAgregado implements PalavraChavePesquisaAgregadoI
	{
		
		private PalavraChavePesquisaCarregador carregador = null;
		private PalavraChavePesquisaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PalavraChavePesquisaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getNaturezaProdutoReferenteA(false) != null)
				vo.getNaturezaProdutoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private PalavraChavePesquisa vo;
		public PalavraChavePesquisaAgregado(PalavraChavePesquisa item) {
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
				usuarioSincroniza.addListaPalavraChavePesquisa_Possui(vo);
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
				naturezaProdutoReferenteA.addListaPalavraChavePesquisa_PodePesquisar(vo);
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
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaProdutoCliente_Gerou() {
			return listaprodutoClienteGerou!= null;
		}
		private List<ProdutoCliente> listaprodutoClienteGerou;
		public void setListaProdutoCliente_Gerou(List<ProdutoCliente> value) 
		{	
			listaprodutoClienteGerou = value;
		} 
		public List<ProdutoCliente> getListaProdutoCliente_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoClienteGerou == null)
			//{
            //	getCarregador().CarregaListaProdutoCliente_Gerou(vo);
            //}
			return listaprodutoClienteGerou;
			
		} 
		public void addListaProdutoCliente_Gerou(ProdutoCliente value)
		{	
			criaVaziaListaProdutoCliente_Gerou();
			listaprodutoClienteGerou.add(value);
		} 
		public ProdutoCliente getCorrenteProdutoCliente_Gerou()
		{	
			if (listaprodutoClienteGerou==null || listaprodutoClienteGerou.size()==0) return null;
			return listaprodutoClienteGerou.get(listaprodutoClienteGerou.size()-1);
		} 
		public void criaVaziaListaProdutoCliente_Gerou() {
			if (listaprodutoClienteGerou == null)
            {
            	listaprodutoClienteGerou = new ArrayList<ProdutoCliente>();
            }
		}
 		
	}
