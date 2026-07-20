package url_shortener.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "urls")
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "short_url", unique = true, nullable = false)
    private String shortUrl;

    @Column(name = "long_url", nullable = false, length = 2048)
    private String longUrl;

    public UrlEntity() {}

    public UrlEntity(String shortLink, String longLink){
        this.shortUrl = shortLink;
        this.longUrl = longLink;
    }

    public Long getId() {return id;}
    public String getShortUrl(){return shortUrl;}
    public String getLongUrl() {return longUrl;}

    public void setId(Long id) {
        this.id = id;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
