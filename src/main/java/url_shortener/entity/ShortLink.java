package url_shortener.entity;

public class ShortLink {
     private final String domain;
     private final String key;

     public ShortLink(String domain, String key){
         this.domain = domain;
         this.key = key;
     }

     public String key() {return key;}
     public String fullLink(){ return String.format("%s/%s", domain, key) ;}
}
