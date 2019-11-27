package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class PalavraProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemPalavra_RelaciondoA(PalavraProduto vo) throws DaoException
    {
       	PalavraRegraColecao servico = FabricaRegra.getInstancia().getPalavraRegraColecao();
    	if (conexao!=null ) { 
            vo.setPalavraRelaciondoA(servico.obtemPorChave(vo.getIdPalavraRa(), conexao));
	    } else {
	    	vo.setPalavraRelaciondoA(servico.obtemPorChave(vo.getIdPalavraRa()));
    	}
    }
 	
	public void CarregaItemProduto_RelaciondoA(PalavraProduto vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoRelaciondoA(servico.obtemPorChave(vo.getIdProdutoRa(), conexao));
	    } else {
	    	vo.setProdutoRelaciondoA(servico.obtemPorChave(vo.getIdProdutoRa()));
    	}
    }
 	
	
	
}