package copa.ingresso;
public class InteiraAtestado extends Inteira { //heranca
    public InteiraAtestado(Comprador novoComprador) { //metodo construtor
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
