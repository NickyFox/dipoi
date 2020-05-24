import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scrapping {
    public List<Optional<JsonObject>> scrap (List <String> urls, String type) throws IOException {
        List<Optional<JsonObject>> jsonLD = new ArrayList<Optional<JsonObject>>();
        if (type == "product") {
            for (String url : urls) {

                jsonLD.add(scrappingProduct(url));
            }
            return jsonLD;
        }else{
            for (String url : urls) {

                jsonLD.add(scrappingNews(url));
            }
            return jsonLD;
        }
    }

    private Optional<JsonObject> scrappingProduct (String url) throws IOException {
        try{
            Document document = Jsoup.connect(url).get();
            String title = document.selectFirst("#gb-main-detail > div.gb-main-detail-content > div.gb-main-detail-title > div.title-product > h1").html();
            String price = document.selectFirst("#gb-main-detail > div.gb-main-detail-info > div.itemBox--price.itemBox--price-lg > span.value-note > del").html();
            String model = document.selectFirst("#gb-tech-spec-generales > ul:nth-child(2) > li:nth-child(1) > span").html();
            Product product = new Product(url, title, price, model);
            String json = new Gson().toJson(product);
            JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

            return Optional.of(convertedObject);
        } catch (Exception e ){
            return Optional.empty();
        }
    }

    private Optional<JsonObject> scrappingNews(String url) throws IOException {

        try{
           Document document = Jsoup.connect(url).get();
           String headline = document.selectFirst("#nota > section.encabezado > h1").html();
           String datePublished = document.selectFirst("#cuerpo > div.barra > div > section.fecha").html();
           News news = new News(url,headline,datePublished);
        String json = new Gson().toJson(news);
        JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);
        return Optional.of(convertedObject);
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
