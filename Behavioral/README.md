✅ Observer Pattern nedir?
Amaç:

Bir nesne değiştiğinde ona bağlı olan diğer nesnelere otomatik bildirim gitmesini sağlamak.

Publisher-Subscriber (Yayıncı-Abone) mantığı.

OOP’de Loose Coupling: Publisher, subscriber’ların kim olduğunu bilmez.

📌 Gerçek hayattan örnek
E-posta bülteni: Bir kullanıcı abone olur, yeni haber gelince mail alır.

Event dinleyiciler: GUI butona tıklayınca listener tetiklenir.

Spring ApplicationEventPublisher → Observer mantığıdır.

🎯 Senaryo
Kanal → Aboneler

Channel (Subject): Video yükler, tüm aboneleri haberdar eder.

Subscriber (Observer): Yeni video yayınlandığında bildirim alır.


✅ Strategy Pattern nedir?
Amaç:

Bir algoritmayı bir ailenin içine koymak ve runtime’da dinamik olarak değiştirmek.

Algoritmayı nesneye sar → kod karmaşasını if-else veya switch ile boğma.

📌 Gerçek hayat örneği
Farklı ödeme yöntemleri (kredi kartı, Paypal, Bitcoin).

Farklı sıralama algoritmaları (QuickSort, MergeSort).

Sıkıştırma stratejileri (Zip, Rar).

🎯 Senaryo
Bir alışveriş sepeti düşün:

Farklı ödeme stratejileri: Kredi kartı veya PayPal.

İstediğin stratejiyle checkout yap.


✅ Command Pattern nedir?
Amaç:

Bir isteği (komutu) nesneye sar → komutu parametre olarak aktar, sırala, kaydet veya geri al.

Komut gönderici (Invoker), komutun nasıl çalıştığını bilmez → Loose Coupling.

📌 Gerçek hayattan örnek
Uzaktan kumanda düğmesi: TV aç/kapa komutları.

SQL transaction log: rollback/commit.

GUI: Menü komutları, undo/redo.

🎯 Senaryo
Bir Uzaktan Kumanda düşün:

Light aç/kapa.

Komutlar: TurnOnLightCommand ve TurnOffLightCommand.


✅ State Pattern nedir?
Amaç:

Bir nesnenin iç durumu değiştikçe davranışını dinamik olarak değiştirmek.

Devasa if-else veya switch blokları yerine, her durum bir sınıf olur.

📌 Gerçek hayattan örnek
ATM → Kart yok, Kart var, PIN girildi, Para çekiliyor.

Müzik çalar → Playing, Paused, Stopped.

Sipariş → Yeni, Hazırlanıyor, Gönderildi, Teslim edildi.

🎯 Senaryo
Bir Müzik Çalar (Player):

Durumlar: Playing, Paused, Stopped.

Her durumda pressPlay() butonu farklı tepki verir.


✅ Chain of Responsibility Pattern nedir?
Amaç:

Bir isteği bir işlem zinciri üzerinden dolaştırmak.

Uygun handler isteği işler, değilse zincirden bir sonraki handler’a aktarır.

Gönderen (client), hangi handler’ın isteği işleyeceğini bilmez → Loose Coupling.

📌 Gerçek hayat örneği
Servlet Filter Chain → Spring, Servlet API.

Middleware → Express.js, NestJS.

Destek talep sistemi → Müşteri temsilcisi → Takım lideri → Yönetici.

🎯 Senaryo
Bir Logger Sistemi:

InfoLogger → info seviyesini işler.

DebugLogger → debug seviyesini işler.

ErrorLogger → error seviyesini işler.

İstek severity’ye göre zincirde yukarı akar.

✅ Tam Tek Dosya Java Chain of Responsibility Örneği


✅ Template Method Pattern nedir?
Amaç:

Bir algoritmanın ana akışını (template) tanımla.

Bazı adımları alt sınıflar override ederek özelleştirsin.

📌 Gerçek hayattan örnek
Veri işleme: Dosya okuma → veriyi ayrıştır → analiz et → raporla.

Çay & kahve yapımı: Su kaynat → içeriği ekle → bardağa dök → şeker/süt ekle.

Spring AbstractController → template method mantığı.

🎯 Senaryo
İçecek hazırlama şablonu

Ortak adımlar: Kaynat, dök.

Farklı adımlar: Çay yap → demlik kullan, Kahve yap → kahve makinesi kullan.


✅ Mediator Pattern nedir?
Amaç:

Bir grup nesne birbirleriyle doğrudan haberleşmez, tüm iletişim bir arabulucu (mediator) üzerinden yürür.

Bu sayede nesneler arasındaki bağımlılık (coupling) azalır.

📌 Gerçek hayattan örnek
Uçak kontrol kulesi (ATC): Tüm uçaklar kuleyle konuşur, birbirleriyle doğrudan iletişim kurmaz.

Chat uygulaması: Kullanıcılar bir sohbet odasına mesaj gönderir → mediator dağıtır.

GUI bileşenleri: Bir formdaki buton, alan, checkbox — Mediator pattern ile kontrol edilir.

🎯 Senaryo
Chat Room:

Kullanıcılar birbirine mesaj göndermez → ChatRoom (mediator) üzerinden mesajlaşır.

User → participant.

ChatRoom → mediator.


✅ Iterator Pattern nedir?
Amaç:

Bir koleksiyonun iç yapısını bilmeden elemanlarını tek tek dolaşmak için ortak bir arayüz sunmak.

Tüm koleksiyonlar (ArrayList, LinkedList, HashSet...) aynı şekilde iterate edilebilir.

📌 Gerçek dünyadaki örnek
java.util.Iterator → List, Set, Map gibi tüm koleksiyonlarda kullanılır.

Dosya gezgini → klasör içeriğini tek tek okursun.

TV kanalları → Kanal listesi içinde ileri/geri dolaşmak.

🎯 Senaryo
Kendi ChannelCollection sınıfını yap:

Channel → Tek bir kanal.

ChannelCollection → Kanal listesi.

ChannelIterator → Koleksiyonu dolaşır.