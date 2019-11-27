package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.LojaVirtual;


public  class LojaVirtualDaoExtendida  extends LojaVirtualDaoBase implements LojaVirtualDao {

	//public LojaVirtualDaoExtendida() {
	//	super(new DataSourceNuvem());
	//}
	
	@Override
	public List ListaNaoRelacionadaEmProdutoListaPossui(long idProduto)
			throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaNaoRelacionadaEmCategoriaLojaListaPossui(
			long idCategoriaLoja) throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaNaoRelacionadaEmLojaNaturezaListaOferece(long idNaturezaProduto) throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaNaoRelacionadaEmContagemProdutoListaPossui(long idContagemProduto) throws DaoException {
		// TODO Auto-generated method stub
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public void corrigeTabelas() throws DaoException {
		// TODO Auto-generated method stub
		//delete from preco_diario where date(data_hora) = date(now())
		this.executaSql("repair table preco_diario");
		
		this.executaSql("delete from preco_diario where date(data_hora) = date(now())");
		System.out.println("Concluiu verificacao tabela preco_diario");
		
		this.executaSql("repair table produto");
		System.out.println("Concluiu verificacao tabela produto");
		
		this.executaSql("repair table preco_produto");
		System.out.println("Concluiu verificacao tabela preco_produto");
		
		this.executaSql("repair table categoria_loja_produto");
		System.out.println("Concluiu verificacao tabela categoria_loja_produto");
	}

	@Override
	public LojaVirtual ObtemPorProduto(long idProduto) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect();
		return null;
				
	} 
}
