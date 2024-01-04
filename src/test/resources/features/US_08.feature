Feature: US08_Urun_Stok_Kontrolu



  @Gratis_US_08
  Scenario: TC01_Urun_Stok_Durumu

    Given Kullanici Gratis ana sayfasina gider
    And Herhangi bir urun kategorisi secer
    And Akilli siralama ile siralar
    And Sayfadaki urunlerden rastgele secer
    Then secilen urunun stok durumunu dogrular
    And Urun ekran kaydini alir
    Then close the application

