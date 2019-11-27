package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.PrecoProduto;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class PrecoProdutoMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaPrecoProduto();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaPrecoProduto();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		PrecoProduto objeto;
		objeto = (PrecoProduto)entrada;
		  
	  	objeto.setIdPrecoProduto(resultadoLista.getInt(pos++));  
	  	objeto.setPrecoBoleto(resultadoLista.getFloat(pos++));  
	  	objeto.setDataVisitaInicial(resultadoLista.getString(pos++));  
	  	objeto.setQuantidadeParcela(resultadoLista.getInt(pos++));  
	  	objeto.setPrecoParcela(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoVenda(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoRegular(resultadoLista.getFloat(pos++));  
	  	objeto.setDataUltimaVisita(resultadoLista.getString(pos++));  
	  	objeto.setPercentualAjuste(resultadoLista.getFloat(pos++));  
	  	objeto.setMedia2meses(resultadoLista.getFloat(pos++));  
	  	objeto.setMinimo3meses(resultadoLista.getFloat(pos++));  
	  	objeto.setIdProdutoPa(resultadoLista.getInt(pos++));
	  	
	  	/*
	  	objeto.setPosicao(resultadoLista.getInt(pos++));
	  	objeto.setPosicao1(resultadoLista.getInt(pos++));
	  	objeto.setPosicao2(resultadoLista.getInt(pos++));
	  	objeto.setPosicao3(resultadoLista.getInt(pos++));
	  	objeto.setPosicao4(resultadoLista.getInt(pos++));
	  	objeto.setPosicao5(resultadoLista.getInt(pos++));
	  	objeto.setPosicao6(resultadoLista.getInt(pos++));
	  	objeto.setPosicao7(resultadoLista.getInt(pos++));
	  	objeto.setDiferencaPosicao7(resultadoLista.getInt(pos++));
	  	*/
	  	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 12;
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
