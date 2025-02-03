import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
    private String password;
    private String userName;

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public abstract UserType getUserType();

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userName, password);
    }
}
}
