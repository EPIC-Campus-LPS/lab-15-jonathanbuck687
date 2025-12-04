package SeatPackage;

public class Seats {
	private static boolean sold;
	private static String type;
	private static double price;
	public static boolean getSold()
	{
		return sold;
	}
	public static String getType()
	{
		return type;
	}
	public static double getPrice()
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
