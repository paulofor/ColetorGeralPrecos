package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class CategoriaLojaProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemCategoriaLoja_ReferenteA(CategoriaLojaProduto vo) throws DaoException
    {
       	CategoriaLojaRegraColecao servico = FabricaRegra.getInstancia().getCategoriaLojaRegraColecao();
    	if (conexao!=null ) { 
            vo.setCategoriaLojaReferenteA(servico.obtemPorChave(vo.getIdCategoriaLojaRa(), conexao));
	    } else {
	    	vo.setCategoriaLojaReferenteA(servico.obtemPorChave(vo.getIdCategoriaLojaRa()));
    	}
    }
 	
	public void CarregaItemProduto_ReferenteA(CategoriaLojaProduto vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa(), conexao));
	    } else {
	    	vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa()));
    	}
    }
 	
	
	
}