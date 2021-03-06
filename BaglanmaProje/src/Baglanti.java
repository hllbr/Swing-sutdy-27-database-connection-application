
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
JDBC ve MYSQL VERİTABANI İŞLEMLERİ == 
VERİTABANI NEDİR ? 
Veritabanı uygulamalar içinde kullandığımız verilerin belli sunucuların içinde depolanmasını sağlayan yapılardır.Veritabanlarını kullanarak verilerimizi saklayabilir ve istediğimiz yerden ulaşabiliriz.
Kullandığımız sunucu yerel(LokalHostumuzda bir sunucu olabilir) veya uzakta bulunan bir sunucu olabilir.
Bu sunucular üzerinde verilerin depolanmasını sağlayan yapılardır.

veritabanları sayesinde verilerimizi hem saklayabilir hemde istediğimizi yerden ulaşabilir ve işlemlewr gerçekleştirebiliriz.
Veritabanının kullanarak uzak bir sunucuda depoladığım bilgileri başka bir bilgisayardaki java projesinde (eğer erişim izni varsa) direkt olarak erişebiliriz.


*****
VeriTabanı Türleri 
Günümüzde kullanılan bazı veritabanı türleri şunlardır :
Relation Database(İlişkiseş Veritabanları): Verileri tablolarda depolarlar.MySQL ve SQLİTE gibi veritabanları bu kategoriye girer.

Document Based Database(Dokuman Bazlı Veritabanları);Verileri dokuman halinde depolarlar.MongoDB ve Azure Document Db bu Kategoriye girer.
JSON OBJESİ GİBİ DEPOLANIYORLAR.

Bendan Sonraki Projelerimde Mysql VeriTabanı üzerinde çalışmalar yürüteceğim.

******

VERİTABANI Işlemleri = 

MySQL Veritabanındaki tablolar ve vberiler üzerinde işlem yapmak için SQL(STRUCTURED QUERY LANGUAGE) sorguları kullanılır.
SQL Dili sorgulamalı bir dildir.

JDBC(Driver) Nedir ? == 

JDBC,java projelerimizin ilişkisel veritabanlarına bağlanabilmesi için oluşturulmuş bir yapıdır.JDBC üzerinde SQL sorgularını çalıştırıcaz.

******
Yapının Temeli 
Java Application -->> JDBC -->> DataBase

JDBC DRIVER ÖZELLİKLERİ == 

**Farklı ilişkisel veritabanlarına (SqlServer,PastgreSql) uyumludur ve her veritabanı için ayrı ayrı kod geliştirmemiz gerekmez.
(Çok küçük değişiklikler dışında)
**JDBC Drıver sayesinde veritabanlarına bağlanmamızı sağlar.
**JDBC DRIVER aynı zamanda veritabanı için gerekli fonksiyon çağrılarımızı farklı veritabanlarına uygun hale getirir.

*/


/*
MySQL veritabanını kurduğum ve üzerinde herhangi bir işlem yapmadığım zaman ,
MySql veritabanına bağlanmam için benim bir kullanıcı adı ve parolaya ihityacım var
Eğer ben herhangi bir işlem yapmadığımda bu Xampp üzerinde otomatik olarak kullanıcı adım root /parolam boş olarak karşıma çıkıyor.

*/
/*public class Baglanti {
    //veritabanına erişmek için gerekli bilgileri özellik olarak ekliyorum...
    private String kullanıcı_adı ="root";//hiçbir işlem yapmadığım için bu şekilde karşıma çıkıyor.
    private String parola = "";//başta nasılsa o şekilde başlatıyorum.
    //Şimdi Hangi veritabanına bağlanmam gerektiğini ifade etmem gerekiyor.
    private String db_ismi ="demo";//daha önceden oluşturduğum database'in ismini verdim
    //şimdi bu db(database)'in hangi sunucuda olduğunu söylemem gerekiyor.Eğer uzak bir sunucu kullanıyorsam sunucunun direkt olarak adresini vermem gerekiyor.
    //ben yerel(lokal) bir sunucu kullandığım için....
    private String host= "localhost";
    
    //Eğer mysql veritabanı belirli bir port ile çalışıyorsa bu port numarasını vermem gerekiyor.
    private int port = 3306;
    //şuana kadar girmiş olduğum herşey veritabanına bağlanmak için gerekli olan verilerdir.
    //şimdi benim connection sınıfından bir obje üretmem gerekiyor.Bu obje üzerinden veri tabanı bağlantılarımı gerçekleştiricem.
    private Connection con = null;
    //şimdi benim bir constructora ihtiyacım var.
    public Baglanti(){
        //ilk olarak burada bir url tanımlaması yapmam gerekiyor.
        String url ="jdbc://"+host+":"+port+"/"+db_ismi; //veritabanı bağlantısını gerçekleştirmem için gerekli urlyi girmem gerekiyor.
        //veritabanına bağlanmak için gerekli olan draverı başlatmam gerekiyor.Bunu yapmmazsam bazı sıkıntılarla karşılaşabilirim.
        
        try{
            Class.forName("com.mysql.jdbc.Driver");//jdbc drıveri burda extradan çağırmış oldum
            System.out.println("Bağlantı Bulundu...");
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Drıver Bulunamadı...");
        }
        try {
            con = DriverManager.getConnection(url,kullanıcı_adı,parola);
            System.out.println("Bağlantı Başarılı...");
        } catch (SQLException ex) {//veritabanına bağlanamazsam...
           // Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Bağlantı Başarısız...");
        }
    }
    public static void main(String[] args) {
        Baglanti baglantı = new Baglanti();
        
    }
    
}
*/

 
public class Baglanti {
    
    private String kullanici_adi = "root";
    private String parola = "";
    
    private String db_ismi = "demo";
    
    private String host =  "localhost";
    
    private int port = 3306;
    
    private Connection con = null;
     public Baglanti() {
        
        // "jbdc:mysql://localhost:3306/demo" 
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
          // ex.printStackTrace();
        }
        
        
        try {
            con = DriverManager.getConnection(url, kullanici_adi, parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
           // ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Baglanti baglanti = new Baglanti();
        //bir tablo oluşturmam gerekiyor Versyon2 projesinde bunuluyor yapının kinici kısmı
    }
}