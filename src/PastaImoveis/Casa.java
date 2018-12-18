package PastaImoveis;

public class Casa extends Imovel{

    public float getAreaContruida() {
        return areaContruida;
    }

    public void setAreaContruida(float areaContruida) {
        this.areaContruida = areaContruida;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
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

    public int getNumeroAndares() {
        return numeroAndares;
    }

    public void setNumeroAndares(int numeroAndares) {
        this.numeroAndares = numeroAndares;
    }
    protected float areaContruida;
    protected int numeroQuartos;
    protected int numeroVagasGaragem;
    protected int anoConstrucao;
    protected int numeroAndares;
}
