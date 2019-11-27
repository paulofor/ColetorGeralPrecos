package coletapreco.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;
import coletapreco.modelo.OportunidadeDia;
import coletapreco.modelo.FabricaVo;


//  Nao consegui fazer extender classe MontadorDao para nao precisar 
//  implementar todos os metodos de MontadorDaoI ( metodos novos )
//  achei o caminho mais simples colocar os metodos aqui.
public class OportunidadeDiaMontador   implements MontadorDaoI { 

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
		objeto = FabricaVo.criaOportunidadeDia();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaOportunidadeDia();
		return extraiRegistro(resultadoLista, objeto, pos );
	}
	
	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		OportunidadeDia objeto;
		objeto = (OportunidadeDia)entrada;
		  
	  	objeto.setIdOportunidadeDia(resultadoLista.getInt(pos++));  
	  	objeto.setUrlProduto(resultadoLista.getString(pos++));  
	  	objeto.setNomeProduto(resultadoLista.getString(pos++));  
	  	objeto.setDataInicioPrecoAtual(resultadoLista.getString(pos++));  
	  	objeto.setNomeMarca(resultadoLista.getString(pos++));  
	  	objeto.setUrlAfiliado(resultadoLista.getString(pos++));  
	  	objeto.setDataUltimaPrecoAnterior(resultadoLista.getString(pos++));  
	  	objeto.setImagemLocal(resultadoLista.getString(pos++));  
	  	objeto.setUrlImagem(resultadoLista.getString(pos++));  
	  	objeto.setPosicaoProduto(resultadoLista.getInt(pos++));  
	  	objeto.setPrecoVendaAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoVendaAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoBoletoAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoBoletoAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoParcelaAnterior(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoParcelaAtual(resultadoLista.getFloat(pos++));  
	  	objeto.setQuantidadeParcelaAnterior(resultadoLista.getInt(pos++));  
	  	objeto.setQuantidadeParcelaAtual(resultadoLista.getInt(pos++));  
	  	objeto.setPercentualAjusteVenda(resultadoLista.getFloat(pos++));  
	  	objeto.setPercentualAjusteBoleto(resultadoLista.getFloat(pos++));  
	  	objeto.setNomeLojaVirtual(resultadoLista.getString(pos++));  
	  	objeto.setPrecoMinimo(resultadoLista.getFloat(pos++));  
	  	objeto.setPrecoMedio(resultadoLista.getFloat(pos++));  
	  	objeto.setIdProdutoRa(resultadoLista.getInt(pos++));  
	  	objeto.setIdNaturezaProdutoPa(resultadoLista.getInt(pos++));
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
