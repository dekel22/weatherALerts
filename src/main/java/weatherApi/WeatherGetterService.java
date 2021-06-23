package weatherApi;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;


@Configuration
@EnableScheduling
@Component
public class WeatherGetterService {

    @Scheduled(fixedDelay = 60000)
    public  void m() throws IOException, InterruptedException, ExecutionException {

        String url="https://api.ims.gov.il/v1/envista/stations/318/data/daily";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                URI.create(url)).
                header("Authorization", "ApiToken f058958a-d8bd-47cc-95d7-7ecf98610e47").header("Accept", "application/json")
                .build();
        HttpResponse<String> resp= client.send(request,  HttpResponse.BodyHandlers.ofString());
        String a=resp.body();
        System.out.println(a);

    }
}
