package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class FacebookPostAgregado implements FacebookPostAgregadoI
	{
		
		private FacebookPostCarregador carregador = null;
		private FacebookPostCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookPostCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getFacebookFanpageFeitoEm(false) != null)
				vo.getFacebookFanpageFeitoEm(false).setConexaoCarregador(conexao);
			if (vo.getProdutoDivulgando(false) != null)
				vo.getProdutoDivulgando(false).setConexaoCarregador(conexao);
			
		}
		
		
		private FacebookPost vo;
		public FacebookPostAgregado(FacebookPost item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private FacebookFanpage facebookFanpageFeitoEm;
		// Montador Tradicional
		public FacebookFanpage getFacebookFanpageFeitoEm(boolean lazyloader) 
		{	
			if (lazyloader && facebookFanpageFeitoEm==null)
			{
				try {
					getCarregador().CarregaItemFacebookFanpage_FeitoEm(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return facebookFanpageFeitoEm;
		} 
		public void setFacebookFanpageFeitoEm(FacebookFanpage value) 
		{	
			facebookFanpageFeitoEm = value;
		} 
		/*
		public void setFacebookFanpageFeitoEmComReversao(FacebookFanpage value) 
		{	
			facebookFanpageFeitoEm = value;
			System.out.println("Alteracao:" + facebookFanpageFeitoEm);
			if (facebookFanpageFeitoEm!=null)
				facebookFanpageFeitoEm.addListaFacebookPost_Tem(vo);
		} 
		*/
		
		public void addListaFacebookFanpage_FeitoEm(FacebookFanpage  value) 
		{	
			facebookFanpageFeitoEm = value;
		} 
		public FacebookFanpage getCorrenteFacebookFanpage_FeitoEm()
		{	
			return facebookFanpageFeitoEm;
		} 
		
 		
		private Produto produtoDivulgando;
		// Montador Tradicional
		public Produto getProdutoDivulgando(boolean lazyloader) 
		{	
			if (lazyloader && produtoDivulgando==null)
			{
				try {
					getCarregador().CarregaItemProduto_Divulgando(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoDivulgando;
		} 
		public void setProdutoDivulgando(Produto value) 
		{	
			produtoDivulgando = value;
		} 
		/*
		public void setProdutoDivulgandoComReversao(Produto value) 
		{	
			produtoDivulgando = value;
			System.out.println("Alteracao:" + produtoDivulgando);
			if (produtoDivulgando!=null)
				produtoDivulgando.addListaFacebookPost_DivulgadoPor(vo);
		} 
		*/
		
		public void addListaProduto_Divulgando(Produto  value) 
		{	
			produtoDivulgando = value;
		} 
		public Produto getCorrenteProduto_Divulgando()
		{	
			return produtoDivulgando;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaFacebookPostPerformance_Gera() {
			return listafacebookPostPerformanceGera!= null;
		}
		private List<FacebookPostPerformance> listafacebookPostPerformanceGera;
		public void setListaFacebookPostPerformance_Gera(List<FacebookPostPerformance> value) 
		{	
			listafacebookPostPerformanceGera = value;
		} 
		public List<FacebookPostPerformance> getListaFacebookPostPerformance_Gera ()
		{	
			// ligando o LazyLoader
			//if (listafacebookPostPerformanceGera == null)
			//{
            //	getCarregador().CarregaListaFacebookPostPerformance_Gera(vo);
            //}
			return listafacebookPostPerformanceGera;
			
		} 
		public void addListaFacebookPostPerformance_Gera(FacebookPostPerformance value)
		{	
			criaVaziaListaFacebookPostPerformance_Gera();
			listafacebookPostPerformanceGera.add(value);
		} 
		public FacebookPostPerformance getCorrenteFacebookPostPerformance_Gera()
		{	
			if (listafacebookPostPerformanceGera==null || listafacebookPostPerformanceGera.size()==0) return null;
			return listafacebookPostPerformanceGera.get(listafacebookPostPerformanceGera.size()-1);
		} 
		public void criaVaziaListaFacebookPostPerformance_Gera() {
			if (listafacebookPostPerformanceGera == null)
            {
            	listafacebookPostPerformanceGera = new ArrayList<FacebookPostPerformance>();
            }
		}
 		
	}
