public class Product {
    private String url;
    private String title;
    private String price;
    private String modelo;

    public Product(String url, String title, String price, String modelo) {
        this.url = url;
        this.title = title;
        this.price = price;
        this.modelo = modelo;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getModelo() {
        return modelo;
    }
}
