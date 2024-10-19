package co.com.tyba.challenge.devops.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cat", url = "https://cataas.com", configuration = CatFeignClientConfiguration.class)
public interface CatFeignClient {
    @GetMapping(value = "/cat", consumes = "image/*")
    byte[] getCat();

    @GetMapping(value = "/cat/says/{randomText}?fontColor={color}", consumes = "image/*")
    byte[] getCat(@PathVariable("randomText") String randomText, @PathVariable("color") String color);

}
