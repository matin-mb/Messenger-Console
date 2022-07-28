import java.util.ArrayList;

public class Reaction {
    String comment;
    int like;
    int dislike;
    User user;
    int post_id;
    public static ArrayList<Reaction> reactions = new ArrayList<>();

    public Reaction() {
    }

    public Reaction(String comment, int like, int dislike, User user) {
        this.comment = comment;
        this.like = like;
        this.dislike = dislike;
        this.user = user;
    }

}
