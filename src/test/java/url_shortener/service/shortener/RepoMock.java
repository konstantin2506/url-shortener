package url_shortener.service.shortener;

import url_shortener.repository.IUrlRepository;

import java.util.HashMap;
import java.util.Optional;

public class RepoMock implements IUrlRepository {
    private final HashMap<String, String> data = new HashMap<>();
    @Override
    public void saveLongLink(String shortLink, String longLink) {
        data.put(shortLink, longLink);
    }

    @Override
    public long getMaxId() {
        return 1;
    }

    @Override
    public Optional<String> getLongLink(String shortLink) {
        if (!data.containsKey(shortLink)){
            return Optional.empty();
        }
        return Optional.of(data.get(shortLink));
    }
}