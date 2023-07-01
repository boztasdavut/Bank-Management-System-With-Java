package main;

import java.util.ArrayList;

public class Musteri {
	private String musteriAdi = "";
	private String musteriSoyadi = "";
	private String musteriTcNo = "";
	public  ArrayList<Hesap> musteriHesaplarListesi = new ArrayList<Hesap>();
	
	
	//Encapsulation
	public void setMusteriAdi(String s)
	{
		this.musteriAdi = s;
	}
	public String getMusteriAdi()
	{
		return this.musteriAdi;
	}
	
	public void setMusteriSoyadi(String s)
	{
		this.musteriSoyadi = s;
	}
	public String getMusteriSoyadi()
	{
		return this.musteriSoyadi;
	}
	
	public void setMusteriTcNo(String s)
	{
		this.musteriTcNo = s;
	}
	public String getMusteriTcNo()
	{
		return this.musteriTcNo;
	}
	
	public void musteriyeBirHesapTanimla(Hesap h)
	{
		if(this.musteriAdi == "" || this.musteriSoyadi == "" || this.musteriTcNo == "")
		{
			System.out.println("EKSIK BILGISI OLAN BIR MUSTERIYE HESAP TANIMLANAMAZ");
		}
		else
		{
			h.setSahipAdi(this.musteriAdi);
			h.setSahipSoyadi(this.musteriSoyadi);
			h.setSahipTc(this.musteriTcNo);
			musteriHesaplarListesi.add(h);
		}
	}
	
	public void musteriHesaplariGetir()
	{
		if(musteriHesaplarListesi.size()==0)
		{
			System.out.println("Musteriye Ait Bir Hesap Bulunamadi");
		}
		else
		{
			for(int i =0; i<musteriHesaplarListesi.size(); i++)
			{
				System.out.println("Hesap No: "+musteriHesaplarListesi.get(i).getHesapNo());
				System.out.println("Hesap Bakiye: "+musteriHesaplarListesi.get(i).getBakiye());
				System.out.println("Hesap Sahibi Adi: "+musteriHesaplarListesi.get(i).getSahipAdi());
				System.out.println("Hesap Sahibi Soyadi: "+musteriHesaplarListesi.get(i).getSahipSoyadi());
				System.out.println("Hesap Sahibi Tc No: "+musteriHesaplarListesi.get(i).getSahipTc());
			}
		}	
		
	}
	
	public Hesap musteriBelirlenenHesabaGit(String hesapNo)
	{
		boolean hesapVarMi = false;
		for(int i =0; i<musteriHesaplarListesi.size(); i++)
		{
			if(musteriHesaplarListesi.get(i).getHesapNo().equals(hesapNo))
			{
				hesapVarMi = true;
				return musteriHesaplarListesi.get(i);
			}
		}
		if(hesapVarMi == false)
		{
			System.out.println("Musterinin Boyle Bir Hesabi Bulunamadi");
			return null;
		}
		return null;
		
		
	}
	public boolean musteriHesabiVarMi()
	{
		if(this.musteriHesaplarListesi.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
