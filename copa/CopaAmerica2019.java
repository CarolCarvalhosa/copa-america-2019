package copa;
import java.util.Scanner; //importacao de classe providas pela linguagem
public class CopaAmerica2019 implements FluxoDeCompra { //uso de interface
    private static final int LOTACAOMAX = 69763; //definicao de constante
    private static int ingressosVendidos = 0;
    private static int[] vetorIngressos = {0,0,0,0,0,0,0,0};
    
    public static void main(String[] args) {
        CopaAmerica2019 copa = new CopaAmerica2019();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("###NOVA VENDA###");
        System.out.print("Insira identificacao da pessoa: ");
        String identificacao = keyboard.nextLine(); //uso de classe providas pela linguagem
        while (!(identificacao.equals("PARAR"))){
            if(ingressosVendidos < LOTACAOMAX){
                copa.novaCompra(identificacao,copa);
                System.out.println("# Total de ingressos vendidos: " + numeroIngressosVendidos());
            }else{
                System.out.println("# Total de ingressos vendidos: " + numeroIngressosVendidos());
                System.out.println("Lotacao maxima atingida.");
                break;
            }
            System.out.println("\n###NOVA VENDA###");
            System.out.print("Insira identificacao da pessoa: ");
            identificacao = keyboard.nextLine(); //uso de classe providas pela linguagem
        }
        System.exit(0);
    }
    /*implementando a interface a partir daqui*/
    @Override //sobrescrita de metodo
    public void novaCompra(String identificacao,CopaAmerica2019 copa){
        Scanner keyboard = new Scanner(System.in); //uso de classe providas pela linguagem
        System.out.println( "# Selecione a categoria (1-4) ou cancelar (0):\n" +
                            "0 - Cancelar Compra");
        copa.categorias();
        int categoria = keyboard.nextInt(); //uso de classe providas pela linguagem
        while(categoria > 5 || categoria < 0){ //tratamento de erro
            System.out.println("Por favor insira um numero valido");
            System.out.println( "# Selecione a categoria (1-4) ou cancelar (0):\n" +
                                "0 - Cancelar Compra");
            copa.categorias();
            categoria = keyboard.nextInt();
        }
        if(categoria == 0){
            return;
        }
        Comprador novoComprador = new Comprador(identificacao,categoria);
        if(categoria == 5){
            novaCompra(novoComprador,categoria); //chamada da sobrecarga do metodo
            return;
        }
        System.out.println( "# Selecione o tipo de ingresso (1-7) ou cancelar (0):\n" +
                            "0 - Cancelar Compra");
        copa.tiposDeIngresso();
        int tipoEscolhido = keyboard.nextInt(); //uso de classe providas pela linguagem
        while(tipoEscolhido > 7 || tipoEscolhido < 0){ //tratamento de erro
            System.out.println("Por favor insira um numero valido");
            System.out.println( "# Selecione o tipo de ingresso (1-7) ou cancelar (0):\n" +
                            "0 - Cancelar Compra");
            copa.tiposDeIngresso();
            tipoEscolhido = keyboard.nextInt();
        }
        keyboard.close(); //uso de classe providas pela linguagem
        Ingresso ingresso; //declarando variavel para uso do polimorfismo
        switch (tipoEscolhido){
            case 0:
                break;
            case 1:
                ingresso = new Inteira(novoComprador);
                System.out.println("R$" + ((Inteira)ingresso).getprecoIngresso()); //casting
                ingressosVendidos += 1;
                vetorIngressos[categoria-1] += 1;
                break;
            case 2:
                ingresso = new MeiaEntradaBrasileiro(novoComprador);
                ingressosVendidos += ((MeiaEntradaBrasileiro)ingresso).isBrasileiro(novoComprador); //casting
                if(novoComprador.isBrasileiro()){
                    System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                    vetorIngressos[categoria-1] += 1;
                }
                break;
            case 3:
                ingresso = new MeiaEntrada(novoComprador);
                System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                ingressosVendidos += 1;
                vetorIngressos[categoria-1] += 1;
                break;
            case 4:
                ingresso = new MeiaEntrada(novoComprador);
                System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                ingressosVendidos += 1;
                vetorIngressos[categoria-1] += 1;
                break;
            case 5:
                ingresso = new InteiraAtestado(novoComprador);
                ingressosVendidos += ((InteiraAtestado)ingresso).isAtestado(novoComprador); //casting
                if(novoComprador.isAtestado()){
                    System.out.println("R$" + ((Inteira)ingresso).getprecoIngresso()); //casting
                    vetorIngressos[categoria-1] += 1;
                }
                break;
            case 6:
                ingresso = new MeiaEntradaAtestado(novoComprador);
                ingressosVendidos += ((MeiaEntradaAtestado)ingresso).isAtestado(novoComprador);
                if(novoComprador.isAtestado()){
                System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                vetorIngressos[categoria-1] += 1;
                }
                break;
            case 7:
                ingresso = new MeiaEntrada(novoComprador);
                System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                ingressosVendidos += 1;
                vetorIngressos[categoria-1] += 1;
                break;
            //nao precisa de default pois ja tem o tratamento de erro inicial
        }
    }
    @Override //sobrescrita de metodo
    public void novaCompra(Comprador novoComprador,int categoria){ //sobrecarga de metodo
        PCD ingresso = new PCD();
        System.out.println("\nR$" + ingresso.getprecoIngresso());
        ingressosVendidos += 2;
        vetorIngressos[categoria-1] += 2;
    }
    //esse metodo nao precisa do @Override, pois eh estatico
    public static int numeroIngressosVendidos() { //uso metodo estatico
        System.out.print( "###Ingressos vendidos###\n" +
                            "1 - Categoria 1: " + vetorIngressos[0] + "\n" +
                            "2 - Categoria 2: " + vetorIngressos[1] + "\n" +
                            "3 - Categoria 3: " + vetorIngressos[2] + "\n" +
                            "4 - Categoria 4: " + vetorIngressos[3] + "\n" +
                            "5 - Categoria PCD: " + vetorIngressos[4] + "\n");
        return ingressosVendidos;
    }
    @Override //sobrescrita de metodos
    public void categorias(){
        System.out.println( "1 - Categoria 1\n" +
                            "2 - Categoria 2\n" +
                            "3 - Categoria 3\n" +
                            "4 - Categoria 4\n" +
                            "5 - Categoria PCD");
    }
    @Override //sobrescrita de metodos
    public void tiposDeIngresso(){
        System.out.println( "1 - Inteira\n" +
                            "2 - Meia-entrada\n" +
                            "3 - Deficiente visual\n" +
                            "4 - Deficiente visual + Cão guia\n" +
                            "5 - Obeso assento especial\n" +
                            "6 - Obeso meia-entrada\n" +
                            "7 - Pessoas com mobilidade reduzida");
    }
}

    
