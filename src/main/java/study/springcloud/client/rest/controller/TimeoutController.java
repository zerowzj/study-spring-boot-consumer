package study.springcloud.client.rest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springcloud.client.rest.support.utils.Results;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TimeoutController {

    @PostMapping("/timeout")
    public Map<String, Object> timeout(@RequestParam Long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Map<String, Object> data = Results.data();
        data.put("timeout", timeout);
        return Results.ok(data);
    }
}
