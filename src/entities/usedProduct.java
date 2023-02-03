package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class usedProduct extends Product {
	private Date manufactureDate;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public usedProduct() {

	}

	public usedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	@Override
	public String priceTag() {
		return name + " (used) $ " + String.format("%.2f", price) + " (Manufacture date: " + sdf.format(manufactureDate) + ")";
	}
}
