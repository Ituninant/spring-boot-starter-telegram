package ru.itanton.spring.boot.starter.telegram.resolver.result;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.itanton.spring.boot.starter.telegram.HandlerMethod;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author itanton
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HandlerMethodResultResolverComposite {

    List<HandlerMethodResultResolver> resolvers;

    Map<HandlerMethod, HandlerMethodResultResolver> resolversCache;

    public HandlerMethodResultResolverComposite(List<HandlerMethodResultResolver> resolvers) {
        this.resolvers = resolvers;
        this.resolversCache = new ConcurrentHashMap<>(256);
    }

    public BotApiMethod<? extends Serializable> mapHandlerMethodResult(HandlerMethod handlerMethod, Object result, Update update) {
        HandlerMethodResultResolver resolver = getResolver(handlerMethod);
        return resolver.mapHandlerMethodResult(result, update);
    }

    private HandlerMethodResultResolver getResolver(HandlerMethod handlerMethod) {
        return resolversCache.computeIfAbsent(handlerMethod, hm -> resolvers.stream()
                .filter(r -> r.supportsResult(hm))
                .findAny()
                .orElseThrow()
        ); //TODO throw
    }


}
