package data;

public enum GenderData {
    MALE("m"),
    FAMALE("f");

    private String name;

    GenderData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
