package com.marcreis.cursomc.domain;

import com.marcreis.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento  implements Serializable {

    private Date dataVencimento;
    private Date dataPagameno;

    public PagamentoComBoleto( ) {
    }

    public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido,   Date dataVencimento, Date dataPagameno) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagameno = dataPagameno;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagameno() {
        return dataPagameno;
    }

    public void setDataPagameno(Date dataPagameno) {
        this.dataPagameno = dataPagameno;
    }
}
