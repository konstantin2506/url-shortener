package url_shortener.service.linkCreator;

import org.springframework.stereotype.Component;

@Component
public class UrlLinkCreator implements ILinkCreator {
    long counter = 0;
    public UrlLinkCreator(){};
    @Override
    public String createLink() {
        counter++;
        return Long.toHexString(counter);
    }
    public void setCounter(long counter){
        this.counter = counter;
    }
}
