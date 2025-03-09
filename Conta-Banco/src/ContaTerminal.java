import java.text.DecimalFormat;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {

        String NUMERO = "";
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        boolean f2 = true;

        int numero = 0;
        String agencia = "";
        String nomeSobrenome = "";
        double saldo = 0.0;

        while (true) {

            if (!isValid(agencia, f) && f == true) {
                System.out.println("Por favor, digite o número da Conta !");
                String input = String.valueOf(numero);
                input = scanner.nextLine();
                NUMERO = input;
                if (isValid(NUMERO, f)) {
                    System.out.println("Usuário: " + NUMERO);
                    f = false;
                } else {
                    System.out.println("Erro: O número deve ter exatamente 4 dígitos no formato 0000.");
                    continue;
                }
            }
            if (f == false && f2 == true) {
                System.out.println("Digite a agencia: ");
                agencia = scanner.nextLine();
                if (isValid(agencia, f)) {
                    System.out.println("Agencia válida: " + agencia);
                    f2 = false;
                } else {
                    System.out.println("A agência deve conter apenas números no formato 000-0.");
                    f = false;
                    continue;
                }
            }
            if (f2 == false) {
                System.out.println("Digite nome sobrenome");
                nomeSobrenome = scanner.nextLine();
                if (isValid(nomeSobrenome, f2)) {
                    System.out.println("Nome e sobrenome válidos: " + nomeSobrenome);
                    f = false;
                } else {
                    System.out.println("Erro: O nome e sobrenome devem conter apenas letras.");
                    f2 = false;
                    continue;
                }
                if (f == false) {
                    System.out.println("Digite o saldo: ");
                    saldo = scanner.nextDouble();
                    if (isValid(String.valueOf(saldo), f2)) {
                        String saldoFormatado = String.format("%.2f", saldo);
                        System.out.println("Olá:");
                        System.out.println("Nome: " + nomeSobrenome);
                        System.out.println("Sua Agência é: " + agencia);
                        System.out.println("Número da Conta: " + NUMERO);
                        System.out.println("Saldo: R$ " + saldoFormatado);
                        System.out.println("Já está disponível para saque.");
                        break;
            }
            scanner.close();
        }
    }
        }
    }
    public static boolean isValid(String str, boolean f2) {
        try {
            if (str.matches("^\\d{4}$") && f2 == true) {
                Long.parseLong(str.replace("-", "")); // Remover hífen antes de tentar converter
                return true;
            }
            if (str.matches("^\\d{3}-\\d$")) {
                return true;
            }
            if (str.matches("^[A-Za-z\\s]+$") && str.length() > 8) {
                return true;
            }
            if (str.matches("^[+-]?\\d+\\.\\d+$")) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false; 
        }
        return false;
    }
}