package url_shortener.service.shortener;

import java.util.Optional;

public interface IShortener {
    public String getShortLink(String longLink);
    public Optional<String> getLongLink(String shortedLink);
}
