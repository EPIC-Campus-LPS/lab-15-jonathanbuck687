package SeatPackage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Venue {
	private Seats[][] Seat;
	public Venue(int row, int col, double price) throws IOException
	{
		Seats[][] s = new Seats[row][col];
		Seat = s;
		for (int i = 0; i < Seat.length; i++)
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
				Seat[i][j] = new Seats(false, "G", price);
			}
		}
		
	}
	public boolean buyTicket(int row, int col)
	{
		if (Seat[row][col].getSold() == true)
		{
			return false;
		}
		Seat[row][col].setSold(true);
		return true;
	}
	public boolean isAvaliable(int row, int col)
	{
		if (Seat[row][col].getSold() == true)
		{
			return false;
		}
		return true;
	}
	public void setPremium(int row, double price)
	{
		for (int i = 0; i < Seat[row].length; i++)
		{
			Seat[row][i].setType("P");
			Seat[row][i].setPrice(price);
		}
	}
	public void setPremium(int row, int colStart, int colEnd, double price)
	{
		for (int i = colStart; i < colEnd; i++)
		{
			Seat[row][i].setType("P");
			Seat[row][i].setPrice(price);
		}
	}
	public void setGA(int row, double price)
	{
		for (int i = 0; i < Seat[row].length; i++)
		{
			Seat[row][i].setType("G");
			Seat[row][i].setPrice(price);
		}
	}
	public boolean importTickets(String filename) throws IOException
	{
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		int i = 0;
		int j = 0;
		String[] s = new String[2];
		while (sc.hasNextLine())
		{
			//System.out.println(sc.nextLine());
			s = sc.nextLine().split(",");
			i = Integer.parseInt(s[0]);
			j = Integer.parseInt(s[1]);
			Seat[i][j].setSold(true);
		}
		return true;
		
	}
	public double totalRevenue()
	{
		int sum = 0;
		for (int i = 0; i < Seat.length; i++)	
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
				if (Seat[i][j].getSold() == true)
				{
					sum += Seat[i][j].getPrice();
				}
			}
		}
		sum += 25;
		return sum;
	}
	public double totalRevenue(int col)
	{
		int sum = 0;
		for (int i = 0; i < Seat.length; i++)
		{
			if (Seat[i][col].getSold() == true)
			{
				sum += Seat[i][col].getPrice();
			}
		}
		return sum;
	}
	public int totalSold()
	{
		int count = 0;
		for (int i = 0; i < Seat.length; i++)
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
				if (Seat[i][j].getSold() == true)
				{
					count++;
				}
			}
		}
		return count;
	}
	public int totalSold(int row)
	{
		int count = 0;
		for (int j = 0; j < Seat[row].length; j++)
		{
			if (Seat[row][j].getSold() == true)
			{
				count++;
			}
		}
		return count;
	}
	public void printVenue()
	{
		for (int i = 0; i < Seat.length; i++)
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
				if (Seat[i][j].getSold() == true)
				{
					System.out.print(i + ", " + j + " : Sold");
				}
				else
				{
					System.out.print(i + ", " + j + " : Not Sold");
				}
			}
		}
	}
	public void printVenueType()
	{
		for (int i = 0; i < Seat.length; i++)
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
				if (Seat[i][j].getType().equals("R"))
				{
					System.out.print(i + ", " + j + " : Regular Seat");
				}
				else if (Seat[i][j].getType().equals("G"))
				{
					System.out.print(i + ", " + j + " : General Admissions Seat");
				}
				else if (Seat[i][j].getType().equals("P"))
				{
					System.out.print(i + ", " + j + " : Premium Seat");
				}
			}
		}
	}
	public void printVenuePrice()
	{
		for (int i = 0; i < Seat.length; i++)
		{
			for (int j = 0; j < Seat[i].length; j++)
			{
					System.out.print(i + ", " + j + " : " + Seat[i][j].getPrice());
				
			}
		}
	}
	public double maxPrice(int rowStart, int rowEnd, int colStart, int colEnd)
	{
		double max = -1;
		for (int i = rowStart; i < rowEnd; i++)
		{
			for (int j = colStart; j < colEnd; j++)
			{	
				if (max < Seat[i][j].getPrice()) {
					max = Seat[i][j].getPrice();
				}
				
			}
		}
		return max;
	}
	public boolean containsGA(int row)
	{
		boolean contain = true;
		for (int j = 0; j < Seat[row].length; j++)
		{
			if (!Seat[row][j].getType().equals("G"))
			{
				contain = false;
			}
			
		}
		return contain;
	}
	public boolean allPremium(int col)
	{
		boolean bean = true;
		for (int j = 0; j < Seat.length; j++)
		{
			if (Seat[j][col].getType().equals("P"))
			{
				bean = bean;
			}
			else
			{
				bean = false;
			}
			
		}
		if (bean)
		{
			return true;
		}
		return false;
	}
	
}
