package PastaImoveis;

public class Terreno extends Imovel{

    public float getDimensaoFrente() {
        return dimensaoFrente;
    }

    public void setDimensaoFrente(float dimensaoFrente) {
        this.dimensaoFrente = dimensaoFrente;
    }

    public float getDimensaoLado() {
        return dimensaoLado;
    }

    public void setDimensaoLado(float dimensaoLado) {
        this.dimensaoLado = dimensaoLado;
    }
    protected float dimensaoFrente;
    protected float dimensaoLado;
}
