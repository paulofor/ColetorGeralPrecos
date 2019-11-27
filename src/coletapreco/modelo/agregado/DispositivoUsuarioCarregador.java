package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class DispositivoUsuarioCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemUsuario_ReferenteA(DispositivoUsuario vo) throws DaoException
    {
       	UsuarioRegraColecao servico = FabricaRegra.getInstancia().getUsuarioRegraColecao();
    	if (conexao!=null ) { 
            vo.setUsuarioReferenteA(servico.obtemPorChave(vo.getIdUsuarioRa(), conexao));
	    } else {
	    	vo.setUsuarioReferenteA(servico.obtemPorChave(vo.getIdUsuarioRa()));
    	}
    }
 	
	public void CarregaItemAppProduto_Usa(DispositivoUsuario vo) throws DaoException
    {
       	AppProdutoRegraColecao servico = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setAppProdutoUsa(servico.obtemPorChave(vo.getIdAppProdutoU(), conexao));
	    } else {
	    	vo.setAppProdutoUsa(servico.obtemPorChave(vo.getIdAppProdutoU()));
    	}
    }
 	
	
	
}