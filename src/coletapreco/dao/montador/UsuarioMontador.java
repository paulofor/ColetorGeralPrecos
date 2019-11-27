package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.Usuario;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class UsuarioMontador   implements MontadorDaoI { 

	public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista result,DCIObjetoDominio objeto) throws  DaoException
    {
		DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
	
    public DaoItemRetorno extraiRegistroInterno(ResultadoLista result, DCIObjetoDominio objeto) throws  DaoException
    {
    	DaoItemRetorno retorno = new DaoItemRetorno();
    	objeto = ((MontadorDaoI)this).extraiRegistro(result);
    	retorno.setInsere(true);
    	retorno.setObjeto(objeto);
        return retorno;
    }
    
    public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaUsuario();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaUsuario();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		Usuario objeto;
		objeto = (Usuario)entrada;
		  
	  	objeto.setIdUsuario(resultadoLista.getInt(pos++));  
	  	objeto.setNomeUsuario(resultadoLista.getString(pos++));  
	  	objeto.setPlano01(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setPlano02(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setPlano03(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setPlano04(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setPlano05(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setDataUltimaAlteracao(resultadoLista.getString(pos++));  
	  	objeto.setPermiteSincronizar(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setCodigoExterno(resultadoLista.getString(pos++));  
	  	objeto.setDataUltimoProcessamento(resultadoLista.getString(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 11;
	}
	
	/*
	Acho que fiz errado criando isso.
	@Override
	public DaoItemRetorno extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto) throws DaoException, ClassNotFoundException,
			NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		throw new UnsupportedOperationException();
	}
	@Override
	public DaoItemRetorno extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto) throws DaoException {
		throw new UnsupportedOperationException();
	}
	*/

}
