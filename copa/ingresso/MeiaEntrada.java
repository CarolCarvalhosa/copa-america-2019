package copa.ingresso; //uso de pacotes
public class MeiaEntrada extends Inteira{ //heranca
    public MeiaEntrada (Comprador novoComprador){ //uso de construtor
        super(novoComprador);
    }
    @Override //sobrescrita de metodo
    public double getprecoIngresso() {
        return this.valorDoIngresso/2;
    }
}