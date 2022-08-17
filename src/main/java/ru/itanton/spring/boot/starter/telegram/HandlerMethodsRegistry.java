package ru.itanton.spring.boot.starter.telegram;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author itanton
 */
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HandlerMethodsRegistry {

    MappingRegistration defaultRegistration;
    final Map<String, MappingRegistration> registry = new ConcurrentHashMap<>(); //TODO ?

    public void register(String mapping, Object botHandler, Method method) {
        MappingRegistration mappingRegistration = createMappingRegistration(mapping, botHandler, method);
        if ("".equals(mapping)) {
            defaultRegistration = mappingRegistration;
        }
        registry.put(mapping, mappingRegistration);
    }

    public MappingRegistration getMapping(String mapping) {
        return registry.getOrDefault(mapping, defaultRegistration);
    }

    private MappingRegistration createMappingRegistration(String mapping, Object botHandler, Method method) {
        HandlerMethod handlerMethod = new HandlerMethod(botHandler, method, createParameters(method));
        return new MappingRegistration(createMapping(mapping), handlerMethod);
    }

    private String createMapping(String mapping) throws RuntimeException {
        if (mapping == null) {
            throw new RuntimeException(""); //TODO
        }

        //TODO
//        if (!mapping.startsWith("/")) {
//            mapping = "/" + mapping;
//        }

        return mapping;
    }

    private List<HandlerMethodParameter> createParameters(Method method) {
        List<HandlerMethodParameter> result = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            result.add(new HandlerMethodParameter(parameter.getDeclaredAnnotations(), parameter.getType(), parameter.getName(), i));
        }
        return result;
    }

}
