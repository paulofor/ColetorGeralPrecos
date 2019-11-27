package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class LojaNaturezaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemLojaVirtual_ReferenteA(LojaNatureza vo) throws DaoException
    {
       	LojaVirtualRegraColecao servico = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
    	if (conexao!=null ) { 
            vo.setLojaVirtualReferenteA(servico.obtemPorChave(vo.getIdLojaVirtualRa(), conexao));
	    } else {
	    	vo.setLojaVirtualReferenteA(servico.obtemPorChave(vo.getIdLojaVirtualRa()));
    	}
    }
 	
	public void CarregaItemNaturezaProduto_ReferenteA(LojaNatureza vo) throws DaoException
    {
       	NaturezaProdutoRegraColecao servico = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa(), conexao));
	    } else {
	    	vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa()));
    	}
    }
 	
	
	
}