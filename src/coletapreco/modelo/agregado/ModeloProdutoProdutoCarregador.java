package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class ModeloProdutoProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemModeloProduto_ReferenteA(ModeloProdutoProduto vo) throws DaoException
    {
       	ModeloProdutoRegraColecao servico = FabricaRegra.getInstancia().getModeloProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setModeloProdutoReferenteA(servico.obtemPorChave(vo.getIdModeloProdutoRa(), conexao));
	    } else {
	    	vo.setModeloProdutoReferenteA(servico.obtemPorChave(vo.getIdModeloProdutoRa()));
    	}
    }
 	
	public void CarregaItemProduto_ReferenteA(ModeloProdutoProduto vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa(), conexao));
	    } else {
	    	vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa()));
    	}
    }
 	
	
	
}