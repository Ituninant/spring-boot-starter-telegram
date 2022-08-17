package ru.itanton.spring.boot.starter.telegram.resolver.parameter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;
import ru.itanton.spring.boot.starter.telegram.HandlerMethodParameter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author itanton
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HandlerMethodArgumentResolverComposite {

    List<HandlerMethodArgumentResolver> resolvers;

    Map<HandlerMethodParameter, HandlerMethodArgumentResolver> resolversCache;

    public HandlerMethodArgumentResolverComposite(List<HandlerMethodArgumentResolver> resolvers) {
        this.resolvers = resolvers;
        this.resolversCache = new ConcurrentHashMap<>(256);
    }

    public Object[] getArgValues(HandlerMethod handlerMethod, Update update) {
        Object[] args = new Object[handlerMethod.getParameters().size()];
        for (HandlerMethodParameter parameter : handlerMethod.getParameters()) {
            HandlerMethodArgumentResolver resolver = getResolver(parameter);
            // TODO only one resolver?
            Object argument = resolver.getValue(update);
            args[parameter.getIndex()] = argument; //TODO index?
        }
        //TODO args < then handlerMethod.getParameters().size()?
        return args;
    }

    private HandlerMethodArgumentResolver getResolver(HandlerMethodParameter parameter) {
        return resolversCache.computeIfAbsent(parameter, p -> resolvers.stream()
                .filter(r -> r.supportsParameter(p))
                .findAny()
                .orElseThrow()
        ); //TODO throw
    }

}
