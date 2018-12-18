package PastaPessoa;

public class PessoaJuridica extends Pessoa{

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    protected String cnpj;
}
