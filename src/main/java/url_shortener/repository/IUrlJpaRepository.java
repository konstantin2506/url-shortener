package url_shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import url_shortener.entity.UrlEntity;

import java.util.Optional;

public interface IUrlJpaRepository extends JpaRepository<UrlEntity, Long> {
    public Optional<UrlEntity> findByShortUrl(String shortUrl);

    @Query("SELECT MAX(u.id) FROM UrlEntity u")
    public Optional<Long> getMaxId();
}
