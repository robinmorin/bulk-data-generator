package com.personal.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@Slf4j
@UtilityClass
public class RequestContextHolderHelper {

    public <T> T getAttribute(String attributeName){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return (T) Objects.requireNonNull(requestAttributes.getAttribute(attributeName,RequestAttributes.SCOPE_REQUEST));
    }

    public <T> T setAttribute(String attributeName, T attribute){
        log.info("Setting attribute {} from Request Context. Object: {}", attributeName, attribute);
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        requestAttributes.setAttribute(attributeName, attribute,RequestAttributes.SCOPE_REQUEST);
        return attribute;
    }

}
