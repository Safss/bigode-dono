package main.java.com.bigode.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Pedido {
    @JsonProperty private long id;
    @JsonProperty private List<ItemPedido> itens;
    @JsonProperty private String status;

    public Pedido(){}

    public Pedido(Long idPedido, List<ItemPedido> itens, String status){
        this.id = idPedido;
        this.itens = itens;
        this.status = status;
    }

    public long getId() {return id;}

    public String getStatus() {return status;}

    public List<ItemPedido> getItens() {
        return itens;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public static class ItemPedido {
        @JsonProperty private long id;
        @JsonProperty private String nome;
        @JsonProperty private double preco;
        @JsonProperty private long qtd;

        public ItemPedido(long id, String nome, double preco, long qtd) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
            this.qtd = qtd;
        }

        public long getId() {return id;}

        public String getNome() {return nome;}

        public double getPreco() {return preco;}

        public long getQtd() {return qtd;}



    }
}
