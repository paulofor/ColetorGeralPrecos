package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.UsuarioPesquisa;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class UsuarioPesquisaMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaUsuarioPesquisa();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaUsuarioPesquisa();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		UsuarioPesquisa objeto;
		objeto = (UsuarioPesquisa)entrada;
		  
	  	objeto.setIdUsuarioPesquisa(resultadoLista.getInt(pos++));  
	  	objeto.setIdUsuarioS(resultadoLista.getInt(pos++));  
	  	objeto.setIdNaturezaProdutoP(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 3;
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
