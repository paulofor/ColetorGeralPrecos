package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class FacebookPerfilAgregado implements FacebookPerfilAgregadoI
	{
		
		private FacebookPerfilCarregador carregador = null;
		private FacebookPerfilCarregador getCarregador() {
			if (carregador==null) {
				carregador = new FacebookPerfilCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private FacebookPerfil vo;
		public FacebookPerfilAgregado(FacebookPerfil item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaFacebookFanpage_Possui() {
			return listafacebookFanpagePossui!= null;
		}
		private List<FacebookFanpage> listafacebookFanpagePossui;
		public void setListaFacebookFanpage_Possui(List<FacebookFanpage> value) 
		{	
			listafacebookFanpagePossui = value;
		} 
		public List<FacebookFanpage> getListaFacebookFanpage_Possui ()
		{	
			// ligando o LazyLoader
			//if (listafacebookFanpagePossui == null)
			//{
            //	getCarregador().CarregaListaFacebookFanpage_Possui(vo);
            //}
			return listafacebookFanpagePossui;
			
		} 
		public void addListaFacebookFanpage_Possui(FacebookFanpage value)
		{	
			criaVaziaListaFacebookFanpage_Possui();
			listafacebookFanpagePossui.add(value);
		} 
		public FacebookFanpage getCorrenteFacebookFanpage_Possui()
		{	
			if (listafacebookFanpagePossui==null || listafacebookFanpagePossui.size()==0) return null;
			return listafacebookFanpagePossui.get(listafacebookFanpagePossui.size()-1);
		} 
		public void criaVaziaListaFacebookFanpage_Possui() {
			if (listafacebookFanpagePossui == null)
            {
            	listafacebookFanpagePossui = new ArrayList<FacebookFanpage>();
            }
		}
 		
	}
