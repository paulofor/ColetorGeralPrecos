package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class UsuarioPesquisaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemUsuario_Sincroniza(UsuarioPesquisa vo) throws DaoException
    {
       	UsuarioRegraColecao servico = FabricaRegra.getInstancia().getUsuarioRegraColecao();
    	if (conexao!=null ) { 
            vo.setUsuarioSincroniza(servico.obtemPorChave(vo.getIdUsuarioS(), conexao));
	    } else {
	    	vo.setUsuarioSincroniza(servico.obtemPorChave(vo.getIdUsuarioS()));
    	}
    }
 	
	public void CarregaItemNaturezaProduto_Pesquisa(UsuarioPesquisa vo) throws DaoException
    {
       	NaturezaProdutoRegraColecao servico = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setNaturezaProdutoPesquisa(servico.obtemPorChave(vo.getIdNaturezaProdutoP(), conexao));
	    } else {
	    	vo.setNaturezaProdutoPesquisa(servico.obtemPorChave(vo.getIdNaturezaProdutoP()));
    	}
    }
 	
	
	
}