public class News {
    private String url;
    private String headline;
    private String datePublished;

    public News(String url, String headline, String datePublished) {
        this.url = url;
        this.headline = headline;
        this.datePublished = datePublished;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getUrl() {
        return url;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDatePublished() {
        return datePublished;
    }
}
