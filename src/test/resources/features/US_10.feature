@Gratis_US_10
Feature: US_10_Favori_Urunlerim


  Scenario: Hesaba giris

          Given Kullanici Gratis ana sayfasina gider
          When Giris yap butonuna tiklar
          And Gecerli "necmettinkaradeli@gmail.com" girer
          And Gecerli "Necminson.38" bilgisini girer
          And Giris yap kutusuna tiklar

  Scenario: TC_01 Kullanıcı "Favori Listelerim" modülüne giriş yapar
          Given kullanici Favori Listelerim sayfasina gider
          Then Favori Listelerim sayfasina gittigini dogrular

  Scenario: TC_02 Kullanıcı "Favori Listelerim" modülünde bir liste oluşturur
          Given Kullanici Yeni istek listesi acilir butonuna tiklar.
          When Acilan Yeni istek listesi sekmesini tiklar.
          And Acilan cercevede Adi kutusuna "Traş Malzemesi" yazar.
          And Uc farkli gizlilik ayarindan birini secer.
          And Ekle butonuna tiklar.
          Then Yeni listenin olusturuldugunu dogrular

  Scenario: TC_03_02 Kullanıcı "Favori Listelerim" modülünde bir liste oluşturur
          Given Alisverise Basla butonunu tiklar
          Then Butun ururnlerin listelendigi sayfanin acildigini dogrular
          When Sayfadaki urunlerden rastgele secer
          And Favoriye ekle butonunu tiklar
          And Acilan  cercevede'Istek listesi secin' acilir butonundan bir istek listesine tiklar
          And Ekle butonuna tiklar.
          And kullanici Favori Listelerim sayfasina gider
          Then Urunun favori listesine eklendigini dogrular
