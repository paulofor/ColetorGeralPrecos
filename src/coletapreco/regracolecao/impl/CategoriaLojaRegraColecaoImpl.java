package coletapreco.regracolecao.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.CategoriaLojaDao;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.regracolecao.CategoriaLojaRegraColecao;


public  class CategoriaLojaRegraColecaoImpl  extends CategoriaLojaRegraColecao {

	@Override
	public CategoriaLoja CriaSeNecessario(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaLoja pesquisa = this.getFiltro().getItem();
		CategoriaLoja existe = dao.obtemPorNomeLojaVirtual(pesquisa);
		if (existe==null) {
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			pesquisa.setDataInclusao(dateFormat.format( new Date()));
			dao.insereItem(pesquisa);
			return pesquisa;
		} else {
			return existe;
		}
	}

	@Override
	public List<CategoriaLoja> ListaPorLojaNaturezaNivel0(DaoConexao conexao) throws DaoException {
		CategoriaLojaDao dao = getDao();
		dao.setConexao(conexao);
		CategoriaLoja pesquisa = this.getFiltro().getItem();
		if (pesquisa==null) {
			throw new RuntimeException("Pesquisa nao pode ser realizada item nao encontrado");
		}
		this.getFiltro().setCodigoLojaVirtualPertenceA(pesquisa.getIdLojaVirtualPa());
		this.getFiltro().setCodigoNaturezaProdutoReferenteA(pesquisa.getIdNaturezaProdutoRa());
		List<CategoriaLoja> listaSaida = dao.ListaFiltro(this.getFiltro());
		return listaSaida;
	} 
}
