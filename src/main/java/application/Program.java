package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.*;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre os dados do contrato: ");
        System.out.print("Número: ");
        int numero = resp.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(resp.next(), fmt1);

        System.out.print("Valor do contrato: ");
        double valor = resp.nextDouble();

        Contrato contrato = new Contrato(numero, data, valor);

        System.out.print("Digite o número de parcelas: ");
        int meses = resp.nextInt();

        System.out.println("Parcelas: ");

        ContractService servico = new ContractService(new PaypalService());
        servico.processContract(contrato, meses);
        for (Parcelas p : servico.getListaParcelas()){
            System.out.println(p.toString());
        }

    }
}
