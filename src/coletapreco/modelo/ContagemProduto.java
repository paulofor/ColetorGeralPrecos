package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface ContagemProduto extends DCIObjetoDominio , ContagemProdutoAgregadoI , ContagemProdutoDerivadaI
{

	
	public long getIdContagemProduto();
	public void setIdContagemProduto(long valor);
	
	
	public long getQuantidade();
	public void setQuantidade(long valor);
	
	
	public String getData();
	public void setData(String valor);
	
	
	public float getPercentualDiferenca();
	public void setPercentualDiferenca(float valor);
	
	
	public boolean getPossibilidadeErro();
	public void setPossibilidadeErro(boolean valor);
	
	
	public long getIdNaturezaProdutoRa();
	public void setIdNaturezaProdutoRa(long valor);
	
	
	public long getIdLojaVirtualRa();
	public void setIdLojaVirtualRa(long valor);
	
	
}

