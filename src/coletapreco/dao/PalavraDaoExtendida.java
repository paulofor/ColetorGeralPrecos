package coletapreco.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletapreco.dao.*;
import coletapreco.dao.basica.*;
import coletapreco.modelo.Palavra;


public  class PalavraDaoExtendida  extends PalavraDaoBase implements PalavraDao {

	@Override
	public List ListaNaoRelacionadaEmPalavraProdutoListaPossui(long idProduto) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Palavra ObtemPorDescricaoPalavra(String palavra) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + this.tabelaSelect() +
				" where descricao = '" + palavra.trim() + "' ";
		return (Palavra) this.getObjeto(sql);
	}

	@Override
	public void atualizaComum(int i) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "update palavra set comum = 'S' " +
				" where id_palavra in ( " + 
				" select id_palavra_ra 	from " +
				" ( " +
				" select id_palavra_ra, count(*) as qtde " +
				" from palavra_produto " +
				" group by id_palavra_ra " +
				" ) total " +
				" where total.qtde > " + i + "	)";
		this.executaSql(sql);
	}

	@Override
	public void atualizaNaoComum() throws DaoException {
		String sql = "update palavra set comum = 'N' where comum is null";
		this.executaSql(sql);
	} 
}
