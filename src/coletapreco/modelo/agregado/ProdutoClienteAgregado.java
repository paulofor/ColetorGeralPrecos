package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ProdutoClienteAgregado implements ProdutoClienteAgregadoI
	{
		
		private ProdutoClienteCarregador carregador = null;
		private ProdutoClienteCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ProdutoClienteCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getNaturezaProdutoReferenteA(false) != null)
				vo.getNaturezaProdutoReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getPalavraChavePesquisaReferenteA(false) != null)
				vo.getPalavraChavePesquisaReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private ProdutoCliente vo;
		public ProdutoClienteAgregado(ProdutoCliente item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
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
				naturezaProdutoReferenteA.addListaProdutoCliente_Possui(vo);
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
				usuarioSincroniza.addListaProdutoCliente_Sincroniza(vo);
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
		
 		
		private PalavraChavePesquisa palavraChavePesquisaReferenteA;
		// Montador Tradicional
		public PalavraChavePesquisa getPalavraChavePesquisaReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && palavraChavePesquisaReferenteA==null)
			{
				try {
					getCarregador().CarregaItemPalavraChavePesquisa_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return palavraChavePesquisaReferenteA;
		} 
		public void setPalavraChavePesquisaReferenteA(PalavraChavePesquisa value) 
		{	
			palavraChavePesquisaReferenteA = value;
		} 
		/*
		public void setPalavraChavePesquisaReferenteAComReversao(PalavraChavePesquisa value) 
		{	
			palavraChavePesquisaReferenteA = value;
			System.out.println("Alteracao:" + palavraChavePesquisaReferenteA);
			if (palavraChavePesquisaReferenteA!=null)
				palavraChavePesquisaReferenteA.addListaProdutoCliente_Gerou(vo);
		} 
		*/
		
		public void addListaPalavraChavePesquisa_ReferenteA(PalavraChavePesquisa  value) 
		{	
			palavraChavePesquisaReferenteA = value;
		} 
		public PalavraChavePesquisa getCorrentePalavraChavePesquisa_ReferenteA()
		{	
			return palavraChavePesquisaReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaInteresseProduto_Possui() {
			return listainteresseProdutoPossui!= null;
		}
		private List<InteresseProduto> listainteresseProdutoPossui;
		public void setListaInteresseProduto_Possui(List<InteresseProduto> value) 
		{	
			listainteresseProdutoPossui = value;
		} 
		public List<InteresseProduto> getListaInteresseProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listainteresseProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaInteresseProduto_Possui(vo);
            //}
			return listainteresseProdutoPossui;
			
		} 
		public void addListaInteresseProduto_Possui(InteresseProduto value)
		{	
			criaVaziaListaInteresseProduto_Possui();
			listainteresseProdutoPossui.add(value);
		} 
		public InteresseProduto getCorrenteInteresseProduto_Possui()
		{	
			if (listainteresseProdutoPossui==null || listainteresseProdutoPossui.size()==0) return null;
			return listainteresseProdutoPossui.get(listainteresseProdutoPossui.size()-1);
		} 
		public void criaVaziaListaInteresseProduto_Possui() {
			if (listainteresseProdutoPossui == null)
            {
            	listainteresseProdutoPossui = new ArrayList<InteresseProduto>();
            }
		}
 		
		public boolean existeListaPrecoDiarioCliente_Possui() {
			return listaprecoDiarioClientePossui!= null;
		}
		private List<PrecoDiarioCliente> listaprecoDiarioClientePossui;
		public void setListaPrecoDiarioCliente_Possui(List<PrecoDiarioCliente> value) 
		{	
			listaprecoDiarioClientePossui = value;
		} 
		public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoDiarioClientePossui == null)
			//{
            //	getCarregador().CarregaListaPrecoDiarioCliente_Possui(vo);
            //}
			return listaprecoDiarioClientePossui;
			
		} 
		public void addListaPrecoDiarioCliente_Possui(PrecoDiarioCliente value)
		{	
			criaVaziaListaPrecoDiarioCliente_Possui();
			listaprecoDiarioClientePossui.add(value);
		} 
		public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Possui()
		{	
			if (listaprecoDiarioClientePossui==null || listaprecoDiarioClientePossui.size()==0) return null;
			return listaprecoDiarioClientePossui.get(listaprecoDiarioClientePossui.size()-1);
		} 
		public void criaVaziaListaPrecoDiarioCliente_Possui() {
			if (listaprecoDiarioClientePossui == null)
            {
            	listaprecoDiarioClientePossui = new ArrayList<PrecoDiarioCliente>();
            }
		}
 		
		public boolean existeListaOportunidadeInteresseCliente_Possui() {
			return listaoportunidadeInteresseClientePossui!= null;
		}
		private List<OportunidadeInteresseCliente> listaoportunidadeInteresseClientePossui;
		public void setListaOportunidadeInteresseCliente_Possui(List<OportunidadeInteresseCliente> value) 
		{	
			listaoportunidadeInteresseClientePossui = value;
		} 
		public List<OportunidadeInteresseCliente> getListaOportunidadeInteresseCliente_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaoportunidadeInteresseClientePossui == null)
			//{
            //	getCarregador().CarregaListaOportunidadeInteresseCliente_Possui(vo);
            //}
			return listaoportunidadeInteresseClientePossui;
			
		} 
		public void addListaOportunidadeInteresseCliente_Possui(OportunidadeInteresseCliente value)
		{	
			criaVaziaListaOportunidadeInteresseCliente_Possui();
			listaoportunidadeInteresseClientePossui.add(value);
		} 
		public OportunidadeInteresseCliente getCorrenteOportunidadeInteresseCliente_Possui()
		{	
			if (listaoportunidadeInteresseClientePossui==null || listaoportunidadeInteresseClientePossui.size()==0) return null;
			return listaoportunidadeInteresseClientePossui.get(listaoportunidadeInteresseClientePossui.size()-1);
		} 
		public void criaVaziaListaOportunidadeInteresseCliente_Possui() {
			if (listaoportunidadeInteresseClientePossui == null)
            {
            	listaoportunidadeInteresseClientePossui = new ArrayList<OportunidadeInteresseCliente>();
            }
		}
 		
	}
