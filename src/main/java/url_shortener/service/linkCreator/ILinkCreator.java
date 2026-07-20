package url_shortener.service.linkCreator;

public interface ILinkCreator {
    public String createLink();
    public void setCounter(long counter);
}
