package coletapreco.dao.basica;

import br.com.digicom.lib.dao.MySqlDataSource;

public class DataSourceNuvem extends MySqlDataSource {
	// Fazendo inicialmente com conexao atraves de banco de dados, no futuro posso passar para webservice.
	public DataSourceNuvem() {
		super("jdbc:mysql://mysql.lojadigicom.com.br/lojadigicom27", "lojadigicom27", "aspnet");
	}
}
