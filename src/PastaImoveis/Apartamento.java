package PastaImoveis;

public class Apartamento extends Imovel{
    
    protected int andarApartamento;
    protected int numeroApartamento;
    protected String nomeEdificio;
    protected int quantidadeQuartos;
    protected int numeroVagasGaragem;
    protected int anoConstrucao;
    protected double valorCondominio;
    protected TipoApartamento tipoDeApartamento;

    public int getAndarApartamento() {
        return andarApartamento;
    }

    public void setAndarApartamento(int andarApartamento) {
        this.andarApartamento = andarApartamento;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public void setNumeroVagasGaragem(int numeroVagasGaragem) {
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public double getValorCondominio() {
        return valorCondominio;
    }

    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }

    public TipoApartamento getTipoDeApartamento() {
        return tipoDeApartamento;
    }

    public void setTipoDeApartamento(TipoApartamento tipoDeApartamento) {
        this.tipoDeApartamento = tipoDeApartamento;
    }

}
