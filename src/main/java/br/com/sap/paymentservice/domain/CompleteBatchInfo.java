package br.com.sap.paymentservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteBatchInfo {
    private Float noLote;
    private Float noPagamento;
    private String valorPagamento;
    private Float codBanco;
    private Float agencia;
    private Float conta;
    private Float digito;
    @JsonProperty("CNPJ")
    private String CNPJ;
    private Float eParcelado;
    private Float noParcela;
    private Float qtdParcela;
    private Float valorParcela;

    public Float getNoLote() {
        return noLote;
    }

    public CompleteBatchInfo setNoLote(Float noLote) {
        this.noLote = noLote;
        return this;
    }

    public Float getNoPagamento() {
        return noPagamento;
    }

    public CompleteBatchInfo setNoPagamento(Float noPagamento) {
        this.noPagamento = noPagamento;
        return this;
    }

    public String getValorPagamento() {
        return valorPagamento;
    }

    public CompleteBatchInfo setValorPagamento(String valorPagamento) {
        this.valorPagamento = valorPagamento;
        return this;
    }

    public Float getCodBanco() {
        return codBanco;
    }

    public CompleteBatchInfo setCodBanco(Float codBanco) {
        this.codBanco = codBanco;
        return this;
    }

    public Float getAgencia() {
        return agencia;
    }

    public CompleteBatchInfo setAgencia(Float agencia) {
        this.agencia = agencia;
        return this;
    }

    public Float getConta() {
        return conta;
    }

    public CompleteBatchInfo setConta(Float conta) {
        this.conta = conta;
        return this;
    }

    public Float getDigito() {
        return digito;
    }

    public CompleteBatchInfo setDigito(Float digito) {
        this.digito = digito;
        return this;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public CompleteBatchInfo setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
        return this;
    }

    public Float geteParcelado() {
        return eParcelado;
    }

    public CompleteBatchInfo seteParcelado(Float eParcelado) {
        this.eParcelado = eParcelado;
        return this;
    }

    public Float getNoParcela() {
        return noParcela;
    }

    public CompleteBatchInfo setNoParcela(Float noParcela) {
        this.noParcela = noParcela;
        return this;
    }

    public Float getQtdParcela() {
        return qtdParcela;
    }

    public CompleteBatchInfo setQtdParcela(Float qtdParcela) {
        this.qtdParcela = qtdParcela;
        return this;
    }

    public Float getValorParcela() {
        return valorParcela;
    }

    public CompleteBatchInfo setValorParcela(Float valorParcela) {
        this.valorParcela = valorParcela;
        return this;
    }
}
