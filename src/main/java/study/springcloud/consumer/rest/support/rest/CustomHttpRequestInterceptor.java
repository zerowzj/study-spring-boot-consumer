package study.springcloud.consumer.rest.support.rest;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CustomHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        URI uri = request.getURI();
        Stopwatch stopwatch = Stopwatch.createStarted();

        ClientHttpResponse response;
        try {
            log.info("开始执行");
            response = execution.execute(request, body);
            log.info("结束执行");
        } catch (Exception ex) {
            throw new RuntimeException("", ex);
        } finally {
            log.info("[{}] cost time [{} ms]", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
        return response;
    }
}
