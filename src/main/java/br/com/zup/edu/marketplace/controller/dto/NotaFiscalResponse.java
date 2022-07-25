package br.com.zup.edu.marketplace.controller.dto;

import br.com.zup.edu.marketplace.model.NotaFiscal;
import br.com.zup.edu.marketplace.model.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class NotaFiscalResponse {

    private String nomeDestinatario;

    private String enderecoDestinatario;

    private String telefoneDestinatario;

    private String cpfDestinantario;

    private List<ProdutoResponse> itens;

    private BigDecimal valorNota;

    public NotaFiscalResponse(NotaFiscal notaFiscal){
        this.nomeDestinatario = notaFiscal.getDestinatario().getNome();
        this.enderecoDestinatario = notaFiscal.getDestinatario().getEndereco();
        this.telefoneDestinatario = notaFiscal.getDestinatario().getTelefone();
        this.cpfDestinantario = notaFiscal.getDestinatario().getCpf();
        this.itens = notaFiscal.getItens().stream().map(ProdutoResponse::new).collect(Collectors.toList());
        this.valorNota = notaFiscal.valorTotal();

    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public String getEnderecoDestinatario() {
        return enderecoDestinatario;
    }

    public String getTelefoneDestinatario() {
        return telefoneDestinatario;
    }

    public String getCpfDestinantario() {
        return cpfDestinantario;
    }

    public List<ProdutoResponse> getItens() {
        return itens;
    }

    public BigDecimal getValorNota() {
        return valorNota;
    }
}
