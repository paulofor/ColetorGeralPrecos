package coletapreco.modelo;

import coletapreco.modelo.agregado.*;
import coletapreco.modelo.derivadas.*;
import br.com.digicom.lib.DCIObjetoDominio;

// Gera??o autom?tica n?o alterar
public interface Usuario extends DCIObjetoDominio , UsuarioAgregadoI , UsuarioDerivadaI
{

	
	public long getIdUsuario();
	public void setIdUsuario(long valor);
	
	
	public String getNomeUsuario();
	public void setNomeUsuario(String valor);
	
	
	public boolean getPlano01();
	public void setPlano01(boolean valor);
	
	
	public boolean getPlano02();
	public void setPlano02(boolean valor);
	
	
	public boolean getPlano03();
	public void setPlano03(boolean valor);
	
	
	public boolean getPlano04();
	public void setPlano04(boolean valor);
	
	
	public boolean getPlano05();
	public void setPlano05(boolean valor);
	
	
	public String getDataUltimaAlteracao();
	public void setDataUltimaAlteracao(String valor);
	
	
	public boolean getPermiteSincronizar();
	public void setPermiteSincronizar(boolean valor);
	
	
	public String getCodigoExterno();
	public void setCodigoExterno(String valor);
	
	
	public String getDataUltimoProcessamento();
	public void setDataUltimoProcessamento(String valor);
	
	
}

