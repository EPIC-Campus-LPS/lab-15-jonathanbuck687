package SeatPackage;

public class Seats {
	private boolean sold;
	private String type;
	private double price;
	public boolean getSold()
	{
		return sold;
	}
	public String getType()
	{
		return type;
	}
	public double getPrice()
	{
		return price;
	}
	public void setSold(boolean b)
	{
		sold = b;
	}
	public void setType(String t)
	{
		type = t;
	}
	public void setPrice(double p)
	{
		price = p;
	}
	public Seats(boolean b, String t, double p)
	{
		sold = b;
		type = t;
		price = p;
	}
}
