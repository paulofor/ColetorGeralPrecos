package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PalavraAgregado implements PalavraAgregadoI
	{
		
		private PalavraCarregador carregador = null;
		private PalavraCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PalavraCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Palavra vo;
		public PalavraAgregado(Palavra item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
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
 		
	}
