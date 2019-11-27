package coletapreco.dao;


import java.text.ParseException;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletapreco.dao.basica.DispositivoUsuarioDaoBase;
import coletapreco.dao.basica.UsuarioDaoBase;
import coletapreco.dao.montador.DispositivoUsuarioMontador;
import coletapreco.dao.montador.UsuarioMontador;
import coletapreco.modelo.Usuario;
import coletapreco.util.UtilData;


public  class UsuarioDaoExtendida  extends UsuarioDaoBase implements UsuarioDao {

	@Override
	public List ListaNaoRelacionadaEmDispositivoUsuarioListaUsa(
			long idDispositivoUsuario) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmUsuarioPesquisaListaSincroniza(long idUsuarioPesquisa) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmPalavraChavePesquisaListaPossui(long idPalavraChavePesquisa) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Usuario ObtemPrimeiroSemDiaAtual(long idApp) throws DaoException {
		String data = null;
		try {
			data = UtilData.deslocaDiasFormatoDabase(0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String sql = "select " + camposOrdenados() + " ,  " + DispositivoUsuarioDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinDispositivoUsuario_Usa() +
				" where id_app_produto_u = " + idApp +
				" and (data_chamada < '" + data + "' or data_chamada is null) and ativo = 'S' " +
				" limit 1";
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new UsuarioMontador(), null);
		montador.adicionaMontador(new DispositivoUsuarioMontador(), "DispositivoUsuario_Usa");
		this.setMontador(montador);
		return (Usuario) this.getObjetoSqlInterno(sql);
				
	}
	
	@Override
	public Usuario ObtemPrimeiroProcessamentoMaisAntigo(long idApp, long minutos)  throws DaoException {
		String sql = "select " + camposOrdenados() + " ,  " + DispositivoUsuarioDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinDispositivoUsuario_Usa() +
				" where id_app_produto_u = " + idApp +
				" and (  data_ultimo_processamento <= DATE_SUB(NOW(), INTERVAL " + minutos + " MINUTE) or " +
				" data_ultimo_processamento is null ) " +
				" and ativo = 'S' " +
				" order by data_chamada asc " + 
				" limit 1";
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new UsuarioMontador(), null);
		montador.adicionaMontador(new DispositivoUsuarioMontador(), "DispositivoUsuario_Usa");
		this.setMontador(montador);
		return (Usuario) this.getObjetoSqlInterno(sql);
	}
	

	@Override
	public List<Usuario> ListaAtivoChamadaDistante(long idApp, long quantidade) throws DaoException {
		String sql = "select " + camposOrdenados() + " ,  " + DispositivoUsuarioDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinDispositivoUsuario_Usa() +
				" where id_app_produto_u = " + idApp + " and ativo = 'S' " +
				" order by data_chamada asc " +
				" limit " + quantidade;
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new UsuarioMontador(), null);
		montador.adicionaMontador(new DispositivoUsuarioMontador(), "DispositivoUsuario_Usa");
		this.setMontador(montador);
		return this.getListaSqlListaInterna(sql);
	}

	@Override
	public List<Usuario> ListaInteresseNovo(long idApp) throws DaoException {
		String sql = "select distinct " + camposOrdenados() + " ,  " + DispositivoUsuarioDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinDispositivoUsuario_Usa() +
				this.innerJoinInteresseProduto_Sincroniza() +
				" where id_app_produto_u = " + idApp + " and novo = 'S' and monitora = 'S' " +
				" order by id_usuario desc";
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new UsuarioMontador(), null);
		montador.adicionaMontador(new DispositivoUsuarioMontador(), "DispositivoUsuario_Usa");
		this.setMontador(montador);
		return this.getListaSqlListaInterna(sql);
	}

	@Override
	public void atualizaDataProcessamento(long idObj) throws DaoException {
		String sql = "update " + tabelaSelect() + " set data_ultimo_processamento = now() " +
				" where id_usuario = " + idObj;
		this.executaSql(sql);
		
	}

	
}
