package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class LojaVirtualAgregado implements LojaVirtualAgregadoI
	{
		
		private LojaVirtualCarregador carregador = null;
		private LojaVirtualCarregador getCarregador() {
			if (carregador==null) {
				carregador = new LojaVirtualCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			
		}
		
		
		private LojaVirtual vo;
		public LojaVirtualAgregado(LojaVirtual item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
		public boolean existeListaProduto_Possui() {
			return listaprodutoPossui!= null;
		}
		private List<Produto> listaprodutoPossui;
		public void setListaProduto_Possui(List<Produto> value) 
		{	
			listaprodutoPossui = value;
		} 
		public List<Produto> getListaProduto_Possui ()
		{	
			// ligando o LazyLoader
			//if (listaprodutoPossui == null)
			//{
            //	getCarregador().CarregaListaProduto_Possui(vo);
            //}
			return listaprodutoPossui;
			
		} 
		public void addListaProduto_Possui(Produto value)
		{	
			criaVaziaListaProduto_Possui();
			listaprodutoPossui.add(value);
		} 
		public Produto getCorrenteProduto_Possui()
		{	
			if (listaprodutoPossui==null || listaprodutoPossui.size()==0) return null;
			return listaprodutoPossui.get(listaprodutoPossui.size()-1);
		} 
		public void criaVaziaListaProduto_Possui() {
			if (listaprodutoPossui == null)
            {
            	listaprodutoPossui = new ArrayList<Produto>();
            }
		}
 		
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
 		
		public boolean existeListaLojaNatureza_Oferece() {
			return listalojaNaturezaOferece!= null;
		}
		private List<LojaNatureza> listalojaNaturezaOferece;
		public void setListaLojaNatureza_Oferece(List<LojaNatureza> value) 
		{	
			listalojaNaturezaOferece = value;
		} 
		public List<LojaNatureza> getListaLojaNatureza_Oferece ()
		{	
			// ligando o LazyLoader
			//if (listalojaNaturezaOferece == null)
			//{
            //	getCarregador().CarregaListaLojaNatureza_Oferece(vo);
            //}
			return listalojaNaturezaOferece;
			
		} 
		public void addListaLojaNatureza_Oferece(LojaNatureza value)
		{	
			criaVaziaListaLojaNatureza_Oferece();
			listalojaNaturezaOferece.add(value);
		} 
		public LojaNatureza getCorrenteLojaNatureza_Oferece()
		{	
			if (listalojaNaturezaOferece==null || listalojaNaturezaOferece.size()==0) return null;
			return listalojaNaturezaOferece.get(listalojaNaturezaOferece.size()-1);
		} 
		public void criaVaziaListaLojaNatureza_Oferece() {
			if (listalojaNaturezaOferece == null)
            {
            	listalojaNaturezaOferece = new ArrayList<LojaNatureza>();
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
 		
	}
