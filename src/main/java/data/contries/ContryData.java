package data.contries;

public enum ContryData {
    RUSSIA("Россия");

    private String contryName;

    ContryData(String contryName) {
        this.contryName = contryName;
    }

    public String getContryName() {
        return contryName;
    }
}
