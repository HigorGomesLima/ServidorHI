package PastaImoveis;

public class Chacara extends Imovel{

    public float getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(float areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public void setAnoConstrucao(int anoConstrucao) {
        this.anoConstrucao = anoConstrucao;
    }

    public int getDistanciaCidade() {
        return distanciaCidade;
    }

    public void setDistanciaCidade(int distanciaCidade) {
        this.distanciaCidade = distanciaCidade;
    }
    protected float areaConstruida;
    protected int numeroQuartos;
    protected int anoConstrucao;
    protected int distanciaCidade;
}
