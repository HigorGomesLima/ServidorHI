package PastaImoveis;

import PastaPessoa.Pessoa;
import java.io.Serializable;

public class Imovel implements Serializable{

    protected String codigo;
    protected String endereco;
    protected String bairro;
    protected String cidade;
    protected long cep;
    protected float areaTotal;
    protected double valor;
    protected  Situacao situacaoatual;
    private Pessoa dono;
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public float getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(float areaTotal) {
        this.areaTotal = areaTotal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Situacao getSituacaoatual() {
        return situacaoatual;
    }

    public void setSituacaoatual(Situacao situacaoatual) {
        this.situacaoatual = situacaoatual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the dono
     */
    public Pessoa getDono() {
        return dono;
    }

    /**
     * @param dono the dono to set
     */
    public void setDono(Pessoa dono) {
        this.dono = dono;
    }
    
}
