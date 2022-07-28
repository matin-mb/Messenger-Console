import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class Manager {
    static Scanner sc= new Scanner(System.in);

    public static StringBuilder securityQuestion;
    public static StringBuilder securityAnswer;


    static public void start() throws SQLException {


        while(true) {

            Firstpage firstpage = new Firstpage();
            System.out.println("Enter your number...");
            System.out.println("1. sign up");
            System.out.println("2. login");
            System.out.println("3. forgot your password?");
            System.out.println("0. exit");
            boolean againe1 = true;
            while (againe1) {
                againe1 = false;
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == 1) {
                    boolean again2 = true;
                    boolean letLoop = true;
                    String id = null;
                    while (letLoop) {
                        letLoop = false;
                        System.out.println("Please enter a username ...");
                        id = sc.nextLine();
                        while (id.isEmpty()) {
                            id = sc.nextLine();
                        }
                        for (int i = 0; i < PersonalUser.allPersonalUsers.size() && !letLoop; i++) {
                            if (PersonalUser.allPersonalUsers.get(i).username.equals(id)) {
                                System.out.println("existed username");
                                letLoop = true;

                            }
                        }
                        for (int i = 0; i < CommercialUser.allCommercialUsers.size() && !letLoop; i++) {
                            if (CommercialUser.allCommercialUsers.get(i).username.equals(id)) {
                                System.out.println("existed username");
                                letLoop = true;

                            }
                        }
                    }
                    String username = id;
                    while (again2) {
                        again2 = false;
                        System.out.println("please enter a password");
                        System.out.println("your password must contains  8 characters (both words and numbers)");
                        String password = sc.nextLine();
                        if (password.length() != 8) {
                            System.out.println("invalid password");
                            again2 = true;
                        } else if ((!password.matches("[a-zA-Z0-9]+")) || (password.matches("[1-9]+"))) {
                            System.out.println("invalid password");
                            System.out.println(password);
                            again2 = true;
                        } else {
                            boolean again3 = true;
                            while (again3) {
                                ArrayList<String> securityQuestions = new ArrayList<>();
                                securityQuestions.add("Random Question : Who is your favorite actor?");
                                securityQuestions.add("Random Question : Who was your favorite school teacher?");
                                securityQuestions.add("Random Question : Who was your favorite classmate?");

                                System.out.println("Please answer this security question:");
                                int rand = (int) (Math.random() * 10) % 3;
                                System.out.println(securityQuestions.get(rand));
                                String securityAns = sc.nextLine();
                                Manager.securityQuestion = new StringBuilder(securityQuestions.get(rand));
                                Manager.securityAnswer = new StringBuilder(securityAns);
                                //System.out.println(securityAns);
                                //Main.addSecurityQA(securityQuestions.get(rand),securityAns);

                                again3 = false;
                                System.out.println("Enter your number...");
                                System.out.println("1. personal user");
                                System.out.println("2. commercial user");
                                System.out.println("0. exit");
                                //byte choice2 = sc.nextByte();
                                int choice2 = Integer.parseInt(sc.nextLine());
                                if (choice2 == 1) {
                                    firstpage.signUp(username, password, 1);
                                } else if (choice2 == 2) {
                                    firstpage.signUp(username, password, 2);
                                } else if (choice2 == 0) {
                                    System.exit(0);
                                } else {
                                    System.out.println("invalid number");
                                    again3 = true;
                                }
                            }
                        }
                    }
                }
                else if (choice == 2) {

                    boolean again4 = true;
                    while (again4) {
                        again4 = false;
                        System.out.println("Enter your number...");
                        System.out.println("1. personal user");
                        System.out.println("2. commercial user");
                        System.out.println("0. exit");
                        int choice4 = Integer.parseInt(sc.nextLine());

                        if (choice4 == 1) {
                            boolean again5 = true;
                            while (again5) {
                                again5 = false;
                                boolean c = false;
                                System.out.println("please enter your username");
                                String username = sc.nextLine();

                                System.out.println("please enter your password");
                                String password = sc.nextLine();
                                for (int i = 0; i < PersonalUser.allPersonalUsers.size(); i++) {
                                    if (PersonalUser.allPersonalUsers.get(i).username.equals(username)) {
                                        c = true;
                                        if (PersonalUser.allPersonalUsers.get(i).password.equals(password)) {
                                            Firstpage firstpage1 = new Firstpage();
                                            firstpage1.signUp(PersonalUser.allPersonalUsers.get(i).username, PersonalUser.allPersonalUsers.get(i).password, 1);
                                        } else {
                                            System.out.println("invalid password");
                                            again5 = true;
                                        }
                                    }
                                }
                                if (!c) {
                                    System.out.println("invalid username");
                                    again5 = true;
                                }
                            }
                        } else if (choice4 == 2) {
                            boolean again5 = true;
                            while (again5) {
                                again5 = false;
                                boolean c = false;
                                System.out.println("please enter your username");
                                String username = sc.nextLine();
                                System.out.println("please enter your password");
                                String password = sc.nextLine();
                                for (int i = 0; i < CommercialUser.allCommercialUsers.size(); i++) {
                                    if (CommercialUser.allCommercialUsers.get(i).username.equals(username)) {
                                        c = true;
                                        if (CommercialUser.allCommercialUsers.get(i).password.equals(password)) {
                                            Firstpage firstpage1 = new Firstpage();
                                            firstpage1.signUp(CommercialUser.allCommercialUsers.get(i).username, CommercialUser.allCommercialUsers.get(i).password, 2);
                                        } else {
                                            System.out.println("invalid password");
                                            again5 = true;
                                        }
                                    }
                                }
                                if (!c) {
                                    System.out.println("invalid username");
                                    again5 = true;
                                }
                            }
                        } else if (choice4 == 0) {
                            System.exit(0);
                        } else {
                            System.out.println("invalid number");
                            again4 = true;
                        }
                    }

                }
                else if (choice == 3) {
                    System.out.println("Enter your Username:");
                    String userName = sc.nextLine();
                    User user = null;
                    for (User allUser : User.allUsers) {
                        if (allUser.username.equals(userName)) {
                            user = allUser;
                        }
                    }
                    System.out.println(user.securityQ);
                    String answer = sc.nextLine();
                    if (answer.equals(user.securityA)) {
                        //System.out.println("now Enter your new Password:");
                        System.out.println("Your password is :");
                        System.out.println(user.password);
                    }

                }
                else if (choice == 0) {
                    Main.dataBaseFin();
                    System.exit(0);
                }
                else {
                    System.out.println("invalid number");
                    againe1 = true;
                }

            }

        }


    }


}
