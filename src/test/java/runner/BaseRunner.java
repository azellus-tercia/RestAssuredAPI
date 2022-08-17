package runner;

public class BaseRunner {
    private final String pageAPI = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    protected String getPageAPI(String word) {
        return pageAPI + word;
    }
}
