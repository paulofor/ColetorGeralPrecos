package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class UsuarioAgregado implements UsuarioAgregadoI
	{
		
		private UsuarioCarregador carregador = null;
		private UsuarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new UsuarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Usuario vo;
		public UsuarioAgregado(Usuario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaDispositivoUsuario_Usa() {
			return listadispositivoUsuarioUsa!= null;
		}
		private List<DispositivoUsuario> listadispositivoUsuarioUsa;
		public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> value) 
		{	
			listadispositivoUsuarioUsa = value;
		} 
		public List<DispositivoUsuario> getListaDispositivoUsuario_Usa ()
		{	
			// ligando o LazyLoader
			//if (listadispositivoUsuarioUsa == null)
			//{
            //	getCarregador().CarregaListaDispositivoUsuario_Usa(vo);
            //}
			return listadispositivoUsuarioUsa;
			
		} 
		public void addListaDispositivoUsuario_Usa(DispositivoUsuario value)
		{	
			criaVaziaListaDispositivoUsuario_Usa();
			listadispositivoUsuarioUsa.add(value);
		} 
		public DispositivoUsuario getCorrenteDispositivoUsuario_Usa()
		{	
			if (listadispositivoUsuarioUsa==null || listadispositivoUsuarioUsa.size()==0) return null;
			return listadispositivoUsuarioUsa.get(listadispositivoUsuarioUsa.size()-1);
		} 
		public void criaVaziaListaDispositivoUsuario_Usa() {
			if (listadispositivoUsuarioUsa == null)
            {
            	listadispositivoUsuarioUsa = new ArrayList<DispositivoUsuario>();
            }
		}
 		
		public boolean existeListaUsuarioPesquisa_Sincroniza() {
			return listausuarioPesquisaSincroniza!= null;
		}
		private List<UsuarioPesquisa> listausuarioPesquisaSincroniza;
		public void setListaUsuarioPesquisa_Sincroniza(List<UsuarioPesquisa> value) 
		{	
			listausuarioPesquisaSincroniza = value;
		} 
		public List<UsuarioPesquisa> getListaUsuarioPesquisa_Sincroniza ()
		{	
			// ligando o LazyLoader
			//if (listausuarioPesquisaSincroniza == null)
			//{
            //	getCarregador().CarregaListaUsuarioPesquisa_Sincroniza(vo);
            //}
			return listausuarioPesquisaSincroniza;
			
		} 
		public void addListaUsuarioPesquisa_Sincroniza(UsuarioPesquisa value)
		{	
			criaVaziaListaUsuarioPesquisa_Sincroniza();
			listausuarioPesquisaSincroniza.add(value);
		} 
		public UsuarioPesquisa getCorrenteUsuarioPesquisa_Sincroniza()
		{	
			if (listausuarioPesquisaSincroniza==null || listausuarioPesquisaSincroniza.size()==0) return null;
			return listausuarioPesquisaSincroniza.get(listausuarioPesquisaSincroniza.size()-1);
		} 
		public void criaVaziaListaUsuarioPesquisa_Sincroniza() {
			if (listausuarioPesquisaSincroniza == null)
            {
            	listausuarioPesquisaSincroniza = new ArrayList<UsuarioPesquisa>();
            }
		}
 		
		public boolean existeListaPalavraChavePesquisa_Possui() {
			return listapalavraChavePesquisaPossui!= null;
		}
		private List<PalavraChavePesquisa> listapalavraChavePesquisaPossui;
		public void setListaPalavraChavePesquisa_Possui(List<PalavraChavePesquisa> value) 
		{	
			listapalavraChavePesquisaPossui = value;
		} 
		public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_Possui ()
		{	
			// ligando o LazyLoader
			//if (listapalavraChavePesquisaPossui == null)
			//{
            //	getCarregador().CarregaListaPalavraChavePesquisa_Possui(vo);
            //}
			return listapalavraChavePesquisaPossui;
			
		} 
		public void addListaPalavraChavePesquisa_Possui(PalavraChavePesquisa value)
		{	
			criaVaziaListaPalavraChavePesquisa_Possui();
			listapalavraChavePesquisaPossui.add(value);
		} 
		public PalavraChavePesquisa getCorrentePalavraChavePesquisa_Possui()
		{	
			if (listapalavraChavePesquisaPossui==null || listapalavraChavePesquisaPossui.size()==0) return null;
			return listapalavraChavePesquisaPossui.get(listapalavraChavePesquisaPossui.size()-1);
		} 
		public void criaVaziaListaPalavraChavePesquisa_Possui() {
			if (listapalavraChavePesquisaPossui == null)
            {
            	listapalavraChavePesquisaPossui = new ArrayList<PalavraChavePesquisa>();
            }
		}
 		
		public boolean existeListaInteresseProduto_Sincroniza() {
			return listainteresseProdutoSincroniza!= null;
		}
		private List<InteresseProduto> listainteresseProdutoSincroniza;
		public void setListaInteresseProduto_Sincroniza(List<InteresseProduto> value) 
		{	
			listainteresseProdutoSincroniza = value;
		} 
		public List<InteresseProduto> getListaInteresseProduto_Sincroniza ()
		{	
			// ligando o LazyLoader
			//if (listainteresseProdutoSincroniza == null)
			//{
            //	getCarregador().CarregaListaInteresseProduto_Sincroniza(vo);
            //}
			return listainteresseProdutoSincroniza;
			
		} 
		public void addListaInteresseProduto_Sincroniza(InteresseProduto value)
		{	
			criaVaziaListaInteresseProduto_Sincroniza();
			listainteresseProdutoSincroniza.add(value);
		} 
		public InteresseProduto getCorrenteInteresseProduto_Sincroniza()
		{	
			if (listainteresseProdutoSincroniza==null || listainteresseProdutoSincroniza.size()==0) return null;
			return listainteresseProdutoSincroniza.get(listainteresseProdutoSincroniza.size()-1);
		} 
		public void criaVaziaListaInteresseProduto_Sincroniza() {
			if (listainteresseProdutoSincroniza == null)
            {
            	listainteresseProdutoSincroniza = new ArrayList<InteresseProduto>();
            }
		}
 		
		public boolean existeListaPrecoDiarioCliente_Sincroniza() {
			return listaprecoDiarioClienteSincroniza!= null;
		}
		private List<PrecoDiarioCliente> listaprecoDiarioClienteSincroniza;
		public void setListaPrecoDiarioCliente_Sincroniza(List<PrecoDiarioCliente> value) 
		{	
			listaprecoDiarioClienteSincroniza = value;
		} 
		public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Sincroniza ()
		{	
			// ligando o LazyLoader
			//if (listaprecoDiarioClienteSincroniza == null)
			//{
            //	getCarregador().CarregaListaPrecoDiarioCliente_Sincroniza(vo);
            //}
			return listaprecoDiarioClienteSincroniza;
			
		} 
		public void addListaPrecoDiarioCliente_Sincroniza(PrecoDiarioCliente value)
		{	
			criaVaziaListaPrecoDiarioCliente_Sincroniza();
			listaprecoDiarioClienteSincroniza.add(value);
		} 
		public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Sincroniza()
		{	
			if (listaprecoDiarioClienteSincroniza==null || listaprecoDiarioClienteSincroniza.size()==0) return null;
			return listaprecoDiarioClienteSincroniza.get(listaprecoDiarioClienteSincroniza.size()-1);
		} 
		public void criaVaziaListaPrecoDiarioCliente_Sincroniza() {
			if (listaprecoDiarioClienteSincroniza == null)
            {
            	listaprecoDiarioClienteSincroniza = new ArrayList<PrecoDiarioCliente>();
            }
		}
 		
		public boolean existeListaCompartilhamentoProduto_Possui() {
			return listacompartilhamentoProdutoPossui!= null;
		}
		private List<CompartilhamentoProduto> listacompartilhamentoProdutoPossui;
		public void setListaCompartilhamentoProduto_Possui(List<CompartilhamentoProduto> value) 
		{	
			listacompartilhamentoProdutoPossui = value;
		} 
		public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacompartilhamentoProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaCompartilhamentoProduto_Possui(vo);
            //}
			return listacompartilhamentoProdutoPossui;
			
		} 
		public void addListaCompartilhamentoProduto_Possui(CompartilhamentoProduto value)
		{	
			criaVaziaListaCompartilhamentoProduto_Possui();
			listacompartilhamentoProdutoPossui.add(value);
		} 
		public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Possui()
		{	
			if (listacompartilhamentoProdutoPossui==null || listacompartilhamentoProdutoPossui.size()==0) return null;
			return listacompartilhamentoProdutoPossui.get(listacompartilhamentoProdutoPossui.size()-1);
		} 
		public void criaVaziaListaCompartilhamentoProduto_Possui() {
			if (listacompartilhamentoProdutoPossui == null)
            {
            	listacompartilhamentoProdutoPossui = new ArrayList<CompartilhamentoProduto>();
            }
		}
 		
		public boolean existeListaProdutoCliente_Sincroniza() {
			return listaprodutoClienteSincroniza!= null;
		}
		private List<ProdutoCliente> listaprodutoClienteSincroniza;
		public void setListaProdutoCliente_Sincroniza(List<ProdutoCliente> value) 
		{	
			listaprodutoClienteSincroniza = value;
		} 
		public List<ProdutoCliente> getListaProdutoCliente_Sincroniza ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoClienteSincroniza == null)
			//{
            //	getCarregador().CarregaListaProdutoCliente_Sincroniza(vo);
            //}
			return listaprodutoClienteSincroniza;
			
		} 
		public void addListaProdutoCliente_Sincroniza(ProdutoCliente value)
		{	
			criaVaziaListaProdutoCliente_Sincroniza();
			listaprodutoClienteSincroniza.add(value);
		} 
		public ProdutoCliente getCorrenteProdutoCliente_Sincroniza()
		{	
			if (listaprodutoClienteSincroniza==null || listaprodutoClienteSincroniza.size()==0) return null;
			return listaprodutoClienteSincroniza.get(listaprodutoClienteSincroniza.size()-1);
		} 
		public void criaVaziaListaProdutoCliente_Sincroniza() {
			if (listaprodutoClienteSincroniza == null)
            {
            	listaprodutoClienteSincroniza = new ArrayList<ProdutoCliente>();
            }
		}
 		
	}
