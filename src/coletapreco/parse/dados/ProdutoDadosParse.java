package coletapreco.parse.dados;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import coletapreco.dao.DBB;
import coletapreco.modelo.FabricaVo;
import coletapreco.modelo.PrecoDiario;
import coletapreco.parse.dados.basico.ProdutoDadosParseBase;
import coletapreco.regracolecao.FabricaRegra;
import coletapreco.regracolecao.PrecoDiarioRegraColecao;
import coletapreco.regracolecao.PrecoProdutoRegraColecao;
import coletapreco.util.ConstantesLoja;
import coletapreco.util.UtilData;

public class ProdutoDadosParse extends ProdutoDadosParseBase{
	
	private String sku;

	
	private PrecoDiarioRegraColecao precoDiarioSrv = FabricaRegra.getInstancia().getPrecoDiarioRegraColecao();
	private PrecoProdutoRegraColecao precoProdutoSrv = FabricaRegra.getInstancia().getPrecoProdutoRegraColecao();
	
	private String precoDetalhe = null;
	private String nomeDetalhe = null;
	private String imagemDetalhe = null;
	
	private boolean possuiJson = false;
	
	public void setPrecoDetalhe(String valor) {
		precoDetalhe = valor;
	}
	public void setNomeDetalhe(String valor) {
		nomeDetalhe = valor;
	}
	public void setImagemDetalhe(String valor) {
		imagemDetalhe = valor;
	}
	
	public void setSku(String valor) {
		sku = valor;
	}

	@Override
	public String getUrlDetalhe() {
		return this.getItemDetalhe().getUrl();
	}

	@Override
	public void setJson(JSONObject json) {
		try {
			if (itemDetalhe.getIdLojaVirtualLe()==ConstantesLoja.ID_DAFITI) 
				processaDafitiJson(json);
			if (itemDetalhe.getIdLojaVirtualLe()==ConstantesLoja.ID_LUIZA) 
				processaLuizaJson(json);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	private void processaDafitiJson(JSONObject json) throws Exception {
		JSONObject obj = json.getJSONObject(sku);
		float preco = (float) obj.getDouble("price");
		String precoStr =String.format("%.2f", preco);
		String nome = obj.getString("name");
		String marca = obj.getString("brand_name");
		processaPreco(preco,this.getItemDetalhe().getIdProduto());
		
		
		precoStr = precoStr.replace('.', ',');
		this.setPrecoDetalhe(precoStr);
		this.setNomeDetalhe(nome);
			
		
		int valor = nome.compareTo(itemDetalhe.getNome());
		if (valor !=0) {
			// Precisa atualizar
			itemDetalhe.setNome(nome);
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			dao.alteraNome(itemDetalhe);
		}
		//System.out.println("Preco:" + precoStr);
		//System.out.println("Nome:" + nome);
		//System.out.println("Marca:" + marca);
	}
	
	private void processaLuizaJson(JSONObject json) throws Exception {
		JSONObject obj = json.getJSONObject("payload").getJSONObject("data").getJSONObject("product");
		float preco = (float) obj.getDouble("discountPrice");
		processaPreco(preco,this.getItemDetalhe().getIdProduto());
		System.out.println("Preco:" + preco);
	}
	
	public void finalizacaoOkDetalhe() {
		// deve ser sobrescrito caso nao seja um update de objeto.
		try {
			dao = DBB.getInstancia().getProdutoDao();
			dao.setConexao(getConexao());
			if (precoDetalhe!=null) {
				float precoNum = extraiValorPreco(precoDetalhe);
				System.out.println(precoNum);
				processaPreco(precoNum,this.getItemDetalhe().getIdProduto());
			}
			if (this.nomeDetalhe!=null) {
				nomeDetalhe = nomeDetalhe.replaceAll("'", "");
				int valor = nomeDetalhe.compareTo(itemDetalhe.getNome());
				if (valor !=0) {
					// Precisa atualizar
					itemDetalhe.setNome(nomeDetalhe);
					dao.alteraNome(itemDetalhe);
				}
			} else {
				// Dafiti
				//dao = DBB.getInstancia().getProdutoDao();
				//dao.setConexao(getConexao());
				//dao.alteraNome(itemDetalhe);
			}
			if (this.imagemDetalhe!=null) {
				itemDetalhe.setImagem(imagemDetalhe);
				dao.alteraImagem(itemDetalhe);
			}
			
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
	
	

	private void processaPreco(float preco, long idProduto) throws DaoException {
		PrecoDiario precoDiario = FabricaVo.criaPrecoDiario();
		precoDiario.setIdProdutoPa(idProduto);
		precoDiario.setDataHora(UtilData.getDataHora());
		precoDiario.setPrecoVenda(preco);
		precoDiarioSrv.getFiltro().setPrecoAtual(precoDiario);
		if (precoDiarioSrv.AtualizaPrecoDia(getConexao())!=null) {
			precoProdutoSrv.getFiltro().setPrecoAtual(precoDiario);
			precoProdutoSrv.AtualizaPorPrecoAtual(getConexao());
		}
		
	}
	
	protected final float extraiValorPreco(String valor) {
		int ini, fimtexto;
		if (valor==null) return 0;
		if (valor.indexOf(",")==-1 && valor.indexOf(".")!=-1) {
			valor = valor.replace('.', ',');
		}
		ini = valor.indexOf("$");
		fimtexto = valor.indexOf(",") + 3;
		valor = valor.substring(ini+1,fimtexto).trim();
		valor = valor.replace(".","");
		valor = valor.replace(',', '.');
		return Float.valueOf(valor);
	}

}