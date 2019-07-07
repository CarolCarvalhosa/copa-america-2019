package copa; //uso de pacotes
//uso de interface java
public interface FluxoDeCompra {
    public void categorias();
    public void tiposDeIngresso();
    public void novaCompra(String identificacao,CopaAmerica2019 copa); //sobrecarga de metodos
    public void novaCompra(Comprador novoComprador,int categoria); //sobrecarga de metodos
    //metodos estaticos abaixo nao precisam do @Override na implementacao
    public static int numeroIngressosVendidos() {return 0;}
}