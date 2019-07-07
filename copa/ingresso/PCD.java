package copa.ingresso;
public final class PCD extends Ingresso { //heranca
    @Override //sobrescrita de metodo
    public double getprecoIngresso() {
        return 400.00;
    }
}
