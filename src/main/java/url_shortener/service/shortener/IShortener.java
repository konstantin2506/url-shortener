package url_shortener.service.shortener;

import url_shortener.entity.ShortLink;

import java.util.Optional;

public interface IShortener {
    public ShortLink getShortLink(String longLink);
    public Optional<String> getLongLink(ShortLink shortedLink);
}
