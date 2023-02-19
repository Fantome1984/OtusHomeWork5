package data;

public enum ProfileFieldData {
    FIRSTNAME("fname"),
    LASTNAME("lname"),
    FIRSTNAMELATIN("fname_latin"),
    LASTNAMELATIN("lname_latin"),
    BLOGNAME("blog_name"),
    COMPANY("company"),
    WORK("work"),
    CONTACTONE("contact-0-value"),
    CONTACTTWO("contact-1-value");


    private String name;

    ProfileFieldData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
