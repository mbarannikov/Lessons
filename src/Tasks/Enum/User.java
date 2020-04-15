package Tasks.Enum;

public class User {
    private String fulName;
    private int salary;
    private Position position;
//    Position[] positions = Position.values();

    public User(String fulName, int salary, Position position) {
        this.fulName = fulName;
        this.salary = salary;
        this.position = position;
    }

    public static void addUser(String fulName, String strPos, User[] userE, User[] userT, User[] userD) {
        Position pos = Position.valueOf(strPos);
        if (pos == Position.D) {
            for (int i = 0; i < userD.length; i++) {
                if (userD[i] == null) {
                    userD[i] = new User(fulName, 1000, Position.D);
                    break;
                }
            }
        } else if (pos == Position.E) {
            for (int i = 0; i < userE.length; i++) {
                if (userE[i] == null) {
                    userE[i] = new User(fulName, 100, Position.E);
                    break;
                }
            }
        } else if (pos == Position.T) {
            for (int i = 0; i < userT.length; i++) {
                if (userT[i] == null) {
                    userT[i] = new User(fulName, 10, Position.T);
                    break;
                }
            }
        }
    }

    ;

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
            return "User{" +
                    "fulName='" + fulName + '\'' +
                    ", salary=" + salary +
                    ", position=" + position.getName() +
                    '}';
    }
}
enum Position {
    E("Engineer"), T("Teacher"), D("Director");
    private String name;

    Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}