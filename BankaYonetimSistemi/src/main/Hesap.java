package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hesap {
	protected String hesapNo;
	protected String sahipAdi;
	protected String sahipSoyadi;
	protected String sahipTc;
	protected double bakiye;
	protected int hesapKontrol;
	Scanner scanner = new Scanner(System.in);
	protected static ArrayList<String> hesapNos = new ArrayList<String>();
	//Constructor
	public Hesap()
	{
		while(true)
		{
			Random random = new Random();
			String ilkUc = Integer.toString(random.nextInt(100,200));
			String ikinciUc = Integer.toString(random.nextInt(200,300));
			String ucuncuUc = Integer.toString(random.nextInt(300,400));
			String dorduncuUc = Integer.toString(random.nextInt(400,500));
			String besinciUc = Integer.toString(random.nextInt(500,600));
			String total = ilkUc+ikinciUc+ucuncuUc+dorduncuUc+besinciUc;
			if(hesapNos.contains(total)==false)
			{
				hesapNos.add(total);
				this.hesapNo = total;
				break;
			}
		}
		this.bakiye = 0;	
	}
	public Hesap(String s)
	{
		this.sahipAdi = s;
	}
	
	public void paraYatir()
	{
		System.out.println("Para Yatirmak istediginiz Tutari Girin: ");
		double yatirilanTutar = scanner.nextDouble();
		this.bakiye = this.bakiye+yatirilanTutar;
	}
	public void paraCek()
	{
		System.out.println("Cekmek istediginiz tutari girin: ");
		double cekilenTutar = scanner.nextDouble();
		this.bakiye = this.bakiye-cekilenTutar;
	}
	
	public void havaleYap(Hesap h2)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gonderim tutarini girin: ");
		int amount = scanner.nextInt();
		if(hesapNos.contains(h2.getHesapNo()))
		{
			if(h2.getSahipAdi().equals(this.sahipAdi))
			{
				System.out.println("Hesaplararası bizim bankamızdan transferde ücret alınmamaktadır.!!");
			}
			else
			{
				System.out.println("Banka içi havalede ücret kesilmektedir.");
				
			}
		}
		
		else
		{
			System.out.println("Başka bankaya havale işleminde 5TL ücret kesilmektedir.!!");
			System.out.println("Onaylıyorsanız 1'e Tıklayınız. Onaylamıyorsanız 0'a tıklayınız.");
		}
		System.out.println("Onaylıyorsanız 1'e Tıklayınız. Onaylamıyorsanız 0'a tıklayınız.");
		int onay = scanner.nextInt();
		if(onay==1)
		{
			System.out.println("Para Gönderim İşlemi Onaylandı.");
			this.bakiye = this.bakiye-amount;
			
		}
		else
		{
			System.out.println("Para Gonderim islemi Onaylanmadi");
		}
	}
	
	
	//Encapsulation
	public String getHesapNo()
	{
		return this.hesapNo;
	}
	public String getSahipAdi()
	{
		return this.sahipAdi;
	}
	public void setSahipAdi(String verilenDeger)
	{
		this.sahipAdi = verilenDeger;
	}
	public void setSahipSoyadi(String s)
	{
		this.sahipSoyadi = s;
	}
	public String getSahipSoyadi()
	{
		return this.sahipSoyadi;
	}
	public String getSahipTc()
	{
		return this.sahipTc;
	}
	public void setSahipTc(String s)
	{
		this.sahipTc = s;
	}
	public double getBakiye()
	{
		return this.bakiye;
	}
	public void setBakiye(double verilenDeger)
	{
		this.bakiye = verilenDeger;
	}
	public static void getHesapNos()
	{
		for(int i =0; i<hesapNos.size(); i++)
		{
			System.out.println(hesapNos.get(i));
		}
	}
}
