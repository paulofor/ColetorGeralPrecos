package coletapreco.modelo.agregado;

import java.util.List;
import java.util.ArrayList;
import coletapreco.modelo.*;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;

// Gera??o autom?tica n?o alterar
	public class LojaNaturezaAgregado implements LojaNaturezaAgregadoI
	{
		
		private LojaNaturezaCarregador carregador = null;
		private LojaNaturezaCarregador getCarregador() {
			if (carregador==null) {
				carregador = new LojaNaturezaCarregador();
			}
			return carregador;
		}
		public void setConexaoCarregador(DaoConexao conexao) {
			getCarregador().setConexao(conexao);
			if (vo.getLojaVirtualReferenteA(false) != null)
				vo.getLojaVirtualReferenteA(false).setConexaoCarregador(conexao);
			if (vo.getNaturezaProdutoReferenteA(false) != null)
				vo.getNaturezaProdutoReferenteA(false).setConexaoCarregador(conexao);
			
		}
		
		
		private LojaNatureza vo;
		public LojaNaturezaAgregado(LojaNatureza item) {
			vo = item;
		}
		
		// Com chave estrangeira
		
		private LojaVirtual lojaVirtualReferenteA;
		// Montador Tradicional
		public LojaVirtual getLojaVirtualReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && lojaVirtualReferenteA==null)
			{
				try {
					getCarregador().CarregaItemLojaVirtual_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return lojaVirtualReferenteA;
		} 
		public void setLojaVirtualReferenteA(LojaVirtual value) 
		{	
			lojaVirtualReferenteA = value;
		} 
		/*
		public void setLojaVirtualReferenteAComReversao(LojaVirtual value) 
		{	
			lojaVirtualReferenteA = value;
			System.out.println("Alteracao:" + lojaVirtualReferenteA);
			if (lojaVirtualReferenteA!=null)
				lojaVirtualReferenteA.addListaLojaNatureza_Oferece(vo);
		} 
		*/
		
		public void addListaLojaVirtual_ReferenteA(LojaVirtual  value) 
		{	
			lojaVirtualReferenteA = value;
		} 
		public LojaVirtual getCorrenteLojaVirtual_ReferenteA()
		{	
			return lojaVirtualReferenteA;
		} 
		
 		
		private NaturezaProduto naturezaProdutoReferenteA;
		// Montador Tradicional
		public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyloader) 
		{	
			if (lazyloader && naturezaProdutoReferenteA==null)
			{
				try {
					getCarregador().CarregaItemNaturezaProduto_ReferenteA(vo);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
			return naturezaProdutoReferenteA;
		} 
		public void setNaturezaProdutoReferenteA(NaturezaProduto value) 
		{	
			naturezaProdutoReferenteA = value;
		} 
		/*
		public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto value) 
		{	
			naturezaProdutoReferenteA = value;
			System.out.println("Alteracao:" + naturezaProdutoReferenteA);
			if (naturezaProdutoReferenteA!=null)
				naturezaProdutoReferenteA.addListaLojaNatureza_Encontrada(vo);
		} 
		*/
		
		public void addListaNaturezaProduto_ReferenteA(NaturezaProduto  value) 
		{	
			naturezaProdutoReferenteA = value;
		} 
		public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA()
		{	
			return naturezaProdutoReferenteA;
		} 
		
 		
     	
     	// Um pra um
     	
     	
     	// Sem Chave Estrangeira
     	
	}
