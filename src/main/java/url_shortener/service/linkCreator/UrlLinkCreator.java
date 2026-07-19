package url_shortener.service.linkCreator;

import org.springframework.stereotype.Component;

@Component
public class UrlLinkCreator implements ILinkCreator {
    int counter = 0;
    public UrlLinkCreator(){};
    @Override
    public String createLink() {
        counter++;
        return Integer.toHexString(counter);
    }
}
