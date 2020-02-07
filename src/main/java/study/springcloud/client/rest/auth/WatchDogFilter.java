package study.springcloud.client.rest.auth;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        log.info("[{}]", uri);
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            filterChain.doFilter(request, response);
        } finally {
            log.info("[{}] cost time {} ms", uri, stopwatch.elapsed(TimeUnit.MILLISECONDS));
        }
    }
}
