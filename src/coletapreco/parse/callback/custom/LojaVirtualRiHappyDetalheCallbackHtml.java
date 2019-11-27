package coletapreco.parse.callback.custom;

/*

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Bicicletas','http://www.extra.com.br/brinquedos/BicicletasInfantojuvenis/?Filtro=C977_C1240&icid=124304',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Mini Veículos','http://www.extra.com.br/brinquedos/MiniVeiculos/?Filtro=C977_C425&icid=124305',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Esporte Infantil','http://www.extra.com.br/brinquedos/EsporteInfantil/?Filtro=C977_C1607&icid=124306',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Bonecas','http://www.extra.com.br/brinquedos/BonecosdeBrinquedos/?Filtro=C977_C955&icid=124308',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Bonecos','http://www.extra.com.br/brinquedos/BonecosdeBrinquedos/?Filtro=C977_C955&icid=124308',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Tocas e Barracas','http://www.extra.com.br/brinquedos/brincadeiras/TocasBarracasInfantis/?Filtro=C977_C993_C1609&icid=124309',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Praia e Piscina','http://www.extra.com.br/brinquedos/brinquedosPraiaPiscina/?Filtro=C977_C1583&icid=124310',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Playground','http://www.extra.com.br/brinquedos/Playground/?Filtro=C977_C758&icid=124311',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Puericultura','http://www.extra.com.br/brinquedos/puericultura/?Filtro=C977_C458&icid=124312',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Blocos de Montar','http://www.extra.com.br/brinquedos/BlocosdeMontar/?Filtro=C977_C981&icid=124313',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Air Drone','http://www.extra.com.br/brinquedos/ARDrone/?Filtro=C977_C1849&icid=124314',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Artes e Atividades','http://www.extra.com.br/brinquedos/arteseatividades/?Filtro=C977_C959&icid=124315',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Autorama e Pistas','http://www.extra.com.br/brinquedos/AutoramasPistas/?Filtro=C977_C1852&icid=124316',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Brincadeiras','http://www.extra.com.br/brinquedos/brincadeiras/?Filtro=C977_C993&icid=124317',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Carrinhos','http://www.extra.com.br/brinquedos/CarrinhosVeiculosBrinquedos/?Filtro=C977_C956&icid=124318',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Colecionáveis','http://www.extra.com.br/brinquedos/BonecosdeBrinquedos/bonecoscolecionaveis/?Filtro=C977_C955_C1637&icid=124319',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Controle Remoto','http://www.extra.com.br/brinquedos/ControleRemoto/?Filtro=C977_C975&icid=124320',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Fantasias','http://www.extra.com.br/artigosparafestas/festaafantasia/fantasia/?Filtro=C2894_C2895_C2899&icid=124321',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Guarda Brinquedos','http://www.extra.com.br/brinquedos/guardabrinquedos/?Filtro=C977_C3047&icid=124322',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Instrumentos Musicais','http://www.extra.com.br/brinquedos/instrumentosMusica/?Filtro=C977_C964&icid=124323',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Lançadores','http://www.extra.com.br/brinquedos/brincadeiras/lancadores/?Filtro=C977_C993_C2017&icid=124325',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Moda e Maquiagem','http://www.extra.com.br/brinquedos/modaemaquiagem/?Filtro=C977_C985&icid=124326',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Pelúcias','http://www.extra.com.br/brinquedos/Pelucias/?Filtro=C977_C984&icid=124327',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Quebra cabeça','http://www.extra.com.br/brinquedos/Quebra-cabeca/?Filtro=C977_C862&icid=124328',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Mini veículos a pedal','http://www.extra.com.br/brinquedos/MiniVeiculos/?Filtro=C977_C425_V11900&icid=124329',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Mini veículos elétricos','http://www.extra.com.br/brinquedos/MiniVeiculos/?Filtro=C977_C425_V11898&icid=124330',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Brinquados Educativos','http://www.extra.com.br/brinquedos/BrinquedosEducativos/?Filtro=C977_C978&icid=124331',CURRENT_DATE,1,3,0);

insert into categoria_loja (nome, url, data_inclusao, id_natureza_produto_ra, id_loja_virtual_pa, id_categoria_loja_p)
values ('Brinquedos Eletrônicos','http://www.extra.com.br/brinquedos/BrinquedosEletronicos/?Filtro=C977_C988&icid=124332',CURRENT_DATE,1,3,0);
 */




import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTML.Tag;

import coletapreco.modelo.CategoriaLoja;
import coletapreco.modelo.FabricaVo;
import coletapreco.parse.callback.LojaVirtualDetalheCallbackHtml;

public class LojaVirtualRiHappyDetalheCallbackHtml extends LojaVirtualDetalheCallbackHtml {
	

	private String nomeCategoria = null;
	private String urlCategoria = null;
	
	private boolean ligaColeta = false;
	private boolean javascript = false;
	
	
	
	
	
	//---------------------------------
	
	public LojaVirtualRiHappyDetalheCallbackHtml() {
		//this.setDebug();
	}
	
	
	
	
	@Override
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		// TODO Auto-generated method stub
		super.handleSimpleTag(t, a, pos);
	}




	




	@Override
	protected void inicioTag(Tag t, String classeNome, String idNome) {
		
		super.inicioTag(t, classeNome, idNome);
		if (t == HTML.Tag.DIV && "search-single-navigator".equals(classeNome)) {
			ligaColeta = true;
		}
		if ("urlLastSearch".equals(classeNome)) {
			ligaColeta = false;
		}
		
	}
	
	
	



	@Override
	public void handleText(char[] data, int pos) {
		super.handleText(data, pos);
		String texto = String.copyValueOf(data);
		String js = null;
		if (this.javascript) {
			js = texto;
		}
		
		if (ligaColeta) {
			String classe = this.getUltClasse();
			String classe2 = this.getUltClasse2();
			HTML.Tag tag = this.getUltTag2();
			String url = this.getUtlUrl();
			if (tag == HTML.Tag.H4) {
				this.nomeCategoria = texto;
				this.urlCategoria = this.getUtlUrl();
				InsereObjeto();
				return;
			}
		}
		

	}
	
	
	private void InsereObjeto() {
		CategoriaLoja categoria = FabricaVo.criaCategoriaLoja();
		categoria.setNome(nomeCategoria);
		categoria.setUrl(urlCategoria);
		dadosParse.getItemDetalhe().addListaCategoriaLoja_Possui(categoria);
		this.nomeCategoria = null;
		this.urlCategoria = null;
	}
	
	
}
