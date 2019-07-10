package copa.ingresso; //uso de pacotes
public class Inteira extends Ingresso{ //heranca
    protected double valorDoIngresso; //modificador de acesso
    public Inteira (Comprador novoComprador){ //metodo construtor
        switch (novoComprador.getCategoria()){
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
    @Override //sobrescrita de metodo
    public double getprecoIngresso() {
        return this.valorDoIngresso;
    }
}
