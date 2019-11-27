package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.InteresseProduto;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class InteresseProdutoMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaInteresseProduto();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaInteresseProduto();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		InteresseProduto objeto;
		objeto = (InteresseProduto)entrada;
		  
	  	objeto.setIdInteresseProduto(resultadoLista.getInt(pos++));  
	  	objeto.setNota(resultadoLista.getInt(pos++));  
	  	objeto.setData(resultadoLista.getString(pos++));  
	  	objeto.setValor(resultadoLista.getFloat(pos++));  
	  	objeto.setEspera(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setMonitora(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setVisualizacaoConcluida(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setPrecoMedio(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoMinimo(resultadoLista.getFloat(pos++));  
	  	objeto.setDataUltimaSincronizacao(resultadoLista.getString(pos++));  
	  	objeto.setNovo(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setMudanca(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setDiferencaAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setMinhaAvaliacao(resultadoLista.getInt(pos++));  
	  	objeto.setDataUltimaMudanca(resultadoLista.getString(pos++));  
	  	objeto.setDataUltimaVerificacao(resultadoLista.getString(pos++));  
	  	objeto.setPrecoAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setEstagioVisualizacaoMudanca(resultadoLista.getInt(pos++));  
	  	objeto.setDataUltimaMudancaGmt(resultadoLista.getString(pos++));  
	  	objeto.setMudancaNota(resultadoLista.getLogicoConvertido(pos++));  
	  	objeto.setDataUltimaMudancaNota(resultadoLista.getString(pos++));  
	  	objeto.setDataUltimaMudancaNotaGmt(resultadoLista.getString(pos++));  
	  	objeto.setPrecoAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setIdProdutoClienteRa(resultadoLista.getInt(pos++));  
	  	objeto.setIdUsuarioS(resultadoLista.getInt(pos++));
      	return objeto;
	}
		
	public int quantidadeCampos()  {
      return 25;
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
