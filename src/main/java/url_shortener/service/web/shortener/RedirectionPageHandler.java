package url_shortener.service.web.shortener;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import url_shortener.service.shortener.IShortener;


@RestController
public class RedirectionPageHandler {
    IShortener shortener;

    RedirectionPageHandler(IShortener shortener){
        this.shortener = shortener;
    }

    @GetMapping("/r/{shortKey}")
    public ResponseEntity<?> getLongLink(@PathVariable String shortKey){
        var result = shortener.getLongLink(shortKey);
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(302).header("location", result.get()).build();
    }


}
