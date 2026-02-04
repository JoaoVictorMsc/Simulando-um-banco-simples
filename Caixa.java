import java.util.Scanner;

public class Caixa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Deposite um valor para iniciar");
        var saldo = sc.nextDouble();
        var chequeEspecial = 0.0;

        if(saldo <= 500 && saldo > 0){
            chequeEspecial = 50;
        } else {
            chequeEspecial = (saldo * 0.50);
        }


        Conta consulta = new Conta(saldo, chequeEspecial);
        consulta.iniciar();
    }
}
