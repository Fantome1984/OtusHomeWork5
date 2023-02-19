package data;

public enum DevelopmentlanguagesData {

    C("1"),

    JAVA("Java");

  private String name;

    DevelopmentlanguagesData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
