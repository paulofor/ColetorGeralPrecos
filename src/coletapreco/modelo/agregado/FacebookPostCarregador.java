package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class FacebookPostCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemFacebookFanpage_FeitoEm(FacebookPost vo) throws DaoException
    {
       	FacebookFanpageRegraColecao servico = FabricaRegra.getInstancia().getFacebookFanpageRegraColecao();
    	if (conexao!=null ) { 
            vo.setFacebookFanpageFeitoEm(servico.obtemPorChave(vo.getIdFacebookFanpageFe(), conexao));
	    } else {
	    	vo.setFacebookFanpageFeitoEm(servico.obtemPorChave(vo.getIdFacebookFanpageFe()));
    	}
    }
 	
	public void CarregaItemProduto_Divulgando(FacebookPost vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoDivulgando(servico.obtemPorChave(vo.getIdProdutoD(), conexao));
	    } else {
	    	vo.setProdutoDivulgando(servico.obtemPorChave(vo.getIdProdutoD()));
    	}
    }
 	
	
	
}