import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class Scrapp {
    public static void main(String[] args) throws IOException {
        Scrapping scrapping= new Scrapping();
        List<String> productUrls = Arrays.asList(
                "https://www.garbarino.com/producto/3a20ba7107",
                "https://www.garbarino.com/producto/3815afa6da",
                "https://www.garbarino.com/producto/aa5745037b",
                "https://www.garbarino.com/producto/2a3284deca",
                "https://www.garbarino.com/producto/f195032d8f",
                "https://www.garbarino.com/producto/fa1c181d95",
                "https://www.garbarino.com/producto/b465a62264",
                "https://www.garbarino.com/producto/6326a5e66c",
                "https://www.garbarino.com/producto/1a2d5f8064",
                "https://www.garbarino.com/producto/d49df8264c",
                "https://www.garbarino.com/producto/4204e2fb87",
                "https://www.garbarino.com/producto/d5bd32209a",
                "https://www.garbarino.com/producto/3f6af0bf5b",
                "https://www.garbarino.com/producto/8c2f541454",
                "https://www.garbarino.com/producto/bf7b533b47",
                "https://www.garbarino.com/producto/764afd11f4",
                "https://www.garbarino.com/producto/bd8851337f",
                "https://www.garbarino.com/producto/74fcde1dc0",
                "https://www.garbarino.com/producto/3ce0c612db",
                "https://www.garbarino.com/producto/44b4087b32",
                "https://www.garbarino.com/producto/f32d4033c4",
                "https://www.garbarino.com/producto/76eb2c68c8",
                "https://www.garbarino.com/producto/a613edb9ef",
                "https://www.garbarino.com/producto/3b5dbee6b5",
                "https://www.garbarino.com/producto/1e5dab6fb6",
                "https://www.garbarino.com/producto/cbce9368b3",
                "https://www.garbarino.com/producto/feb4384168",
                "https://www.garbarino.com/producto/99403a3dec",
                "https://www.garbarino.com/producto/2badcf2ac5",
                "https://www.garbarino.com/producto/d35fe26bb9",
                "https://www.garbarino.com/producto/1e2517ac06",
                "https://www.garbarino.com/producto/d0588c57cb",
                "https://www.garbarino.com/producto/d23b9884fd",
                "https://www.garbarino.com/producto/3459b9e1b3",
                "https://www.garbarino.com/producto/c5addf03ce",
                "https://www.garbarino.com/producto/8019f31ade",
                "https://www.garbarino.com/producto/8bb9b3dc79",
                "https://www.garbarino.com/producto/7d94820ed5",
                "https://www.garbarino.com/producto/ae3041a1ef",
                "https://www.garbarino.com/producto/49954d0e56",
                "https://www.garbarino.com/producto/cdef5909d9",
                "https://www.garbarino.com/producto/c5e366f361",
                "https://www.garbarino.com/producto/86f0f22a88",
                "https://www.garbarino.com/producto/672b65f1d8",
                "https://www.garbarino.com/producto/44a6bf1e02",
                "https://www.garbarino.com/producto/0089017127",
                "https://www.garbarino.com/producto/2badcf2ac5",
                "https://www.garbarino.com/producto/d35fe26bb9",
                "https://www.garbarino.com/producto/d0588c57cb",
                "https://www.garbarino.com/producto/d23b9884fd",
                "https://www.garbarino.com/producto/0fa928accd",
                "https://www.garbarino.com/producto/3459b9e1b3",
                "https://www.garbarino.com/producto/c5addf03ce",
                "https://www.garbarino.com/producto/afc631ffa3",
                "https://www.garbarino.com/producto/8019f31ade",
                "https://www.garbarino.com/producto/8bb9b3dc79",
                "https://www.garbarino.com/producto/7d94820ed5",
                "https://www.garbarino.com/producto/ae3041a1ef",
                "https://www.garbarino.com/producto/9eff428080",
                "https://www.garbarino.com/producto/2f27b98a0b",
                "https://www.garbarino.com/producto/49954d0e56",
                "https://www.garbarino.com/producto/afcab0d0a2",
                "https://www.garbarino.com/producto/cdef5909d9",
                "https://www.garbarino.com/producto/09e3b0c9c9",
                "https://www.garbarino.com/producto/86f0f22a88",
                "https://www.garbarino.com/producto/672b65f1d8",
                "https://www.garbarino.com/producto/44a6bf1e02",
                "https://www.garbarino.com/producto/0089017127",
                "https://www.garbarino.com/producto/fee0b3dc04",
                "https://www.garbarino.com/producto/f9de2e7b2f",
                "https://www.garbarino.com/producto/87b8e45f39",
                "https://www.garbarino.com/producto/8b6148660d",
                "https://www.garbarino.com/producto/e4d221928e",
                "https://www.garbarino.com/producto/2c6161499f",
                "https://www.garbarino.com/producto/08fbe1ed54",
                "https://www.garbarino.com/producto/fa453e4e23",
                "https://www.garbarino.com/producto/ef3c2abf43",
                "https://www.garbarino.com/producto/0cc7f290a1",
                "https://www.garbarino.com/producto/70f60e6c45",
                "https://www.garbarino.com/producto/fa292ad7f8",
                "https://www.garbarino.com/producto/6d64a1a379",
                "https://www.garbarino.com/producto/ecf9e34d8a",
                "https://www.garbarino.com/producto/32c9025ec0",
                "https://www.garbarino.com/producto/a8badf9d52",
                "https://www.garbarino.com/producto/cd4407cf11",
                "https://www.garbarino.com/producto/5654e46409",
                "https://www.garbarino.com/producto/5a30cdb7c8",
                "https://www.garbarino.com/producto/04864b797f",
                "https://www.garbarino.com/producto/86a310a898",
                "https://www.garbarino.com/producto/4196e65865",
                "https://www.garbarino.com/producto/fab7d99195",
                "https://www.garbarino.com/producto/2cd57b5db6",
                "https://www.garbarino.com/producto/a7e85801bb",
                "https://www.garbarino.com/producto/6b0b687206");


        System.out.println(scrapping.scrap(productUrls, "product") + "\n");

        List<String> newsUrls = new ArrayList<String>();
        for (int i = 0; i <= 100; i++){
            newsUrls.add("http://www.lanacion.com.ar/" + (2351900 +i));
        }



        System.out.println(scrapping.scrap(newsUrls,"news" ));

    }
}
