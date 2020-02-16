package study.springcloud.client.rest.auth;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class WatchDogFilter extends OncePerRequestFilter {

    private static final String HEADER_KEY_REQUEST_ID = "Request-Id";

    private static final String KEY_REQUEST_ID = "request_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String requestId = request.getHeader(HEADER_KEY_REQUEST_ID);
        MDC.put(KEY_REQUEST_ID, requestId);

        String uri = request.getRequestURI();
        try {
            doFilter(request, response, filterChain);
        } finally {
            log.info("[{}] cost time [{} ms]", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
            MDC.remove(KEY_REQUEST_ID);
        }
    }
}
