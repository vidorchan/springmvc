package main.java.vidor;

public class UserInfo {

    private String userId;

    private String username;

    private int age;

    public UserInfo() {
    }

    public UserInfo(String userId, String username, int age) {
        this.userId = userId;
        this.username = username;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}