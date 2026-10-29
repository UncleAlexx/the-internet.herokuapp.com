package tests.testHelpers;

import java.util.Comparator;

public abstract class ComparableHelpers {
    public static <T> boolean isSorted(T[] comparableItems, Comparator<T> comparator){
        for (int i = 0; i < comparableItems.length - 1; i++){
            if((comparator.compare(comparableItems[i], comparableItems[i + 1])) > 0){
                return false;
            }
        }
        return true;
    }
}
