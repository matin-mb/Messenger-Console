import java.util.ArrayList;

public class Group {

    String name;
    String admin;
    String id;
    ArrayList<String> closed_users = new ArrayList<String>();
    ArrayList<String > users = new ArrayList<String>();
    ArrayList<Chats> groupChats = new ArrayList<Chats>();

    public static ArrayList<Group> groups = new ArrayList<Group>();


}
