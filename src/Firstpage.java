//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Firstpage {
//
//    Scanner scanner =new Scanner(System.in);
//
//    public void signUp(String username, String password,int kind)
//    {
//        PersonalUser tempUser = new PersonalUser();
//        tempUser.username ="parsann";
//        tempUser.password = "1234567l";
//        tempUser.bio = "I'm 19 from Sabzevar!";
//        PersonalUser.allPersonalUsers.add(tempUser);
//
//        PersonalUser tempUser2 = new PersonalUser();
//        tempUser2.username ="matin";
//        tempUser2.password = "12345678";
//        tempUser2.bio = "I'm 19";
//        PersonalUser.allPersonalUsers.add(tempUser2);
//
//        if(kind==1)
//        {
//            PersonalUser personalUser =new PersonalUser();
//            personalUser.password = password;
//            personalUser.username = username;
//            PersonalUser.allPersonalUsers.add(personalUser);
//
//            boolean repeatHomePage = true;
//
//            while (repeatHomePage) {
//                repeatHomePage = false;
//                // User interact
//                printHomePage();
//
//                int option= Integer.parseInt(scanner.nextLine());
//
//                if(option == 1){
//                    int t=0;
//                    for(int i=Post.allPosts.size()-1;i>Post.allPosts.size()-20 && i>=0 ;i--)
//                    {
//                        System.out.println(String.valueOf(++t)+". " + Post.allPosts.get(i).text);
//                    }
//                    System.out.println("Do you want to react to these posts");
//                    System.out.println("1. Yes");
//                    System.out.println("2. No");
//                    System.out.println("0. Back");
//                    int num = Integer.parseInt(scanner.nextLine());
//                    if(num==1)
//                    {
//                        System.out.println("Please enter the comment number...");
//                        int num2=Integer.parseInt(scanner.nextLine());
//                        System.out.println("Do you want to add comment to this post or just react or both...");
//                        System.out.println("1. Add Comment");
//                        System.out.println("2. Reaction");
//                        System.out.println("3. Both");
//                        int num3=Integer.parseInt(scanner.nextLine());
//                        if (num3==1)
//                        {
//                            System.out.println("Please add your comment...");
//                            Reaction reaction =new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.comment=scanner.nextLine();
//                            Post.allPosts.get(Post.allPosts.size()-num).reactions.add(reaction);
//                            reaction.user=personalUser;
//                        }
//                        else if(num3==2)
//                        {
//                            System.out.println("Please like or this like this post...");
//                            System.out.println("1. Like");
//                            System.out.println("2. dislike");
//                            int num4=Integer.parseInt(scanner.nextLine());
//                            Reaction reaction = new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.user=personalUser;
//                            if (num4==1)
//                            {
//                                reaction.like=1;
//
//                            }
//                            if(num4==2)
//                            {
//                                reaction.dislike=1;
//
//                            }
//                        }
//                        else if(num3==3)
//                        {
//                            System.out.println("Please add your comment...");
//                            Reaction reaction =new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.comment=scanner.nextLine();
//                            Post.allPosts.get(Post.allPosts.size()-num).reactions.add(reaction);
//                            reaction.user=personalUser;
//                            System.out.println("Please like or this like this post...");
//                            System.out.println("1. Like");
//                            System.out.println("2. dislike");
//                            int num4=Integer.parseInt(scanner.nextLine());
//                            if (num4==1)
//                            {
//                                reaction.like=1;
//
//                            }
//                            if(num4==2)
//                            {
//                                reaction.dislike=1;
//
//                            }
//                        }
//
//                    }
//                    else if(num==2)
//                    {
//                        System.out.println("to see the reactions enter the post's number...");
//                        t=0;
//                        for(int i=Post.allPosts.size()-1;i>Post.allPosts.size()-20 && i>=0 ;i--)
//                        {
//                            System.out.println(String.valueOf(++t)+". " + Post.allPosts.get(i).text);
//                        }
//                        int num2= Integer.parseInt(scanner.nextLine());
//                        System.out.println("Please enter your number...");
//                        System.out.println("1. Show comments");
//                        System.out.println("2. Show likes and dislikes");
//                        int num3=Integer.parseInt(scanner.nextLine());
//                        if(num3==1)
//                        {
//                            int f=0;
//                            System.out.println("   "+"\t"+"Username"+"\t"+"Comment");
//                            for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
//                            {
//                                if(!Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).comment.isEmpty())
//                                {
//                                    System.out.println(String.valueOf(++f)+". "+"\t" +Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).user.username+"\t"+Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).comment);
//                                }
//                            }
//
//                        }
//                        else if(num3==2)
//                        {
//                            int f=0;
//                            System.out.println("   "+"\t"+"Username"+"\t"+"like/dislike");
//                            for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
//                            {
//                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).like == 1) {
//                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "like");
//                                }
//                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).dislike == 1) {
//                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "dislike");
//                                }
//
//                            }
//                        }
//
//                    }
//
//                    repeatHomePage=true;
//
//                }
//                else if(option == 2) {
//                    Post post = new Post();
//                    System.out.println("Start your text  with ADD TEXT and finish it with POST...");
//
//                    String text =  scanner.nextLine();
//
//                    while (!text.equals("ADD TEXT"))
//                    {
//                        System.out.println("invalid start! please write down ADD TEXT...");
//                        text = scanner.nextLine();
//                    }
//                    text = scanner.nextLine();
//
//                    post.text=text;
//                    post.user=personalUser;
//                    Post.allPosts.add(post);
//                    text = scanner.nextLine();
//
//                    while (!text.equals("POST")) {
//                        System.out.println("invalid finishing! please write down POST...");
//                        text = scanner.nextLine();
//                    }
//                    repeatHomePage=true;
//                }
//                else if(option == 3) {
//
//                    System.out.println("enter your number...");
//                    ArrayList<String> helpWithUsers = new ArrayList<String>();
//
//                    System.out.println("Personal_users:");
//                    int t=0;
//                    for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
//                        if (PersonalUser.allPersonalUsers.get(i).username.equals(personalUser.username)) {
//                        } else {
//                            boolean let = true;
//                            for (int j = 0; j < personalUser.followers.size() && let; j++) {
//                                if (personalUser.followers.get(j).username.equals(PersonalUser.allPersonalUsers.get(i).username)) {
//                                    let = false;
//                                }
//                            }
//                            if (let) {
//                                System.out.println(String.valueOf(++t) + ". " + PersonalUser.allPersonalUsers.get(i).username);
//                                helpWithUsers.add(PersonalUser.allPersonalUsers.get(i).username);
//                            }
//
//                        }
//                    }
//                    System.out.println("0. Back");
//                    int thisnumber =Integer.parseInt(scanner.nextLine());
//                    if (thisnumber == 0) {
//                    } else {
//                        for (int j = 0; j < PersonalUser.allPersonalUsers.size(); j++) {
//                            if (PersonalUser.allPersonalUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
//                                personalUser.followers.add(PersonalUser.allPersonalUsers.get(j));
//                                PersonalUser.allPersonalUsers.get(j).followings.add(personalUser);
//                                j=PersonalUser.allPersonalUsers.size();
//                                repeatHomePage = true;
//
//                            }
//                        }
//                    }
//
//                }
//                else if(option == 4){
//
//                }
//                else if(option == 5){
//                    System.out.println("Username: " + personalUser.username );
//                    System.out.println("Password: " + personalUser.password );
//                    System.out.println("Bio: " + personalUser.bio );
//                    System.out.println("EmailAddress: " + personalUser.emailAddress );
//                    System.out.println("My followings: ");
//                    for (int i=0;i<personalUser.followings.size();i++)
//                    {
//                        System.out.println(personalUser.followings.get(i).username);
//                    }
//                    System.out.println("My followers: ");
//                    for (int i=0;i<personalUser.followers.size();i++)
//                    {
//                        System.out.println(String.valueOf(i+1)+". "+personalUser.followers.get(i).username);
//                    }
//
//
//
//
//
//
//                }
//                else if(option == 0){
//                    Manager.start();
//
//                }
//
//
//
//            }
//
//
//        }
//
//        else
//        {
//            CommercialUser commercialUser = new CommercialUser();
//
//        }
//
//    }
//
//    public static void printHomePage(){
//        System.out.println("Welcome to HomePage!\nChoose one to do:\n1-Visit Recent Posts\n2-Create post\n3-Follow new users\n4-Show Stats\n" +
//                "5-View my Profile\n0-Log out");
//    }
//
//    public static void printNewPeople(ArrayList<User> followings , String myUsername){
//        ArrayList<String> userNames = new ArrayList<>();
//        for (User following : followings) {
//            userNames.add(following.username);
//        }
//
//        System.out.println("New Users:");
//        for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
//            if(!userNames.contains(PersonalUser.allPersonalUsers.get(i).username)
//                    && !PersonalUser.allPersonalUsers.get(i).username.equals(myUsername)) {
//                System.out.println("Id: " + PersonalUser.allPersonalUsers.get(i).username
//                        + "\nBio: " + PersonalUser.allPersonalUsers.get(i).bio);
//            }
//        }
//
//    }
//
//
//    public void login(PersonalUser personalUser)
//    {
//
//    }
//    public void login(CommercialUser commercialUser)
//    {
//
//    }
//
//
//}


//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Firstpage {
//
//    Scanner scanner =new Scanner(System.in);
//
//    public void signUp(String username, String password,int kind)
//    {
////        PersonalUser tempUser = new PersonalUser();
////        tempUser.username ="parsann";
////        tempUser.password = "1234567l";
////        tempUser.bio = "I'm 19 from Sabzevar!";
////        PersonalUser.allPersonalUsers.add(tempUser);
////        //User.allUsers.add(tempUser);
////
////        PersonalUser tempUser2 = new PersonalUser();
////        tempUser2.username ="matin";
////        tempUser2.password = "12345678";
////        tempUser2.bio = "I'm 19";
////        PersonalUser.allPersonalUsers.add(tempUser2);
////        //User.allUsers.add(tempUser2);
//
//        if(kind==1)
//        {
//            PersonalUser personalUser =new PersonalUser();
//            personalUser.password = password;
//            personalUser.username = username;
//            PersonalUser.allPersonalUsers.add(personalUser);
//
//            boolean repeatHomePage = true;
//
//            while (repeatHomePage) {
//                repeatHomePage = false;
//                // User interact
//                printHomePage();
//
//                int option= Integer.parseInt(scanner.nextLine());
//
//                if(option == 1){
//                    int t=0;
//                    for(int i=Post.allPosts.size()-1;i>Post.allPosts.size()-20 && i>=0 ;i--)
//                    {
//                        System.out.println(String.valueOf(++t)+". " + Post.allPosts.get(i).text);
//                    }
//                    System.out.println("Do you want to react to these posts");
//                    System.out.println("1. Yes");
//                    System.out.println("2. No");
//                    System.out.println("0. Back");
//                    int num = Integer.parseInt(scanner.nextLine());
//                    if(num==1)
//                    {
//                        System.out.println("Please enter the comment number...");
//                        int num2=Integer.parseInt(scanner.nextLine());
//                        System.out.println("Do you want to add comment to this post or just react or both...");
//                        System.out.println("1. Add Comment");
//                        System.out.println("2. Reaction");
//                        System.out.println("3. Both");
//                        int num3=Integer.parseInt(scanner.nextLine());
//                        if (num3==1)
//                        {
//                            System.out.println("Please add your comment...");
//                            Reaction reaction =new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.comment=scanner.nextLine();
//                            Post.allPosts.get(Post.allPosts.size()-num).reactions.add(reaction);
//                            reaction.user=personalUser;
//                        }
//                        else if(num3==2)
//                        {
//                            System.out.println("Please like or this like this post...");
//                            System.out.println("1. Like");
//                            System.out.println("2. dislike");
//                            int num4=Integer.parseInt(scanner.nextLine());
//                            Reaction reaction = new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.user=personalUser;
//                            if (num4==1)
//                            {
//                                reaction.like=1;
//
//                            }
//                            if(num4==2)
//                            {
//                                reaction.dislike=1;
//
//                            }
//                        }
//                        else if(num3==3)
//                        {
//                            System.out.println("Please add your comment...");
//                            Reaction reaction =new Reaction();
//                            reaction.like=0;
//                            reaction.dislike=0;
//                            reaction.comment=scanner.nextLine();
//                            Post.allPosts.get(Post.allPosts.size()-num).reactions.add(reaction);
//                            reaction.user=personalUser;
//                            System.out.println("Please like or this like this post...");
//                            System.out.println("1. Like");
//                            System.out.println("2. dislike");
//                            int num4=Integer.parseInt(scanner.nextLine());
//                            if (num4==1)
//                            {
//                                reaction.like=1;
//
//                            }
//                            if(num4==2)
//                            {
//                                reaction.dislike=1;
//
//                            }
//                        }
//
//                    }
//                    else if(num==2)
//                    {
//                        System.out.println("to see the reactions enter the post's number...");
//                        t=0;
//                        for(int i=Post.allPosts.size()-1;i>Post.allPosts.size()-20 && i>=0 ;i--)
//                        {
//                            System.out.println(String.valueOf(++t)+". " + Post.allPosts.get(i).text);
//                        }
//                        int num2= Integer.parseInt(scanner.nextLine());
//                        System.out.println("Please enter your number...");
//                        System.out.println("1. Show comments");
//                        System.out.println("2. Show likes and dislikes");
//                        int num3=Integer.parseInt(scanner.nextLine());
//                        if(num3==1)
//                        {
//                            int f=0;
//                            System.out.println("   "+"\t"+"Username"+"\t"+"Comment");
//                            for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
//                            {
//                                if(!Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).comment.isEmpty())
//                                {
//                                    System.out.println(String.valueOf(++f)+". "+"\t" +Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).user.username+"\t"+Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).comment);
//                                }
//                            }
//
//                        }
//                        else if(num3==2)
//                        {
//                            int f=0;
//                            System.out.println("   "+"\t"+"Username"+"\t"+"like/dislike");
//                            for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
//                            {
//                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).like == 1) {
//                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "like");
//                                }
//                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).dislike == 1) {
//                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "dislike");
//                                }
//
//                            }
//                        }
//
//                    }
//
//                    repeatHomePage=true;
//
//                }
//                else if(option == 2) {
//                    Post post = new Post();
//                    System.out.println("Start your text  with ADD TEXT and finish it with POST...");
//
//                    String text =  scanner.nextLine();
//
//                    while (!text.equals("ADD TEXT"))
//                    {
//                        System.out.println("invalid start! please write down ADD TEXT...");
//                        text = scanner.nextLine();
//                    }
//                    text = new String(scanner.nextLine());
//                    post.text=text;
//                    post.user=personalUser;
//                    Post.allPosts.add(post);
//                    text = new String(scanner.nextLine());
//
//                    while (!text.equals("POST")) {
//                        System.out.println("invalid finishing! please write down POST...");
//                        text = new String(scanner.nextLine());
//                    }
//                    repeatHomePage=true;
//                }
//                else if(option == 3) {
//
//
//                    System.out.println("enter your number...");
//                    ArrayList<String> helpWithUsers = new ArrayList<String>();
//
//                    System.out.println("Personal_users:");
//                    int t=0;
//                    for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
//                        if (PersonalUser.allPersonalUsers.get(i).username.equals(personalUser.username)) {
//                        } else {
//                            boolean let = true;
//                            for (int j = 0; j < personalUser.followers.size() && let; j++) {
//                                if (personalUser.followers.get(j).equals(PersonalUser.allPersonalUsers.get(i).username)) {
//                                    let = false;
//                                }
//                            }
//                            if (let) {
//                                System.out.println(String.valueOf(++t) + ". " + PersonalUser.allPersonalUsers.get(i).username);
//                                helpWithUsers.add(PersonalUser.allPersonalUsers.get(i).username);
//                            }
//
//                        }
//                    }
//                    System.out.println("0. Back");
//                    int thisnumber =Integer.parseInt(scanner.nextLine());
//                    if (thisnumber == 0) {
//                    } else {
//                        for (int j = 0; j < PersonalUser.allPersonalUsers.size(); j++) {
//                            if (PersonalUser.allPersonalUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
//                                personalUser.followers.add(PersonalUser.allPersonalUsers.get(j).username);
//                                PersonalUser.allPersonalUsers.get(j).followings.add(personalUser.username);
//                                j=PersonalUser.allPersonalUsers.size();
//                                repeatHomePage = true;
//
//                            }
//                        }
//                    }
//
//                }
//                else if(option == 4){
//
//                }
//                else if(option == 5){
//                    System.out.println("Username: " + personalUser.username );
//                    System.out.println("Password: " + personalUser.password );
//                    System.out.println("Bio: " + personalUser.bio );
//                    System.out.println("EmailAddress: " + personalUser.emailAddress );
//                    System.out.println("My followings: ");
//                    for (int i=0;i<personalUser.followings.size();i++)
//                    {
//                        System.out.println(personalUser.followings.get(i));
//                    }
//                    System.out.println("My followers: ");
//                    for (int i=0;i<personalUser.followers.size();i++)
//                    {
//                        System.out.println(String.valueOf(i+1)+". "+personalUser.followers.get(i));
//                    }
//
//
//
//
//
//
//                }
//                else if(option == 0){
//                    Manager.start();
//
//                }
//
//
//
//            }
//
//
//        }
//
//        else
//        {
//            CommercialUser commercialUser = new CommercialUser();
//
//        }
//
//    }
//
//    public static void printHomePage(){
//        System.out.println("Welcome to HomePage!\nChoose one to do:\n1-Visit Recent Posts\n2-Create post\n3-Follow new users\n4-Show Stats\n" +
//                "5-View my Profile\n0-Log out");
//    }
//
//    public static void printNewPeople(ArrayList<String> followings , String myUsername){
////        ArrayList<String> userNames = new ArrayList<>();
////        for (User following : followings) {
////            userNames.add(following.username);
////        }
//        System.out.println("New Users:");
////        for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
////            if(!userNames.contains(PersonalUser.allPersonalUsers.get(i).username)
////                    && !PersonalUser.allPersonalUsers.get(i).username.equals(myUsername)) {
////                System.out.println("Id: " + PersonalUser.allPersonalUsers.get(i).username
////                        + "\nBio: " + PersonalUser.allPersonalUsers.get(i).bio);
////            }
////        }
//        for (int i = 0; i < User.allUsers.size(); i++) {
//            if(!followings.contains(User.allUsers.get(i).username) &
//            User.allUsers.get(i).username.equals(myUsername)){
//                System.out.println("Id: " + User.allUsers.get(i).username
//                        + "\nBio: " + User.allUsers.get(i).bio);
//
//            }
//
//        }
//    }
//
//
//    public void login(PersonalUser personalUser)
//    {
//
//    }
//    public void login(CommercialUser commercialUser)
//    {
//
//    }
//
//
//
//
//
//
//}

import java.sql.SQLException;
import java.util.*;

public class Firstpage {

    int  counter=0;
    Scanner scanner =new Scanner(System.in);

    public void signUp(String username, String password,int kind) throws SQLException {


        if (kind == 1) {

            ArrayList<String> userNames = new ArrayList<>();
            for (PersonalUser allPersonalUser : PersonalUser.allPersonalUsers) {
                userNames.add(allPersonalUser.username);
            }

            PersonalUser personalUser = null;
            if(userNames.contains(username)){
                for (PersonalUser allPersonalUser : PersonalUser.allPersonalUsers) {
                    if(allPersonalUser.username.equals(username))
                        personalUser = allPersonalUser;
                }
            }
            else {
                personalUser = new PersonalUser();
                personalUser.password = password;
                personalUser.username = username;

                personalUser.securityQ = Manager.securityQuestion.toString();
                personalUser.securityA = Manager.securityAnswer.toString();
                Manager.securityQuestion.setLength(0);
                Manager.securityAnswer.setLength(0);

                PersonalUser.allPersonalUsers.add(personalUser);
                User.allUsers.add(personalUser);
            }

            Main.accountRecommender(personalUser);

            boolean repeatHomePage = true;

            while (repeatHomePage) {
                repeatHomePage = false;
                // User interact
                printHomePage_Personal();

                int option = Integer.parseInt(scanner.nextLine());

                if (option == 1) {

                    int t = 0;
                    for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                        System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Do you want to see the posts and react to them or just see the comments...");
                    System.out.println("1. Yes, see the posts and react to them");
                    System.out.println("2. No, just see the comments");
                    System.out.println("0. Back");
                    int num = Integer.parseInt(scanner.nextLine());
                    if (num == 1) {
                        t=0;
                        System.out.println("Please enter the comment number...");
                        for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                            System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                        }
                        int num2 = Integer.parseInt(scanner.nextLine());
                        boolean letlet=true;

                        for (int i=0;i<Post.allPosts.get(Post.allPosts.size() - num2).allView.size() && letlet;i++ )
                        {
                            if(Post.allPosts.get(Post.allPosts.size() - num2).allView.contains(personalUser.username))
                            {
                                letlet=false;
                            }
                        }
                        if(letlet) {
                            Post.allPosts.get(Post.allPosts.size() - num).allView.add(personalUser.username);
                        }
                        System.out.println("Do you want to add comment to this post or just react or both...");
                        System.out.println("1. Add Comment");
                        System.out.println("2. Reaction");
                        System.out.println("3. Both");
                        int num3 = Integer.parseInt(scanner.nextLine());



                        if (num3 == 1) {
                            System.out.println("Please add your comment...");
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.comment = scanner.nextLine();
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);
                            reaction.user = personalUser;
                        }
                        else if (num3 == 2) {
                            System.out.println("Please like or this like this post...");
                            System.out.println("1. Like");
                            System.out.println("2. dislike");
                            int num4 = Integer.parseInt(scanner.nextLine());
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.user = personalUser;
                            if (num4 == 1) {
                                reaction.like = 1;

                            }
                            if (num4 == 2) {
                                reaction.dislike = 1;

                            }
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);

                        }
                        else if (num3 == 3) {
                            System.out.println("Please add your comment...");
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.comment = scanner.nextLine();
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);
                            reaction.user = personalUser;
                            System.out.println("Please like or this like this post...");
                            System.out.println("1. Like");
                            System.out.println("2. dislike");
                            int num4 = Integer.parseInt(scanner.nextLine());
                            if (num4 == 1) {
                                reaction.like = 1;

                            }
                            if (num4 == 2) {
                                reaction.dislike = 1;

                            }
                        }

                    }
                    else if (num == 2) {
                        System.out.println("to see the reactions enter the post's number...");
                        t = 0;
                        for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                            System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                        }
                        int num2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Please enter your number...");
                        System.out.println("1. Show comments");
                        System.out.println("2. Show likes and dislikes");
                        int num3 = Integer.parseInt(scanner.nextLine());
                        if (num3 == 1) {
                            int f = 0;
                            System.out.println("   " + "\t" + "Username" + "\t" + "Comment");
                            for (int i = 0; i < Post.allPosts.get(Post.allPosts.size() - num2).reactions.size(); i++) {
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).comment!=null) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).comment);
                                }
                            }

                        }
                        else if (num3 == 2) {
                            int f = 0;
                            System.out.println("   " + "\t" + "Username" + "\t" + "like/dislike");
                            for (int i = 0; i < Post.allPosts.get(Post.allPosts.size() - num2).reactions.size(); i++) {
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).like == 1) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "like");
                                }
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).dislike == 1) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "dislike");
                                }

                            }
                        }

                    }

                    repeatHomePage = true;

                }
                else if (option == 2) {
                    Post post = new Post();
                    System.out.println("Please write down your post and enter -ENTER-  to finish it...");
                    String text = new String(scanner.nextLine());
                    post.text = text;
                    post.user = personalUser;
                    Post.allPosts.add(post);

                    repeatHomePage = true;
                }
                else if (option == 3) {
                    System.out.println("enter your number...");
                    System.out.println("1. Personal Users");
                    System.out.println("2. Commercial Users");
                    int follow_choice = Integer.parseInt(scanner.nextLine());
                    if (follow_choice == 1) {
                        System.out.println("enter your number...");
                        ArrayList<String> helpWithUsers = new ArrayList<String>();

                        System.out.println("Personal_users:");
                        int t = 0;
                        for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
                            if (PersonalUser.allPersonalUsers.get(i).username.equals(personalUser.username)) {
                            } else {
                                boolean let = true;
                                for (int j = 0; j < personalUser.followers.size() && let; j++) {
                                    if (personalUser.followers.get(j).equals(PersonalUser.allPersonalUsers.get(i).username)) {
                                        let = false;
                                    }
                                }
                                if (let) {
                                    System.out.println(String.valueOf(++t) + ". " + PersonalUser.allPersonalUsers.get(i).username);
                                    helpWithUsers.add(PersonalUser.allPersonalUsers.get(i).username);
                                }

                            }
                        }
                        System.out.println("0. Back");
                        int thisnumber = Integer.parseInt(scanner.nextLine());
                        if (thisnumber == 0) {
                        }
                        else {
                            for (int j = 0; j < PersonalUser.allPersonalUsers.size(); j++) {
                                if (PersonalUser.allPersonalUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
                                    personalUser.followers.add(PersonalUser.allPersonalUsers.get(j).username);
                                    PersonalUser.allPersonalUsers.get(j).followings.add(personalUser.username);
                                    j = PersonalUser.allPersonalUsers.size();
                                    repeatHomePage = true;

                                }
                            }
                        }
                    }
                    else if (follow_choice==2)
                    {
                        ArrayList<String> helpWithUsers = new ArrayList<String>();
                        System.out.println("enter your number...");

                        System.out.println("Commercial_users:");
                        int t = 0;
                        for (int i = 0; i < CommercialUser.allCommercialUsers.size(); i++) {

                            boolean let = true;
                            for (int j = 0; j < personalUser.followers.size() && let; j++) {
                                if (personalUser.followers.get(j).equals(CommercialUser.allCommercialUsers.get(i).username)) {
                                    let = false;
                                }

                                if (let) {
                                    System.out.println(String.valueOf(++t) + ". " + CommercialUser.allCommercialUsers.get(i).username);
                                    helpWithUsers.add(CommercialUser.allCommercialUsers.get(i).username);
                                }

                            }
                        }
                        System.out.println("0. Back");
                        int thisnumber = Integer.parseInt(scanner.nextLine());
                        if (thisnumber == 0) {
                        } else {
                            for (int j = 0; j < CommercialUser.allCommercialUsers.size(); j++) {
                                if (CommercialUser.allCommercialUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
                                    personalUser.followers.add(CommercialUser.allCommercialUsers.get(j).username);
                                    CommercialUser.allCommercialUsers.get(j).followings.add(personalUser.username);
                                    j = CommercialUser.allCommercialUsers.size();
                                    repeatHomePage = true;

                                }
                            }
                        }

                    }

                }
                else if (option==4) {
                    int t = 0;
                    boolean let = false;
                    ArrayList<Secret_Chat> thisS = new ArrayList<Secret_Chat>();
                    for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                        if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username) || Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                            let = true;
                            thisS.add(Secret_Chat.all_Secret_Chats.get(i));
                        }
                    }
                    Secret_Chat[] thisSe= new Secret_Chat[thisS.size()];


                    if (let) {

                        thisSe=thisS.toArray(thisSe);

                        System.out.println("All secret chats...");

                        for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                            if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username)) {
                                System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user2);
                            } else if (Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user1);
                            }
                        }

                    }
                    System.out.println(String.valueOf(0)  + ". a new secret chat");
                    int cSC =Integer.parseInt(scanner.nextLine());
                    if(cSC==0)
                    {
                        boolean let2=false;
                        Secret_Chat secret_chat = new Secret_Chat();

                        while(!let2) {
                            System.out.println("enter an ID");
                            String id = scanner.nextLine();
                            for (int i = 0; i < PersonalUser.allPersonalUsers.size() && !let2; i++) {
                                if (PersonalUser.allPersonalUsers.get(i).username.equals(id) && !personalUser.username.equals(id)) {
                                    let2 = true;
                                    secret_chat.user1 = personalUser.username;
                                    secret_chat.user2 = id;
                                    Secret_Chat.all_Secret_Chats.add(secret_chat);
                                }
                            }
                            if (!let2) {
                                System.out.println("invalid id");
                            }
                            else {
                                System.out.println("Please write down your first chat and finish you chatting with the word -end-...");
                                String chat1 = scanner.nextLine();
                                while (!chat1.equals("end")) {
                                    if (!chat1.isEmpty()) {
                                        Chats chats = new Chats();
                                        chats.ID = ++counter;
                                        chats.sender = personalUser.username;
                                        chats.receiver = secret_chat.user2;
                                        chats.text = new StringBuilder(chat1);
                                        Chats.allChats.add(chats);
                                        chats.forwarded=-1;
                                        chats.replied=-1;
                                        secret_chat.thisPVChats.add(chats);
                                    }
                                    chat1 = new String(scanner.nextLine());

                                }

                            }
                        }
                        repeatHomePage=true;
                    }
                    else {
                        Secret_Chat secret_chat = new Secret_Chat();
                        secret_chat = thisSe[cSC - 1];
                        int te = 0;
                        System.out.println("Chat...");


                        for (int i = 0; i < secret_chat.thisPVChats.size(); i++) {
                            if (secret_chat.thisPVChats.get(i).replied == -1 && secret_chat.thisPVChats.get(i).forwarded == -1) {
                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + secret_chat.thisPVChats.get(i).text);
                            } else if (secret_chat.thisPVChats.get(i).replied != -1) {
                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "replied to" + String.valueOf(secret_chat.thisPVChats.get(i).replied) + " : " + secret_chat.thisPVChats.get(i).text);

                            } else if (secret_chat.thisPVChats.get(i).forwarded != -1) {
                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(secret_chat.thisPVChats.get(i).forwarded).username + " : " + secret_chat.thisPVChats.get(i).text);
                            }

                        }
                        if (secret_chat.block == 0) {
                            boolean conWithChat = true;
                            System.out.println("\n");
                            System.out.println("\n");
                            System.out.println("Hint. to reply the nth line in your chat you must start your line with -rep_n:- or there is a normal chat ");
                            System.out.println("example:");
                            System.out.println("rep_2:perfect!");
                            System.out.println("Hint. to forward the nth line in your chat you must start your line with -for_n:- or there is a normal chat ");
                            System.out.println("example:");
                            System.out.println("for_5");
                            System.out.println();
                            System.out.println("2. delete");
                            System.out.println("1. edit");
                            System.out.println("0. Back or finish Chatting");
                            System.out.println("-1. Block");
                            while (conWithChat) {
                                String chat1 = scanner.nextLine();
                                if (!chat1.isEmpty()) {
                                    if (chat1.startsWith("rep")) {
                                        Chats chats = new Chats();
                                        chats.replied = Integer.parseInt(String.valueOf(chat1.charAt(4)));
                                        chats.forwarded = -1;
                                        chats.text = new StringBuilder(chat1.substring(6));
                                        chats.ID = ++counter;
                                        chats.sender = personalUser.username;
                                        if (secret_chat.user1.equals(personalUser.username)) {
                                            chats.receiver = secret_chat.user2;
                                        } else
                                            chats.receiver = secret_chat.user1;
                                        secret_chat.thisPVChats.add(chats);
                                        Chats.allChats.add(chats);


                                    } else if (chat1.startsWith("for")) {
                                        t = 0;
                                        System.out.println("to...?");
                                        for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                                            if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username)) {
                                                System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user2);
                                            } else if (Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                                System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user1);
                                            }
                                        }
                                        Chats chats = new Chats();
                                        chats.replied = -1;
                                        chats.forwarded = PersonalUser.findPU(username);
                                        chats.text = secret_chat.thisPVChats.get(Integer.parseInt(String.valueOf(chat1.charAt(4)))-1).text;
                                        chats.ID = ++counter;
                                        chats.sender = personalUser.username;

                                        int num = Integer.parseInt(scanner.nextLine());
                                        Secret_Chat secret_chat1 = new Secret_Chat();
                                        secret_chat1 = thisSe[num - 1];
                                        if (secret_chat1.user1.equals(personalUser.username))
                                            chats.receiver = secret_chat1.user2;
                                        else
                                            chats.receiver = secret_chat1.user1;
                                        secret_chat1.thisPVChats.add(chats);
                                        Chats.allChats.add(chats);
                                        conWithChat = false;
                                        repeatHomePage = true;
                                    }
                                    else if(chat1.equals("1")) {

                                        System.out.println("Which line do you want to edit?");
                                        te = 0;
                                        for (int i = 0; i < secret_chat.thisPVChats.size(); i++) {
                                            if (secret_chat.thisPVChats.get(i).replied == -1 && secret_chat.thisPVChats.get(i).forwarded == -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + secret_chat.thisPVChats.get(i).text);
                                            } else if (secret_chat.thisPVChats.get(i).replied != -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "replied to" + String.valueOf(secret_chat.thisPVChats.get(i).replied) + " : " + secret_chat.thisPVChats.get(i).text);

                                            } else if (secret_chat.thisPVChats.get(i).forwarded != -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(secret_chat.thisPVChats.get(i).forwarded).username + " : " + secret_chat.thisPVChats.get(i).text);
                                            }
                                        }
                                        boolean forwarded = false;
                                        while (!forwarded) {
                                            int num = Integer.parseInt(scanner.nextLine());
                                            if(num!=0) {
                                                if (secret_chat.thisPVChats.get(num - 1).forwarded == -1) {

                                                    System.out.println("Please type the new one.(without rep_n or for_n)");
                                                    secret_chat.thisPVChats.get(num - 1).text = new StringBuilder(scanner.nextLine());
                                                    forwarded=true;

                                                }
                                                else
                                                {
                                                    System.out.println("You can't edit forwarded messages. Please enter a new one or enter 0 to back");
                                                }

                                            }
                                            else {
                                                forwarded=true;
                                            }
                                            conWithChat = false;
                                            repeatHomePage = true;

                                        }
                                    }
                                    else if(chat1.equals("2"))
                                    {
                                        System.out.println("Which line do you want to edit?");
                                        te=0;
                                        for (int i = 0; i < secret_chat.thisPVChats.size(); i++) {
                                            if (secret_chat.thisPVChats.get(i).replied == -1 && secret_chat.thisPVChats.get(i).forwarded == -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + secret_chat.thisPVChats.get(i).text);
                                            } else if (secret_chat.thisPVChats.get(i).replied != -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "replied to" + String.valueOf(secret_chat.thisPVChats.get(i).replied) + " : " + secret_chat.thisPVChats.get(i).text);

                                            } else if (secret_chat.thisPVChats.get(i).forwarded != -1) {
                                                System.out.println(String.valueOf(++te) + ". " + secret_chat.thisPVChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(secret_chat.thisPVChats.get(i).forwarded).username + " : " + secret_chat.thisPVChats.get(i).text);
                                            }
                                        }
                                        int num = Integer.parseInt(scanner.nextLine());
                                        int id=secret_chat.thisPVChats.get(num-1).ID;
                                        Chats.allChats.remove(id-1);

                                        for (int i=0;i<secret_chat.thisPVChats.size();i++)
                                        {
                                            if(secret_chat.thisPVChats.get(i).replied==num)
                                            {
                                                secret_chat.thisPVChats.get(i).replied=-1;
                                            }
                                            else if(secret_chat.thisPVChats.get(i).replied>=num)
                                            {
                                                secret_chat.thisPVChats.get(i).replied--;
                                            }
                                            if(i>=num)
                                            {
                                                secret_chat.thisPVChats.get(i).ID--;
                                            }

                                        }
                                        secret_chat.thisPVChats.remove(num-1);
                                        for (int i=0;i<Chats.allChats.size();i++)
                                        {
                                            System.out.println(String.valueOf(Chats.allChats.get(i).ID)+"   "+Chats.allChats.get(i).text);
                                        }
                                        conWithChat = false;
                                        repeatHomePage = true;
                                    }
                                    else if (chat1.equals("0")) {
                                        conWithChat = false;
                                        repeatHomePage = true;
                                    }
                                    else if(chat1.equals("-1"))
                                    {
                                        if (secret_chat.user1.equals(personalUser.username))
                                            secret_chat.block=1;
                                        else
                                            secret_chat.block=2;
                                        conWithChat = false;
                                        repeatHomePage = true;



                                    }
                                    else {
                                        Chats chats = new Chats();
                                        chats.ID = ++counter;
                                        chats.sender = personalUser.username;
                                        if (secret_chat.user1.equals(personalUser.username)) {
                                            chats.receiver = secret_chat.user2;
                                        } else
                                            chats.receiver = secret_chat.user1;
                                        chats.text = new StringBuilder(chat1);
                                        Chats.allChats.add(chats);
                                        chats.replied = -1;
                                        chats.forwarded = -1;
                                        secret_chat.thisPVChats.add(chats);
                                        Chats.allChats.add(chats);

                                    }
                                }
                            }
                        }
                        else if (secret_chat.block==1)
                        {
                            System.out.println();
                            boolean l=false;
                            System.out.println("this id has been blocked by "+secret_chat.user1);
                            System.out.println("0. Back ");
                            if(personalUser.username.equals(secret_chat.user1)) {
                                System.out.println("-1. Unblock");
                                l=true;
                            }
                            String c = scanner.nextLine();

                            if (c.equals("0")) {
                                repeatHomePage = true;

                            } else if (c.equals("-1") && l) {
                                secret_chat.block = 0;
                                repeatHomePage = true;

                            }

                        }
                        else if (secret_chat.block==2) {
                            System.out.println();
                            boolean l=false;
                            System.out.println("this id has been blocked by " + secret_chat.user2);
                            System.out.println("0. Back ");
                            if (personalUser.username.equals(secret_chat.user2)) {
                                System.out.println("-1. Unblock");
                                l=true;
                            }
                            String c = scanner.nextLine();
                            if (c.equals("0")) {
                                repeatHomePage = true;

                            } else if (c.equals("-1") && l) {
                                secret_chat.block = 0;
                                repeatHomePage = true;
                            }
                        }
                    }
                }
                else if(option==5)
                {
                    Group group = new Group();
                    group.admin=personalUser.username;
                    System.out.println("Please type a name for your group...");
                    group.name=scanner.nextLine();

                    boolean letLoop = true;
                    String id=null;
                    while (letLoop) {
                        letLoop = false;
                        System.out.println("Please type an id for your group...");
                        id = scanner.nextLine();
                        while (id.isEmpty()) {
                            id = scanner.nextLine();
                        }
                        for (int i = 0; i < Group.groups.size() && !letLoop; i++) {
                            if (Group.groups.get(i).id.equals(id)) {
                                System.out.println("existed id");
                                letLoop = true;

                            }
                        }
                    }
                    group.id=id;
                    group.users.add(group.admin);
                    Group.groups.add(group);


                    System.out.println("Do you want to add users to your group");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int num = Integer.parseInt(scanner.nextLine());
                    if(num==1)
                    {
                        int t=0;
                        System.out.println("Add the users");
                        ArrayList<PersonalUser> perusers = new ArrayList<PersonalUser>();
                        for (int i=0;i<PersonalUser.allPersonalUsers.size();i++)
                        {
                            if(!PersonalUser.allPersonalUsers.get(i).username.equals(personalUser.username))
                            {
                                perusers.add(PersonalUser.allPersonalUsers.get(i));
                                System.out.println(String.valueOf(++t)+". "+PersonalUser.allPersonalUsers.get(i).username);
                            }
                        }
                        System.out.println("0. Back");
                        int num2 = Integer.parseInt(scanner.nextLine());
                        while(num2!=0) {
                            group.users.add(perusers.get(num2- 1).username);
                            String num_str =scanner.nextLine();

                            while (num_str.isEmpty())
                            {
                                num_str =scanner.nextLine();
                            }
                            num2=Integer.parseInt(num_str);

                        }
                        System.out.println();
                        System.out.println();
                        repeatHomePage = true;

                    }
                    else
                        repeatHomePage = true;



                }
                else if(option==6) {

                    System.out.println("My groups");
                    int t = 0;
                    ArrayList<Group> mygroups = new ArrayList<Group>();
                    for (int i = 0; i < Group.groups.size(); i++) {
                        if (Group.groups.get(i).users.contains(personalUser.username)) {
                            mygroups.add(Group.groups.get(i));
                            System.out.println(String.valueOf(++t) + ". " + Group.groups.get(i).name);
                        }
                    }
                    int num2 = Integer.parseInt(scanner.nextLine());
                    Group group = new Group();
                    group = mygroups.get(num2 - 1);
                    if (group.admin.equals(personalUser.username)) {
                        boolean repeatGroupPage = true;
                        while (repeatGroupPage) {
                            System.out.println("Enter your number...");
                            System.out.println("1. Chatting...");
                            System.out.println("2. Add member");
                            System.out.println("3. Group_Profile");
                            System.out.println("4. Members");
                            System.out.println("5. Change group_profile");
                            System.out.println("6. Ban member");
                            System.out.println("7. Allow ban_members");
                            System.out.println("0. Back");
                            int num3 = Integer.parseInt(scanner.nextLine());
                            if (num3 == 1) {
                                boolean conWithChat = true;
                                int te = 0;
                                System.out.println("Chats...");
                                for (int i = 0; i < group.groupChats.size(); i++) {
                                    if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                    } else if (group.groupChats.get(i).replied != -1) {
                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                    } else if (group.groupChats.get(i).forwarded != -1) {
                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                    }
                                }
                                System.out.println("\n");
                                System.out.println("\n");
                                System.out.println("Hint. to reply the nth line in your chat you must start your line with -rep_n:- or there is a normal chat ");
                                System.out.println("example:");
                                System.out.println("rep_2:perfect!");
                                System.out.println("Hint. to forward the nth line in your chat you must start your line with -for_n:- or there is a normal chat ");
                                System.out.println("example:");
                                System.out.println("for_5");
                                System.out.println();
                                System.out.println("2. delete");
                                System.out.println("1. edit");
                                System.out.println("0. Back or finish Chatting");
                                System.out.println("-1. Block");
                                while (conWithChat) {
                                    String chat1 = scanner.nextLine();
                                    if (!chat1.isEmpty()) {
                                        if (chat1.startsWith("rep")) {
                                            Chats chats = new Chats();
                                            chats.replied = Integer.parseInt(String.valueOf(chat1.charAt(4)));
                                            chats.forwarded = -1;
                                            chats.text = new StringBuilder(chat1.substring(6));
                                            chats.ID = ++counter;
                                            chats.sender = personalUser.username;
                                            group.groupChats.add(chats);
                                            Chats.allChats.add(chats);
                                        } else if (chat1.startsWith("for")) {
                                            t = 0;

                                            System.out.println("to...?");
                                            System.out.println("1. Groups");
                                            System.out.println("2. Secret_Chats");
                                            System.out.println();
                                            int num6 = Integer.parseInt(scanner.nextLine());
                                            if (num6 == 1) {
                                                System.out.println("to...?");
                                                ArrayList<Group> thisS = new ArrayList<Group>();
                                                boolean let = false;

                                                for (int i = 0; i < Group.groups.size(); i++) {
                                                    if (Group.groups.get(i).users.contains(personalUser.username)) {
                                                        System.out.println(String.valueOf(++t) + ". " + Group.groups.get(i).name);
                                                        thisS.add(Group.groups.get(i));
                                                        let = true;

                                                    }
                                                }
                                                Group[] thisSe = new Group[thisS.size()];
                                                if (let) {

                                                    thisSe = thisS.toArray(thisSe);
                                                }
                                                Chats chats = new Chats();
                                                chats.replied = -1;
                                                chats.forwarded = PersonalUser.findPU(username);
                                                chats.text = group.groupChats.get(Integer.parseInt(String.valueOf(chat1.charAt(4))) - 1).text;
                                                chats.ID = ++counter;
                                                chats.sender = personalUser.username;

                                                int num = Integer.parseInt(scanner.nextLine());
                                                if (num != 0) {
                                                    Group group1 = new Group();

                                                    group1 = thisSe[num - 1];

                                                    group1.groupChats.add(chats);
                                                    Chats.allChats.add(chats);
                                                }
                                                conWithChat = false;
                                                repeatGroupPage = true;

                                            } else {
                                                System.out.println("to...?");
//
                                                for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                                                    if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username)) {
                                                        System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user2);
                                                    } else if (Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                                        System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user1);
                                                    }
                                                }
                                                Chats chats = new Chats();
                                                chats.replied = -1;
                                                chats.forwarded = PersonalUser.findPU(username);
                                                chats.text = group.groupChats.get(Integer.parseInt(String.valueOf(chat1.charAt(4))) - 1).text;
                                                chats.ID = ++counter;
                                                chats.sender = personalUser.username;

                                                int num = Integer.parseInt(scanner.nextLine());
                                                if (num != 0) {
                                                    boolean let = false;
                                                    Secret_Chat secret_chat1 = new Secret_Chat();
                                                    ArrayList<Secret_Chat> thisS = new ArrayList<Secret_Chat>();
                                                    for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                                                        if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username) || Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                                            let = true;
                                                            thisS.add(Secret_Chat.all_Secret_Chats.get(i));
                                                        }
                                                    }
                                                    Secret_Chat[] thisSe = new Secret_Chat[thisS.size()];


                                                    if (let) {

                                                        thisSe = thisS.toArray(thisSe);
                                                    }
                                                    secret_chat1 = thisSe[num - 1];
                                                    if (secret_chat1.user1.equals(personalUser.username))
                                                        chats.receiver = secret_chat1.user2;
                                                    else
                                                        chats.receiver = secret_chat1.user1;
                                                    secret_chat1.thisPVChats.add(chats);
                                                    Chats.allChats.add(chats);
                                                }
                                                conWithChat = false;
                                                repeatGroupPage = true;
                                            }
                                        } else if (chat1.equals("1")) {
                                            System.out.println("Which line do you want to edit?");
                                            te = 0;
                                            for (int i = 0; i < group.groupChats.size(); i++) {
                                                if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                                } else if (group.groupChats.get(i).replied != -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                                } else if (group.groupChats.get(i).forwarded != -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                                }
                                            }
                                            boolean forwarded = false;
                                            while (!forwarded) {
                                                int num = Integer.parseInt(scanner.nextLine());
                                                if (num != 0) {
                                                    if (group.groupChats.get(num - 1).forwarded == -1) {

                                                        System.out.println("Please type the new one.(without rep_n or for_n)");
                                                        group.groupChats.get(num - 1).text = new StringBuilder(scanner.nextLine());
                                                        forwarded = true;
                                                    } else {
                                                        System.out.println("You can't edit forwarded messages. Please enter a new one or enter 0 to back");
                                                    }
                                                } else {
                                                    forwarded = true;
                                                }
                                                conWithChat = false;
                                                repeatGroupPage = true;
                                            }
                                        } else if (chat1.equals("2")) {
                                            System.out.println("Which line do you want to edit?");
                                            te = 0;
                                            for (int i = 0; i < group.groupChats.size(); i++) {
                                                if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                                } else if (group.groupChats.get(i).replied != -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                                } else if (group.groupChats.get(i).forwarded != -1) {
                                                    System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                                }
                                            }
                                            int num = Integer.parseInt(scanner.nextLine());
                                            int id = group.groupChats.get(num - 1).ID;
                                            Chats.allChats.remove(id - 1);

                                            for (int i = 0; i < group.groupChats.size(); i++) {
                                                if (group.groupChats.get(i).replied == num) {
                                                    group.groupChats.get(i).replied = -1;
                                                } else if (group.groupChats.get(i).replied >= num) {
                                                    group.groupChats.get(i).replied--;
                                                }
                                                if (i >= num) {
                                                    group.groupChats.get(i).ID--;
                                                }

                                            }
                                            group.groupChats.remove(num - 1);
                                            for (int i = 0; i < Chats.allChats.size(); i++) {
                                                System.out.println(String.valueOf(Chats.allChats.get(i).ID) + "   " + Chats.allChats.get(i).text);
                                            }
                                            conWithChat = false;
                                            repeatGroupPage = true;
                                        }
                                        else if (chat1.equals("0")) {
                                            conWithChat = false;
                                            repeatGroupPage = true;
                                        }

                                        else {
                                            Chats chats = new Chats();
                                            chats.ID = ++counter;
                                            chats.sender = personalUser.username;
                                            chats.text = new StringBuilder(chat1);
                                            Chats.allChats.add(chats);
                                            chats.replied = -1;
                                            chats.forwarded = -1;
                                            group.groupChats.add(chats);
                                            Chats.allChats.add(chats);

                                        }
                                    }
                                }
                            } else if (num3 == 2) {
                                System.out.println();
                                System.out.println("Add member...");
                                int f = 0;
                                ArrayList<PersonalUser> pesuse = new ArrayList<PersonalUser>();
                                for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
                                    if (!group.users.contains(PersonalUser.allPersonalUsers.get(i).username)) {
                                        System.out.println(String.valueOf(++f) + ". " + PersonalUser.allPersonalUsers.get(i).username);
                                        pesuse.add(PersonalUser.allPersonalUsers.get(i));
                                    }
                                }
                                System.out.println("0. Back");
                                int num5 = Integer.parseInt(scanner.nextLine());
                                while (num5 != 0) {
                                    group.users.add(pesuse.get(num5 - 1).username);
                                    String num_str = scanner.nextLine();
                                    while (num_str.isEmpty()) {
                                        num_str = scanner.nextLine();
                                    }
                                    num5 = Integer.parseInt(num_str);
                                }
                                System.out.println();
                                System.out.println();
                                repeatGroupPage = true;
                            } else if (num3 == 3) {
                                System.out.println();
                                System.out.println("Group_Profile...");
                                System.out.println("Group_name: " + group.name);
                                System.out.println("Group_id: " + group.id);
                                System.out.println("Group_admin: " + group.admin);
                                System.out.println();
                                System.out.println();
                                repeatGroupPage = true;

                            } else if (num3 == 4) {
                                System.out.println();
                                System.out.println("Members...");
                                for (int i = 0; i < group.users.size(); i++) {
                                    System.out.println(String.valueOf(i + 1) + ". " + group.users.get(i));
                                }
                                System.out.println();
                                System.out.println();
                                repeatGroupPage = true;
                            } else if (num3 == 5) {
                                System.out.println("Change group_profile...");
                                System.out.println("1. Name");
                                System.out.println("2. ID");
                                System.out.println("0. Back");
                                int num6=Integer.parseInt(scanner.nextLine());
                                if(num6==1)
                                {
                                    System.out.println("Type a new name...");
                                    group.name=scanner.nextLine();
                                }
                                else if(num6==2) {
                                    boolean letLoop = true;
                                    String id=null;
                                    while (letLoop) {
                                        letLoop = false;
                                        System.out.println("Type a new ID...");
                                        id = scanner.nextLine();
                                        while (id.isEmpty()) {
                                            id = scanner.nextLine();
                                        }
                                        for (int i = 0; i < Group.groups.size() && !letLoop; i++) {
                                            if (Group.groups.get(i).id.equals(id)) {
                                                System.out.println("existed id");
                                                letLoop = true;
                                            }
                                        }
                                    }
                                    group.id=id;
                                }

                                repeatGroupPage=true;
                            }
                            else if(num3==6)
                            {
                                int tl=0;
                                System.out.println();
                                System.out.println("Enters the number of users which you want to ban...");
                                ArrayList<String> allowedMembers =new ArrayList<String>();
                                for (int i=1;i<group.users.size();i++)
                                {
                                    if(!group.closed_users.contains(group.users.get(i)))
                                    {
                                        System.out.println(String.valueOf(++tl)+". "+group.users.get(i));
                                        allowedMembers.add(group.users.get(i));
                                    }
                                }
                                System.out.println("0. Back");
                                int num5 = Integer.parseInt(scanner.nextLine());
                                while (num5 != 0) {
                                    group.closed_users.add(allowedMembers.get(num5 - 1));
                                    String num_str = scanner.nextLine();
                                    while (num_str.isEmpty()) {
                                        num_str = scanner.nextLine();
                                    }
                                    num5 = Integer.parseInt(num_str);
                                }
                                System.out.println();
                                System.out.println();
                                repeatGroupPage = true;


                            }
                            else if(num3==7)
                            {

                                int num8=-1;
                                System.out.println("Ban_Members...");
                                while (num8!=0) {
                                    int tl=0;
                                    for (int i = 0; i < group.closed_users.size(); i++) {

                                        System.out.println(String.valueOf(++tl) + ". " + group.closed_users.get(i));
                                    }
                                    System.out.println("0. back");
                                    String str=scanner.nextLine();
                                    while (str.isEmpty())
                                    {
                                        str=scanner.nextLine();
                                    }
                                    num8=Integer.parseInt(str);
                                    if(num8!=0)
                                    {
                                        group.closed_users.remove(num8-1);
                                    }
                                }
                                repeatGroupPage=true;
                            }


                            else {
                                repeatGroupPage = false;
                                repeatHomePage = true;
                            }
                        }

                    } else {
                        boolean repeatGroupPage = true;
                        while (repeatGroupPage) {
                            System.out.println("Enter your number...");
                            System.out.println("1. Chatting...");
                            System.out.println("2. Group_Profile");
                            System.out.println("3. Members");

                            int num3 = Integer.parseInt(scanner.nextLine());
                            if (num3 == 1) {
                                if (group.closed_users.contains(personalUser.username)) {
                                    System.out.println("You can't chat because you're banned by admin");
                                    repeatGroupPage = true;
                                } else {
                                    boolean conWithChat = true;
                                    int te = 0;
                                    System.out.println("Chats...");
                                    for (int i = 0; i < group.groupChats.size(); i++) {
                                        if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                            System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                        } else if (group.groupChats.get(i).replied != -1) {
                                            System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                        } else if (group.groupChats.get(i).forwarded != -1) {
                                            System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                        }
                                    }
                                    System.out.println("\n");
                                    System.out.println("\n");
                                    System.out.println("Hint. to reply the nth line in your chat you must start your line with -rep_n:- or there is a normal chat ");
                                    System.out.println("example:");
                                    System.out.println("rep_2:perfect!");
                                    System.out.println("Hint. to forward the nth line in your chat you must start your line with -for_n:- or there is a normal chat ");
                                    System.out.println("example:");
                                    System.out.println("for_5");
                                    System.out.println();
                                    System.out.println("2. delete");
                                    System.out.println("1. edit");
                                    System.out.println("0. Back or finish Chatting");
                                    System.out.println("-1. Block");
                                    while (conWithChat) {
                                        String chat1 = scanner.nextLine();
                                        if (!chat1.isEmpty()) {
                                            if (chat1.startsWith("rep")) {
                                                Chats chats = new Chats();
                                                chats.replied = Integer.parseInt(String.valueOf(chat1.charAt(4)));
                                                chats.forwarded = -1;
                                                chats.text = new StringBuilder(chat1.substring(6));
                                                chats.ID = ++counter;
                                                chats.sender = personalUser.username;
                                                group.groupChats.add(chats);
                                                Chats.allChats.add(chats);
                                            } else if (chat1.startsWith("for")) {
                                                t = 0;

                                                System.out.println("to...?");
                                                System.out.println("1. Groups");
                                                System.out.println("2. Secret_Chats");
                                                System.out.println();
                                                int num6 = Integer.parseInt(scanner.nextLine());
                                                if (num6 == 1) {
                                                    System.out.println("to...?");
                                                    ArrayList<Group> thisS = new ArrayList<Group>();
                                                    boolean let = false;

                                                    for (int i = 0; i < Group.groups.size(); i++) {
                                                        if (Group.groups.get(i).users.contains(personalUser.username)) {
                                                            System.out.println(String.valueOf(++t) + ". " + Group.groups.get(i).name);
                                                            thisS.add(Group.groups.get(i));
                                                            let = true;

                                                        }
                                                    }
                                                    Group[] thisSe = new Group[thisS.size()];
                                                    if (let) {

                                                        thisSe = thisS.toArray(thisSe);
                                                    }
                                                    Chats chats = new Chats();
                                                    chats.replied = -1;
                                                    chats.forwarded = PersonalUser.findPU(username);
                                                    chats.text = group.groupChats.get(Integer.parseInt(String.valueOf(chat1.charAt(4))) - 1).text;
                                                    chats.ID = ++counter;
                                                    chats.sender = personalUser.username;

                                                    int num = Integer.parseInt(scanner.nextLine());
                                                    if (num != 0) {
                                                        Group group1 = new Group();

                                                        group1 = thisSe[num - 1];

                                                        group1.groupChats.add(chats);
                                                        Chats.allChats.add(chats);
                                                    }
                                                    conWithChat = false;
                                                    repeatGroupPage = true;

                                                } else {
                                                    System.out.println("to...?");
//
                                                    for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                                                        if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username)) {
                                                            System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user2);
                                                        } else if (Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                                            System.out.println(String.valueOf(++t) + ". with  " + Secret_Chat.all_Secret_Chats.get(i).user1);
                                                        }
                                                    }
                                                    Chats chats = new Chats();
                                                    chats.replied = -1;
                                                    chats.forwarded = PersonalUser.findPU(username);
                                                    chats.text = group.groupChats.get(Integer.parseInt(String.valueOf(chat1.charAt(4))) - 1).text;
                                                    chats.ID = ++counter;
                                                    chats.sender = personalUser.username;

                                                    int num = Integer.parseInt(scanner.nextLine());
                                                    if (num != 0) {
                                                        boolean let = false;
                                                        Secret_Chat secret_chat1 = new Secret_Chat();
                                                        ArrayList<Secret_Chat> thisS = new ArrayList<Secret_Chat>();
                                                        for (int i = 0; i < Secret_Chat.all_Secret_Chats.size(); i++) {
                                                            if (Secret_Chat.all_Secret_Chats.get(i).user1.equals(personalUser.username) || Secret_Chat.all_Secret_Chats.get(i).user2.equals(personalUser.username)) {
                                                                let = true;
                                                                thisS.add(Secret_Chat.all_Secret_Chats.get(i));
                                                            }
                                                        }
                                                        Secret_Chat[] thisSe = new Secret_Chat[thisS.size()];


                                                        if (let) {

                                                            thisSe = thisS.toArray(thisSe);
                                                        }
                                                        secret_chat1 = thisSe[num - 1];
                                                        if (secret_chat1.user1.equals(personalUser.username))
                                                            chats.receiver = secret_chat1.user2;
                                                        else
                                                            chats.receiver = secret_chat1.user1;
                                                        secret_chat1.thisPVChats.add(chats);
                                                        Chats.allChats.add(chats);
                                                    }
                                                    conWithChat = false;
                                                    repeatGroupPage = true;
                                                }
                                            } else if (chat1.equals("1")) {
                                                System.out.println("Which line do you want to edit?");
                                                te = 0;
                                                for (int i = 0; i < group.groupChats.size(); i++) {
                                                    if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                                    } else if (group.groupChats.get(i).replied != -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                                    } else if (group.groupChats.get(i).forwarded != -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                                    }
                                                }
                                                boolean forwarded = false;
                                                while (!forwarded) {
                                                    int num = Integer.parseInt(scanner.nextLine());
                                                    if (num != 0) {
                                                        if (group.groupChats.get(num - 1).forwarded == -1) {

                                                            System.out.println("Please type the new one.(without rep_n or for_n)");
                                                            group.groupChats.get(num - 1).text = new StringBuilder(scanner.nextLine());
                                                            forwarded = true;
                                                        } else {
                                                            System.out.println("You can't edit forwarded messages. Please enter a new one or enter 0 to back");
                                                        }
                                                    } else {
                                                        forwarded = true;
                                                    }
                                                    conWithChat = false;
                                                    repeatGroupPage = true;
                                                }
                                            } else if (chat1.equals("2")) {
                                                System.out.println("Which line do you want to edit?");
                                                te = 0;
                                                for (int i = 0; i < group.groupChats.size(); i++) {
                                                    if (group.groupChats.get(i).replied == -1 && group.groupChats.get(i).forwarded == -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + group.groupChats.get(i).text);
                                                    } else if (group.groupChats.get(i).replied != -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "replied to" + String.valueOf(group.groupChats.get(i).replied) + " : " + group.groupChats.get(i).text);

                                                    } else if (group.groupChats.get(i).forwarded != -1) {
                                                        System.out.println(String.valueOf(++te) + ". " + group.groupChats.get(i).sender + ": " + "forwarded from " + PersonalUser.allPersonalUsers.get(group.groupChats.get(i).forwarded).username + " : " + group.groupChats.get(i).text);
                                                    }
                                                }
                                                int num = Integer.parseInt(scanner.nextLine());
                                                int id = group.groupChats.get(num - 1).ID;
                                                Chats.allChats.remove(id - 1);

                                                for (int i = 0; i < group.groupChats.size(); i++) {
                                                    if (group.groupChats.get(i).replied == num) {
                                                        group.groupChats.get(i).replied = -1;
                                                    } else if (group.groupChats.get(i).replied >= num) {
                                                        group.groupChats.get(i).replied--;
                                                    }
                                                    if (i >= num) {
                                                        group.groupChats.get(i).ID--;
                                                    }

                                                }
                                                group.groupChats.remove(num - 1);
                                                for (int i = 0; i < Chats.allChats.size(); i++) {
                                                    System.out.println(String.valueOf(Chats.allChats.get(i).ID) + "   " + Chats.allChats.get(i).text);
                                                }
                                                conWithChat = false;
                                                repeatGroupPage = true;
                                            } else if (chat1.equals("0")) {
                                                conWithChat = false;
                                                repeatGroupPage = true;
                                            } else {
                                                Chats chats = new Chats();
                                                chats.ID = ++counter;
                                                chats.sender = personalUser.username;
                                                chats.text = new StringBuilder(chat1);
                                                Chats.allChats.add(chats);
                                                chats.replied = -1;
                                                chats.forwarded = -1;
                                                group.groupChats.add(chats);
                                                Chats.allChats.add(chats);

                                            }
                                        }
                                    }
                                }
                            }
                            else if (num3 == 2) {
                                System.out.println();
                                System.out.println("Group_Profile...");
                                System.out.println("Group_name: " + group.name);
                                System.out.println("Group_id: " + group.id);
                                System.out.println("Group_admin: " + group.admin);
                                repeatGroupPage = true;

                            } else if (num3 == 3) {
                                System.out.println();
                                System.out.println("Members...");
                                for (int i = 0; i < group.users.size(); i++) {
                                    System.out.println(String.valueOf(i + 1) + ". " + group.users.get(i));
                                    repeatGroupPage = true;

                                }
                            } else {
                                repeatGroupPage = false;

                                repeatHomePage = true;
                            }
                        }


                    }
                }
                else if (option == 7) {
                    System.out.println("Username: " + personalUser.username);
                    System.out.println("Password: " + personalUser.password);
                    System.out.println("Bio: " + personalUser.bio);
                    System.out.println("EmailAddress: " + personalUser.emailAddress);
                    System.out.println("My followings: ");
                    for (int i = 0; i < personalUser.followings.size(); i++) {
                        System.out.println(personalUser.followings.get(i));
                    }
                    System.out.println("My followers: ");
                    for (int i = 0; i < personalUser.followers.size(); i++) {
                        System.out.println(String.valueOf(i + 1) + ". " + personalUser.followers.get(i));
                    }

                    repeatHomePage = true;

                }
                else if (option == 0) {
                    Manager.start();
                }


            }


        }
        else {
            ArrayList<String> userNames = new ArrayList<>();
            for (CommercialUser allCommercialUser : CommercialUser.allCommercialUsers) {
                userNames.add(allCommercialUser.username);
            }

            CommercialUser commercialUser = null;
            if(userNames.contains(username)){
                for (CommercialUser allCommercialUser : CommercialUser.allCommercialUsers) {
                    if(allCommercialUser.username.equals(username))
                        commercialUser = allCommercialUser;
                }
            }
            else {
                commercialUser = new CommercialUser();
                commercialUser.password = password;
                commercialUser.username = username;

                commercialUser.securityQ = Manager.securityQuestion.toString();
                commercialUser.securityA = Manager.securityAnswer.toString();
                Manager.securityQuestion.setLength(0);
                Manager.securityAnswer.setLength(0);

                CommercialUser.allCommercialUsers.add(commercialUser);
                User.allUsers.add(commercialUser);

            }
            Main.accountRecommender(commercialUser);



            boolean repeatHomePage = true;

            while (repeatHomePage) {
                repeatHomePage = false;
                printHomePage_Commercial();

                int option = Integer.parseInt(scanner.nextLine());

                if (option == 1) {
                    int t = 0;
                    for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                        System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println("Do you want to see the posts and react to them or just see the comments?");
                    System.out.println("1. Yes, see the posts and react to them");
                    System.out.println("2. No, just see the comments");
                    System.out.println("0. Back");
                    int num = Integer.parseInt(scanner.nextLine());
                    if (num == 1) {
                        t=0;
                        System.out.println("Please enter the post_number...");
                        for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                            System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                        }
                        int num2 = Integer.parseInt(scanner.nextLine());
                        boolean letlet=true;

                        for (int i=0;i<Post.allPosts.get(Post.allPosts.size() - num2).allView.size() && letlet;i++ )
                        {
                            if(Post.allPosts.get(Post.allPosts.size() - num2).allView.contains(commercialUser.username))
                            {
                                letlet=false;
                            }
                        }
                        if(letlet) {
                            Post.allPosts.get(Post.allPosts.size() - num).allView.add(commercialUser.username);
                        }
                        System.out.println("Enter your number...");
                        System.out.println("1. Add Comment");
                        System.out.println("2. Like/Dislike");
                        System.out.println("3. Both");
                        int num3 = Integer.parseInt(scanner.nextLine());
                        if (num3 == 1) {
                            System.out.println("Please add your comment...");
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.comment = scanner.nextLine();
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);
                            reaction.user = commercialUser;
                        } else if (num3 == 2) {
                            System.out.println("Please like or this like this post...");
                            System.out.println("1. Like");
                            System.out.println("2. dislike");
                            int num4 = Integer.parseInt(scanner.nextLine());
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.user = commercialUser;
                            if (num4 == 1) {
                                reaction.like = 1;

                            }
                            if (num4 == 2) {
                                reaction.dislike = 1;
                            }
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);


                        } else if (num3 == 3) {
                            System.out.println("Please add your comment...");
                            Reaction reaction = new Reaction();
                            reaction.like = 0;
                            reaction.dislike = 0;
                            reaction.comment = scanner.nextLine();
                            Post.allPosts.get(Post.allPosts.size() - num).reactions.add(reaction);
                            reaction.user = commercialUser;
                            System.out.println("Please like or this like this post...");
                            System.out.println("1. Like");
                            System.out.println("2. dislike");
                            int num4 = Integer.parseInt(scanner.nextLine());
                            if (num4 == 1) {
                                reaction.like = 1;

                            }
                            if (num4 == 2) {
                                reaction.dislike = 1;
                            }
                        }

                    } else if (num == 2) {
                        System.out.println("to see the reactions enter the post's number...");
                        t = 0;
                        for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                            System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                        }
                        int num2 = Integer.parseInt(scanner.nextLine());
                        System.out.println("Please enter your number...");
                        System.out.println("1. Show comments");
                        System.out.println("2. Show likes and dislikes");
                        int num3 = Integer.parseInt(scanner.nextLine());
                        if (num3 == 1) {
                            int f = 0;
                            System.out.println("   " + "\t" + "Username" + "\t" + "Comment");
                            for (int i = 0; i < Post.allPosts.get(Post.allPosts.size() - num2).reactions.size(); i++) {
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).comment!=null) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).comment);
                                }
                            }

                        } else if (num3 == 2) {
                            int f = 0;
                            System.out.println("   " + "\t" + "Username" + "\t" + "like/dislike");
                            for (int i = 0; i < Post.allPosts.get(Post.allPosts.size() - num2).reactions.size(); i++) {
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).like == 1) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "like");
                                }
                                if (Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).dislike == 1) {
                                    System.out.println(String.valueOf(++f) + ". " + "\t" + Post.allPosts.get(Post.allPosts.size() - num2).reactions.get(i).user.username + "\t" + "dislike");
                                }

                            }
                        }

                    }

                    repeatHomePage = true;

                } else if (option == 2) {
                    Post post = new Post();
                    System.out.println("Please write down your post and enter -ENTER-  to finish it...");
                    String text = new String(scanner.nextLine());
                    post.text =("-ad-"+ text);
                    post.user = commercialUser;
                    Post.allPosts.add(post);

                    repeatHomePage = true;
                } else if (option == 3) {

                    System.out.println("enter your number...");
                    System.out.println("1. Personal Users");
                    System.out.println("2. Commercial Users");
                    int follow_choice = Integer.parseInt(scanner.nextLine());
                    if (follow_choice == 1) {
                        ArrayList<String> helpWithUsers = new ArrayList<String>();
                        System.out.println("enter your number...");

                        System.out.println("Personal_users:");
                        int t = 0;
                        for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {

                            boolean let = true;
                            for (int j = 0; j < commercialUser.followers.size() && let; j++) {
                                if (commercialUser.followers.get(j).equals(PersonalUser.allPersonalUsers.get(i).username)) {
                                    let = false;
                                }

                                if (let) {
                                    System.out.println(String.valueOf(++t) + ". " + PersonalUser.allPersonalUsers.get(i).username);
                                    helpWithUsers.add(PersonalUser.allPersonalUsers.get(i).username);
                                }

                            }
                        }
                        System.out.println("0. Back");
                        int thisnumber = Integer.parseInt(scanner.nextLine());
                        if (thisnumber == 0) {
                        } else {
                            for (int j = 0; j < PersonalUser.allPersonalUsers.size(); j++) {
                                if (PersonalUser.allPersonalUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
                                    commercialUser.followers.add(PersonalUser.allPersonalUsers.get(j).username);
                                    PersonalUser.allPersonalUsers.get(j).followings.add(commercialUser.username);
                                    j = PersonalUser.allPersonalUsers.size();
                                    repeatHomePage = true;

                                }
                            }
                        }
                    }
                    else if(follow_choice==2)
                    {
                        System.out.println("enter your number...");
                        ArrayList<String> helpWithUsers = new ArrayList<String>();

                        System.out.println("Commercial_users:");
                        int t = 0;
                        for (int i = 0; i < CommercialUser.allCommercialUsers.size(); i++) {
                            if (CommercialUser.allCommercialUsers.get(i).username.equals(commercialUser.username)) {
                            } else {
                                boolean let = true;
                                for (int j = 0; j < commercialUser.followers.size() && let; j++) {
                                    if (commercialUser.followers.get(j).equals(CommercialUser.allCommercialUsers.get(i).username)) {
                                        let = false;
                                    }
                                }
                                if (let) {
                                    System.out.println(String.valueOf(++t) + ". " + CommercialUser.allCommercialUsers.get(i).username);
                                    helpWithUsers.add(CommercialUser.allCommercialUsers.get(i).username);
                                }

                            }
                        }
                        System.out.println("0. Back");
                        int thisnumber = Integer.parseInt(scanner.nextLine());
                        if (thisnumber == 0) {
                        } else {
                            for (int j = 0; j < CommercialUser.allCommercialUsers.size(); j++) {
                                if (CommercialUser.allCommercialUsers.get(j).username.equals(helpWithUsers.get(thisnumber - 1))) {
                                    commercialUser.followers.add(CommercialUser.allCommercialUsers.get(j).username);
                                    CommercialUser.allCommercialUsers.get(j).followings.add(commercialUser.username);
                                    j = CommercialUser.allCommercialUsers.size();
                                    repeatHomePage = true;

                                }
                            }
                        }

                    }
                }
                else if (option == 4) {
                    System.out.println("To see how many people have seen the post and like it...");
                    System.out.println("Please enter the post_number...");
                    int t=0;
                    for (int i = Post.allPosts.size() - 1; i > Post.allPosts.size() - 20 && i >= 0; i--) {
                        System.out.println(String.valueOf(++t) + ". " + Post.allPosts.get(i).text);
                    }
                    int num2 = Integer.parseInt(scanner.nextLine());
                    System.out.println("1. Views: "+String.valueOf(Post.allPosts.get(Post.allPosts.size()-num2).allView.size()));
                    int n=0;
                    for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
                    {
                        if(Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).like==1)
                        {
                            n++;
                        }
                    }
                    System.out.println("2. Likes: "+String.valueOf(n));
                    n=0;
                    for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
                    {
                        if(Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).dislike==1)
                        {
                            n++;
                        }
                    }
                    System.out.println("2. Dislikes: "+String.valueOf(n));

                    System.out.println("Do you want to see the users?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int num9=Integer.parseInt(scanner.nextLine());
                    if(num9==1)
                    {
                        int num8=1;
                        while (num8!=0) {
                            System.out.println("1. Views");
                            System.out.println("2. Likes");
                            System.out.println("3. Dislikes");
                            System.out.println("0. Back");
                            String str = scanner.nextLine();
                            if (str.isEmpty()) {
                                str = scanner.nextLine();
                            }
                            num8 = Integer.parseInt(str);
                            if(num8==1)
                            {
                                int trt=0;
                                for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).allView.size();i++)
                                {
                                    System.out.println(String.valueOf(++trt)+". "+Post.allPosts.get(Post.allPosts.size()-num2).allView.get(i));
                                }
                                System.out.println();
                                System.out.println();
                            }
                            else if(num8==2)
                            {
                                int trt=0;

                                for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
                                {
                                    if(Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).like==1)
                                    {
                                        System.out.println(String.valueOf(++trt)+". "+Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).user.username);
                                    }
                                }
                                System.out.println();
                                System.out.println();

                            }
                            else if(num8==3)
                            {
                                int trt=0;

                                for (int i=0;i<Post.allPosts.get(Post.allPosts.size()-num2).reactions.size();i++)
                                {
                                    if(Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).dislike==1)
                                    {
                                        System.out.println(String.valueOf(++trt)+". "+Post.allPosts.get(Post.allPosts.size()-num2).reactions.get(i).user.username);
                                    }
                                }
                                System.out.println();
                                System.out.println();

                            }
                        }
                        repeatHomePage=true;
                    }
                    else
                    {
                        repeatHomePage=true;
                    }



                }

                else if (option == 5) {
                    System.out.println("Username: " + commercialUser.username);
                    System.out.println("Password: " + commercialUser.password);
                    System.out.println("Bio: " + commercialUser.bio);
                    System.out.println("My followings: ");
                    for (int i = 0; i < commercialUser.followings.size(); i++) {
                        System.out.println(commercialUser.followings.get(i));
                    }
                    System.out.println("My followers: ");
                    for (int i = 0; i < commercialUser.followers.size(); i++) {
                        System.out.println(String.valueOf(i + 1) + ". " + commercialUser.followers.get(i));
                    }


                } else if (option == 0) {
                    Manager.start();

                }

            }
        }
    }

    public static void printHomePage_Personal(){
        System.out.println("Welcome to HomePage!\nChoose one to do:\n1-Visit Recent Posts\n2-Create post\n3-Follow new users\n" +
                "4-Secret_Chats\n5-Make_Group\n6-Groups\n7-View my Profile\n0-Log out");
    }

    public static void printHomePage_Commercial(){
        System.out.println("Welcome to HomePage!\nChoose one to do:\n1-Visit Recent Posts\n2-Create post\n3-Follow new users\n4-Show Stats\n" +
                "5-View my Profile\n0-Log out");
    }

    public static void printNewPeople(ArrayList<User> followings , String myUsername){
        ArrayList<String> userNames = new ArrayList<>();
        for (User following : followings) {
            userNames.add(following.username);
        }

        System.out.println("New Users:");
        for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
            if(!userNames.contains(PersonalUser.allPersonalUsers.get(i).username)
                    && !PersonalUser.allPersonalUsers.get(i).username.equals(myUsername)) {
                System.out.println("Id: " + PersonalUser.allPersonalUsers.get(i).username
                        + "\nBio: " + PersonalUser.allPersonalUsers.get(i).bio);
            }
        }

    }

    public void login(PersonalUser personalUser)
    {

    }
    public void login(CommercialUser commercialUser)
    {

    }



}
