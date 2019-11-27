package coletapreco.modelo {

import  coletapreco.modelo.vo.*;

public  class FabricaVo   {
	public static Usuario criaUsuario()  {
          return new UsuarioVo();
	}
	public static DispositivoUsuario criaDispositivoUsuario()  {
          return new DispositivoUsuarioVo();
	}
	public static Produto criaProduto()  {
          return new ProdutoVo();
	}
	public static PrecoProduto criaPrecoProduto()  {
          return new PrecoProdutoVo();
	}
	public static ModeloProduto criaModeloProduto()  {
          return new ModeloProdutoVo();
	}
	public static ModeloProdutoProduto criaModeloProdutoProduto()  {
          return new ModeloProdutoProdutoVo();
	}
	public static LojaVirtual criaLojaVirtual()  {
          return new LojaVirtualVo();
	}
	public static Marca criaMarca()  {
          return new MarcaVo();
	}
	public static CategoriaLoja criaCategoriaLoja()  {
          return new CategoriaLojaVo();
	}
	public static CategoriaLojaProduto criaCategoriaLojaProduto()  {
          return new CategoriaLojaProdutoVo();
	}
	public static NaturezaProduto criaNaturezaProduto()  {
          return new NaturezaProdutoVo();
	}
	public static OportunidadeDia criaOportunidadeDia()  {
          return new OportunidadeDiaVo();
	}
	public static LojaNatureza criaLojaNatureza()  {
          return new LojaNaturezaVo();
	}
	public static Palavra criaPalavra()  {
          return new PalavraVo();
	}
	public static PalavraProduto criaPalavraProduto()  {
          return new PalavraProdutoVo();
	}
	public static UsuarioPesquisa criaUsuarioPesquisa()  {
          return new UsuarioPesquisaVo();
	}
	public static PrecoDiario criaPrecoDiario()  {
          return new PrecoDiarioVo();
	}
	public static ContagemProduto criaContagemProduto()  {
          return new ContagemProdutoVo();
	}
	public static FacebookPerfil criaFacebookPerfil()  {
          return new FacebookPerfilVo();
	}
	public static ProdutoCliente criaProdutoCliente()  {
          return new ProdutoClienteVo();
	}
	public static FacebookFanpage criaFacebookFanpage()  {
          return new FacebookFanpageVo();
	}
	public static AppProduto criaAppProduto()  {
          return new AppProdutoVo();
	}
	public static PalavraChavePesquisa criaPalavraChavePesquisa()  {
          return new PalavraChavePesquisaVo();
	}
	public static FacebookPost criaFacebookPost()  {
          return new FacebookPostVo();
	}
	public static FacebookPostPerformance criaFacebookPostPerformance()  {
          return new FacebookPostPerformanceVo();
	}
	public static InteresseProduto criaInteresseProduto()  {
          return new InteresseProdutoVo();
	}
}
}