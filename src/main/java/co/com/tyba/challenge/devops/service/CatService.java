package co.com.tyba.challenge.devops.service;

import co.com.tyba.challenge.devops.client.CatFeignClient;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatFeignClient catFeignClient;

    public String getCat() {
        byte[] cat = catFeignClient.getCat();
        //encode it to Base64
        return java.util.Base64.getEncoder().encodeToString(cat);
    }

    public String getCatWithRandomText() {
        Faker faker = new Faker();
        String randomText = faker.yoda().quote();
        if (randomText.isEmpty() || randomText.isBlank()) {
            randomText = "Hello World!";
        }
        Logger.getLogger(CatService.class.getName()).info("Random text: " + randomText);
        byte[] cat = catFeignClient.getCat(randomText, "%23FFFFFF");
        //encode it to Base64
        return java.util.Base64.getEncoder().encodeToString(cat);
    }
}
