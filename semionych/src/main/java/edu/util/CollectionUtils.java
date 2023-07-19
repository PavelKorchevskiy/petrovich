package edu.util;

import java.util.List;

public class CollectionUtils {

    public static <T> T getRandomElementFromList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get((int) (Math.random() * list.size()));
    }
}
