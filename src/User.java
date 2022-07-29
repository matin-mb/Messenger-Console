import java.util.ArrayList;


public class User {
    public String username;
    //public String password;
    public StringBuilder password;
    public ArrayList<String> followers = new ArrayList<>();
    public ArrayList<String> followings = new ArrayList<>();
    //public String bio;
    public StringBuilder bio;
    public String securityQ;
    public String securityA;


    public static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username, String password, String bio) {
        this.username = username;
        this.password = new StringBuilder(password);
        if(bio != null)
        this.bio = new StringBuilder(bio);
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", followers=" + followers +
                ", followings=" + followings +
                ", bio='" + bio + '\'' +
                '}';
    }
}
