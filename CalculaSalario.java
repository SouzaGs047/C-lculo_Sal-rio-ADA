import java.util.Scanner;

public class CalculaSalario {
    public static double[] criarVetor() {
        System.out.println("\n*- CRIANDO VETOR-*");

        double[] salariosBruto = new double[5];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < salariosBruto.length; i++) {
            System.out.print("Digite o seu salário: ");
            salariosBruto[i] = input.nextDouble();
        }
        return salariosBruto;
    }

    public static void imprimeSBruto(double[] vetor){
        System.out.print("\n*- IMPRIMINDO SALÁRIO BRUTO -*\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.printf("R$:%.2f | ",vetor[i]);
        }
        System.out.println();
    }
    public static void imprimeSLiquido(double[] vetor){
        System.out.print("\n*- IMPRIMINDO SALÁRIO LÍQUIDO -*\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.printf("\"R$:%.2f | ",vetor[i]);
        }
        System.out.println();
    }
    public static void imprimeInss(double[] vetor){
        System.out.print("\n*- IMPRIMINDO INSS -*\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.printf("\"R$:%.2f | ",vetor[i]);
        }
        System.out.println();
    }
    public static void imprimeIR(double[] vetor){
        System.out.print("\n*- IMPRIMINDO IMPOSTO DE RENDA -*\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.printf("\"R$:%.2f | ",vetor[i]);
        }
        System.out.println();
    }

    public static double[] calculaINSS(double[] salariosBruto){
        System.out.println("\n*- CALCULANDO INSS -*");
        double[] INSS = new double[salariosBruto.length];

        for (int i = 0; i < salariosBruto.length; i++) {
            if (salariosBruto[i] <= 1212.00) {
                INSS[i] = salariosBruto[i] * 0.075;
            } else if (salariosBruto[i] <= 2427.35) {
                double faixa1 = 1212.00 * 0.075;
                double faixa2 = (salariosBruto[i] - 1212.01) * 0.09;
                INSS[i] = faixa1 + faixa2;
            } else if (salariosBruto[i] <= 3641.03) {
                double faixa1 = 1212.00 * 0.075;
                double faixa2 = (2427.35 - 1212.01) * 0.09;
                double faixa3 = (salariosBruto[i] - 2427.36) * 0.12;
                INSS[i] = faixa1 + faixa2 + faixa3;
            } else if (salariosBruto[i] <= 7087.22) {
                double faixa1 = 1212.00 * 0.075;
                double faixa2 = (2427.35 - 1212.01) * 0.09;
                double faixa3 = (3641.03 - 2427.36) * 0.12;
                double faixa4 = (salariosBruto[i] - 3641.04) * 0.14;
                INSS[i] = faixa1 + faixa2 + faixa3 + faixa4;
            } else{
                double faixa1 = 1212.00 * 0.075;
                double faixa2 = (2427.35 - 1212.01) * 0.09;
                double faixa3 = (3641.03 - 2427.36) * 0.12;
                double faixa4 = (7087.22 - 3641.04) * 0.14;
                INSS[i] = faixa1 + faixa2 + faixa3 + faixa4;
            }
        }
        return INSS;
    }

    public static double[] calculaIR (double[] salariosBruto){
        System.out.println("\n*- CALCULANDO IMPOSTO DE RENDA -*");
        double[] impostoRenda = new double[salariosBruto.length];

        for (int i = 0; i < salariosBruto.length; i++) {
            if (salariosBruto[i] >= 4664.69) {
                double faixa1 = (2826.65 - 1903.99) * 0.075;
                double faixa2 = (3751.05 - 2826.66) * 0.15;
                double faixa3 = (4664.68 - 3751.06) * 0.225;
                double faixa4 = (salariosBruto[i] - 4664.68) * 0.275;
                impostoRenda[i] = faixa1 + faixa2 + faixa3 + faixa4;
            } else if (salariosBruto[i] >= 3751.06) {
                double faixa1 = (2826.65 - 1903.99) * 0.075;
                double faixa2 = (3751.05 - 2826.66) * 0.15;
                double faixa3 = (salariosBruto[i] - 3751.06) * 0.225;
                impostoRenda[i] = faixa1 + faixa2 + faixa3;
            } else if (salariosBruto[i] >= 2826.66) {
                double faixa1 = (2826.65 - 1903.99) * 0.075;
                double faixa2 = (salariosBruto[i] - 2826.66) * 0.15;
                impostoRenda[i] = faixa1 + faixa2;
            } else if (salariosBruto[i] >= 1903.99) {
                double faixa1 = salariosBruto[i] * 0.075;
                impostoRenda[i] = faixa1;
            }
        }
        return impostoRenda;
    }

    public static double[] calculaSalario (double[] salariosBruto,double[] descontosINSS,double[] impostoRenda){
        System.out.println("\n*- CALCULANDO SALÁRIO LIQUIDO -*");
        double[] salarioLiquido = new double[salariosBruto.length];
        double salario = 0;
        double inss = 0;
        double ir = 0;

        for (int i = 0; i < salariosBruto.length; i++) {
            salario = salariosBruto[i];
            inss = descontosINSS[i];
            ir = impostoRenda[i];
            for (int j = 0; j < salariosBruto.length; j++){
                salarioLiquido[i] = salario-inss-ir;
            }
        }
        return salarioLiquido;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] salariosBruto = criarVetor();
        double[] descontoINSS = calculaINSS(salariosBruto);
        double[] impostoRenda = calculaIR(salariosBruto);
        double[] salarioliquido = calculaSalario(salariosBruto,descontoINSS,impostoRenda);

        imprimeSBruto(salariosBruto);
        imprimeInss(descontoINSS);
        imprimeIR(impostoRenda);
        imprimeSLiquido(salarioliquido);
    }
}
