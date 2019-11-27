package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class FacebookFanpageAgregado implements FacebookFanpageAgregadoI
	{
		
		private FacebookFanpageCarregador carregador = null;
		private FacebookFanpageCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookFanpageCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getFacebookPerfilPertenceA(false) != null)
				vo.getFacebookPerfilPertenceA(false).setConexaoCarregador(conexao);
			if (vo.getAppProdutoDivulga(false) != null)
				vo.getAppProdutoDivulga(false).setConexaoCarregador(conexao);
			
		}
		
		
		private FacebookFanpage vo;
		public FacebookFanpageAgregado(FacebookFanpage item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private FacebookPerfil facebookPerfilPertenceA;
		// Montador Tradicional
		public FacebookPerfil getFacebookPerfilPertenceA(boolean lazyloader) 
		{	
			if (lazyloader && facebookPerfilPertenceA==null)
			{
				try {
					getCarregador().CarregaItemFacebookPerfil_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return facebookPerfilPertenceA;
		} 
		public void setFacebookPerfilPertenceA(FacebookPerfil value) 
		{	
			facebookPerfilPertenceA = value;
		} 
		/*
		public void setFacebookPerfilPertenceAComReversao(FacebookPerfil value) 
		{	
			facebookPerfilPertenceA = value;
			System.out.println("Alteracao:" + facebookPerfilPertenceA);
			if (facebookPerfilPertenceA!=null)
				facebookPerfilPertenceA.addListaFacebookFanpage_Possui(vo);
		} 
		*/
		
		public void addListaFacebookPerfil_PertenceA(FacebookPerfil  value) 
		{	
			facebookPerfilPertenceA = value;
		} 
		public FacebookPerfil getCorrenteFacebookPerfil_PertenceA()
		{	
			return facebookPerfilPertenceA;
		} 
		
 		
		private AppProduto appProdutoDivulga;
		// Montador Tradicional
		public AppProduto getAppProdutoDivulga(boolean lazyloader) 
		{	
			if (lazyloader && appProdutoDivulga==null)
			{
				try {
					getCarregador().CarregaItemAppProduto_Divulga(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return appProdutoDivulga;
		} 
		public void setAppProdutoDivulga(AppProduto value) 
		{	
			appProdutoDivulga = value;
		} 
		/*
		public void setAppProdutoDivulgaComReversao(AppProduto value) 
		{	
			appProdutoDivulga = value;
			System.out.println("Alteracao:" + appProdutoDivulga);
			if (appProdutoDivulga!=null)
				appProdutoDivulga.addListaFacebookFanpage_DivulgadoPor(vo);
		} 
		*/
		
		public void addListaAppProduto_Divulga(AppProduto  value) 
		{	
			appProdutoDivulga = value;
		} 
		public AppProduto getCorrenteAppProduto_Divulga()
		{	
			return appProdutoDivulga;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaFacebookPost_Tem() {
			return listafacebookPostTem!= null;
		}
		private List<FacebookPost> listafacebookPostTem;
		public void setListaFacebookPost_Tem(List<FacebookPost> value) 
		{	
			listafacebookPostTem = value;
		} 
		public List<FacebookPost> getListaFacebookPost_Tem ()
		{	
			// ligando o LazyLoader
			//if (listafacebookPostTem == null)
			//{
            //	getCarregador().CarregaListaFacebookPost_Tem(vo);
            //}
			return listafacebookPostTem;
			
		} 
		public void addListaFacebookPost_Tem(FacebookPost value)
		{	
			criaVaziaListaFacebookPost_Tem();
			listafacebookPostTem.add(value);
		} 
		public FacebookPost getCorrenteFacebookPost_Tem()
		{	
			if (listafacebookPostTem==null || listafacebookPostTem.size()==0) return null;
			return listafacebookPostTem.get(listafacebookPostTem.size()-1);
		} 
		public void criaVaziaListaFacebookPost_Tem() {
			if (listafacebookPostTem == null)
            {
            	listafacebookPostTem = new ArrayList<FacebookPost>();
            }
		}
 		
	}
