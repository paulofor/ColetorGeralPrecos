package coletapreco.parse.dados;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.parse.dados.basico.LojaVirtualDadosParseBase;
import coletapreco.regracolecao.CategoriaLojaRegraColecao;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.impl.LojaVirtualRegraColecaoImpl;

public class LojaVirtualDadosParse extends LojaVirtualDadosParseBase{
	
	private NaturezaProduto naturezaProduto = null;
	public void setNaturezaProduto(NaturezaProduto dado) {
		this.naturezaProduto = dado;
	}

	@Override
	public String getUrlDetalhe() {
		return this.itemDetalhe.getCorrenteLojaNatureza_Oferece().getUrlInicial();
	}

	@Override
	public void finalizacaoOkDetalhe()  {
		try {
			CategoriaLojaRegraColecao categoriaLojaSrv = FabricaRegra.getInstancia().getCategoriaLojaRegraColecao();
			List<CategoriaLoja> listaCategoria = this.itemDetalhe.getListaCategoriaLoja_Possui();
			for (CategoriaLoja categoria : listaCategoria) {
				if (categoria!=null) {
					categoria.setLojaVirtualPertenceA(itemDetalhe);
					categoria.setCategoriaLojaFilho(null);
					categoria.setNaturezaProdutoReferenteA(naturezaProduto);
					categoriaLojaSrv.getFiltro().setItem(categoria);
					categoriaLojaSrv.CriaSeNecessario(this.getConexao());
				}
			}
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	

}