package url_shortener.service.web.shortener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import url_shortener.service.shortener.IShortener;

import java.util.Map;

@RestController
@RequestMapping("api/shortener")
public class ShortenerPageHandler {
    IShortener shortener;
    String domain;

    ShortenerPageHandler(IShortener shortener, @Value("${app.domain}") String domain){
        this.shortener = shortener;
        this.domain = domain;
    }

    @PostMapping
    public ResponseEntity<?> createShortLink(@RequestBody Map<String, String> request){
        var url = request.get("longUrl");
        var shortLink = shortener.getShortLink(url);
        return ResponseEntity.ok(Map.of("shortUrl", String.format("%s/r/%s",domain, shortLink)));
    }
}
