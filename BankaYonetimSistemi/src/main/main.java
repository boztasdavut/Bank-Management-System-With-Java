package main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		System.out.println("BANKA YONETIM UYGULAMASINA HOSGELDINIZ");
		System.out.println("WELCOME TO THE BANK MANAGEMENT SYSTEM.");
		Scanner scanner = new Scanner(System.in);
		Banka b = new Banka();
		int controller;
		while(true)
		{
			System.out.println("Yeni Bir Musteri Eklemek İçin 1 Tıklayınız.");
			System.out.println("Bir Musteri Kaydi Silmek Icin 2 Tıklayınız.");
			System.out.println("Bir Musteri ve Hesaplarını Bulmak İçin 3 Tıklayınız.");
			System.out.println("Total Musterileri Bulmak İcin 4 Tıklayınız.");
			System.out.println("Bir Musteriye Yeni Hesap Acmak İcin 5 Tıklayınız.");
			System.out.println("Bir Hesaba Para Yatirmak İcin 6 Tiklayiniz.");
			System.out.println("Bir Hesaptan Para Çekmek İcin 7 Tiklayiniz.");
			controller = scanner.nextInt();
			if(controller == 1)
			{
				
				Musteri m = b.yeniMusteriEkle();
			}
			else if(controller == 2)
			{
				Musteri s = new Musteri();
				System.out.println("Silmek istediginiz musterinin ismini girin: ");
				String temp = scanner.next();
				System.out.println("Silmek istediginiz musterinin soyadini girin: ");
				temp = scanner.next();
				System.out.println("Silmek istediginiz musterinin Tc Girin: ");
				temp = scanner.next();
				s = b.istenenMusteriyeGit(temp);
				
				b.musteriSil(s);
			}
			else if(controller == 3)
			{
				
				 System.out.println("Incelemek istediginiz musterinin Tc girin: ");
				 String a = scanner.next();
				 Musteri m = Banka.istenenMusteriyeGit(a);
				 if(m != null)
				 {
					 m.musteriHesaplariGetir();
				 }
				 else
				 {
					 System.out.println("Bu Tc'ye Ait Bir Müşteri Bulunamadi");
				 }
				 
			}
			else if(controller == 4)
			{
				Banka.totalMusteriListesiGoster();
			}
			else if(controller == 5)
			{
				System.out.println("Yeni Hesap Acmak istediginiz musterinin Tc girin: ");
				String a = scanner.next();
				Musteri m = Banka.istenenMusteriyeGit(a);
				m.musteriyeBirHesapTanimla(new Hesap());
				System.out.println("Hesap Basariyla Oluşturuldu.");
			}
			else if(controller == 6)
			{
				System.out.println("Para Yatirmak Istediginiz Hesabın Sahibinin Tc Girin: ");
				String a = scanner.next();
				Musteri m = Banka.istenenMusteriyeGit(a);
				
				m.musteriHesaplariGetir();
				if(m.musteriHesaplarListesi.size()!=0)
				{
					System.out.println("Musterinin Para Yatirmak Istediginiz Hesap No Girin: ");
					String f = scanner.next();
					Hesap h = m.musteriBelirlenenHesabaGit(f);
					if(h == null)
					{
						System.out.println("Lutfen Girdiginiz Hesap No'yu Kontrol Ediniz.");
					}
					else
					{
						h.paraYatir();
					}
				}
				
				
					
				
			}
			else
			{
				System.out.println("Menüde geçerli bir değer girmediniz.");
			}
		}
		
		
		
		
	}

}
