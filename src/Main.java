import java.util.Random;
import java.util.Scanner;

public class Main {
    static int xPlayerPosition = 0;
    static int yPlayerPosition = 0;
    static char[][] map = new char[0][0];

    public static void main(String[] args) {
        System.out.println("controlled hexagonal coordinate system");
        System.out.println("--------------------------------------");
        System.out.println("keyboard control:");
        System.out.println("wa - up and left");
        System.out.println("wa - up and right");
        System.out.println("a - left");
        System.out.println("d - right");
        System.out.println("sa - down and left");
        System.out.println("sd - down and right");
        System.out.println("0 - to exit");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose map size:");
        System.out.print("x: ");
        int x = scanner.nextInt();
        System.out.println();
        System.out.print("y: ");
        int y = scanner.nextInt();
        System.out.println();
        map = generate(x, y);
        char[][] changedMap = map;
        //creating player on the map
        createPlayerOnTheMap(changedMap);
        System.out.println("Map was generated and player was created on random place.");
        System.out.println("Control player: wa, wd, a, d, sa, sd or 0 to exit.");

        boolean checker = true;
        while (checker) {
            //displaying map
            display(changedMap);

            //walking player
            Scanner sc = new Scanner(System.in);
            String position = sc.nextLine();
            if ("0".equals(position)) {
                checker = false;
            } else {
                walk(position);
            }
            //xPlayerPosition = sc.nextInt();
            //yPlayerPosition = sc.nextInt();
        }

    }
    public static void walk(String position) {

        switch (position) {
            case "wa":
                if (xPlayerPosition - 1 >= 0 && yPlayerPosition - 1 >= 0) {
                    System.out.println("side 1");
                    xPlayerPosition -= 1;
                    yPlayerPosition -= 1;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
            case "wd":
                if (xPlayerPosition + 1 < map[0].length && yPlayerPosition - 1 >= 0) {
                    System.out.println("side 2");
                    xPlayerPosition += 1;
                    yPlayerPosition -= 1;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
            case "a":
                if (xPlayerPosition - 2 >= 0) {
                    System.out.println("side 3");
                    xPlayerPosition -= 2;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
            case "d":
                System.out.println(xPlayerPosition);
                System.out.println(map[0].length);
                if (xPlayerPosition + 2 < map[0].length) {
                    System.out.println("side 4");
                    xPlayerPosition += 2;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
            case "sa":
                if (xPlayerPosition - 1 >= 0 && yPlayerPosition + 1 < map.length) {
                    System.out.println("side 5");
                    xPlayerPosition -= 1;
                    yPlayerPosition += 1;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
            case "sd":
                if (xPlayerPosition + 1 < map[0].length && yPlayerPosition + 1 < map.length) {
                    System.out.println("side 6");
                    xPlayerPosition += 1;
                    yPlayerPosition += 1;
                } else {
                    System.out.println("you cannot go there");
                }
                break;
        }

    }
    public static void createPlayerOnTheMap(char[][] changedMap) {
        Random r = new Random();
        boolean stopper = true;
        while (stopper) {
            xPlayerPosition = r.nextInt(changedMap.length);
            yPlayerPosition = r.nextInt(changedMap[0].length);
            if ((xPlayerPosition + yPlayerPosition) % 2 != 0) {
                stopper = false;
            }
        }
    }
    public static char[][] generate(int sizeA, int sizeB) {
        char[][] map = new char[sizeA][sizeB];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if ((i + j) % 2 == 0) {
                    map[i][j] = ' ';
                } else {
                    map[i][j] = '\'';
                }
            }
        }
        return map;
    }

    public static void display(char[][] changedMap) {
        for (int i = 0; i < changedMap.length; i++) {
            for (int j = 0; j < changedMap[0].length; j++) {
                if (xPlayerPosition == j && yPlayerPosition == i) {
                    System.out.print("P");
                } else {
                    System.out.print(changedMap[i][j]);
                }
            }
            System.out.println();
        }
    }
}
