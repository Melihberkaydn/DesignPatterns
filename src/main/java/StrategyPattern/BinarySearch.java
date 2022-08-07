package StrategyPattern;

import java.util.List;

public class BinarySearch implements SearchStrategy {

    @Override
    public int performSearch(List<Chapter> list, String chapterName) {
        //base case
        if (list.isEmpty()) return -1;
        //recursive case
        Chapter middleChapter = list.get(list.size() / 2);
        if (middleChapter.getName().compareTo(chapterName) > 0) {
            return performSearch(list.subList(0, list.size() / 2), chapterName);
        }

        if (middleChapter.getName().compareTo(chapterName) < 0) {
            return performSearch(list.subList(list.size() / 2 + 1, list.size()), chapterName);
        }
        assert middleChapter.getName().equals(chapterName);
        return middleChapter.getPageNumber();
    }
}
