package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.usedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("Product #%d data:\n", i + 1);
			System.out.print("Common, used or imported? (c/u/i)? ");
			char type = sc.next().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (type == 'i') {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				price += fee;
				Product product = new ImportedProduct(name, price, fee);
				products.add(product);

			}

			if (type == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());

				Product product = new usedProduct(name, price, manufactureDate);
				products.add(product);
			}

			if (type == 'c') {
				Product product = new Product(name, price);
				products.add(product);
			}

		}
		
		System.out.println("PRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

}
