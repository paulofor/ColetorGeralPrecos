package coletapreco.modelo.vo;

import java.util.List;
import java.text.*;
import br.com.digicom.lib.DCIObjetoDominio;
import br.com.digicom.lib.dao.DaoConexao;
import coletapreco.modelo.*;
import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;

// Gera??o autom?tica n?o alterar
public class UsuarioVo implements Usuario
{
		
	public long getIdObj()
    {
       return idUsuario;
    }
    
	public String toWS() {
		return "" + getIdObj();
	}
	
	private String JsonAtributos() {
		return 
		" \"IdUsuario\" : \"" + idUsuario + "\" "
		+ ", \"NomeUsuario\" : \"" + nomeUsuario + "\" "
		+ ", \"Plano01\" : \"" + plano01 + "\" "
		+ ", \"Plano02\" : \"" + plano02 + "\" "
		+ ", \"Plano03\" : \"" + plano03 + "\" "
		+ ", \"Plano04\" : \"" + plano04 + "\" "
		+ ", \"Plano05\" : \"" + plano05 + "\" "
		+ ", \"DataUltimaAlteracao\" : \"" + dataUltimaAlteracao + "\" "
		+ ", \"PermiteSincronizar\" : \"" + permiteSincronizar + "\" "
		+ ", \"CodigoExterno\" : \"" + codigoExterno + "\" "
		+ ", \"DataUltimoProcessamento\" : \"" + dataUltimoProcessamento + "\" "
	
	;
	}
	
	
	
	public String JSon() {
		return " { " + JsonAtributos() + " } ";
	}
	
	private UsuarioDerivada derivada = null;
	private UsuarioDerivada getDerivada() {
		if (derivada==null) {
			derivada = new UsuarioDerivada(this);
		}
		return derivada;
	}

	private UsuarioAgregado agregado = null;
	private UsuarioAgregado getAgregado() {
		if (agregado==null) {
			agregado = new UsuarioAgregado(this);
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
	public boolean existeListaDispositivoUsuario_Usa() {
		return getAgregado().existeListaDispositivoUsuario_Usa();
	}
	public void criaVaziaListaDispositivoUsuario_Usa() {
		getAgregado().criaVaziaListaDispositivoUsuario_Usa();
	}
	public List<DispositivoUsuario> getListaDispositivoUsuario_Usa() 
	{
		return getAgregado().getListaDispositivoUsuario_Usa(); 
	} 
	public void setListaDispositivoUsuario_Usa(List<DispositivoUsuario> value) 
	{
		getAgregado().setListaDispositivoUsuario_Usa(value); 
	} 
	public void addListaDispositivoUsuario_Usa(DispositivoUsuario value) 
	{
		getAgregado().addListaDispositivoUsuario_Usa(value); 
	} 
	public DispositivoUsuario getCorrenteDispositivoUsuario_Usa()
	{
		return getAgregado().getCorrenteDispositivoUsuario_Usa(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaUsuarioPesquisa_Sincroniza() {
		return getAgregado().existeListaUsuarioPesquisa_Sincroniza();
	}
	public void criaVaziaListaUsuarioPesquisa_Sincroniza() {
		getAgregado().criaVaziaListaUsuarioPesquisa_Sincroniza();
	}
	public List<UsuarioPesquisa> getListaUsuarioPesquisa_Sincroniza() 
	{
		return getAgregado().getListaUsuarioPesquisa_Sincroniza(); 
	} 
	public void setListaUsuarioPesquisa_Sincroniza(List<UsuarioPesquisa> value) 
	{
		getAgregado().setListaUsuarioPesquisa_Sincroniza(value); 
	} 
	public void addListaUsuarioPesquisa_Sincroniza(UsuarioPesquisa value) 
	{
		getAgregado().addListaUsuarioPesquisa_Sincroniza(value); 
	} 
	public UsuarioPesquisa getCorrenteUsuarioPesquisa_Sincroniza()
	{
		return getAgregado().getCorrenteUsuarioPesquisa_Sincroniza(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPalavraChavePesquisa_Possui() {
		return getAgregado().existeListaPalavraChavePesquisa_Possui();
	}
	public void criaVaziaListaPalavraChavePesquisa_Possui() {
		getAgregado().criaVaziaListaPalavraChavePesquisa_Possui();
	}
	public List<PalavraChavePesquisa> getListaPalavraChavePesquisa_Possui() 
	{
		return getAgregado().getListaPalavraChavePesquisa_Possui(); 
	} 
	public void setListaPalavraChavePesquisa_Possui(List<PalavraChavePesquisa> value) 
	{
		getAgregado().setListaPalavraChavePesquisa_Possui(value); 
	} 
	public void addListaPalavraChavePesquisa_Possui(PalavraChavePesquisa value) 
	{
		getAgregado().addListaPalavraChavePesquisa_Possui(value); 
	} 
	public PalavraChavePesquisa getCorrentePalavraChavePesquisa_Possui()
	{
		return getAgregado().getCorrentePalavraChavePesquisa_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaInteresseProduto_Sincroniza() {
		return getAgregado().existeListaInteresseProduto_Sincroniza();
	}
	public void criaVaziaListaInteresseProduto_Sincroniza() {
		getAgregado().criaVaziaListaInteresseProduto_Sincroniza();
	}
	public List<InteresseProduto> getListaInteresseProduto_Sincroniza() 
	{
		return getAgregado().getListaInteresseProduto_Sincroniza(); 
	} 
	public void setListaInteresseProduto_Sincroniza(List<InteresseProduto> value) 
	{
		getAgregado().setListaInteresseProduto_Sincroniza(value); 
	} 
	public void addListaInteresseProduto_Sincroniza(InteresseProduto value) 
	{
		getAgregado().addListaInteresseProduto_Sincroniza(value); 
	} 
	public InteresseProduto getCorrenteInteresseProduto_Sincroniza()
	{
		return getAgregado().getCorrenteInteresseProduto_Sincroniza(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaPrecoDiarioCliente_Sincroniza() {
		return getAgregado().existeListaPrecoDiarioCliente_Sincroniza();
	}
	public void criaVaziaListaPrecoDiarioCliente_Sincroniza() {
		getAgregado().criaVaziaListaPrecoDiarioCliente_Sincroniza();
	}
	public List<PrecoDiarioCliente> getListaPrecoDiarioCliente_Sincroniza() 
	{
		return getAgregado().getListaPrecoDiarioCliente_Sincroniza(); 
	} 
	public void setListaPrecoDiarioCliente_Sincroniza(List<PrecoDiarioCliente> value) 
	{
		getAgregado().setListaPrecoDiarioCliente_Sincroniza(value); 
	} 
	public void addListaPrecoDiarioCliente_Sincroniza(PrecoDiarioCliente value) 
	{
		getAgregado().addListaPrecoDiarioCliente_Sincroniza(value); 
	} 
	public PrecoDiarioCliente getCorrentePrecoDiarioCliente_Sincroniza()
	{
		return getAgregado().getCorrentePrecoDiarioCliente_Sincroniza(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaCompartilhamentoProduto_Possui() {
		return getAgregado().existeListaCompartilhamentoProduto_Possui();
	}
	public void criaVaziaListaCompartilhamentoProduto_Possui() {
		getAgregado().criaVaziaListaCompartilhamentoProduto_Possui();
	}
	public List<CompartilhamentoProduto> getListaCompartilhamentoProduto_Possui() 
	{
		return getAgregado().getListaCompartilhamentoProduto_Possui(); 
	} 
	public void setListaCompartilhamentoProduto_Possui(List<CompartilhamentoProduto> value) 
	{
		getAgregado().setListaCompartilhamentoProduto_Possui(value); 
	} 
	public void addListaCompartilhamentoProduto_Possui(CompartilhamentoProduto value) 
	{
		getAgregado().addListaCompartilhamentoProduto_Possui(value); 
	} 
	public CompartilhamentoProduto getCorrenteCompartilhamentoProduto_Possui()
	{
		return getAgregado().getCorrenteCompartilhamentoProduto_Possui(); 
	} 
	
	// Montador Alternativo
	public boolean existeListaProdutoCliente_Sincroniza() {
		return getAgregado().existeListaProdutoCliente_Sincroniza();
	}
	public void criaVaziaListaProdutoCliente_Sincroniza() {
		getAgregado().criaVaziaListaProdutoCliente_Sincroniza();
	}
	public List<ProdutoCliente> getListaProdutoCliente_Sincroniza() 
	{
		return getAgregado().getListaProdutoCliente_Sincroniza(); 
	} 
	public void setListaProdutoCliente_Sincroniza(List<ProdutoCliente> value) 
	{
		getAgregado().setListaProdutoCliente_Sincroniza(value); 
	} 
	public void addListaProdutoCliente_Sincroniza(ProdutoCliente value) 
	{
		getAgregado().addListaProdutoCliente_Sincroniza(value); 
	} 
	public ProdutoCliente getCorrenteProdutoCliente_Sincroniza()
	{
		return getAgregado().getCorrenteProdutoCliente_Sincroniza(); 
	} 
	

	
	
	
	
	
	private long idUsuario;
	public long getIdUsuario()
	{
		return idUsuario;
	}
	public  void setIdUsuario(long value)
	{
		idUsuario = value; 
	}
	
	
	
	
	
	private String nomeUsuario;
	public String getNomeUsuario()
	{
		return nomeUsuario;
	}
	public  void setNomeUsuario(String value)
	{
		nomeUsuario = value; 
	}
	
	
	
	
	
	private boolean plano01;
	public boolean getPlano01()
	{
		return plano01;
	}
	public  void setPlano01(boolean value)
	{
		plano01 = value; 
	}
	
	
	
	
	
	private boolean plano02;
	public boolean getPlano02()
	{
		return plano02;
	}
	public  void setPlano02(boolean value)
	{
		plano02 = value; 
	}
	
	
	
	
	
	private boolean plano03;
	public boolean getPlano03()
	{
		return plano03;
	}
	public  void setPlano03(boolean value)
	{
		plano03 = value; 
	}
	
	
	
	
	
	private boolean plano04;
	public boolean getPlano04()
	{
		return plano04;
	}
	public  void setPlano04(boolean value)
	{
		plano04 = value; 
	}
	
	
	
	
	
	private boolean plano05;
	public boolean getPlano05()
	{
		return plano05;
	}
	public  void setPlano05(boolean value)
	{
		plano05 = value; 
	}
	
	
	
	
	
	private String dataUltimaAlteracao;
	public String getDataUltimaAlteracao()
	{
		return dataUltimaAlteracao;
	}
	public  void setDataUltimaAlteracao(String value)
	{
		dataUltimaAlteracao = value; 
	}
	
	
	
	
	
	private boolean permiteSincronizar;
	public boolean getPermiteSincronizar()
	{
		return permiteSincronizar;
	}
	public  void setPermiteSincronizar(boolean value)
	{
		permiteSincronizar = value; 
	}
	
	
	
	
	
	private String codigoExterno;
	public String getCodigoExterno()
	{
		return codigoExterno;
	}
	public  void setCodigoExterno(String value)
	{
		codigoExterno = value; 
	}
	
	
	
	
	
	private String dataUltimoProcessamento;
	public String getDataUltimoProcessamento()
	{
		return dataUltimoProcessamento;
	}
	public  void setDataUltimoProcessamento(String value)
	{
		dataUltimoProcessamento = value; 
	}
	
	
	
	
	
	
	//-------------------------------------------------------
	
	
}
