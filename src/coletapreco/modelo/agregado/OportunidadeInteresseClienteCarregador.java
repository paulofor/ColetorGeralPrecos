package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class OportunidadeInteresseClienteCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemProdutoCliente_PertenceA(OportunidadeInteresseCliente vo) throws DaoException
    {
       	ProdutoClienteRegraColecao servico = FabricaRegra.getInstancia().getProdutoClienteRegraColecao();
    	if (conexao!=null ) { 
            vo.setProdutoClientePertenceA(servico.obtemPorChave(vo.getIdProdutoClientePa(), conexao));
	    } else {
	    	vo.setProdutoClientePertenceA(servico.obtemPorChave(vo.getIdProdutoClientePa()));
    	}
    }
 	
	
	
}