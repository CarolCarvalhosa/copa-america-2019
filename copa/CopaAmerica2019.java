package copa; //uso de pacotes
import java.util.Scanner; //importacao de classe providas pela linguagem
public class CopaAmerica2019 implements FluxoDeCompra { //uso de interface
    private static final int LOTACAOMAX = 69763; //definicao de constante
    private static int ingressosVendidos = 0;
    
    public static void main(String[] args) { //uso de metodo estatico
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
        keyboard.close();
        System.exit(0);
    }
    /*implementando a interface a partir daqui*/
    @Override //sobrescrita de metodo
    public void novaCompra(String identificacao,CopaAmerica2019 copa){
        Scanner keyboard = new Scanner(System.in); //uso de classe providas pela linguagem
        System.out.println( "# Selecione a categoria (1-4):");
        copa.categorias();
        int categoria = keyboard.nextInt(); //uso de classe providas pela linguagem
        while(categoria > 5 || categoria < 1){ //tratamento de erro
            System.out.println("Por favor insira um numero valido");
            System.out.println( "# Selecione a categoria (1-4):");
            copa.categorias();
            categoria = keyboard.nextInt();
        }
        if(categoria == 0){
            return;
        }
        Comprador novoComprador = new Comprador(identificacao,categoria);
        Ingresso ingresso = null; //declarando variavel para uso do polimorfismo
        if(categoria == 5){
            novaCompra(novoComprador,categoria,ingresso); //chamada da sobrecarga do metodo
            return;
        }
        
        novoComprador.setBrasileiro();
        if(novoComprador.isBrasileiro()){
            ingresso = new MeiaEntrada(novoComprador); //polimorfismo
            System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
            ingressosVendidos += 1;
        }else{
            novoComprador.setDeficiente();
            if(novoComprador.isDeficiente()){
                ingresso = new MeiaEntrada(novoComprador); //polimorfismo
                System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                ingressosVendidos += 1;
            }else{
                novoComprador.setObeso();
                if(novoComprador.isObeso()){
                    ingresso = new MeiaEntrada(novoComprador); //polimorfismo
                    System.out.println("R$" + ((MeiaEntrada)ingresso).getprecoIngresso()); //casting
                    ingressosVendidos += 1;
                }else{
                    ingresso = new Inteira(novoComprador); //polimorfismo
                    System.out.println("R$" + ((Inteira)ingresso).getprecoIngresso()); //casting
                    ingressosVendidos += 1;
                }
            }
        }
    }
    @Override //sobrescrita de metodo
    public void novaCompra(Comprador novoComprador,int categoria,Ingresso ingresso){ //sobrecarga de metodo
        ingresso = new PCD();
        System.out.println("\nR$" + ingresso.getprecoIngresso());
        ingressosVendidos += 2;
    }
    //esse metodo nao precisa do @Override, pois eh estatico
    public static int numeroIngressosVendidos() { //uso metodo estatico
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

}

    
