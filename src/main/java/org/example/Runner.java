package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public Runner(){
        System.out.println("-------------Kutuphane Sistemimize Hosgeldiniz-------------");
    }

    public void runnerMain() throws SQLException {
        Books books = new Books();
        Uye uye = new Uye();
        Personel personel = new Personel();
        Scanner input = new Scanner(System.in);
        System.out.println("Kitap islemleri icin 1 \nUye islemleri icin 2 \nPersonel islemleri icin 3 \nCikis yapmak icin 4");
        int choice = input.nextInt();
        if (choice == 1){
            System.out.println("Kitap islemleri \nKitap eklemek icin 1 \nKitap silmek icin 2 \nKitap goruntulemek icin 3 \nButun kitaplari goruntulemek icin 4");
            int choiceKitap = input.nextInt();
            if (choiceKitap == 1){
                System.out.println("Barkod numarasi giriniz");
                int barkodNo = input.nextInt();
                System.out.println("Kitap adi giriniz");
                input.nextLine();
                String kitapAdi = input.nextLine();
                System.out.println("Yazar ismi giriniz");
                String yazarAdi = input.nextLine();
                System.out.println("Kitabin sayfa sayisi giriniz");
                int sayfaSayisi = input.nextInt();
                books.kitapEkle(barkodNo,kitapAdi,yazarAdi,sayfaSayisi);
                runnerMain();
            } else if (choiceKitap == 2){
                books.butunKitaplariGoruntule();
                System.out.println("Silmek istediginiz kitabin barkod numarasini giriniz");
                int barkodNo = input.nextInt();
                books.kitapSil(barkodNo);
                runnerMain();
            } else if (choiceKitap == 3) {
                System.out.println("Kitab adi giriniz");
                input.nextLine();
                String kitabAdi = input.nextLine();
                books.kitapGoruntule(kitabAdi);
                runnerMain();
            } else if (choiceKitap == 4) {
                books.butunKitaplariGoruntule();
                runnerMain();
            } else {
                System.out.println("Yanlis numara girdiniz...");
                runnerMain();
            }
        } else if (choice == 2) {
            System.out.println("Uye islemleri \nUye eklemek icin 1 \nUye silmek icin 2 \nUye goruntulemek icin 3 \nButun uyeleri goruntulemek icin 4");
            int uyeChoice = input.nextInt();
            if (uyeChoice == 1){
                System.out.println("TC giriniz");
                int tcNo = input.nextInt();
                System.out.println("Uye adi giriniz");
                input.nextLine();
                String uyeAdi = input.nextLine();
                System.out.println("Uye Soyadi giriniz");
                String uyeSoyadi = input.nextLine();
                System.out.println("Uye numarasi giriniz");
                int uyeNo = input.nextInt();
                uye.uyeEkle(tcNo,uyeAdi,uyeSoyadi,uyeNo);
                runnerMain();
            } else if (uyeChoice == 2) {
                uye.butunUyeleriGoruntule();
                System.out.println("Silmek istediginiz uyenin tc giriniz");
                int tcNo = input.nextInt();
                uye.uyeSil(tcNo);
                runnerMain();
            } else if (uyeChoice == 3) {
                System.out.println("Uye adi giriniz");
                input.nextLine();
                String uyeAdi = input.nextLine();
                uye.uyeGoruntule(uyeAdi);
                runnerMain();
            } else if (uyeChoice == 4) {
                uye.butunUyeleriGoruntule();
                runnerMain();
            } else {
                System.out.println("Yanlis numara girdiniz...");
                runnerMain();
            }
        } else if (choice == 3) {
            System.out.println("Personel islemleri \nPersonel eklemek icin 1 \nPersonel silmek icin 2 \nPersonel goruntulemek icin 3 \nButun personelleri goruntulemek icin 4\n" +
                    "Personele zam yapmak icin 5");
            int personelChoice = input.nextInt();
            if (personelChoice == 1){
                System.out.println("TC giriniz");
                int tcNo = input.nextInt();
                System.out.println("Personel adi giriniz");
                input.nextLine();
                String personelAdi = input.nextLine();
                System.out.println("Personel Soyadi giriniz");
                String personelSoyadi = input.nextLine();
                System.out.println("Personel maasi giriniz");
                int personelMaas = input.nextInt();
                System.out.println("Persoenl yasi giriniz");
                int personelyas = input.nextInt();
                personel.personelEkle(tcNo,personelAdi,personelSoyadi,personelMaas,personelyas);
                runnerMain();
            } else if (personelChoice == 2) {
                personel.butunPersonelleriGoruntule();
                System.out.println("Silmek istediginiz personelin tc giriniz");
                int tcNo = input.nextInt();
                personel.personelSil(tcNo);
                runnerMain();
            } else if (personelChoice == 3) {
                System.out.println("Personel adi giriniz");
                input.nextLine();
                String personelAdi = input.nextLine();
                personel.personelGoruntule(personelAdi);
                runnerMain();
            } else if (personelChoice == 4) {
                personel.butunPersonelleriGoruntule();
                runnerMain();
            } else if (personelChoice == 5) {
                personel.butunPersonelleriGoruntule();
                System.out.println("Maasina zamn yapmak istedigin personelin tc giriniz");
                int tcNo = input.nextInt();
                System.out.println("Maasina zamn yapmak istedigin personelin zam miktarini giriniz");
                int zamMiktari = input.nextInt();
                personel.personelMaasZam(tcNo,zamMiktari);
                personel.butunPersonelleriGoruntule();
                runnerMain();
            }else {
                System.out.println("Yanlis numara girdiniz...");
                runnerMain();
            }
        } else if (choice == 4) {
            System.out.println("Gule Gule...");
        }
    }

}
