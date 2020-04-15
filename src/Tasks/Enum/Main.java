package Tasks.Enum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] userE = new User[3];
        User[] userT = new User[3];
        User[] userD = new User[3];

        for (int i = 0; i < 3; i++) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя и фамилию");
            String strName = in.nextLine();
            System.out.println("Введите должность 'E' или 'D' или 'T' ");
            String strPosition = in.next();
            User.addUser(strName,strPosition,userE,userT,userD);
        }

        for (User u: userE) {
            if (u != null) System.out.println(u.toString());
        }
        for (User u: userT) {
            if (u != null) System.out.println(u.toString());
        }
        for (User u: userD) {
            if (u != null) System.out.println(u.toString());
        }
    }
}
