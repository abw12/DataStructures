package Map.HashMap;

public class Bucket {

    private String key;
    private int value;

    public Bucket(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
