package coletapreco.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceAplicacao extends MySqlDataSource {
	public DataSourceAplicacao() {
		super("jdbc:mysql://localhost/coletorgeralbd", "coletorgeral", "aspnet");
		//super("jdbc:mysql://localhost/coletorgeralbd", "root", "root");
	}
}
