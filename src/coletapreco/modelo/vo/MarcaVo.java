package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class MarcaVo implements Marca
{
		
	public long getIdObj()
    {
       return idMarca;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdMarca\" : \"" + idMarca + "\" "
		+ ", \"NomeMarca\" : \"" + nomeMarca + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private MarcaDerivada derivada = null;
	private MarcaDerivada getDerivada() {
		if (derivada==null) {
			derivada = new MarcaDerivada(this);
		}
		return derivada;
	}

	private MarcaAgregado agregado = null;
	private MarcaAgregado getAgregado() {
		if (agregado==null) {
			agregado = new MarcaAgregado(this);
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
	public boolean existeListaProduto_ReferenteA() {
		return getAgregado().existeListaProduto_ReferenteA();
	}
	public void criaVaziaListaProduto_ReferenteA() {
		getAgregado().criaVaziaListaProduto_ReferenteA();
	}
	public List<Produto> getListaProduto_ReferenteA() 
	{
		return getAgregado().getListaProduto_ReferenteA(); 
	} 
	public void setListaProduto_ReferenteA(List<Produto> value) 
	{
		getAgregado().setListaProduto_ReferenteA(value); 
	} 
	public void addListaProduto_ReferenteA(Produto value) 
	{
		getAgregado().addListaProduto_ReferenteA(value); 
	} 
	public Produto getCorrenteProduto_ReferenteA()
	{
		return getAgregado().getCorrenteProduto_ReferenteA(); 
	} 
	

	
	
	
	
	
	private long idMarca;
	public long getIdMarca()
	{
		return idMarca;
	}
	public  void setIdMarca(long value)
	{
		idMarca = value; 
	}
	
	
	
	
	
	private String nomeMarca;
	public String getNomeMarca()
	{
		return nomeMarca;
	}
	public  void setNomeMarca(String value)
	{
		nomeMarca = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
