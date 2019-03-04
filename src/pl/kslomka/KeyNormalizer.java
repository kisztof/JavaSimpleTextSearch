package pl.kslomka;

public class KeyNormalizer implements IndexNormalizer {
    @Override
    public String normalize(String string) {
        return string
                .replaceAll("[^A-Za-z0-9 ]", "")
                .toLowerCase();
    }
}
