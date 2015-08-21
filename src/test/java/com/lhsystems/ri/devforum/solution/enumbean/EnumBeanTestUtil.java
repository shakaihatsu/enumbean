package com.lhsystems.ri.devforum.solution.enumbean;

import java.util.HashMap;
import java.util.Map;

import net.shakaihatsu.devforum.solution.enumbean.BeanHolder;

import org.mockito.Mockito;

public class EnumBeanTestUtil {
    public static <B, E extends Enum<E> & BeanHolder<B>> Map<E, B> initBeanHolderEnumAndCreateEnumToMockMap(Class<E> enumClass,
            Class<B> beanClass) {

        Map<E, B> enumToMock = new HashMap<>();

        E[] enumElements = enumClass.getEnumConstants();
        for (E enumElement : enumElements) {
            B mock = Mockito.mock(beanClass);
            enumToMock.put(enumElement, mock);
            enumElement.setBean(mock);
        }

        return enumToMock;
    }
}

