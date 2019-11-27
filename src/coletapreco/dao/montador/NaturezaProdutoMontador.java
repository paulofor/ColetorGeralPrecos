package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.NaturezaProduto;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class NaturezaProdutoMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaNaturezaProduto();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaNaturezaProduto();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		NaturezaProduto objeto;
		objeto = (NaturezaProduto)entrada;
		  
	  	objeto.setIdNaturezaProduto(resultadoLista.getInt(pos++));  
	  	objeto.setNomeNaturezaProduto(resultadoLista.getString(pos++));  
	  	objeto.setCodigoNaturezaProduto(resultadoLista.getString(pos++));  
	  	objeto.setIdAppProdutoAp(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 4;
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
