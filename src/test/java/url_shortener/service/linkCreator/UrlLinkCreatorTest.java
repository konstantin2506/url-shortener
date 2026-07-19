package url_shortener.service.linkCreator;

import org.junit.jupiter.api.Test;
import url_shortener.service.linkCreator.UrlLinkCreator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrlLinkCreatorTest {
    @Test
    public void testCreate(){
        var creator = new UrlLinkCreator();
        var link1 = creator.createLink();
        assertEquals("1", link1);

        String currentLink = "";
        for (int i = 0; i < 9; i++){
            currentLink = creator.createLink();
        }
        assertEquals("a", currentLink);
    }
}
