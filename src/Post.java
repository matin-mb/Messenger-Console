import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Post {
    String text ;
    User user;
    LocalDateTime postTime;
//    LocalDate postDate;
//    LocalTime postTime;

    ArrayList<Reaction> reactions = new  ArrayList<Reaction>();
    public static ArrayList<Post> allPosts = new ArrayList<Post>();
    public static ArrayList<String> allView = new ArrayList<>();

    public Post(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}
