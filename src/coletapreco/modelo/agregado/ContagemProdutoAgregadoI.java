package coletapreco.modelo.agregado;

import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;

// Gera??o autom?tica n?o alterar
public interface ContagemProdutoAgregadoI{

	//void setConexaoCarregador(DaoConexao conexao);
		
	// Com chave estrangeira
  	
	// Montador tradicional
	public NaturezaProduto getNaturezaProdutoReferenteA(boolean lazyLoader);
	public void setNaturezaProdutoReferenteA(NaturezaProduto item);
	//public void setNaturezaProdutoReferenteAComReversao(NaturezaProduto item);
	
	// Montador alternativo
	
	public void addListaNaturezaProduto_ReferenteA(NaturezaProduto item); 
	public NaturezaProduto getCorrenteNaturezaProduto_ReferenteA();
	
		
	// Montador tradicional
	public LojaVirtual getLojaVirtualReferenteA(boolean lazyLoader);
	public void setLojaVirtualReferenteA(LojaVirtual item);
	//public void setLojaVirtualReferenteAComReversao(LojaVirtual item);
	
	// Montador alternativo
	
	public void addListaLojaVirtual_ReferenteA(LojaVirtual item); 
	public LojaVirtual getCorrenteLojaVirtual_ReferenteA();
	
		
	
	// Sem Chave Estrangeira
	
	
	// Um pra um
	
	
	public void setConexaoCarregador(DaoConexao conexao);
}
