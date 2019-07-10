package copa.comprador; //uso de pacotes
import java.util.Scanner; //importacao de classe providas pela linguagem
public class Comprador {
    //uso de encapsulamento modificador private
    private String identificacao;
    //uso de encapsulamento: getter, setter e modificador private
    private boolean atestado;
    //uso de encapsulamento: getter, setter e modificador private
    private boolean brasileiro;
    //uso de encapsulamento: getter, setter e modificador private
    private int categoria;
    
    //uso de metodo construtor
    public Comprador(String identificacao,int categoria){
        this.identificacao = identificacao;
        this.categoria = categoria;
    }
    //uso de encapsulamento getter
    public String getIdentificacao() {
        return identificacao;
    }
    //uso de encapsulamento setter
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    //uso de encapsulamento getter
    public boolean isAtestado() {
        return atestado;
    }
    //uso de encapsulamento setter personalizado
    public void setAtestado() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Comprador com atestado (responda com \"sim\" ou \"nao\"):");
        String resposta = keyboard.nextLine(); //uso de classe providas pela linguagem
        this.atestado = (resposta.toLowerCase()).equals("sim") || (resposta.toLowerCase()).equals("s");
        keyboard.close();
    }
    //uso de encapsulamento getter
    public boolean isBrasileiro() {
        return brasileiro;
    }
    //uso de encapsulamento setter personalizado
    public void setBrasileiro() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nacionalidade brasileira (responda com \"sim\" ou \"nao\"):");
        String resposta = keyboard.nextLine(); //uso de classe providas pela linguagem
        this.brasileiro = (resposta.toLowerCase()).equals("sim") || (resposta.toLowerCase()).equals("s");
        keyboard.close(); //uso de classe providas pela linguagem
    }
    //uso de encapsulamento getter
    public int getCategoria() {
        return categoria;
    }
    //uso de encapsulamento setter
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
