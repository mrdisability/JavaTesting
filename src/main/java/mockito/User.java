package mockito;

import java.util.Objects;

public class User {
    public enum UserType { REGULAR_USER, ADMIN_USER };

    private String username;
    private String password;

    //User is live and can log in
    private boolean live = true;

    private final UserType userType;

    User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public static User createRegularUser(String username, String password) {
        return new User(username, password, UserType.REGULAR_USER);
    }

    public static User createAdminUser(String username, String password) {
        return new User(username, password, UserType.ADMIN_USER);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLive() {
        return live;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return live == user.live && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, live);
    }
}
