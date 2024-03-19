package ders5;

import java.util.Scanner;

public class homework {

	public static void main(String[] args) {
		Scanner giris = new Scanner(System.in);
		System.out.println("Kişi Sayısını Giriniz :");
		int ks = giris.nextInt();
		String ad[] = new String[ks];
		String cnsyt[] = new String[ks];
		String mdn[] = new String[ks];
		byte yas[] = new byte[ks];
		int maas[] = new int[ks];
		byte menu;

		for (int i = 0; i < ks; i++) {
			System.out.println("Kişinin İsmini Giriniz : ");
			ad[i] = giris.next();
			System.out.println("Kişinin Cinsiyetini Giriniz : ");
			cnsyt[i] = giris.next();
			while (!cnsyt[i].equalsIgnoreCase("erkek") && !cnsyt[i].equalsIgnoreCase("kadın")) {
				System.out.println("Geçersiz cinsiyet bilgisi! Lütfen tekrar giriniz (erkek/kadın): ");
				cnsyt[i] = giris.next();
			}
			System.out.println("Kişinin Medeni Durumunu Giriniz (evli/bekar): ");
			mdn[i] = giris.next();
			while (!mdn[i].equalsIgnoreCase("evli") && !mdn[i].equalsIgnoreCase("bekar")) {
				System.out.println("Geçersiz medeni durum bilgisi! Lütfen tekrar giriniz (evli/bekar): ");
				mdn[i] = giris.next();
			}
			System.out.println("Kişinin Yaşını Giriniz : ");
			yas[i] = giris.nextByte();
			System.out.println("Kişinin Maaşını Giriniz : ");
			maas[i] = giris.nextInt();
		}
		for (;;) {
			System.out.println("1-Listeleme\n2-İsim Arama\n3-Evlilerin Maaş Ortalaması"
					+ "\n4-Erkeklerin Yaş Ortalaması\n5-En Büyük Maaşlı Kadın Bilgisi\n6-En Küçük Yaş Kime Ait\n7-Çıkış");
			menu = giris.nextByte();
			switch (menu) {
			case 1:
				for (int i = 0; i < maas.length; i++) {
					System.out.println("Adı : " + ad[i]);
					System.out.println("Cinsiyeti : " + cnsyt[i]);
					System.out.println("Medeni Durumu : " + mdn[i]);
					System.out.println("Yaşı : " + yas[i]);
					System.out.println("Maaşı : " + maas[i] + " " + "TL");
				}

				break;

			case 2:
				System.out.println("Aranacak adı giriniz : ");
				String arananAd = giris.next();
				for (int i = 0; i < maas.length; i++) {
					if (arananAd.equalsIgnoreCase(ad[i])) {
						System.out.println("Adı : " + ad[i]);
						System.out.println("Cinsiyeti : " + cnsyt[i]);
						System.out.println("Medeni Durumu : " + mdn[i]);
						System.out.println("Yaşı : " + yas[i]);
						System.out.println("Maaşı : " + maas[i] + " " + "TL");
					}
				}
				break;
			case 3:
				int evliMaasToplami = 0;
				int evliSayisi = 0;
				for (int i = 0; i < ks; i++) {
					if (mdn[i].equalsIgnoreCase("evli")) {
						evliSayisi++;
						evliMaasToplami += maas[i];
					}
				}
				double evlilerinMaasOrtlamasi = (double) evliMaasToplami / evliSayisi;
				System.out.println("Evli kişilerin ortlama maaşı: " + evlilerinMaasOrtlamasi + " " + "TL");
				break;
			case 4:
				byte erkekSayisi = 0;
				byte erkeklerinYasToplami = 0;
				for (int i = 0; i < ks; i++) {
					if (cnsyt[i].equalsIgnoreCase("erkek")) {
						erkekSayisi++;
						erkeklerinYasToplami += yas[i];
					}
				}
				float erkeklerinYasOrtalamasi = (float) erkeklerinYasToplami / erkekSayisi;
				System.out.println("Erkeklerin yaş ortalaması: " + erkeklerinYasOrtalamasi);
				break;
			case 5:
				int enBuyukMaas = Integer.MIN_VALUE;
				String enBuyukMaasliKadin = "";

				for (int i = 0; i < ks; i++) {
					if (cnsyt[i].equalsIgnoreCase("kadın")) {
						if (maas[i] > enBuyukMaas) {
							enBuyukMaas = maas[i];
							enBuyukMaasliKadin = ad[i];
						}
					}
				}

				if (!enBuyukMaasliKadin.isEmpty()) {
					System.out.println("En büyük maaşlı kadın: " + enBuyukMaasliKadin + ", Maaşı: " + enBuyukMaas);
				} else {
					System.out.println("Kadın kaydı bulunamadı.");
				}
				break;
			case 6:
				byte enKucukYas = yas[0]; 
				String enKucukYasliKisi = ad[0]; 

				for (int i = 1; i < ks; i++) {
					if (yas[i] < enKucukYas) {
						enKucukYas = yas[i];
						enKucukYasliKisi = ad[i];
					}
				}

				System.out.println("En küçük yaşlı kişi: " + enKucukYasliKisi + ", Yaşı: " + enKucukYas);
				break;
			case 7:
				System.out.println("Program Bitti");
				giris.close();
				System.exit(0);
				break;
			default:
				System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
				break;
			}

		}
	}
}