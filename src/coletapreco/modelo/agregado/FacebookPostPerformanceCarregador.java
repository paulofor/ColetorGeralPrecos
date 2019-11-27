package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class FacebookPostPerformanceCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemFacebookPost_ReferenteA(FacebookPostPerformance vo) throws DaoException
    {
       	FacebookPostRegraColecao servico = FabricaRegra.getInstancia().getFacebookPostRegraColecao();
    	if (conexao!=null ) { 
            vo.setFacebookPostReferenteA(servico.obtemPorChave(vo.getIdFacebookPostRa(), conexao));
	    } else {
	    	vo.setFacebookPostReferenteA(servico.obtemPorChave(vo.getIdFacebookPostRa()));
    	}
    }
 	
	
	
}