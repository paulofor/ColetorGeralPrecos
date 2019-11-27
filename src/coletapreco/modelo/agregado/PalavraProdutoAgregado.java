package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class PalavraProdutoAgregado implements PalavraProdutoAgregadoI
	{
		
		private PalavraProdutoCarregador carregador = null;
		private PalavraProdutoCarregador getCarregador() {
			if (carregador==null) {
				carregador = new PalavraProdutoCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getPalavraRelaciondoA(false) != null)
				vo.getPalavraRelaciondoA(false).setConexaoCarregador(conexao);
			if (vo.getProdutoRelaciondoA(false) != null)
				vo.getProdutoRelaciondoA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private PalavraProduto vo;
		public PalavraProdutoAgregado(PalavraProduto item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Palavra palavraRelaciondoA;
		// Montador Tradicional
		public Palavra getPalavraRelaciondoA(boolean lazyloader) 
		{	
			if (lazyloader && palavraRelaciondoA==null)
			{
				try {
					getCarregador().CarregaItemPalavra_RelaciondoA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return palavraRelaciondoA;
		} 
		public void setPalavraRelaciondoA(Palavra value) 
		{	
			palavraRelaciondoA = value;
		} 
		/*
		public void setPalavraRelaciondoAComReversao(Palavra value) 
		{	
			palavraRelaciondoA = value;
			System.out.println("Alteracao:" + palavraRelaciondoA);
			if (palavraRelaciondoA!=null)
				palavraRelaciondoA.addListaPalavraProduto_Possui(vo);
		} 
		*/
		
		public void addListaPalavra_RelaciondoA(Palavra  value) 
		{	
			palavraRelaciondoA = value;
		} 
		public Palavra getCorrentePalavra_RelaciondoA()
		{	
			return palavraRelaciondoA;
		} 
		
 		
		private Produto produtoRelaciondoA;
		// Montador Tradicional
		public Produto getProdutoRelaciondoA(boolean lazyloader) 
		{	
			if (lazyloader && produtoRelaciondoA==null)
			{
				try {
					getCarregador().CarregaItemProduto_RelaciondoA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoRelaciondoA;
		} 
		public void setProdutoRelaciondoA(Produto value) 
		{	
			produtoRelaciondoA = value;
		} 
		/*
		public void setProdutoRelaciondoAComReversao(Produto value) 
		{	
			produtoRelaciondoA = value;
			System.out.println("Alteracao:" + produtoRelaciondoA);
			if (produtoRelaciondoA!=null)
				produtoRelaciondoA.addListaPalavraProduto_Possui(vo);
		} 
		*/
		
		public void addListaProduto_RelaciondoA(Produto  value) 
		{	
			produtoRelaciondoA = value;
		} 
		public Produto getCorrenteProduto_RelaciondoA()
		{	
			return produtoRelaciondoA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
