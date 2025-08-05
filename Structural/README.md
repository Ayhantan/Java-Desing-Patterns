✅ Adapter Pattern nedir?
Amaç:
Bir sınıfın arayüzü, başka bir sınıfın beklentisine uymuyorsa uyum katmanı sağlar.
Yani, iki uyumsuz interface arasında köprü kurar.

🎯 Gerçek hayat örneği:
Telefon priz adaptörü → İngiliz fişini Avrupa prizine uydurmak.

Eski bir kütüphaneyi yeni kodla uyumlu hale getirmek.

✅ Senaryo: MediaPlayer
Diyelim ki bir müzik uygulaman var:

AudioPlayer sadece mp3 dosyalarını çalabiliyor.

Ama vlc ve mp4 desteği lazım.

AdvancedMediaPlayer sınıfı bunları oynatabiliyor.

Adapter ile bu farkı kapat.


✅ Decorator Pattern nedir?
Amaç:

Bir nesneye yeni sorumlulukları dinamik olarak eklemek.

Kalıtım (inheritance) kullanmak yerine kompozisyon ile genişletmek.

Avantaj:
✔ Esnek: Birden fazla decorator’ü zincirleyebilirsin.
✔ Orijinal sınıfın kodunu değiştirmeden yeni yetenekler eklersin.
✔ Açık/Kapalı prensibi (OCP) ile uyumlu.

📌 Gerçek hayattan örnek
Java IO: InputStream, BufferedInputStream, DataInputStream
Her biri bir Decorator’dür.

UI bileşenlerine border, scrollbar, renk efekti eklemek.

🎯 Senaryo
Bir Coffee Shop örneği:

Coffee = Temel ürün.

Ekstra: Süt, Şeker, Çikolata gibi eklentiler → Decorator.


✅ Composite Pattern nedir?
Amaç:

Nesneleri ağaç yapısında hiyerarşik olarak organize etmek.

Tekil nesne (leaf) ve bileşik nesne (composite) aynı arayüzü paylaşır.

Client tarafı, “tekil mi, grup mu?” diye düşünmez → hepsi bir Component gibi davranır.

📌 Gerçek dünya örnekleri
Dosya sistemleri (klasörler → dosya veya başka klasör içerebilir)

Organizasyon yapıları (müdür → çalışanları / alt müdürler)

GUI bileşenleri (panel içinde butonlar, label’lar)

🎯 Senaryo
Kurumsal şirket yapısı:

Employee → Ortak interface.

Developer → Leaf.

Manager → Composite → alt çalışanları olur.


✅ Proxy Pattern nedir?
Amaç:
Bir nesneye erişimi kontrol etmek, sınırlamak veya izlemek için onun yerine bir proxy (vekil) sınıf kullanmak.

📌 Gerçek hayat örneği
İnternet Proxy Server → İstekleri önce alır, gerekirse cache’den döner.

Dosya Sistemi Proxy → Erişim yetkisini kontrol eder.

Lazy-loading → Büyük nesneleri gerektiğinde yüklemek.

Protection Proxy → Yetki kontrolü sağlar.

🎯 Senaryo
Bir dosyayı açan bir nesne hayal et.
Ama her dosya herkese açık değil.
RealFile doğrudan dosyayı açar.
ProxyFile → kullanıcının yetkisi var mı? diye kontrol eder.


✅ Facade Pattern nedir?
Amaç:

Karmaşık bir alt sistemi basit bir arayüzle saklamak.

Client karmaşık sınıfları veya alt modülleri bilmez; tek bir kapıdan (facade) işini halleder.

📌 Gerçek hayat örnekleri
Arabada motoru, elektronik sistemleri açmak için sadece bir düğmeye basarsın → motorun içindeki karmaşayı bilmezsin.

API Gateway → Arka uçta birçok mikroservisi tek bir endpoint altında toplar.

Spring JdbcTemplate → JDBC karmaşasını gizler.

🎯 Senaryo
Ev Sinema Sistemi

Alt sistemler: DVD Player, Amplifier, Projector.

HomeTheaterFacade → Hepsini kolayca yönetir.


✅ Bridge Pattern nedir?
Amaç:

Abstraction (soyutlama) ile Implementation (uygulama) katmanlarını ayrı sınıflara ayırmak.

Böylece her iki taraf da birbirinden bağımsız olarak geliştirilebilir.

📌 Ne zaman kullanılır?
✔ Bir nesnenin soyutlama kısmı (arayüz) ve uygulama kısmı (detay) bağımsız olarak değişebilmeli.
✔ Karmaşık class hiyerarşisini patlatmak yerine soyutlama & uygulama boyutlarını ayırırsın.

🎯 Gerçek hayat örneği
Farklı cihazlar (TV, Radio) + Farklı uzaktan kumandalar (BasicRemote, AdvancedRemote).

Remote soyutlamadır → Device implementasyondur.

Remote birden çok cihazla uyumlu çalışabilir.