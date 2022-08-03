import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static Connection connection ;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dataBaseInit();
        Manager manager = new Manager();
        manager.start();
    }

    public static void dataBaseInit() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysocial", "root" ,
                "2231382");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        while (resultSet.next()){
            if(resultSet.getInt("type") == 1){
                PersonalUser personalUser = new PersonalUser(resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("bio"));
                personalUser.securityQ = resultSet.getString("securityQ");
                personalUser.securityA = resultSet.getString("securityA");
                PersonalUser.allPersonalUsers.add(personalUser);
                User.allUsers.add(personalUser);

            }
            else if(resultSet.getInt("type") == 2){
                CommercialUser commercialUser = new CommercialUser(resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("bio"));
                commercialUser.securityQ = resultSet.getString("securityQ");
                commercialUser.securityA= resultSet.getString("securityA");
                CommercialUser.allCommercialUsers.add(commercialUser);
                User.allUsers.add(commercialUser);

            }

        }

        resultSet = statement.executeQuery("select * from followlist");
        while (resultSet.next()){

            int follower_id = resultSet.getInt("follower_id") , followee_id = resultSet.getInt("followee_id");
            User follower, followee ;
            follower = User.allUsers.get(follower_id - 1);
            followee = User.allUsers.get(followee_id - 1);

            follower.followings.add(followee.username);
            followee.followers.add(follower.username);
        }

        resultSet = statement.executeQuery("select * from posts");
        while (resultSet.next()){
            User author = User.allUsers.get(resultSet.getInt("user_id") - 1);
            Post post = new Post(resultSet.getString("content"),author);
            post.postTime = resultSet.getObject("postDateTime", LocalDateTime.class);
            //System.out.println(post.postTime);

            Post.allPosts.add(post);
        }

        resultSet = statement.executeQuery("select * from reactions");
        while (resultSet.next()){
            User commenter = User.allUsers.get(resultSet.getInt("user_id") - 1);
            Reaction reaction = new Reaction(resultSet.getString("comment"),resultSet.getInt("liked"),
                    resultSet.getInt("disliked"),commenter);
            reaction.post_id = resultSet.getInt("post_id");
            Post post = Post.allPosts.get(resultSet.getInt("post_id") - 1);
            post.reactions.add(reaction);
        }

        resultSet = statement.executeQuery("select * from privatechats");
        while (resultSet.next()){

            Secret_Chat secret_chat = null;
            for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
                if( (all_secret_chat.user1.equals(resultSet.getString("user1_id")) && all_secret_chat.user2.equals(resultSet.getString("user2_id") ) )
                        || (all_secret_chat.user2.equals(resultSet.getString("user1_id")) && all_secret_chat.user1.equals(resultSet.getString("user2_id") ) ) )
                {
                    secret_chat = all_secret_chat;
                }
            }
            if(secret_chat != null){
                Chats chats = new Chats();
                chats.receiver = resultSet.getString("user2_id");
                chats.sender = resultSet.getString("user1_id");
                chats.text = new StringBuilder(resultSet.getString("text"));
                chats.replied = resultSet.getInt("replied");
                chats.forwarded = resultSet.getInt("forwarded");
                secret_chat.block = resultSet.getInt("blocked");
                chats.ID = 1;

                secret_chat.thisPVChats.add(chats);
            }
            else {
                secret_chat = new Secret_Chat();
                secret_chat.user1 = resultSet.getString("user1_id");
                secret_chat.user2 = resultSet.getString("user2_id");
                Chats chats = new Chats();
                chats.receiver = resultSet.getString("user2_id");
                chats.sender = resultSet.getString("user1_id");
                chats.text = new StringBuilder(resultSet.getString("text"));
                chats.replied = resultSet.getInt("replied");
                chats.forwarded = resultSet.getInt("forwarded");
                chats.ID = secret_chat.thisPVChats.size() + 1;

                secret_chat.thisPVChats.add(chats);
                //secret_chat.thisPVChats.add(resultSet.)
                Secret_Chat.all_Secret_Chats.add(secret_chat);
            }

        }

        resultSet = statement.executeQuery("select * from allgroups" );
        while (resultSet.next()){
            Group group = null;
            for (Group group1 : Group.groups) {
                if(group1.admin.equals(resultSet.getString("groupAdmin"))){
                    group = group1;
                }
            }

            if(group != null){
                group.users.add(resultSet.getString("member"));
            }
            else {
                group = new Group();
                group.id = resultSet.getString("group_id");
                group.admin = resultSet.getString("groupAdmin");
                group.name = resultSet.getString("groupName");
                group.users.add(resultSet.getString("member"));

                Group.groups.add(group);
            }

        }

        resultSet = statement.executeQuery("select * from groupchats" );
        while (resultSet.next()){
            Group group;
            int groupId = resultSet.getInt("group_id");
            group = Group.groups.get(groupId - 1);

            //group.groupChats.add(resultSet.getString())
            Chats chats = new Chats();
            chats.text = new StringBuilder(resultSet.getString("text"));
            chats.sender = resultSet.getString("sender_id");
            chats.replied = resultSet.getInt("replied");
            chats.forwarded = resultSet.getInt("forwarded");

            group.groupChats.add(chats);


        }

        resultSet = statement.executeQuery("select * from groupclosed");
        while (resultSet.next()){
            String groupid = resultSet.getString("group_id");
            Group group = null;
            for (Group group1 : Group.groups) {
                if(group1.id.equals(groupid))
                    group = group1;
            }
            if(group != null)
                group.closed_users.add(resultSet.getString("banned_user"));

        }

        resultSet = statement.executeQuery("select * from viewing");
        while (resultSet.next()){

            Post.allPosts.get(resultSet.getInt("post_id") - 1).allView.add(resultSet.getString("viewer"));

        }

    }

    public static void accountRecommender(User myUser) {

        ArrayList<String> myfollowings = new ArrayList<>();
        myfollowings.addAll(myUser.followings);
        ArrayList<User> releative = new ArrayList<>();

        for (String following : myUser.followings) {
            User followingUser = getUser(following);
            if(followingUser == null) continue;

            for (String f : followingUser.followings) {

                if(!myfollowings.contains(f) && !myUser.username.equals(f)){
                    User userf = getUser(f);
                    if(userf == null) continue;
                    releative.add(userf);
                }

            }

        }

        HashMap<User,Integer> countMap = new HashMap<>();
        for (User user : releative) {
            if (countMap.containsKey(user))
                countMap.put(user, countMap.get(user) + 1);
            else
                countMap.put(user, 1);

        }

        HashMap<User,Integer> countMap1 = sortByValue(countMap);
        releative = (ArrayList<User>) countMap1.keySet().stream().collect(Collectors.toList());

        System.out.println("Recommended Users:");
        for (int i = releative.size() - 1;  i >= 0; i--) {
            //System.out.println(releative.get(i));
            System.out.println( (releative.size() - i) + " - " + releative.get(i).username);
        }
        if(releative.size() == 0) System.out.println("There is no recommended user!");
        System.out.println();

    }

    private static User getUser(String following) {

        for (User allUser : User.allUsers) {
            if(allUser.username.equals(following))
                return allUser;

        }

        return null;
    }

    public static HashMap<User, Integer> sortByValue(HashMap<User, Integer> hm) {
        List<Map.Entry<User, Integer> > list =
                new LinkedList<Map.Entry<User, Integer> >(hm.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<User, Integer> >() {
            public int compare(Map.Entry<User, Integer> o1,
                               Map.Entry<User, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<User, Integer> temp = new LinkedHashMap<User, Integer>();
        for (Map.Entry<User, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static HashMap<Post, Integer> sortByValue1(HashMap<Post, Integer> hm) {
        List<Map.Entry<Post, Integer> > list =
                new LinkedList<Map.Entry<Post, Integer> >(hm.entrySet());


        Collections.sort(list, new Comparator<Map.Entry<Post, Integer> >() {
            public int compare(Map.Entry<Post, Integer> o1,
                               Map.Entry<Post, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<Post, Integer> temp = new LinkedHashMap<Post, Integer>();
        for (Map.Entry<Post, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void dataBaseFin() throws SQLException {

        Statement statement = connection.createStatement();

        statement.executeUpdate("truncate users");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into users" +
                "(username,password,bio,type,securityQ,securityA) values(?,?,?,?,?,?)");

        for (User allUser : User.allUsers) {
            preparedStatement.setString(1, allUser.username);
            preparedStatement.setString(2, allUser.password.toString());
            if(allUser.bio != null)
                preparedStatement.setString(3,allUser.bio.toString());
            else
                preparedStatement.setString(3 , "no bio!");

            if(allUser.getClass() == PersonalUser.class )
                preparedStatement.setInt(4,1);
            else
                preparedStatement.setInt(4,2);

            preparedStatement.setString(5, allUser.securityQ);
            preparedStatement.setString(6 , allUser.securityA);

            preparedStatement.executeUpdate();
        }


        statement.executeUpdate("truncate posts");
        preparedStatement = connection.prepareStatement("insert into posts" +
                "(user_id,content,postDateTime) values (?,?,?)");
        for (Post allPost : Post.allPosts) {
            preparedStatement.setInt(1,getId(allPost.user));
            preparedStatement.setString(2,allPost.text);
            preparedStatement.setObject(3 , allPost.postTime);

            preparedStatement.executeUpdate();
        }

        statement.executeUpdate("truncate reactions");
        preparedStatement = connection.prepareStatement("insert into reactions" +
                "(post_id,user_id,comment,liked,disliked) values (?,?,?,?,?)");


        for (int i = 0; i < Post.allPosts.size(); i++) {
            for (Reaction reaction : Post.allPosts.get(i).reactions) {
                reaction.post_id = i + 1;
                Reaction.reactions.add(reaction);
            }
        }

        for (Reaction reaction : Reaction.reactions) {
            preparedStatement.setInt(1 , reaction.post_id);
            preparedStatement.setInt(2 , getId(reaction.user));
            preparedStatement.setString(3 , reaction.comment);
            preparedStatement.setInt(4,reaction.like);
            preparedStatement.setInt(5,reaction.dislike);

            preparedStatement.executeUpdate();
        }

        statement.executeUpdate("truncate followlist");
        preparedStatement = connection.prepareStatement("insert into followlist" +
                "(follower_id,followee_id) values (?,?)");

        for (User allUser : User.allUsers) {
            for (String following : allUser.followings) {
                User followee = getUser(following);
                preparedStatement.setInt(1, getId(allUser));
                preparedStatement.setInt(2, getId(followee));
                preparedStatement.executeUpdate();
            }
        }

        statement.executeUpdate("truncate privatechats");
        preparedStatement = connection.prepareStatement("insert into privatechats" +
                "(user1_id,user2_id,text,replied,forwarded,blocked) values (?,?,?,?,?,?)");

        for (Secret_Chat all_secret_chat : Secret_Chat.all_Secret_Chats) {
            for (Chats pvChat : all_secret_chat.thisPVChats) {
                preparedStatement.setString(1, pvChat.sender);
                preparedStatement.setString(2, pvChat.receiver);
                preparedStatement.setString(3,pvChat.text.toString());
                preparedStatement.setInt(4,pvChat.replied);
                preparedStatement.setInt(5,pvChat.forwarded);
                preparedStatement.setInt(6,all_secret_chat.block);

                preparedStatement.executeUpdate();
            }
        }

        statement.executeUpdate("truncate allgroups");
        preparedStatement = connection.prepareStatement("insert into allgroups" +
                "(groupName,groupAdmin,member,group_id) values (?,?,?,?)");

        for (int i = 0; i < Group.groups.size(); i++) {
            for (String user : Group.groups.get(i).users) {
                preparedStatement.setString(1, Group.groups.get(i).name);
                preparedStatement.setString(2, Group.groups.get(i).admin);
                preparedStatement.setString(3,user);
                //preparedStatement.setInt(4, i + 1);
                preparedStatement.setInt(4 , Integer.parseInt(Group.groups.get(i).id));

                preparedStatement.executeUpdate();
            }
        }

        statement.executeUpdate("truncate groupchats");
        preparedStatement = connection.prepareStatement("insert into groupchats" +
                "(sender_id,text,group_id,replied,forwarded) values (?,?,?,?,?)");

        for (int i = 0; i < Group.groups.size(); i++) {
            for (Chats groupChat : Group.groups.get(i).groupChats) {
                preparedStatement.setString(1,groupChat.sender);
                preparedStatement.setString(2,groupChat.text.toString());
                preparedStatement.setInt(3, Integer.parseInt(Group.groups.get(i).id));
                preparedStatement.setInt(4,groupChat.replied);
                preparedStatement.setInt(5,groupChat.forwarded);
                preparedStatement.executeUpdate();

            }
        }


        statement.executeUpdate("truncate groupclosed");
        preparedStatement = connection.prepareStatement("insert into groupclosed" +
                "(group_id,banned_user) values (?,?)");

        for (Group group : Group.groups) {
            for (String closedUser : group.closed_users) {
                preparedStatement.setString(1 , group.id);
                preparedStatement.setString(2 , closedUser);
                preparedStatement.executeUpdate();
            }
        }

        statement.executeUpdate("truncate viewing");
        preparedStatement = connection.prepareStatement("insert into viewing" +
                "(post_id,viewer) values (?,?)");


        for (int i = 0; i < Post.allPosts.size(); i++) {
            for (String s : Post.allPosts.get(i).allView) {
                preparedStatement.setInt(1,i + 1);
                preparedStatement.setString(2,s);
                preparedStatement.executeUpdate();
            }
        }

    }

    public static int getId(User user){

        int id = -1;
        for (int i = 0; i < User.allUsers.size(); i++) {
            if(User.allUsers.get(i).username.equals(user.username))
                id = i + 1;
        }

        return id;
    }

    public static void postRecommender(PersonalUser personalUser) {

        ArrayList<String> followings = personalUser.followings;
        ArrayList<User> userFollowings = new ArrayList<>();
        for (String following : followings) {
            userFollowings.add(getUser(following));
        }

        ArrayList<User> sameInterest = new ArrayList<>();
        for (Post allPost : Post.allPosts) {
            for (Reaction reaction : allPost.reactions) {
                if(followings.contains(reaction.user.username)){
                    //check if personal user has liked or disliked
                    boolean liked = checkInterest(personalUser,allPost);
                    if( (liked && reaction.like ==1) || (!liked && reaction.dislike == 1) ){
                        sameInterest.add(reaction.user);
                    }
                }
            }
        }

        HashMap<User,Integer> countMap = new HashMap<>();
        for (User user : sameInterest) {
            if (countMap.containsKey(user))
                countMap.put(user, countMap.get(user) + 1);
            else
                countMap.put(user, 1);

        }

        HashMap<User,Integer> countMap1 = sortByValue(countMap);
        sameInterest = (ArrayList<User>) countMap1.keySet().stream().collect(Collectors.toList());

        ArrayList<User> sameInterest1 = new ArrayList<>();
        for (int i = sameInterest.size() - 1; i >= 0; i--) {
            sameInterest1.add(sameInterest.get(i));
        }

        ArrayList<Post> recommendedPost = new ArrayList<>();


        for (User user : sameInterest1) {
            for (Post allPost : Post.allPosts) {
                if( allPost.user.getClass() == CommercialUser.class ){

                    boolean seenByFollowing = checkHadReaction(user , allPost);
                    if(seenByFollowing && checkInterest((PersonalUser) user, allPost)) {
                        boolean seen = checkHadReaction(personalUser, allPost);
                        if (!seen) {
                            recommendedPost.add(allPost);
                        }
                    }

                }
            }
        }

        HashMap<Post,Integer> countMap2 = new HashMap<>();
        for (Post post : recommendedPost) {
            if (countMap2.containsKey(post))
                countMap2.put(post, countMap2.get(post) + 1);
            else
                countMap2.put(post, 1);

        }

        HashMap<Post,Integer> countMap3 = sortByValue1(countMap2);
        recommendedPost = (ArrayList<Post>) countMap3.keySet().stream().collect(Collectors.toList());


        ArrayList<Post> recommendedPost1 = new ArrayList<>();
        for (int i = recommendedPost.size() - 1; i >= 0 ; i--) {
            recommendedPost1.add(recommendedPost.get(i));
        }
        recommendedPost = recommendedPost1;


        System.out.println("Recommended Commercial Posts:");
        for (int i = 0; i < recommendedPost.size(); i++) {
            System.out.println( (i+1) + " - " + recommendedPost.get(i).user.username + " : " +
                    recommendedPost.get(i).text + "    " + recommendedPost.get(i).postTime.toLocalDate() + "  "
            + recommendedPost.get(i).postTime.toLocalTime());
        }
        if(recommendedPost.size() == 0 ) System.out.println("No recommended Commercial Posts!");
        System.out.println();


    }

    private static boolean checkHadReaction(User user, Post allPost) {
        boolean hadReacted = false;
        for (Reaction reaction : allPost.reactions) {
            if(reaction.user.username.equals(user.username)){
                hadReacted = true;
            }
        }
        return hadReacted;
    }

    private static boolean checkInterest(PersonalUser personalUser, Post allPost) {

        boolean likes = false;
        for (Reaction reaction : allPost.reactions) {
            if(reaction.user.username.equals(personalUser.username)){
                if(reaction.like == 1)
                    likes = true;
            }
        }

        return likes;
    }


//    public static void addSecurityQA(String securityQ , String securityA) throws SQLException {
//        Statement statement = connection.createStatement();
//        statement.executeUpdate("insert ")
//        PreparedStatement preparedStatement = connection.prepareStatement(
//                "insert into "
//        );
//    }

}
