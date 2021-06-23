package weatherApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;


@Configuration
@EnableScheduling
@SpringBootApplication
public class WeatherGetter {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        ConfigurableApplicationContext context = SpringApplication.run(WeatherGetter.class, args);

        String url="https://api.ims.gov.il/v1/envista/stations/318/data/daily";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                URI.create("https://api.ims.gov.il/v1/envista/stations")).
                header("Authorization", "ApiToken f058958a-d8bd-47cc-95d7-7ecf98610e47").header("Accept", "application/json")
                .build();
        HttpResponse<String> resp= client.send(request,  HttpResponse.BodyHandlers.ofString());
        String a=resp.body();
        System.out.println(a);

    }












}
