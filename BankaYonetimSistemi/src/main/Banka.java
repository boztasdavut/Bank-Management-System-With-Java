package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Banka {
	private static ArrayList<Musteri> totalMusteriListesi = new ArrayList<Musteri>();
	public Musteri yeniMusteriEkle()
	{
		Scanner scanner = new Scanner(System.in);
		Musteri m = new Musteri();
		System.out.println("Musteri Adi Girin: ");
		String musteriName = scanner.next();
		m.setMusteriAdi(musteriName);
		
		System.out.println("Musteri Soyadi Girin: ");
		String musteriSurname = scanner.next();
		m.setMusteriSoyadi(musteriSurname);
		
		System.out.println("Musteri Tc Girin: ");
		String musteriTc = scanner.next();
		m.setMusteriTcNo(musteriTc);
		boolean kayitli = false;
		for(Musteri musteri : totalMusteriListesi)
		{
			if(musteri.getMusteriTcNo().equals(musteriTc))
			{
				System.out.println("Bu TC Numarali Musteri Sistemde Zaten Kayitli");
				kayitli = true;
				break;
			}
		}
		if(!kayitli)
		{
			totalMusteriListesi.add(m);
			return m;
		}
		
		
		return null;
	}
	public void musteriSil(Musteri m)
	{
		Scanner scanner = new Scanner(System.in);
		if(m.musteriHesabiVarMi())
		{
			System.out.println("Silmek istedigin musterinin kayıtlı hesapları bulunmaktadır.");
			System.out.println("Odemeler yapıldıktan sonra 'Onaylandı' yazarak musteriyi silebilirsiniz.");
			String message = scanner.next();
			if(message.equals("Onaylandı"))
			{
				System.out.println("Musteri Basariyla Silindi");
				totalMusteriListesi.remove(m);
			}
			
		}
		else
		{
			System.out.println("Musterinin Kayıtlı Hesabı Bulunmamaktadır.");
			System.out.println("Musteriyi Silmek İcin Ekrana 'Onaylandı' yazınız.");
			String message = scanner.next();
			if(message == "Onaylandı")
			{
				System.out.println("Musteri Basariyla Silindi");
				totalMusteriListesi.remove(m);
			}
			
		}
	}
	public static void totalMusteriListesiGoster()
	{
		for(int i =0; i<totalMusteriListesi.size(); i++)
		{
			System.out.println(totalMusteriListesi.get(i).getMusteriAdi());
			System.out.println(totalMusteriListesi.get(i).getMusteriSoyadi());
			System.out.println(totalMusteriListesi.get(i).getMusteriTcNo());
		}
	}
	public static Musteri istenenMusteriyeGit(String tc)
	{
		for(int i =0; i<totalMusteriListesi.size(); i++)
		{
			if(totalMusteriListesi.get(i).getMusteriTcNo().equals(tc))
			{
				return totalMusteriListesi.get(i);
			}
		}
		return null;
		
	}
	
	
	 
	

}
