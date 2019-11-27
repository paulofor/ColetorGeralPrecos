package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class ProdutoCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemLojaVirtual_LidoEm(Produto vo) throws DaoException
    {
       	LojaVirtualRegraColecao servico = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
    	if (conexao!=null ) { 
            vo.setLojaVirtualLidoEm(servico.obtemPorChave(vo.getIdLojaVirtualLe(), conexao));
	    } else {
	    	vo.setLojaVirtualLidoEm(servico.obtemPorChave(vo.getIdLojaVirtualLe()));
    	}
    }
 	
	public void CarregaItemMarca_Possui(Produto vo) throws DaoException
    {
       	MarcaRegraColecao servico = FabricaRegra.getInstancia().getMarcaRegraColecao();
    	if (conexao!=null ) { 
            vo.setMarcaPossui(servico.obtemPorChave(vo.getIdMarcaP(), conexao));
	    } else {
	    	vo.setMarcaPossui(servico.obtemPorChave(vo.getIdMarcaP()));
    	}
    }
 	
	
	
}