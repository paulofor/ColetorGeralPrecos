package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ProdutoAgregado implements ProdutoAgregadoI
	{
		
		private ProdutoCarregador carregador = null;
		private ProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getLojaVirtualLidoEm(false) != null)
				vo.getLojaVirtualLidoEm(false).setConexaoCarregador(conexao);
			if (vo.getMarcaPossui(false) != null)
				vo.getMarcaPossui(false).setConexaoCarregador(conexao);
			
		}
		
		
		private Produto vo;
		public ProdutoAgregado(Produto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private LojaVirtual lojaVirtualLidoEm;
		// Montador Tradicional
		public LojaVirtual getLojaVirtualLidoEm(boolean lazyloader) 
		{	
			if (lazyloader && lojaVirtualLidoEm==null)
			{
				try {
					getCarregador().CarregaItemLojaVirtual_LidoEm(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return lojaVirtualLidoEm;
		} 
		public void setLojaVirtualLidoEm(LojaVirtual value) 
		{	
			lojaVirtualLidoEm = value;
		} 
		/*
		public void setLojaVirtualLidoEmComReversao(LojaVirtual value) 
		{	
			lojaVirtualLidoEm = value;
			System.out.println("Alteracao:" + lojaVirtualLidoEm);
			if (lojaVirtualLidoEm!=null)
				lojaVirtualLidoEm.addListaProduto_Possui(vo);
		} 
		*/
		
		public void addListaLojaVirtual_LidoEm(LojaVirtual  value) 
		{	
			lojaVirtualLidoEm = value;
		} 
		public LojaVirtual getCorrenteLojaVirtual_LidoEm()
		{	
			return lojaVirtualLidoEm;
		} 
		
 		
		private Marca marcaPossui;
		// Montador Tradicional
		public Marca getMarcaPossui(boolean lazyloader) 
		{	
			if (lazyloader && marcaPossui==null)
			{
				try {
					getCarregador().CarregaItemMarca_Possui(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return marcaPossui;
		} 
		public void setMarcaPossui(Marca value) 
		{	
			marcaPossui = value;
		} 
		/*
		public void setMarcaPossuiComReversao(Marca value) 
		{	
			marcaPossui = value;
			System.out.println("Alteracao:" + marcaPossui);
			if (marcaPossui!=null)
				marcaPossui.addListaProduto_ReferenteA(vo);
		} 
		*/
		
		public void addListaMarca_Possui(Marca  value) 
		{	
			marcaPossui = value;
		} 
		public Marca getCorrenteMarca_Possui()
		{	
			return marcaPossui;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaPrecoDiario_Possui() {
			return listaprecoDiarioPossui!= null;
		}
		private List<PrecoDiario> listaprecoDiarioPossui;
		public void setListaPrecoDiario_Possui(List<PrecoDiario> value) 
		{	
			listaprecoDiarioPossui = value;
		} 
		public List<PrecoDiario> getListaPrecoDiario_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoDiarioPossui == null)
			//{
            //	getCarregador().CarregaListaPrecoDiario_Possui(vo);
            //}
			return listaprecoDiarioPossui;
			
		} 
		public void addListaPrecoDiario_Possui(PrecoDiario value)
		{	
			criaVaziaListaPrecoDiario_Possui();
			listaprecoDiarioPossui.add(value);
		} 
		public PrecoDiario getCorrentePrecoDiario_Possui()
		{	
			if (listaprecoDiarioPossui==null || listaprecoDiarioPossui.size()==0) return null;
			return listaprecoDiarioPossui.get(listaprecoDiarioPossui.size()-1);
		} 
		public void criaVaziaListaPrecoDiario_Possui() {
			if (listaprecoDiarioPossui == null)
            {
            	listaprecoDiarioPossui = new ArrayList<PrecoDiario>();
            }
		}
 		
		public boolean existeListaModeloProdutoProduto_ReferenteA() {
			return listamodeloProdutoProdutoReferenteA!= null;
		}
		private List<ModeloProdutoProduto> listamodeloProdutoProdutoReferenteA;
		public void setListaModeloProdutoProduto_ReferenteA(List<ModeloProdutoProduto> value) 
		{	
			listamodeloProdutoProdutoReferenteA = value;
		} 
		public List<ModeloProdutoProduto> getListaModeloProdutoProduto_ReferenteA ()
		{	
			// ligando o LazyLoader
			//if (listamodeloProdutoProdutoReferenteA == null)
			//{
            //	getCarregador().CarregaListaModeloProdutoProduto_ReferenteA(vo);
            //}
			return listamodeloProdutoProdutoReferenteA;
			
		} 
		public void addListaModeloProdutoProduto_ReferenteA(ModeloProdutoProduto value)
		{	
			criaVaziaListaModeloProdutoProduto_ReferenteA();
			listamodeloProdutoProdutoReferenteA.add(value);
		} 
		public ModeloProdutoProduto getCorrenteModeloProdutoProduto_ReferenteA()
		{	
			if (listamodeloProdutoProdutoReferenteA==null || listamodeloProdutoProdutoReferenteA.size()==0) return null;
			return listamodeloProdutoProdutoReferenteA.get(listamodeloProdutoProdutoReferenteA.size()-1);
		} 
		public void criaVaziaListaModeloProdutoProduto_ReferenteA() {
			if (listamodeloProdutoProdutoReferenteA == null)
            {
            	listamodeloProdutoProdutoReferenteA = new ArrayList<ModeloProdutoProduto>();
            }
		}
 		
		public boolean existeListaPrecoProduto_Possui() {
			return listaprecoProdutoPossui!= null;
		}
		private List<PrecoProduto> listaprecoProdutoPossui;
		public void setListaPrecoProduto_Possui(List<PrecoProduto> value) 
		{	
			listaprecoProdutoPossui = value;
		} 
		public List<PrecoProduto> getListaPrecoProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprecoProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaPrecoProduto_Possui(vo);
            //}
			return listaprecoProdutoPossui;
			
		} 
		public void addListaPrecoProduto_Possui(PrecoProduto value)
		{	
			criaVaziaListaPrecoProduto_Possui();
			listaprecoProdutoPossui.add(value);
		} 
		public PrecoProduto getCorrentePrecoProduto_Possui()
		{	
			if (listaprecoProdutoPossui==null || listaprecoProdutoPossui.size()==0) return null;
			return listaprecoProdutoPossui.get(listaprecoProdutoPossui.size()-1);
		} 
		public void criaVaziaListaPrecoProduto_Possui() {
			if (listaprecoProdutoPossui == null)
            {
            	listaprecoProdutoPossui = new ArrayList<PrecoProduto>();
            }
		}
 		
		public boolean existeListaCategoriaLojaProduto_Possui() {
			return listacategoriaLojaProdutoPossui!= null;
		}
		private List<CategoriaLojaProduto> listacategoriaLojaProdutoPossui;
		public void setListaCategoriaLojaProduto_Possui(List<CategoriaLojaProduto> value) 
		{	
			listacategoriaLojaProdutoPossui = value;
		} 
		public List<CategoriaLojaProduto> getListaCategoriaLojaProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listacategoriaLojaProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaCategoriaLojaProduto_Possui(vo);
            //}
			return listacategoriaLojaProdutoPossui;
			
		} 
		public void addListaCategoriaLojaProduto_Possui(CategoriaLojaProduto value)
		{	
			criaVaziaListaCategoriaLojaProduto_Possui();
			listacategoriaLojaProdutoPossui.add(value);
		} 
		public CategoriaLojaProduto getCorrenteCategoriaLojaProduto_Possui()
		{	
			if (listacategoriaLojaProdutoPossui==null || listacategoriaLojaProdutoPossui.size()==0) return null;
			return listacategoriaLojaProdutoPossui.get(listacategoriaLojaProdutoPossui.size()-1);
		} 
		public void criaVaziaListaCategoriaLojaProduto_Possui() {
			if (listacategoriaLojaProdutoPossui == null)
            {
            	listacategoriaLojaProdutoPossui = new ArrayList<CategoriaLojaProduto>();
            }
		}
 		
		public boolean existeListaOportunidadeDia_PodePossuir() {
			return listaoportunidadeDiaPodePossuir!= null;
		}
		private List<OportunidadeDia> listaoportunidadeDiaPodePossuir;
		public void setListaOportunidadeDia_PodePossuir(List<OportunidadeDia> value) 
		{	
			listaoportunidadeDiaPodePossuir = value;
		} 
		public List<OportunidadeDia> getListaOportunidadeDia_PodePossuir ()
		{	
			// ligando o LazyLoader
			//if (listaoportunidadeDiaPodePossuir == null)
			//{
            //	getCarregador().CarregaListaOportunidadeDia_PodePossuir(vo);
            //}
			return listaoportunidadeDiaPodePossuir;
			
		} 
		public void addListaOportunidadeDia_PodePossuir(OportunidadeDia value)
		{	
			criaVaziaListaOportunidadeDia_PodePossuir();
			listaoportunidadeDiaPodePossuir.add(value);
		} 
		public OportunidadeDia getCorrenteOportunidadeDia_PodePossuir()
		{	
			if (listaoportunidadeDiaPodePossuir==null || listaoportunidadeDiaPodePossuir.size()==0) return null;
			return listaoportunidadeDiaPodePossuir.get(listaoportunidadeDiaPodePossuir.size()-1);
		} 
		public void criaVaziaListaOportunidadeDia_PodePossuir() {
			if (listaoportunidadeDiaPodePossuir == null)
            {
            	listaoportunidadeDiaPodePossuir = new ArrayList<OportunidadeDia>();
            }
		}
 		
		public boolean existeListaPalavraProduto_Possui() {
			return listapalavraProdutoPossui!= null;
		}
		private List<PalavraProduto> listapalavraProdutoPossui;
		public void setListaPalavraProduto_Possui(List<PalavraProduto> value) 
		{	
			listapalavraProdutoPossui = value;
		} 
		public List<PalavraProduto> getListaPalavraProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listapalavraProdutoPossui == null)
			//{
            //	getCarregador().CarregaListaPalavraProduto_Possui(vo);
            //}
			return listapalavraProdutoPossui;
			
		} 
		public void addListaPalavraProduto_Possui(PalavraProduto value)
		{	
			criaVaziaListaPalavraProduto_Possui();
			listapalavraProdutoPossui.add(value);
		} 
		public PalavraProduto getCorrentePalavraProduto_Possui()
		{	
			if (listapalavraProdutoPossui==null || listapalavraProdutoPossui.size()==0) return null;
			return listapalavraProdutoPossui.get(listapalavraProdutoPossui.size()-1);
		} 
		public void criaVaziaListaPalavraProduto_Possui() {
			if (listapalavraProdutoPossui == null)
            {
            	listapalavraProdutoPossui = new ArrayList<PalavraProduto>();
            }
		}
 		
		public boolean existeListaFacebookPost_DivulgadoPor() {
			return listafacebookPostDivulgadoPor!= null;
		}
		private List<FacebookPost> listafacebookPostDivulgadoPor;
		public void setListaFacebookPost_DivulgadoPor(List<FacebookPost> value) 
		{	
			listafacebookPostDivulgadoPor = value;
		} 
		public List<FacebookPost> getListaFacebookPost_DivulgadoPor ()
		{	
			// ligando o LazyLoader
			//if (listafacebookPostDivulgadoPor == null)
			//{
            //	getCarregador().CarregaListaFacebookPost_DivulgadoPor(vo);
            //}
			return listafacebookPostDivulgadoPor;
			
		} 
		public void addListaFacebookPost_DivulgadoPor(FacebookPost value)
		{	
			criaVaziaListaFacebookPost_DivulgadoPor();
			listafacebookPostDivulgadoPor.add(value);
		} 
		public FacebookPost getCorrenteFacebookPost_DivulgadoPor()
		{	
			if (listafacebookPostDivulgadoPor==null || listafacebookPostDivulgadoPor.size()==0) return null;
			return listafacebookPostDivulgadoPor.get(listafacebookPostDivulgadoPor.size()-1);
		} 
		public void criaVaziaListaFacebookPost_DivulgadoPor() {
			if (listafacebookPostDivulgadoPor == null)
            {
            	listafacebookPostDivulgadoPor = new ArrayList<FacebookPost>();
            }
		}
 		
		public boolean existeListaCompartilhamentoProduto_Gerou() {
			return listacompartilhamentoProdutoGerou!= null;
		}
		private List<CompartilhamentoProduto> listacompartilhamentoProdutoGerou;
		public void setListaCompartilhamentoProduto_Gerou(List<CompartilhamentoProduto> value) 
		{	
			listacompartilhamentoProdutoGerou = value;
		} 
		public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Gerou ()
		{	
			// ligando o LazyLoader
			//if (listacompartilhamentoProdutoGerou == null)
			//{
            //	getCarregador().CarregaListaCompartilhamentoProduto_Gerou(vo);
            //}
			return listacompartilhamentoProdutoGerou;
			
		} 
		public void addListaCompartilhamentoProduto_Gerou(CompartilhamentoProduto value)
		{	
			criaVaziaListaCompartilhamentoProduto_Gerou();
			listacompartilhamentoProdutoGerou.add(value);
		} 
		public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Gerou()
		{	
			if (listacompartilhamentoProdutoGerou==null || listacompartilhamentoProdutoGerou.size()==0) return null;
			return listacompartilhamentoProdutoGerou.get(listacompartilhamentoProdutoGerou.size()-1);
		} 
		public void criaVaziaListaCompartilhamentoProduto_Gerou() {
			if (listacompartilhamentoProdutoGerou == null)
            {
            	listacompartilhamentoProdutoGerou = new ArrayList<CompartilhamentoProduto>();
            }
		}
 		
	}
