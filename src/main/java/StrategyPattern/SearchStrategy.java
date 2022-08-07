package StrategyPattern;

import java.util.List;

public interface SearchStrategy {
    int performSearch(List<Chapter> book, String name);
}

