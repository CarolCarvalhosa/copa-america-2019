package copa.ingresso;
public class MeiaEntradaAtestado extends MeiaEntrada { //heranca
    public MeiaEntradaAtestado(Comprador novoComprador) { //uso de metodo construtor
        super(novoComprador); //uso de super
    }
    public int isAtestado(Comprador novoComprador){
        novoComprador.setAtestado();
        if(novoComprador.isAtestado())
            return 1;
        System.out.println("Apenas apresentando um atestado podem pegar lugar especial");
        return 0;
    }
}
