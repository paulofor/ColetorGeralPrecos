package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class MarcaAgregado implements MarcaAgregadoI
	{
		
		private MarcaCarregador carregador = null;
		private MarcaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new MarcaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private Marca vo;
		public MarcaAgregado(Marca item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaProduto_ReferenteA() {
			return listaprodutoReferenteA!= null;
		}
		private List<Produto> listaprodutoReferenteA;
		public void setListaProduto_ReferenteA(List<Produto> value) 
		{	
			listaprodutoReferenteA = value;
		} 
		public List<Produto> getListaProduto_ReferenteA ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoReferenteA == null)
			//{
            //	getCarregador().CarregaListaProduto_ReferenteA(vo);
            //}
			return listaprodutoReferenteA;
			
		} 
		public void addListaProduto_ReferenteA(Produto value)
		{	
			criaVaziaListaProduto_ReferenteA();
			listaprodutoReferenteA.add(value);
		} 
		public Produto getCorrenteProduto_ReferenteA()
		{	
			if (listaprodutoReferenteA==null || listaprodutoReferenteA.size()==0) return null;
			return listaprodutoReferenteA.get(listaprodutoReferenteA.size()-1);
		} 
		public void criaVaziaListaProduto_ReferenteA() {
			if (listaprodutoReferenteA == null)
            {
            	listaprodutoReferenteA = new ArrayList<Produto>();
            }
		}
 		
	}
