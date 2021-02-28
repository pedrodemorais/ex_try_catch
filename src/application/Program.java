package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = input.nextInt();
		input.nextLine();
		
		System.out.print("Holder: ");
		String holder = input.nextLine();
		
		System.out.print("Initial balance: ");
		Double balanceInitial = input.nextDouble();
		
		System.out.println("Withdraw limit: ");
		Double withdrawLimit = input.nextDouble();
		
		Account account = new Account(number, holder, balanceInitial, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		Double amount = input.nextDouble();
		
		account.withdraw(amount);
		System.out.println("New balance: "+account.getBalance());
		}
		catch(DomainExceptions e) {
			System.out.println("Erro inesperado - "+e.getMessage());
			
		}
		catch(InputMismatchException e) {
			System.out.println("Formato Inválido - Digitar somente números!");
		}
		catch (Exception e) {
			System.out.println("Erro Inesperado!");
		}

		input.close();
	}

}
