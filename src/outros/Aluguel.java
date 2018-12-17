package outros;

import java.io.Serializable;

public class Aluguel implements Serializable{
    
    protected String dataInicio;
    protected String dataVigencia;
    protected String encerramento;
    protected double valor;
    protected double comissao;

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(String dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public String getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(String encerramento) {
        this.encerramento = encerramento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

}
