import java.util.Scanner;

public class Game {
    User[] user = new User[3];
    Scanner input = new Scanner(System.in);

    public Game() {
        user[0] = new User("aaa", "123", "first", 100000);
        user[1] = new User("bbb", "123", "second", 200000);
        user[2] = new User("ccc", "123", "third", 300000);
    }

    public void run() {
        while (true) {
            System.out.print("사용하실 아이디를 입력해주세요: ");
            String inputId = input.nextLine();
            System.out.print("사용하실 비번를 입력해주세요: ");
            String inputPw = input.nextLine();
            boolean flag = false;
            for (int i = 0; i < user.length; i++) {
                if (user[i].getId().equals(inputId)) {
                    if (user[i].getPw().equals(inputPw)) {
                        flag = true;
                        selectGame(user[i]);
                    }
                }
            }
            if (!flag) {
                continue;
            }
        }

    }

    public void selectGame(User login) {
        while (true) {
            System.out.print("(1)블랙잭,(2)홀덤 (3)라이어게임 ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    BlackJack game = new BlackJack(login);
                    game.start();
                    break;
                case 2:
                    break;
                case 3:
                    LiarGame game3 = new LiarGame(login);
                    game3.start();
                    break;
            }
        }
    }
}
