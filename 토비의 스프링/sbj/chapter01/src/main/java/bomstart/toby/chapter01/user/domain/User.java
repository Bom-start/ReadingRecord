package bomstart.toby.chapter01.user.domain;

/**
 * 유저 정보를 저장할 자바빈
 */
public class User {
    String id;
    String name;
    String password;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
