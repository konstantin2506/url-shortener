package url_shortener.service.shortener;

import url_shortener.service.linkCreator.ILinkCreator;

public class LinkCreatorMock implements ILinkCreator {
    int counter = 0;
    @Override
    public String createLink() {
        return "123" + String.valueOf(counter++);
    }
    public String expected(){
        counter--;
        return createLink();

    }
}
