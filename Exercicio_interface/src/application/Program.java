package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contracts;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the contract data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();

		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());

		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();

		Contracts contract = new Contracts(number, date, contractValue);

		ContractService cs = new ContractService(new PaypalService());// INJEÇÃO DE DEPENDENCIA USANDO CONSTRUTOR - é de
																		// controle do
																		// programa principal escolher qual serviço(paypalService) deve
																		// ser instanciado.
		System.out.print("Enter the number of the installments: ");
		int N = sc.nextInt();
		
		cs.proccessContract(contract, N);
		
		System.out.println("Installments: ");
		for (Installment it: contract.getInstallments()) {
			System.out.println(it);
		}
	}

}
