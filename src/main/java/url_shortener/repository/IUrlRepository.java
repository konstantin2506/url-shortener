package url_shortener.repository;


import url_shortener.entity.ShortLink;

import java.util.Optional;

public interface IUrlRepository  {
    public Optional<String> getLongLink(String shortLink);
    public void saveLongLink(String shortLink, String longLink);
    public long getMaxId();
}
