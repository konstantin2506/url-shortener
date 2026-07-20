package url_shortener.service.shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import url_shortener.entity.ShortLink;
import url_shortener.repository.IUrlRepository;
import url_shortener.service.linkCreator.ILinkCreator;

import java.util.Optional;

@Service
public class UrlShortener implements IShortener{
    private final IUrlRepository repo;
    private final ILinkCreator linkCreator;

    private final String domain;

    @Autowired
    public UrlShortener(@Value("${app.domain}") String domain, IUrlRepository repo, ILinkCreator creator){
        this.domain = domain;
        this.repo = repo;
        this.linkCreator = creator;

        creator.setCounter(repo.getMaxId());
    }
    @Override
    public ShortLink getShortLink(String longLink) {
        var lastPart = linkCreator.createLink();
        repo.saveLongLink(lastPart, longLink);
        return new ShortLink(domain, lastPart);
    }
    @Override
    public Optional<String> getLongLink(ShortLink shortedLink){
        return repo.getLongLink(shortedLink.key());
    }
}
