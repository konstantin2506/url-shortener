package url_shortener.repository;



import org.springframework.stereotype.Repository;
import url_shortener.entity.ShortLink;
import url_shortener.entity.UrlEntity;


import java.util.Optional;

@Repository
public class UrlRepository implements IUrlRepository{
    IUrlJpaRepository jpaRepo;

    UrlRepository(IUrlJpaRepository jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public void saveLongLink(String shortLink, String longLink) {
        jpaRepo.save(new UrlEntity(shortLink, longLink));
    }

    @Override
    public Optional<String> getLongLink(String shortLink) {
        var entity = jpaRepo.findByShortUrl(shortLink);
        return entity.map(UrlEntity::getLongUrl);
    }

    @Override
    public long getMaxId() {
        var maxId = jpaRepo.getMaxId();
        if (maxId.isEmpty()){
            return 0;
        }
        return maxId.get();
    }
}
