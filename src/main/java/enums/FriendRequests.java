package enums;

public enum FriendRequests {
    REQUESTED("requested"),
    PENDING("pending"),
    ACCEPTED("accepted");
    private String value;
    FriendRequests(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
