package StrategyPattern;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    @Override
    public int performSearch(List<Chapter> list, String chapterName) {
        for (Chapter ch: list
        ) {
            if (ch.getName().equals(chapterName)) {
                return ch.getPageNumber();
            }
        }
        return -1;
    }
}
