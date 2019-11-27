package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class FacebookPostPerformanceAgregado implements FacebookPostPerformanceAgregadoI
	{
		
		private FacebookPostPerformanceCarregador carregador = null;
		private FacebookPostPerformanceCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookPostPerformanceCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getFacebookPostReferenteA(false) != null)
				vo.getFacebookPostReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private FacebookPostPerformance vo;
		public FacebookPostPerformanceAgregado(FacebookPostPerformance item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private FacebookPost facebookPostReferenteA;
		// Montador Tradicional
		public FacebookPost getFacebookPostReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && facebookPostReferenteA==null)
			{
				try {
					getCarregador().CarregaItemFacebookPost_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return facebookPostReferenteA;
		} 
		public void setFacebookPostReferenteA(FacebookPost value) 
		{	
			facebookPostReferenteA = value;
		} 
		/*
		public void setFacebookPostReferenteAComReversao(FacebookPost value) 
		{	
			facebookPostReferenteA = value;
			System.out.println("Alteracao:" + facebookPostReferenteA);
			if (facebookPostReferenteA!=null)
				facebookPostReferenteA.addListaFacebookPostPerformance_Gera(vo);
		} 
		*/
		
		public void addListaFacebookPost_ReferenteA(FacebookPost  value) 
		{	
			facebookPostReferenteA = value;
		} 
		public FacebookPost getCorrenteFacebookPost_ReferenteA()
		{	
			return facebookPostReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
