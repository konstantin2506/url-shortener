package url_shortener.service.shortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import url_shortener.repository.IUrlRepository;
import url_shortener.service.linkCreator.ILinkCreator;

import java.util.Optional;

@Service
public class UrlShortener implements IShortener{
    private final IUrlRepository repo;
    private final ILinkCreator linkCreator;


    @Autowired
    public UrlShortener(IUrlRepository repo, ILinkCreator creator){
        this.repo = repo;
        this.linkCreator = creator;

        creator.setCounter(repo.getMaxId());
    }
    @Override
    public String getShortLink(String longLink) {
        var lastPart = linkCreator.createLink();
        repo.saveLongLink(lastPart, longLink);
        return lastPart;
    }
    @Override
    public Optional<String> getLongLink(String shortedLink){
        return repo.getLongLink(shortedLink);
    }
}
