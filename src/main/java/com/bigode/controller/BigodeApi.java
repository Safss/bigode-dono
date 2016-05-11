package main.java.com.bigode.controller;

import main.java.com.bigode.action.BigodeActions;
import main.java.com.bigode.exception.RequestProblemException;
import main.java.com.bigode.model.Mesa;
import main.java.com.bigode.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BigodeApi {

    @Autowired
    private BigodeActions bigodeActions = null;

    @RequestMapping(path = "/mesas", method = RequestMethod.GET)
    public List<Mesa> getListaPedidos(){
        //TODO: Retornar lista de pedidos a serem entregues
        return BigodeActions.getListaPedidos();
    }

    @RequestMapping(path = "/mesas/fake/{numeroMesa}", method = RequestMethod.GET)
    public void criaMesaFake(
            @PathVariable Long numeroMesa
    ){
        BigodeActions.criaPedido(numeroMesa);
    }

    @RequestMapping(path = "/mesas/{numeroMesa}/pedidos", method = RequestMethod.GET)
    public Mesa getListaPedidosMesa(
            @PathVariable Long numeroMesa
    ){
        //TODO: Retornar lista de pedidos de uma mesa especifica
        return BigodeActions.getListaPedidosMesa(numeroMesa);
    }

    @RequestMapping(path = "/mesas/{numeroMesa}/pedidos/{numeroPedido}", method = RequestMethod.GET)
    public Pedido getDetalhesPedido(
            @PathVariable Long numeroMesa,
            @PathVariable Long numeroPedido
    ){
        //TODO: Retornar detalhes de um pedido especifico
        return BigodeActions.getDetalhesPedido(numeroMesa, numeroPedido);
    }


    // TEMP -----------------------------------------------------------------------
    @RequestMapping(path = "/util/tabelas", method = RequestMethod.GET)
    public String getNomesTabelasMysql(){
        return BigodeActions.getMysqlTableNames();
    }

    @RequestMapping(path = "/util/pedidos", method = RequestMethod.GET)
    public String getPedidosMysql(){
        return BigodeActions.getPedidosTeste();
    }

    @RequestMapping(path = "/util/400", method = RequestMethod.GET)
    public String getErrorTest(){
        return BigodeActions.getErrorTest();
    }

    @RequestMapping(path = "/util/400/custom", method = RequestMethod.GET)
    public String getCustomErrorTest() throws RequestProblemException{
        return BigodeActions.getCustomErrorTest();
    }

}