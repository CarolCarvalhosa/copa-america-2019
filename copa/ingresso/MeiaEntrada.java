package copa.ingresso;
public class MeiaEntrada extends Ingresso{ //heranca
    protected double valorDoIngresso; //modificador de acesso
    public MeiaEntrada (Comprador novoComprador){ //uso de construtor
        setValorDoIngresso(novoComprador.getCategoria());
    }
    @Override //sobrescrita de metodo
    public double getprecoIngresso() {
        return this.valorDoIngresso/2;
    }
    public void setValorDoIngresso(int categoria) {
        switch (categoria){
            case 1:
                this.valorDoIngresso = VALORCATEGORIA1;
                break;
            case 2:
                this.valorDoIngresso =  VALORCATEGORIA2;
                break;
            case 3:
                this.valorDoIngresso = VALORCATEGORIA3;
                break;
            case 4:
                this.valorDoIngresso = VALORCATEGORIA4;
                break;
        }
    }
}
