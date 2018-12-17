package outros;

import java.io.Serializable;

public class PagamentoAluguel implements Serializable{
    
    protected String dataVencimento;
    protected String dataPagamento;
    protected double valorPago;
    protected double jurosPago;
    protected double porcentagemImobiliaria;

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getJurosPago() {
        return jurosPago;
    }

    public void setJurosPago(double jurosPago) {
        this.jurosPago = jurosPago;
    }

    public double getPorcentagemImobiliaria() {
        return porcentagemImobiliaria;
    }

    public void setPorcentagemImobiliaria(double porcentagemImobiliaria) {
        this.porcentagemImobiliaria = porcentagemImobiliaria;
    }

}
