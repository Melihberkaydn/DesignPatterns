package BridgePattern.HashingExample;

public class PreviewHashing extends Hashing {

    private static final int MAX_EXAM_LENGTH = 1000;

    public PreviewHashing() {
        setImplementation(new SimpleHashAlgorithm());
    }

    @Override
    public String hashDocument(String string) {
        if (string.length() > MAX_EXAM_LENGTH) {
            throw new IllegalArgumentException("Exam too long!");
        } else {
            return getImplementation().calculateHashCode(string);
        }
    }
}
