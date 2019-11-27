package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class PrecoProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProduto_PertenceA(PrecoProduto vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoPertenceA(servico.obtemPorChave(vo.getIdProdutoPa(), conexao));
	    } else {
	    	vo.setProdutoPertenceA(servico.obtemPorChave(vo.getIdProdutoPa()));
    	}
    }
 	
	
	
}