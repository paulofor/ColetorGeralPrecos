package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class FacebookFanpageCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemFacebookPerfil_PertenceA(FacebookFanpage vo) throws DaoException
    {
       	FacebookPerfilRegraColecao servico = FabricaRegra.getInstancia().getFacebookPerfilRegraColecao();
    	if (conexao!=null ) { 
            vo.setFacebookPerfilPertenceA(servico.obtemPorChave(vo.getIdFacebookPerfilPa(), conexao));
	    } else {
	    	vo.setFacebookPerfilPertenceA(servico.obtemPorChave(vo.getIdFacebookPerfilPa()));
    	}
    }
 	
	public void CarregaItemAppProduto_Divulga(FacebookFanpage vo) throws DaoException
    {
       	AppProdutoRegraColecao servico = FabricaRegra.getInstancia().getAppProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setAppProdutoDivulga(servico.obtemPorChave(vo.getIdAppProdutoD(), conexao));
	    } else {
	    	vo.setAppProdutoDivulga(servico.obtemPorChave(vo.getIdAppProdutoD()));
    	}
    }
 	
	
	
}