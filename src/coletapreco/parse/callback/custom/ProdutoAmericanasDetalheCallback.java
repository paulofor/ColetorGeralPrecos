package coletapreco.parse.callback.custom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import coletapreco.parse.callback.ProdutoDetalheCallbackHtml;
import coletapreco.parse.dados.ProdutoDadosParse;

public class ProdutoAmericanasDetalheCallback extends ProdutoDetalheCallbackHtml {


	private String preco = null;
	private String nome = null;
	
	private String fotoProduto = null;
	private JSONObject itemJson = null;
	
	public ProdutoAmericanasDetalheCallback() {
		//this.setDebug();
	}
	
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		/*
		String texto = String.copyValueOf(data);
		if (preco==null && "sales-price".equals(this.getUltClasse())) {
			preco = texto;
			((ProdutoDadosParse)dadosParse).setPrecoDetalhe(texto);
			//System.out.println(texto);
		}
		if ("product-name".equals(this.getUltClasse())) {
			((ProdutoDadosParse)dadosParse).setNomeDetalhe(texto);
			//System.out.println(texto);
		}
		*/
	}
	
	
	
	/*
	@Override
	protected void meta(String propriedade, String conteudo) {
		if("og:image".equals(propriedade)) {
			System.out.println("Imagem:" + conteudo);
			((ProdutoDadosParse) this.dadosParse).setImagemDetalhe(conteudo);
		}
	}
	*/

	
	
	
	/*
	@Override
	protected void handleImagem(String imagem) {
		super.handleImagem(imagem);
		if (fotoProduto==null) {
			fotoProduto = imagem;
			System.out.println("Imagem:" + imagem);
			((ProdutoDadosParse) this.dadosParse).setImagemDetalhe(imagem);
		}
	}
	*/

	@Override
	protected void script(String tipo, String texto) {
		// TODO Auto-generated method stub
		super.script(tipo, texto);
		if ("application/ld+json".equals(tipo)) {
			try {
				itemJson = new JSONObject(texto);
				JSONArray obj1 = (JSONArray) itemJson.get("@graph");
				String imagem = (String) obj1.getJSONObject(4).getJSONObject("image").get("url");
				System.out.println("imagem: " + imagem);
				((ProdutoDadosParse) this.dadosParse).setImagemDetalhe(imagem);
			} catch (Exception e) {
				System.out.println(texto);
				e.printStackTrace();
			}
		}
	}

	@Override
	public void antesLoop() {
		super.antesLoop();
		this.fotoProduto = null;
	}
	
	
}
