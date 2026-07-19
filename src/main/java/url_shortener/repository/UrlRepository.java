package url_shortener.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO implement
@Repository
public class UrlRepository implements IUrlRepository{
    @Override
    public Optional<String> getLongLink(String shortLink) {
        return Optional.empty();
    }

    @Override
    public void saveLongLink(String shortLink, String longLink) {

    }
}
