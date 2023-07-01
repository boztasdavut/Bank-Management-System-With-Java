package main;

import java.util.Scanner;

public class MemurHesap extends Hesap implements IHesapManager{
	
	public MemurHesap()
	{
		super();
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
		double amount = scanner.nextDouble();
		if(this.bakiye<amount)
		{
			System.out.println("Yetersiz Bakiye");
		}
		else
		{
			if(this.hesapNos.contains(h2.getHesapNo()))
			{
				if(this.sahipAdi.equals(h2.getSahipAdi()))
				{
					System.out.println("Aynı banka hesaplararası transferde ücret alınmamaktadır.");
					System.out.println("Onaylıyorsanız 1, Onaylamıyorsanız 0 tiklayiniz.");
					int controller = scanner.nextInt();
					if(controller == 1)
					{
						this.bakiye = this.bakiye-amount;
						System.out.println("Havale Başarıyla Gerçekleştirildi.");
						h2.setBakiye(h2.getBakiye()+amount);
					}
					else
					{
						System.out.println("Havale gönderimi başarısız.");
					}
				}
				else
				{
					System.out.println("Aynı banka başka bir kişinin hesabına para aktarmak için Memurlarda 0.75kr para kesilmektedir.");
					System.out.println("Onaylıyorsanız 1, Onaylamıyorsanız 0 tiklayiniz.");
					int controller = scanner.nextInt();
					if(controller == 1)
					{
						this.bakiye = this.bakiye-amount-0.75;
						System.out.println("Havale Başarıyla Gerçekleştirildi.");
						h2.setBakiye(h2.getBakiye()+amount);
					}
					else
					{
						System.out.println("Havale gönderimi başarısız.");
					}
				}
			}
			else
			{
				System.out.println("Başka bankaya havale işlemleri için Memurlardan 5TL ücret kesilmektedir.");
				System.out.println("Onaylıyorsanız 1, Onaylamıyorsanız 0 tiklayiniz.");
				int controller = scanner.nextInt();
				if(controller == 1)
				{
					this.bakiye = this.bakiye-amount-5;
					System.out.println("Havale Başarıyla Gerçekleştirildi.");
					h2.setBakiye(h2.getBakiye()+amount);
				}
				else
				{
					System.out.println("Havale gönderimi başarısız.");
				}
			}
			
		}

	}
	

}
