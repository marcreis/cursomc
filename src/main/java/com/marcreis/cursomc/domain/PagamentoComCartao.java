package com.marcreis.cursomc.domain;

import com.marcreis.cursomc.domain.enums.EstadoPagamento;

import java.io.Serializable;

public class PagamentoComCartao extends Pagamento implements Serializable {
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Endereco enderecoEntrega, Cliente cliente, Integer numeroDeParcelas) {
        super(id, estado, pedido, enderecoEntrega, cliente);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
