package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class ContagemProdutoVo implements ContagemProduto
{
		
	public long getIdObj()
    {
       return idContagemProduto;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdContagemProduto\" : \"" + idContagemProduto + "\" "
		+ ", \"Quantidade\" : \"" + quantidade + "\" "
		+ ", \"Data\" : \"" + data + "\" "
		+ ", \"PercentualDiferenca\" : \"" + percentualDiferenca + "\" "
		+ ", \"PossibilidadeErro\" : \"" + possibilidadeErro + "\" "
		+ ", \"IdNaturezaProdutoRa\" : \"" + idNaturezaProdutoRa + "\" "
		+ ", \"IdLojaVirtualRa\" : \"" + idLojaVirtualRa + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private ContagemProdutoDerivada derivada = null;
	private ContagemProdutoDerivada getDerivada() {
		if (derivada==null) {
			derivada = new ContagemProdutoDerivada(this);
		}
		return derivada;
	}

	private ContagemProdutoAgregado agregado = null;
	private ContagemProdutoAgregado getAgregado() {
		if (agregado==null) {
			agregado = new ContagemProdutoAgregado(this);
		}
		return agregado;
	}
	
	
	// Com Chave Estrangeira
	
	// Montador Tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader)
	{
		return getAgregado().getNaturezaProdutoReferenteA(lazyLoader); 
	} 
	public void setNaturezaProdutoReferenteA(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	/*
	public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto value) 
	{
		getAgregado().setNaturezaProdutoReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto value)
	{
		getAgregado().setNaturezaProdutoReferenteA(value); 
	} 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA()
	{
		return getAgregado().getNaturezaProdutoReferenteA(false); 
	} 
	
	
	// Montador Tradicional
	public LojaVirtual getLojaVirtualReferenteA(boolean lazyLoader)
	{
		return getAgregado().getLojaVirtualReferenteA(lazyLoader); 
	} 
	public void setLojaVirtualReferenteA(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualReferenteA(value); 
	} 
	/*
	public void setLojaVirtualReferenteAComReversao(LojaVirtual value) 
	{
		getAgregado().setLojaVirtualReferenteAComReversao(value); 
	} 
	*/
	
	// Montador Alternativo e Tradicional
	public void addListaLojaVirtual_ReferenteA(LojaVirtual value)
	{
		getAgregado().setLojaVirtualReferenteA(value); 
	} 
	public LojaVirtual getCorrenteLojaVirtual_ReferenteA()
	{
		return getAgregado().getLojaVirtualReferenteA(false); 
	} 
	
	
	
	
	// Um pra um
	
	
	
	
	
	public void setConexaoCarregador(DaoConexao conexao) {
		getAgregado().setConexaoCarregador(conexao);
	}
	
	
	// Sem chave estrangeira
	

	
	
	
	
	
	private long idContagemProduto;
	public long getIdContagemProduto()
	{
		return idContagemProduto;
	}
	public  void setIdContagemProduto(long value)
	{
		idContagemProduto = value; 
	}
	
	
	
	
	
	private long quantidade;
	public long getQuantidade()
	{
		return quantidade;
	}
	public  void setQuantidade(long value)
	{
		quantidade = value; 
	}
	
	
	
	
	
	private String data;
	public String getData()
	{
		return data;
	}
	public  void setData(String value)
	{
		data = value; 
	}
	
	
	
	
	
	private float percentualDiferenca;
	public float getPercentualDiferenca()
	{
		return percentualDiferenca;
	}
	public  void setPercentualDiferenca(float value)
	{
		percentualDiferenca = value; 
	}
	
	
	
	
	
	private boolean possibilidadeErro;
	public boolean getPossibilidadeErro()
	{
		return possibilidadeErro;
	}
	public  void setPossibilidadeErro(boolean value)
	{
		possibilidadeErro = value; 
	}
	
	
	
	
		
	private long idNaturezaProdutoRa;
	public long getIdNaturezaProdutoRa() {
		// relacionamento
		if (idNaturezaProdutoRa==0 && this.getNaturezaProdutoReferenteA(false)!=null) 
			return getNaturezaProdutoReferenteA(false).getIdObj();
		else
			return idNaturezaProdutoRa;
	}
	public void setIdNaturezaProdutoRa(long _valor) {
		idNaturezaProdutoRa = _valor;
	}
	
	
	
	
		
	private long idLojaVirtualRa;
	public long getIdLojaVirtualRa() {
		// relacionamento
		if (idLojaVirtualRa==0 && this.getLojaVirtualReferenteA(false)!=null) 
			return getLojaVirtualReferenteA(false).getIdObj();
		else
			return idLojaVirtualRa;
	}
	public void setIdLojaVirtualRa(long _valor) {
		idLojaVirtualRa = _valor;
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
