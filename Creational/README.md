✅ Singleton Pattern Nedir?
Amaç:

Bir sınıfın sadece bir tane örneği (instance) olsun.

Her yerden bu tek örneğe erişebil.

Nerede kullanılır?

Config nesneleri

Logger sistemleri

Database connection pool

Thread pool

🧩 Nasıl çalışır?
private constructor → Dışarıdan new yapılmasın diye.

static bir değişken → Tek örneği saklar.

public static getInstance() → Tek örneği döndürür.

Spring Bean’lerin varsayılan scope’u Singleton’dır.

Yani sen @Component veya @Service yazarsan Spring bunu Singleton olarak oluşturur ve ApplicationContext üzerinden hep aynı nesneyi döner.

|                | Lazy                                 | Eager               | Thread-safe   |
| -------------- | ------------------------------------ | ------------------- | ------------- |
| **Avantaj**    | Bellek verimli                       | Kolay & basit       | Güvenli       |
| **Dezavantaj** | Dikkatli yazmazsan thread-safe olmaz | Gereksiz yer kaplar | Daha karmaşık |


✅ Factory Pattern Nedir?
Amaç:

Nesne oluşturmayı merkezi hale getirmek — “Neyi new yapacağım?” mantığı Factory içinde.

Client (kullanan kod) sadece interface/abstract class bilir — nasıl oluşturulduğu umurunda olmaz.

Avantaj:
✔ Kod bağımlılığı azalır.
✔ Yeni tipler eklemek kolaylaşır.
✔ Tek sorumluluk ilkesi: Nesne üretme kodu başka yere taşınır.

📌 Basit tanım:
Product: Ortak interface veya abstract class.

ConcreteProduct: Gerçek sınıflar.

Factory: Üretim mantığını barındırır.

✅ Java ile örnek
🎯 Örneğimiz: Hayvan Fabrikası — Dog ve Cat üreten bir AnimalFactory



✅ Abstract Factory Pattern nedir?
Kısa tanım:
Factory Pattern bir ürünün nesnesini yaratır.
Abstract Factory Pattern ise birbiriyle ilişkili ürün ailelerini yaratır.

🔑 Fark ne?
Factory	Abstract Factory
Tek bir ürün yaratır	Ürün aileleri yaratır
Tek bir factory class	Birden fazla factory class
Örn: AnimalFactory	Örn: GUIFactory (WinButton, MacButton, vs.)

📌 Nerede kullanılır?
GUI toolkit’lerde (Windows, MacOS, Linux)

Database driver’larda

Çoklu platform destekleyen uygulamalarda

✅ Mini Senaryo
Örnek: GUI bileşenleri

Ürün ailesi: Button ve Checkbox

İki varyant: Windows ve MacOS



✅ Builder Pattern nedir?
Amaç:

Karmaşık nesneleri adım adım inşa etmek.

Bir constructor’a 10 parametre göndermek yerine, her adımda anlamlı şekilde set etmek.

Immutable (değişmez) nesnelerle harika uyumludur.

Gerçek örnek:

StringBuilder

Lombok @Builder

java.lang.ProcessBuilder

📌 Senaryo: Bir User sınıfı
Bir kullanıcının:

Zorunlu alanları: id, name

Opsiyonel alanları: email, phone

✔ Builder Pattern = karmaşık nesne oluşturmayı adım adım yönetmek.
✔ Okunabilir, genişletilebilir, test edilebilir.
✔ Immutable sınıflarla harika uyumludur.



✅ Prototype Pattern nedir?
Amaç:

Nesnelerin maliyetli new işlemlerini tekrar tekrar yapmak yerine mevcut bir nesneden kopya üretmek.

Özellikle aynı yapıdaki objeler sık sık kopyalanacaksa kullanılır.

Gerçek örnek:

java.lang.Cloneable

clone() metodu

Video oyunu NPC kopyaları

UI taslak (template) bileşenleri

✅ Özellikleri
✔ Nesneler clone() ile klonlanır.
✔ Sık sık tekrar eden nesne yaratımı yerine kopya alınır.
✔ Hafıza ve performans avantajı sağlar.

✨ Örnek Senaryo
Bir Şekil (Shape) sınıfı olsun.
Farklı şekiller (Circle, Rectangle) var.
Her şekil kendisini clone() edebilsin.
