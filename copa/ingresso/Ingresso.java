package copa.ingresso; //uso de pacotes
//uso de classe abstrata
public abstract class Ingresso {
    protected static final double VALORCATEGORIA1 = 890.00; //definindo constantes
    protected static final double VALORCATEGORIA2 = 590.00; //definindo constantes
    protected static final double VALORCATEGORIA3 = 400.00; //definindo constantes
    protected static final double VALORCATEGORIA4 = 260.00; //definindo constantes
    
    //uso de metodo abstrato
    public abstract double getprecoIngresso();
}
