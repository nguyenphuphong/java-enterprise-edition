package vn.kase.jee.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    public static <S, D> D simpleMapping(S source, Class<D> destination) {
        D d = null;
        try {
            d = destination.getDeclaredConstructor().newInstance();

            for (Field df : destination.getDeclaredFields()) {
                Field sf = source.getClass().getDeclaredField(df.getName());

                if ("serialVersionUID".equals(df.getName()) || "serialVersionUID".equals(sf.getName())) {
                    continue;
                }

                sf.setAccessible(true);
                df.setAccessible(true);

                df.set(d, sf.get(source));
            }
        } catch (NoSuchFieldException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Can't convert object", e);
        }
        return d;
    }

    public static <S, D> List<D> listMapping(List<S> sources, Class<D> destination) {
        List<D> dlist = new ArrayList<>();
        for (S source : sources) {
            dlist.add(simpleMapping(source, destination));
        }

        return dlist;
    }

    public static <S, D> void simpleMapping(S source, D destination) {
        try {
            for (Field df : destination.getClass().getDeclaredFields()) {
                Field sf = source.getClass().getDeclaredField(df.getName());
                if (sf == null) {
                    continue;
                }

                sf.setAccessible(true);
                df.setAccessible(true);

                df.set(destination, sf.get(source));
            }
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException("Can't convert object", e);
        }
    }
}
