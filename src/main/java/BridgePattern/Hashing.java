package BridgePattern;

public abstract class Hashing {
    private HashFunction implementation;

    public abstract String hashDocument(String string);

    public HashFunction getImplementation() {
        return implementation;
    }

    public void setImplementation(HashFunction implementation) {
        this.implementation = implementation;
    }
}
