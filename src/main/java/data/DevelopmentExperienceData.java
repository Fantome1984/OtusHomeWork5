package data;

public enum DevelopmentExperienceData {
   JUSTSTARTED("Только начал"),
   ONEYEAR("1 год");

   private String names;

    DevelopmentExperienceData(String names) {
        this.names = names;
    }

    public String getName() {
        return names;
    }
}
