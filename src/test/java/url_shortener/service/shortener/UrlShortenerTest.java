package url_shortener.service.shortener;

import org.junit.jupiter.api.Test;
import url_shortener.entity.ShortLink;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class UrlShortenerTest {
    @Test
    public void getShortLinkTest(){
        var repo = new RepoMock();
        var creator = new LinkCreatorMock();
        var domain = "https://test.ru";
        var shortener = new UrlShortener(domain, repo, creator);

        var shortLink = shortener.getShortLink("test-long-link");
        assertEquals(String.format("%s/%s", domain, creator.expected()), shortLink.fullLink());
    }
    @Test
    public void getLongLinkTest(){
        var repo = new RepoMock();
        var creator = new LinkCreatorMock();

        var shortener = new UrlShortener("https://test.ru", repo, creator);

        var longLink = shortener.getLongLink(new ShortLink("https:://test.com","12345"));
        assertEquals(Optional.empty(), longLink);

        var link1 = shortener.getShortLink("test");
        var link2 = shortener.getShortLink("test");

        assertNotSame(link1, link2);
    }
}
