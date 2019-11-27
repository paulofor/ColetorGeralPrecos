package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class OportunidadeDiaAgregado implements OportunidadeDiaAgregadoI
	{
		
		private OportunidadeDiaCarregador carregador = null;
		private OportunidadeDiaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new OportunidadeDiaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getProdutoReferenteA(false) != null)
				vo.getProdutoReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getNaturezaProdutoPertenceA(false) != null)
				vo.getNaturezaProdutoPertenceA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private OportunidadeDia vo;
		public OportunidadeDiaAgregado(OportunidadeDia item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private Produto produtoReferenteA;
		// Montador Tradicional
		public Produto getProdutoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && produtoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemProduto_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return produtoReferenteA;
		} 
		public void setProdutoReferenteA(Produto value) 
		{	
			produtoReferenteA = value;
		} 
		/*
		public void setProdutoReferenteAComReversao(Produto value) 
		{	
			produtoReferenteA = value;
			System.out.println("Alteracao:" + produtoReferenteA);
			if (produtoReferenteA!=null)
				produtoReferenteA.addListaOportunidadeDia_PodePossuir(vo);
		} 
		*/
		
		public void addListaProduto_ReferenteA(Produto  value) 
		{	
			produtoReferenteA = value;
		} 
		public Produto getCorrenteProduto_ReferenteA()
		{	
			return produtoReferenteA;
		} 
		
 		
		private NaturezaProduto naturezaProdutoPertenceA;
		// Montador Tradicional
		public NaturezaProduto getNaturezaProdutoPertenceA(boolean lazyloader) 
		{	
			if (lazyloader && naturezaProdutoPertenceA==null)
			{
				try {
					getCarregador().CarregaItemNaturezaProduto_PertenceA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return naturezaProdutoPertenceA;
		} 
		public void setNaturezaProdutoPertenceA(NaturezaProduto value) 
		{	
			naturezaProdutoPertenceA = value;
		} 
		/*
		public void setNaturezaProdutoPertenceAComReversao(NaturezaProduto value) 
		{	
			naturezaProdutoPertenceA = value;
			System.out.println("Alteracao:" + naturezaProdutoPertenceA);
			if (naturezaProdutoPertenceA!=null)
				naturezaProdutoPertenceA.addListaOportunidadeDia_Possui(vo);
		} 
		*/
		
		public void addListaNaturezaProduto_PertenceA(NaturezaProduto  value) 
		{	
			naturezaProdutoPertenceA = value;
		} 
		public NaturezaProduto getCorrenteNaturezaProduto_PertenceA()
		{	
			return naturezaProdutoPertenceA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
