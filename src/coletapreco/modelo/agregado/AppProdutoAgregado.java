package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class AppProdutoAgregado implements AppProdutoAgregadoI
	{
		
		private AppProdutoCarregador carregador = null;
		private AppProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new AppProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private AppProduto vo;
		public AppProdutoAgregado(AppProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaFacebookFanpage_DivulgadoPor() {
			return listafacebookFanpageDivulgadoPor!= null;
		}
		private List<FacebookFanpage> listafacebookFanpageDivulgadoPor;
		public void setListaFacebookFanpage_DivulgadoPor(List<FacebookFanpage> value) 
		{	
			listafacebookFanpageDivulgadoPor = value;
		} 
		public List<FacebookFanpage> getListaFacebookFanpage_DivulgadoPor ()
		{	
			// ligando o LazyLoader
			//if (listafacebookFanpageDivulgadoPor == null)
			//{
            //	getCarregador().CarregaListaFacebookFanpage_DivulgadoPor(vo);
            //}
			return listafacebookFanpageDivulgadoPor;
			
		} 
		public void addListaFacebookFanpage_DivulgadoPor(FacebookFanpage value)
		{	
			criaVaziaListaFacebookFanpage_DivulgadoPor();
			listafacebookFanpageDivulgadoPor.add(value);
		} 
		public FacebookFanpage getCorrenteFacebookFanpage_DivulgadoPor()
		{	
			if (listafacebookFanpageDivulgadoPor==null || listafacebookFanpageDivulgadoPor.size()==0) return null;
			return listafacebookFanpageDivulgadoPor.get(listafacebookFanpageDivulgadoPor.size()-1);
		} 
		public void criaVaziaListaFacebookFanpage_DivulgadoPor() {
			if (listafacebookFanpageDivulgadoPor == null)
            {
            	listafacebookFanpageDivulgadoPor = new ArrayList<FacebookFanpage>();
            }
		}
 		
		public boolean existeListaNaturezaProduto_Atende() {
			return listanaturezaProdutoAtende!= null;
		}
		private List<NaturezaProduto> listanaturezaProdutoAtende;
		public void setListaNaturezaProduto_Atende(List<NaturezaProduto> value) 
		{	
			listanaturezaProdutoAtende = value;
		} 
		public List<NaturezaProduto> getListaNaturezaProduto_Atende ()
		{	
			// ligando o LazyLoader
			//if (listanaturezaProdutoAtende == null)
			//{
            //	getCarregador().CarregaListaNaturezaProduto_Atende(vo);
            //}
			return listanaturezaProdutoAtende;
			
		} 
		public void addListaNaturezaProduto_Atende(NaturezaProduto value)
		{	
			criaVaziaListaNaturezaProduto_Atende();
			listanaturezaProdutoAtende.add(value);
		} 
		public NaturezaProduto getCorrenteNaturezaProduto_Atende()
		{	
			if (listanaturezaProdutoAtende==null || listanaturezaProdutoAtende.size()==0) return null;
			return listanaturezaProdutoAtende.get(listanaturezaProdutoAtende.size()-1);
		} 
		public void criaVaziaListaNaturezaProduto_Atende() {
			if (listanaturezaProdutoAtende == null)
            {
            	listanaturezaProdutoAtende = new ArrayList<NaturezaProduto>();
            }
		}
 		
		public boolean existeListaDispositivoUsuario_UsadoPor() {
			return listadispositivoUsuarioUsadoPor!= null;
		}
		private List<DispositivoUsuario> listadispositivoUsuarioUsadoPor;
		public void setListaDispositivoUsuario_UsadoPor(List<DispositivoUsuario> value) 
		{	
			listadispositivoUsuarioUsadoPor = value;
		} 
		public List<DispositivoUsuario> getListaDispositivoUsuario_UsadoPor ()
		{	
			// ligando o LazyLoader
			//if (listadispositivoUsuarioUsadoPor == null)
			//{
            //	getCarregador().CarregaListaDispositivoUsuario_UsadoPor(vo);
            //}
			return listadispositivoUsuarioUsadoPor;
			
		} 
		public void addListaDispositivoUsuario_UsadoPor(DispositivoUsuario value)
		{	
			criaVaziaListaDispositivoUsuario_UsadoPor();
			listadispositivoUsuarioUsadoPor.add(value);
		} 
		public DispositivoUsuario getCorrenteDispositivoUsuario_UsadoPor()
		{	
			if (listadispositivoUsuarioUsadoPor==null || listadispositivoUsuarioUsadoPor.size()==0) return null;
			return listadispositivoUsuarioUsadoPor.get(listadispositivoUsuarioUsadoPor.size()-1);
		} 
		public void criaVaziaListaDispositivoUsuario_UsadoPor() {
			if (listadispositivoUsuarioUsadoPor == null)
            {
            	listadispositivoUsuarioUsadoPor = new ArrayList<DispositivoUsuario>();
            }
		}
 		
	}
