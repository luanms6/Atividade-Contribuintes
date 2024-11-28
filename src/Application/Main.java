package Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Company;
import Entities.Individual;
import Entities.TaxPayer;

public class Main{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

         for (int i = 1; i <= n; i++) {
            System.out.println("Taxpayer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0.0;
        for (TaxPayer tp : taxPayers) {
            double tax = tp.tax();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            totalTaxes += tax;
        }

        System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", totalTaxes));

        sc.close();
    }       
}