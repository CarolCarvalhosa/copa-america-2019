package copa.ingresso; //uso de pacotes
public class MeiaEntradaBrasileiro extends MeiaEntrada{ //heranca
    public MeiaEntradaBrasileiro(Comprador novoComprador) { //uso de metodo construtor
        super(novoComprador); //uso de super
    }
    public int isBrasileiro(Comprador novoComprador){
        novoComprador.setBrasileiro();
        if(novoComprador.isBrasileiro())
            return 1;
        System.out.println("Apenas brasileiros podem pagar meia");
        return 0;
    }
}
