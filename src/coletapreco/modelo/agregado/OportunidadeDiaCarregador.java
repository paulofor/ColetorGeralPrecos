package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class OportunidadeDiaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProduto_ReferenteA(OportunidadeDia vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa(), conexao));
	    } else {
	    	vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa()));
    	}
    }
 	
	public void CarregaItemNaturezaProduto_PertenceA(OportunidadeDia vo) throws DaoException
    {
       	NaturezaProdutoRegraColecao servico = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setNaturezaProdutoPertenceA(servico.obtemPorChave(vo.getIdNaturezaProdutoPa(), conexao));
	    } else {
	    	vo.setNaturezaProdutoPertenceA(servico.obtemPorChave(vo.getIdNaturezaProdutoPa()));
    	}
    }
 	
	
	
}