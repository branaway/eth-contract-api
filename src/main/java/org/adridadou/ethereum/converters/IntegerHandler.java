package org.adridadou.ethereum.converters;

import java.lang.reflect.Method;
import java.math.BigInteger;

/**
 * Created by davidroon on 27.04.16.
 * This code is released under Apache 2 license
 */
public class IntegerHandler implements TypeHandler<Integer> {
    @Override
    public boolean isOfType(Method method) {
        return Integer.class.equals(method.getReturnType()) || method.getReturnType().getSimpleName().equals("int");
    }

    @Override
    public Integer convert(Object[] result) {
        Object obj = result[0];
        if (obj.getClass().equals(BigInteger.class)) {
            return ((BigInteger) obj).intValue();
        }
        throw new IllegalArgumentException("cannot convert " + obj.getClass().getSimpleName() + " to Integer");
    }
}
