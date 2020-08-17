package no.fint.consumer.utils;

import lombok.extern.slf4j.Slf4j;
import no.fint.consumer.exceptions.ForbiddenException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Slf4j
public class FintAccessPolicyInterceptor extends HandlerInterceptorAdapter {

    private static final String COLLECTION_HEADER_NAME = "x-fint-access-collection";
    private static final String READ_HEADER_NAME = "x-fint-access-read";
    private static final String MODIFY_HEADER_NAME = "x-fint-access-modify";
    private final Collection<String> paths;

    public FintAccessPolicyInterceptor(Collection<String> paths) {
        this.paths = paths;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (StringUtils.equalsAny(request.getMethod(), "POST", "PUT", "DELETE")) {
            if (paths.stream().anyMatch(s -> StringUtils.startsWith(request.getRequestURI(), s))) {
                String[] permittedPaths = StringUtils.split(request.getHeader(MODIFY_HEADER_NAME), ",;");
                if (StringUtils.startsWithAny(request.getRequestURI(), permittedPaths)) {
                    log.trace("{} {} permitted by modify policy", request.getMethod(), request.getRequestURI());
                    return true;
                }
            } else {
                log.debug("{} {} not matched", request.getMethod(), request.getRequestURI());
                return true;
            }

        } else {

            if (paths.contains(StringUtils.lowerCase(request.getRequestURI()))) {

                final String[] permittedPaths = StringUtils.split(request.getHeader(COLLECTION_HEADER_NAME), ",;");

                if (StringUtils.equalsAny(request.getRequestURI(), permittedPaths)) {
                    log.trace("{} {} permitted by collection policy", request.getMethod(), request.getRequestURI());
                    return true;
                }

            } else if (paths.stream().anyMatch(s -> StringUtils.startsWith(request.getRequestURI(), s))) {

                final String[] permittedPaths = StringUtils.split(request.getHeader(READ_HEADER_NAME), ",;");

                if (StringUtils.startsWithAny(request.getRequestURI(), permittedPaths)) {
                    log.trace("{} {} permitted by read policy", request.getMethod(), request.getRequestURI());
                    return true;
                }
            } else {
                log.debug("{} {} not matched", request.getMethod(), request.getRequestURI());
                return true;
            }

        }
        log.debug("{} {} rejected", request.getMethod(), request.getRequestURI());
        throw new ForbiddenException();
    }
}