package data;

public enum CommunicationData {
    VK("vk"),
    FACEBOOK("facebook"),
    VKEXP("1-service'"),
    FACEBOOKEXP("0-service'");





    private String name;

    CommunicationData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
