package coletapreco.dao.basica;

import br.com.digicom.lib.dao.DaoBase;
import br.com.digicom.lib.dao.DataFonte;

public abstract class DaoAplicacao extends DaoBase {
	public DaoAplicacao() {
		super(new DataSourceAplicacao());
	}

	public DaoAplicacao(DataFonte dataSource) {
		super(dataSource);
	}
}

/*
 * Location: C:\Fontes\ProjetosJava2\Recuperacao-CotacaoJava15\Cotacao15\
 * Qualified Name: sisacaoweb2.dao.basica.DaoAplicacao JD-Core Version: 0.6.0
 */