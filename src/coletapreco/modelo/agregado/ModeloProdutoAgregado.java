package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class ModeloProdutoAgregado implements ModeloProdutoAgregadoI
	{
		
		private ModeloProdutoCarregador carregador = null;
		private ModeloProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new ModeloProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private ModeloProduto vo;
		public ModeloProdutoAgregado(ModeloProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
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
 		
	}
