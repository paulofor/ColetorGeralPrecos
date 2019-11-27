package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class NaturezaProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemAppProduto_AtendidoPor(NaturezaProduto vo) throws DaoException
    {
       	AppProdutoRegraColecao servico = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setAppProdutoAtendidoPor(servico.obtemPorChave(vo.getIdAppProdutoAp(), conexao));
	    } else {
	    	vo.setAppProdutoAtendidoPor(servico.obtemPorChave(vo.getIdAppProdutoAp()));
    	}
    }
 	
	
	
}