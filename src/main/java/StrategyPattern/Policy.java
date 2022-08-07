package StrategyPattern;

public class Policy {
    private Context context;

    public Policy(Context context) {
        this.context = context;
    }

    public void configure() {
        if (context.isChaptersSortedByName()) {
            context.setSearchAlgorithm(new BinarySearch());
        } else {
            context.setSearchAlgorithm(new LinearSearch());
        }
    }

    public Context getContext() {
        return context;
    }
}
