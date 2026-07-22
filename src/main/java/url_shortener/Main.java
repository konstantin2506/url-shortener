package url_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
//    @Bean
//    public CommandLineRunner testDatabase(UrlShortener urlShortener) {
//        return args -> {
//            System.out.println(">>> НАЧАЛО ТЕСТИРОВАНИЯ БАЗЫ ДАННЫХ <<<");
//
//            var shortLink = urlShortener.getShortLink("https://google.com");
//            IO.println("Your shortLink: "+shortLink.fullLink());
//
//            var realLink = urlShortener.getLongLink(new ShortLink("https://my_domain", "121212121"));
//            realLink.ifPresentOrElse(
//                  link ->  IO.println(String.format("Real link: %s", link)),
//                    () -> IO.println("not found")
//            );
//
//            System.out.println(">>> ТЕСТИРОВАНИЕ ЗАВЕРШЕНО <<<");
//        };
//    }
}
