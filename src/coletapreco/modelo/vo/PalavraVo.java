package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class PalavraVo implements Palavra
{
		
	public long getIdObj()
    {
       return idPalavra;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdPalavra\" : \"" + idPalavra + "\" "
		+ ", \"Descricao\" : \"" + descricao + "\" "
		+ ", \"Comum\" : \"" + comum + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private PalavraDerivada derivada = null;
	private PalavraDerivada getDerivada() {
		if (derivada==null) {
			derivada = new PalavraDerivada(this);
		}
		return derivada;
	}

	private PalavraAgregado agregado = null;
	private PalavraAgregado getAgregado() {
		if (agregado==null) {
			agregado = new PalavraAgregado(this);
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
	public boolean existeListaPalavraProduto_Possui() {
		return getAgregado().existeListaPalavraProduto_Possui();
	}
	public void criaVaziaListaPalavraProduto_Possui() {
		getAgregado().criaVaziaListaPalavraProduto_Possui();
	}
	public List<PalavraProduto> getListaPalavraProduto_Possui() 
	{
		return getAgregado().getListaPalavraProduto_Possui(); 
	} 
	public void setListaPalavraProduto_Possui(List<PalavraProduto> value) 
	{
		getAgregado().setListaPalavraProduto_Possui(value); 
	} 
	public void addListaPalavraProduto_Possui(PalavraProduto value) 
	{
		getAgregado().addListaPalavraProduto_Possui(value); 
	} 
	public PalavraProduto getCorrentePalavraProduto_Possui()
	{
		return getAgregado().getCorrentePalavraProduto_Possui(); 
	} 
	

	
	
	
	
	
	private long idPalavra;
	public long getIdPalavra()
	{
		return idPalavra;
	}
	public  void setIdPalavra(long value)
	{
		idPalavra = value; 
	}
	
	
	
	
	
	private String descricao;
	public String getDescricao()
	{
		return descricao;
	}
	public  void setDescricao(String value)
	{
		descricao = value; 
	}
	
	
	
	
	
	private boolean comum;
	public boolean getComum()
	{
		return comum;
	}
	public  void setComum(boolean value)
	{
		comum = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
