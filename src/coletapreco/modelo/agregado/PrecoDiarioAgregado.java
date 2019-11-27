package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PrecoDiarioAgregado implements PrecoDiarioAgregadoI
	{
		
		private PrecoDiarioCarregador carregador = null;
		private PrecoDiarioCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PrecoDiarioCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoPertenceA(false) != null)
				vo.getProdutoPertenceA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private PrecoDiario vo;
		public PrecoDiarioAgregado(PrecoDiario item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Produto produtoPertenceA;
		// Montador Tradicional
		public Produto getProdutoPertenceA(boolean lazyloader) 
		{	
			if (lazyloader && produtoPertenceA==null)
			{
				try {
					getCarregador().CarregaItemProduto_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoPertenceA;
		} 
		public void setProdutoPertenceA(Produto value) 
		{	
			produtoPertenceA = value;
		} 
		/*
		public void setProdutoPertenceAComReversao(Produto value) 
		{	
			produtoPertenceA = value;
			System.out.println("Alteracao:" + produtoPertenceA);
			if (produtoPertenceA!=null)
				produtoPertenceA.addListaPrecoDiario_Possui(vo);
		} 
		*/
		
		public void addListaProduto_PertenceA(Produto  value) 
		{	
			produtoPertenceA = value;
		} 
		public Produto getCorrenteProduto_PertenceA()
		{	
			return produtoPertenceA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
