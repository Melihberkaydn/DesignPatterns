package BridgePattern.HashingExample;

public class EnterpriseHashing extends Hashing {

    public EnterpriseHashing() {
        setImplementation(new CryptoSecureHashAlgorithm());
    }

    @Override
    public String hashDocument(String string) {
        return getImplementation().calculateHashCode(string);
    }
}
