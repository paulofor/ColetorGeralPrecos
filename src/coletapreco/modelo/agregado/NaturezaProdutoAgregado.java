package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class NaturezaProdutoAgregado implements NaturezaProdutoAgregadoI
	{
		
		private NaturezaProdutoCarregador carregador = null;
		private NaturezaProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new NaturezaProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getAppProdutoAtendidoPor(false) != null)
				vo.getAppProdutoAtendidoPor(false).setConexaoCarregador(conexao);
			
		}
		
		
		private NaturezaProduto vo;
		public NaturezaProdutoAgregado(NaturezaProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private AppProduto appProdutoAtendidoPor;
		// Montador Tradicional
		public AppProduto getAppProdutoAtendidoPor(boolean lazyloader) 
		{	
			if (lazyloader && appProdutoAtendidoPor==null)
			{
				try {
					getCarregador().CarregaItemAppProduto_AtendidoPor(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return appProdutoAtendidoPor;
		} 
		public void setAppProdutoAtendidoPor(AppProduto value) 
		{	
			appProdutoAtendidoPor = value;
		} 
		/*
		public void setAppProdutoAtendidoPorComReversao(AppProduto value) 
		{	
			appProdutoAtendidoPor = value;
			System.out.println("Alteracao:" + appProdutoAtendidoPor);
			if (appProdutoAtendidoPor!=null)
				appProdutoAtendidoPor.addListaNaturezaProduto_Atende(vo);
		} 
		*/
		
		public void addListaAppProduto_AtendidoPor(AppProduto  value) 
		{	
			appProdutoAtendidoPor = value;
		} 
		public AppProduto getCorrenteAppProduto_AtendidoPor()
		{	
			return appProdutoAtendidoPor;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaCategoriaLoja_Possui() {
			return listacategoriaLojaPossui!= null;
		}
		private List<CategoriaLoja> listacategoriaLojaPossui;
		public void setListaCategoriaLoja_Possui(List<CategoriaLoja> value) 
		{	
			listacategoriaLojaPossui = value;
		} 
		public List<CategoriaLoja> getListaCategoriaLoja_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaLojaPossui == null)
			//{
            //	getCarregador().CarregaListaCategoriaLoja_Possui(vo);
            //}
			return listacategoriaLojaPossui;
			
		} 
		public void addListaCategoriaLoja_Possui(CategoriaLoja value)
		{	
			criaVaziaListaCategoriaLoja_Possui();
			listacategoriaLojaPossui.add(value);
		} 
		public CategoriaLoja getCorrenteCategoriaLoja_Possui()
		{	
			if (listacategoriaLojaPossui==null || listacategoriaLojaPossui.size()==0) return null;
			return listacategoriaLojaPossui.get(listacategoriaLojaPossui.size()-1);
		} 
		public void criaVaziaListaCategoriaLoja_Possui() {
			if (listacategoriaLojaPossui == null)
            {
            	listacategoriaLojaPossui = new ArrayList<CategoriaLoja>();
            }
		}
 		
		public boolean existeListaLojaNatureza_Encontrada() {
			return listalojaNaturezaEncontrada!= null;
		}
		private List<LojaNatureza> listalojaNaturezaEncontrada;
		public void setListaLojaNatureza_Encontrada(List<LojaNatureza> value) 
		{	
			listalojaNaturezaEncontrada = value;
		} 
		public List<LojaNatureza> getListaLojaNatureza_Encontrada ()
		{	
			// ligando o LazyLoader
			//if (listalojaNaturezaEncontrada == null)
			//{
            //	getCarregador().CarregaListaLojaNatureza_Encontrada(vo);
            //}
			return listalojaNaturezaEncontrada;
			
		} 
		public void addListaLojaNatureza_Encontrada(LojaNatureza value)
		{	
			criaVaziaListaLojaNatureza_Encontrada();
			listalojaNaturezaEncontrada.add(value);
		} 
		public LojaNatureza getCorrenteLojaNatureza_Encontrada()
		{	
			if (listalojaNaturezaEncontrada==null || listalojaNaturezaEncontrada.size()==0) return null;
			return listalojaNaturezaEncontrada.get(listalojaNaturezaEncontrada.size()-1);
		} 
		public void criaVaziaListaLojaNatureza_Encontrada() {
			if (listalojaNaturezaEncontrada == null)
            {
            	listalojaNaturezaEncontrada = new ArrayList<LojaNatureza>();
            }
		}
 		
		public boolean existeListaOportunidadeDia_Possui() {
			return listaoportunidadeDiaPossui!= null;
		}
		private List<OportunidadeDia> listaoportunidadeDiaPossui;
		public void setListaOportunidadeDia_Possui(List<OportunidadeDia> value) 
		{	
			listaoportunidadeDiaPossui = value;
		} 
		public List<OportunidadeDia> getListaOportunidadeDia_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaoportunidadeDiaPossui == null)
			//{
            //	getCarregador().CarregaListaOportunidadeDia_Possui(vo);
            //}
			return listaoportunidadeDiaPossui;
			
		} 
		public void addListaOportunidadeDia_Possui(OportunidadeDia value)
		{	
			criaVaziaListaOportunidadeDia_Possui();
			listaoportunidadeDiaPossui.add(value);
		} 
		public OportunidadeDia getCorrenteOportunidadeDia_Possui()
		{	
			if (listaoportunidadeDiaPossui==null || listaoportunidadeDiaPossui.size()==0) return null;
			return listaoportunidadeDiaPossui.get(listaoportunidadeDiaPossui.size()-1);
		} 
		public void criaVaziaListaOportunidadeDia_Possui() {
			if (listaoportunidadeDiaPossui == null)
            {
            	listaoportunidadeDiaPossui = new ArrayList<OportunidadeDia>();
            }
		}
 		
		public boolean existeListaUsuarioPesquisa_PesquisadoPor() {
			return listausuarioPesquisaPesquisadoPor!= null;
		}
		private List<UsuarioPesquisa> listausuarioPesquisaPesquisadoPor;
		public void setListaUsuarioPesquisa_PesquisadoPor(List<UsuarioPesquisa> value) 
		{	
			listausuarioPesquisaPesquisadoPor = value;
		} 
		public List<UsuarioPesquisa> getListaUsuarioPesquisa_PesquisadoPor ()
		{	
			// ligando o LazyLoader
			//if (listausuarioPesquisaPesquisadoPor == null)
			//{
            //	getCarregador().CarregaListaUsuarioPesquisa_PesquisadoPor(vo);
            //}
			return listausuarioPesquisaPesquisadoPor;
			
		} 
		public void addListaUsuarioPesquisa_PesquisadoPor(UsuarioPesquisa value)
		{	
			criaVaziaListaUsuarioPesquisa_PesquisadoPor();
			listausuarioPesquisaPesquisadoPor.add(value);
		} 
		public UsuarioPesquisa getCorrenteUsuarioPesquisa_PesquisadoPor()
		{	
			if (listausuarioPesquisaPesquisadoPor==null || listausuarioPesquisaPesquisadoPor.size()==0) return null;
			return listausuarioPesquisaPesquisadoPor.get(listausuarioPesquisaPesquisadoPor.size()-1);
		} 
		public void criaVaziaListaUsuarioPesquisa_PesquisadoPor() {
			if (listausuarioPesquisaPesquisadoPor == null)
            {
            	listausuarioPesquisaPesquisadoPor = new ArrayList<UsuarioPesquisa>();
            }
		}
 		
		public boolean existeListaContagemProduto_Possui() {
			return listacontagemProdutoPossui!= null;
		}
		private List<ContagemProduto> listacontagemProdutoPossui;
		public void setListaContagemProduto_Possui(List<ContagemProduto> value) 
		{	
			listacontagemProdutoPossui = value;
		} 
		public List<ContagemProduto> getListaContagemProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacontagemProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaContagemProduto_Possui(vo);
            //}
			return listacontagemProdutoPossui;
			
		} 
		public void addListaContagemProduto_Possui(ContagemProduto value)
		{	
			criaVaziaListaContagemProduto_Possui();
			listacontagemProdutoPossui.add(value);
		} 
		public ContagemProduto getCorrenteContagemProduto_Possui()
		{	
			if (listacontagemProdutoPossui==null || listacontagemProdutoPossui.size()==0) return null;
			return listacontagemProdutoPossui.get(listacontagemProdutoPossui.size()-1);
		} 
		public void criaVaziaListaContagemProduto_Possui() {
			if (listacontagemProdutoPossui == null)
            {
            	listacontagemProdutoPossui = new ArrayList<ContagemProduto>();
            }
		}
 		
		public boolean existeListaPalavraChavePesquisa_PodePesquisar() {
			return listapalavraChavePesquisaPodePesquisar!= null;
		}
		private List<PalavraChavePesquisa> listapalavraChavePesquisaPodePesquisar;
		public void setListaPalavraChavePesquisa_PodePesquisar(List<PalavraChavePesquisa> value) 
		{	
			listapalavraChavePesquisaPodePesquisar = value;
		} 
		public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_PodePesquisar ()
		{	
			// ligando o LazyLoader
			//if (listapalavraChavePesquisaPodePesquisar == null)
			//{
            //	getCarregador().CarregaListaPalavraChavePesquisa_PodePesquisar(vo);
            //}
			return listapalavraChavePesquisaPodePesquisar;
			
		} 
		public void addListaPalavraChavePesquisa_PodePesquisar(PalavraChavePesquisa value)
		{	
			criaVaziaListaPalavraChavePesquisa_PodePesquisar();
			listapalavraChavePesquisaPodePesquisar.add(value);
		} 
		public PalavraChavePesquisa getCorrentePalavraChavePesquisa_PodePesquisar()
		{	
			if (listapalavraChavePesquisaPodePesquisar==null || listapalavraChavePesquisaPodePesquisar.size()==0) return null;
			return listapalavraChavePesquisaPodePesquisar.get(listapalavraChavePesquisaPodePesquisar.size()-1);
		} 
		public void criaVaziaListaPalavraChavePesquisa_PodePesquisar() {
			if (listapalavraChavePesquisaPodePesquisar == null)
            {
            	listapalavraChavePesquisaPodePesquisar = new ArrayList<PalavraChavePesquisa>();
            }
		}
 		
		public boolean existeListaProdutoCliente_Possui() {
			return listaprodutoClientePossui!= null;
		}
		private List<ProdutoCliente> listaprodutoClientePossui;
		public void setListaProdutoCliente_Possui(List<ProdutoCliente> value) 
		{	
			listaprodutoClientePossui = value;
		} 
		public List<ProdutoCliente> getListaProdutoCliente_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoClientePossui == null)
			//{
            //	getCarregador().CarregaListaProdutoCliente_Possui(vo);
            //}
			return listaprodutoClientePossui;
			
		} 
		public void addListaProdutoCliente_Possui(ProdutoCliente value)
		{	
			criaVaziaListaProdutoCliente_Possui();
			listaprodutoClientePossui.add(value);
		} 
		public ProdutoCliente getCorrenteProdutoCliente_Possui()
		{	
			if (listaprodutoClientePossui==null || listaprodutoClientePossui.size()==0) return null;
			return listaprodutoClientePossui.get(listaprodutoClientePossui.size()-1);
		} 
		public void criaVaziaListaProdutoCliente_Possui() {
			if (listaprodutoClientePossui == null)
            {
            	listaprodutoClientePossui = new ArrayList<ProdutoCliente>();
            }
		}
 		
	}
