package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class ProdutoClienteCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemNaturezaProduto_ReferenteA(ProdutoCliente vo) throws DaoException
    {
       	NaturezaProdutoRegraColecao servico = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa(), conexao));
	    } else {
	    	vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa()));
    	}
    }
 	
	public void CarregaItemUsuario_Sincroniza(ProdutoCliente vo) throws DaoException
    {
       	UsuarioRegraColecao servico = FabricaRegra.getInstancia().getUsuarioRegraColecao();
    	if (conexao!=null ) { 
            vo.setUsuarioSincroniza(servico.obtemPorChave(vo.getIdUsuarioS(), conexao));
	    } else {
	    	vo.setUsuarioSincroniza(servico.obtemPorChave(vo.getIdUsuarioS()));
    	}
    }
 	
	public void CarregaItemPalavraChavePesquisa_ReferenteA(ProdutoCliente vo) throws DaoException
    {
       	PalavraChavePesquisaRegraColecao servico = FabricaRegra.getInstancia().getPalavraChavePesquisaRegraColecao();
    	if (conexao!=null ) { 
            vo.setPalavraChavePesquisaReferenteA(servico.obtemPorChave(vo.getIdPalavraChavePesquisaRa(), conexao));
	    } else {
	    	vo.setPalavraChavePesquisaReferenteA(servico.obtemPorChave(vo.getIdPalavraChavePesquisaRa()));
    	}
    }
 	
	
	
}