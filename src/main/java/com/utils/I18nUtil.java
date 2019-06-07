package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nUtil {

    @Autowired
    private MessageSource messageSource;

    public String getMsg(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        locale = Locale.SIMPLIFIED_CHINESE;
        return messageSource.getMessage(key, null, locale);
    }
}
