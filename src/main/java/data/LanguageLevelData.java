package data;

public enum LanguageLevelData {

    BEGINNER("Начальный уровень (Beginner)"),
    ELEMENTARY("Элементарный уровень (Elementary)");

    private String name;

     LanguageLevelData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
