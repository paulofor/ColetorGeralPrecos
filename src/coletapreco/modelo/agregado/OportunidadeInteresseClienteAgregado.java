package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OportunidadeInteresseClienteAgregado implements OportunidadeInteresseClienteAgregadoI
	{
		
		private OportunidadeInteresseClienteCarregador carregador = null;
		private OportunidadeInteresseClienteCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OportunidadeInteresseClienteCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoClientePertenceA(false) != null)
				vo.getProdutoClientePertenceA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private OportunidadeInteresseCliente vo;
		public OportunidadeInteresseClienteAgregado(OportunidadeInteresseCliente item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private ProdutoCliente produtoClientePertenceA;
		// Montador Tradicional
		public ProdutoCliente getProdutoClientePertenceA(boolean lazyloader) 
		{	
			if (lazyloader && produtoClientePertenceA==null)
			{
				try {
					getCarregador().CarregaItemProdutoCliente_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoClientePertenceA;
		} 
		public void setProdutoClientePertenceA(ProdutoCliente value) 
		{	
			produtoClientePertenceA = value;
		} 
		/*
		public void setProdutoClientePertenceAComReversao(ProdutoCliente value) 
		{	
			produtoClientePertenceA = value;
			System.out.println("Alteracao:" + produtoClientePertenceA);
			if (produtoClientePertenceA!=null)
				produtoClientePertenceA.addListaOportunidadeInteresseCliente_Possui(vo);
		} 
		*/
		
		public void addListaProdutoCliente_PertenceA(ProdutoCliente  value) 
		{	
			produtoClientePertenceA = value;
		} 
		public ProdutoCliente getCorrenteProdutoCliente_PertenceA()
		{	
			return produtoClientePertenceA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
