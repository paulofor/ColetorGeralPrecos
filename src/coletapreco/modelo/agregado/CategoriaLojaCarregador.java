package coletapreco.modelo.agregado;


import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.*;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.*;

public class CategoriaLojaCarregador {
	
	private DaoConexao conexao = null;

	public void setConexao(DaoConexao conexao) {
		this.conexao = conexao;
	}
	
	
	
	public void CarregaItemCategoriaLoja_Filho(CategoriaLoja vo) throws DaoException
    {
       	CategoriaLojaRegraColecao servico = FabricaRegra.getInstancia().getCategoriaLojaRegraColecao();
    	if (conexao!=null ) { 
            vo.setCategoriaLojaFilho(servico.obtemPorChave(vo.getIdCategoriaLojaF(), conexao));
	    } else {
	    	vo.setCategoriaLojaFilho(servico.obtemPorChave(vo.getIdCategoriaLojaF()));
    	}
    }
 	
	public void CarregaItemNaturezaProduto_ReferenteA(CategoriaLoja vo) throws DaoException
    {
       	NaturezaProdutoRegraColecao servico = FabricaRegra.getInstancia().getNaturezaProdutoRegraColecao();
    	if (conexao!=null ) { 
            vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa(), conexao));
	    } else {
	    	vo.setNaturezaProdutoReferenteA(servico.obtemPorChave(vo.getIdNaturezaProdutoRa()));
    	}
    }
 	
	public void CarregaItemLojaVirtual_PertenceA(CategoriaLoja vo) throws DaoException
    {
       	LojaVirtualRegraColecao servico = FabricaRegra.getInstancia().getLojaVirtualRegraColecao();
    	if (conexao!=null ) { 
            vo.setLojaVirtualPertenceA(servico.obtemPorChave(vo.getIdLojaVirtualPa(), conexao));
	    } else {
	    	vo.setLojaVirtualPertenceA(servico.obtemPorChave(vo.getIdLojaVirtualPa()));
    	}
    }
 	
	
	
}