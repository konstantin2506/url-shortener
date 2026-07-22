package url_shortener.service.shortener;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class UrlShortenerTest {
    @Test
    public void getShortLinkTest(){
        var repo = new RepoMock();
        var creator = new LinkCreatorMock();
        var shortener = new UrlShortener(repo, creator);

        var shortLink = shortener.getShortLink("test-long-link");
        assertEquals(String.format(creator.expected()), shortLink);
    }
    @Test
    public void getLongLinkTest(){
        var repo = new RepoMock();
        var creator = new LinkCreatorMock();

        var shortener = new UrlShortener(repo, creator);

        var longLink = shortener.getLongLink("12345");
        assertEquals(Optional.empty(), longLink);

        var link1 = shortener.getShortLink("test");
        var link2 = shortener.getShortLink("test");

        assertNotSame(link1, link2);
    }
}
