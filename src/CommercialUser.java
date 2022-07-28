import java.util.ArrayList;

public class CommercialUser extends User {
    static ArrayList<CommercialUser> allCommercialUsers = new ArrayList<CommercialUser>();


    public CommercialUser(String username, String password, String bio) {
        super(username, password, bio);
    }

    public CommercialUser() {
    }

//    @Override
//    public String toString() {
//        return "CommercialUser{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", followers=" + followers +
//                ", followings=" + followings +
//                ", bio='" + bio + '\'' +
//                '}';
//    }
}


