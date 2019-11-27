package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class CompartilhamentoProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemUsuario_PertenceA(CompartilhamentoProduto vo) throws DaoException
    {
       	UsuarioRegraColecao servico = FabricaRegra.getInstancia().getUsuarioRegraColecao();
    	if (conexao!=null ) { 
            vo.setUsuarioPertenceA(servico.obtemPorChave(vo.getIdUsuarioPa(), conexao));
	    } else {
	    	vo.setUsuarioPertenceA(servico.obtemPorChave(vo.getIdUsuarioPa()));
    	}
    }
 	
	public void CarregaItemProduto_ReferenteA(CompartilhamentoProduto vo) throws DaoException
    {
       	ProdutoRegraColecao servico = FabricaRegra.getInstancia().getProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa(), conexao));
	    } else {
	    	vo.setProdutoReferenteA(servico.obtemPorChave(vo.getIdProdutoRa()));
    	}
    }
 	
	
	
}