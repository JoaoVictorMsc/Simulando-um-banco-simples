import java.time.OffsetDateTime;
import java.util.Scanner;

public class Conta {
    private double saldo;
    private double chequeEspecial;
    private boolean chequeEspecialUsado = false;
    private int cobrancaMensal = OffsetDateTime.now().getMonthValue();
    Scanner sc = new Scanner(System.in);

    public Conta(double saldo, double chequeEspecial){
        setSaldo(saldo);
        setChequeEspecial(chequeEspecial);
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setChequeEspecial(double chequeEspecial){
        this.chequeEspecial = chequeEspecial;
    }

    public void exibirMenu(){
        System.out.println("\t Menu");
        System.out.println("====================");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Consultar Cheque Especial");
        System.out.println("3 - Depositar Dinheiro");
        System.out.println("4 - Sacar Dinheiro");
        System.out.println("5 - Pagar Boleto");
        System.out.println("6 - Verificar se a Conta está Usando Cheque Especial");
        System.out.println("7 - Sair");
    }

    public void  consultarSaldo(){
        System.out.println("Seu saldo é de: " + this.saldo);
    }

    public void depositar(double valor){
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Seu novo saldo é de: " + this.saldo);
        } else {
            System.out.println("Operação invalida");
        }
    }

    public void sacar(double valor){
        if(valor > 0){
            this.saldo -= valor;
            System.out.println("Seu novo saldo é de: " + this.saldo + ".");
        } else {
            System.out.println("Operação invalida");
        }
    }

    public void pagarBoleto(double valor){
        if(valor > 0 && valor <= saldo){
            this.saldo -= valor;
            System.out.println("Boleto pago com sucesso");
            System.out.println("Seu novo saldo é de: " + this.saldo);
        } else {
            System.out.println("Operação invalida");
        }
    }

    public void verificarSeAContaEstaUsandoOChequeEspecial(){
            if(chequeEspecialUsado == true){
                System.out.println("Cheque Especial em Uso");
            } else {
                System.out.println("Você não está usando o cheque especial");
            }
    }

    public void cobrancaMensalSobreOChequeEspecial(){

        int mesAtual = OffsetDateTime.now().getMonthValue();

        if(mesAtual > this.cobrancaMensal && chequeEspecialUsado){
            double taxa = this.chequeEspecial * 0.20;
            this.saldo -= taxa;
            this.cobrancaMensal = mesAtual;
            System.out.println("Cobrança mensal realizada: " + taxa + ".");
            System.out.println("Seu novo saldo é de: " + this.saldo);
        }

    }

    public void iniciar(){
        int opcao;

        do{
            cobrancaMensalSobreOChequeEspecial();
            exibirMenu();
            opcao = sc.nextInt();
            menuOpcoes(opcao);
        }while (opcao != 7);
    }

    public void menuOpcoes(int opcao){
        double valor;

        switch (opcao){
            case 1 -> consultarSaldo();
            case 2 -> {
                menuChequeEspecial();
                int valorMenuChequeEspecial = sc.nextInt();
                menuOpcoesChequeEspecial(valorMenuChequeEspecial);
            }
            case 3 -> {
                System.out.println("Quanto você deseja depositar:");
                valor = sc.nextDouble();
                depositar(valor);
            }
            case 4 -> {
                System.out.println("Quanto você deseja sacar:");
                valor = sc.nextDouble();
                sacar(valor);
            }
            case 5 -> {
                System.out.println("Valor do a pagar: ");
                valor = sc.nextDouble();
                pagarBoleto(valor);
            }
            case 6 -> verificarSeAContaEstaUsandoOChequeEspecial();
            case 7 -> System.out.println("Saindo.");
            default -> System.out.println("Opção invalida");
        }
    }

    public void menuChequeEspecial(){
        System.out.println("1 - Consultar Cheque Especial");
        System.out.println("2 - Consultar Regras Contratuais");
        System.out.println("3 - Contratar");
        System.out.println("4 - Voltar");
    }

    public void consultarChequeEspecial(){
        System.out.println("Seu Cheque especial é de: " + this.chequeEspecial + ".");
    }

    public void consultarRegras(){
        System.out.println("O valor descontado sera de 20% do valor do seu Cheque Especial que é de: " + this.chequeEspecial);
    }

    public void contratarChequeEspecial(){
        System.out.println("Contratado com sucesso");
        chequeEspecialUsado = true;
        System.out.println("Seu novo saldo é de: " + this.saldo + ".");
    }

    public void menuOpcoesChequeEspecial(int valorMenuChequeEspecial){
        switch(valorMenuChequeEspecial){
            case 1 -> consultarChequeEspecial();
            case 2 -> consultarRegras();
            case 3 -> contratarChequeEspecial();
            case 4 -> System.out.println("Voltando ao Menu anterior");
            default -> System.out.println("Opção invalida");
        }
    }
}