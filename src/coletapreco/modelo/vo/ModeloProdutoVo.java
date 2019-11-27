package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ModeloProdutoVo implements ModeloProduto
{
		
	public long getIdObj()
    {
       return idModeloProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdModeloProduto\" : \"" + idModeloProduto + "\" "
		+ ", \"NomeModeloProduto\" : \"" + nomeModeloProduto + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ModeloProdutoDerivada derivada = null;
	private ModeloProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ModeloProdutoDerivada(this);
		}
		return derivada;
	}

	private ModeloProdutoAgregado agregado = null;
	private ModeloProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ModeloProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	
	// Montador Alternativo
	public boolean existeListaModeloProdutoProduto_ReferenteA() {
		return getAgregado().existeListaModeloProdutoProduto_ReferenteA();
	}
	public void criaVaziaListaModeloProdutoProduto_ReferenteA() {
		getAgregado().criaVaziaListaModeloProdutoProduto_ReferenteA();
	}
	public List<ModeloProdutoProduto> getListaModeloProdutoProduto_ReferenteA() 
	{
		return getAgregado().getListaModeloProdutoProduto_ReferenteA(); 
	} 
	public void setListaModeloProdutoProduto_ReferenteA(List<ModeloProdutoProduto> value) 
	{
		getAgregado().setListaModeloProdutoProduto_ReferenteA(value); 
	} 
	public void addListaModeloProdutoProduto_ReferenteA(ModeloProdutoProduto value) 
	{
		getAgregado().addListaModeloProdutoProduto_ReferenteA(value); 
	} 
	public ModeloProdutoProduto getCorrenteModeloProdutoProduto_ReferenteA()
	{
		return getAgregado().getCorrenteModeloProdutoProduto_ReferenteA(); 
	} 
	

	
	
	
	
	
	private long idModeloProduto;
	public long getIdModeloProduto()
	{
		return idModeloProduto;
	}
	public  void setIdModeloProduto(long value)
	{
		idModeloProduto = value; 
	}
	
	
	
	
	
	private String nomeModeloProduto;
	public String getNomeModeloProduto()
	{
		return nomeModeloProduto;
	}
	public  void setNomeModeloProduto(String value)
	{
		nomeModeloProduto = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
