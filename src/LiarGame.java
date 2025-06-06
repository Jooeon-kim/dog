import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LiarGame {
    User user;
    int stake;
    ArrayList<Card> gameDeck;
    Card FieldCard;
    LiarsPlayer player1;
    LiarsPlayer player2;
    Liars first;
    Liars second;
    Liars third;
    Liars Striker = null;
    boolean isLie = false;
    Liars winner = null;
    Liars loser = null;
    ArrayList<Card> LastPlayerCard;
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    public LiarGame(User user) {
        this.user = user;
    }

    void start() {
        System.out.println("""
                라이어 게임을 시작하겠습니다
                
                😍규칙😍
                
                승리조건은 자신의 모든 패를 제출. 혹은 상대방의 거짓말을 간파
                자신의 턴에 카드를 낼지, 1장 드로우를 할지 선택할 수 있습니다.
                같은 랭크의 카드를 3장까지 동시에 낼수 있습니다.
                혹은 서로 다른 랭크의 카드도 제출 가능하나 상대방이 라이어를 외친다면 패배!
                조커의 경우, 제출할 때 어떤 랭크든 같은 랭크로 취급됩니다
                순서는 매 판 랜덤으로 결정됩니다
                라이어 지목은 자신의 다음 사람을 대상으로만 지목할 수 있습니다.
                """);

        BettingStart();

        setGameDeck();

        setPlayers();

        DealHand(player1, player2, this.user);

        ShowAllCardInHand();//확인용 겜다만듬 지움

        RollWhoWillBeFirst();

        startPlaying();

        showLastPlayerCard();


    }


    void BettingStart() {
        while (true) {
            System.out.print("판돈을 입력해주세요:");
            int userBet = input.nextInt();
            if (userBet > user.getUserMoney()) {
                System.out.println("판돈이 모자랍니다.");
            } else {
                System.out.println(userBet + "원을 배팅합니다. 승리 시 " + userBet * 2 + "원 획득!");
                this.user.LoseBet(userBet);
                this.stake = userBet;
                break;
            }
        }
    }

    void setGameDeck() {
        Deck LiarsDeck = new Deck();
        this.gameDeck = LiarsDeck.LiarsDecK();
    }

    void setPlayers() {
        LiarsPlayer player1 = new LiarsPlayer();
        LiarsPlayer player2 = new LiarsPlayer();
        while (true) {
            if (player2.name.equals(player1.name))
                player2 = new LiarsPlayer();
            else break;
        }
        this.player1 = player1;
        this.player2 = player2;
        System.out.println(player1.name + "(이)가 게임에 참가했습니다.");
        System.out.println(player2.name + "(이)가 게임에 참가했습니다.");
    }

    void DealHand(LiarsPlayer player1, LiarsPlayer player2, User user) {
        for (int i = 0; i < 5; i++) {
            player1.PlayerDeck.add(this.gameDeck.remove(0));
            player2.PlayerDeck.add(this.gameDeck.remove(0));
            user.PlayerDeck.add(this.gameDeck.remove(0));
        }
        this.FieldCard = gameDeck.remove(0);
        player1.FieldCard = this.FieldCard;
        player2.FieldCard = this.FieldCard;
    }

    void RollWhoWillBeFirst() {
        int roll = random.nextInt(3);
        switch (roll) {
            case 0:
                this.first = this.player1;
                this.second = this.player2;
                this.third = this.user;
                break;
            case 1:
                this.first = this.player2;
                this.second = this.user;
                this.third = this.player1;
                break;
            case 2:
                this.first = this.user;
                this.second = this.player1;
                this.third = this.player2;
        }
        System.out.println("순서: " + first.getName() + " 👉 " + second.getName() + " 👉 " + third.getName());
        System.out.println(first.getName() + " 부터 게임을 시작합니다! 확인>아무거나 입력");
        input.next();
    }

    void startPlaying() {
        boolean stop = false;
        do {

            ArrayList<Card> firstTurn = first.selectAct(this.gameDeck);
            this.LastPlayerCard = firstTurn;
            showLastPlayerCard();
            chooseForStrike(third, first);
            stop = check();
            if(stop)
                break;

            ArrayList<Card> secondTurn = second.selectAct(this.gameDeck);
            this.LastPlayerCard = secondTurn;
            showLastPlayerCard();
            chooseForStrike(first, second);
            stop = check();
            if(stop)
                break;
            ArrayList<Card> thirdTurn = third.selectAct(this.gameDeck);
            this.LastPlayerCard = thirdTurn;
            showLastPlayerCard();
            chooseForStrike(second, third);
            stop = check();
            if(stop)
                break;
        } while (true);
        if (winner != null)
            System.out.println("우승 " + winner.getName());
    }

    void ShowAllCardInHand() {
        player1.showMyDeck();
        player2.showMyDeck();
        user.showDeck();
        System.out.println("필드 카드");
        FieldCard.toCardString();
        System.out.println();
        System.out.println("남은 패");
        for (Card c : gameDeck)
            c.toCardString();
        System.out.println();
    }

    void showLastPlayerCard() {
        if (LastPlayerCard == null)
            System.out.println("패 낸거 없음");
        else {
            for (Card c : LastPlayerCard) {
                c.toCardString();
            }
            System.out.println();
        }
    }

    void chooseForStrike(Liars LastPlayer, Liars nowPlayer) {
        if (LastPlayer == this.user) {
            System.out.println("결정하세요 1.넘김 2.라이어!");
            int choose = input.nextInt();
            if (choose == 2) {
                this.Striker = LastPlayer;
                this.isLie = LastPlayer.StrikeLiar(this.LastPlayerCard);
                if (isLie) {
                    System.out.println(LastPlayer + " 승리");
                    this.winner = LastPlayer;
                    this.loser = nowPlayer;
                } else
                    this.loser = LastPlayer;

            } else return;
        } else {
            System.out.println(LastPlayer.getName() + "가 결정중입니다");
            int choose = random.nextInt(100) + 1;
            if (choose < 70) {
                System.out.println(LastPlayer.getName() + "라이어 선언! 너 그짓말이지");
                this.Striker = LastPlayer;
                this.isLie = LastPlayer.StrikeLiar(this.LastPlayerCard);
                if (isLie) {
                    System.out.println(LastPlayer + "승리");
                    winner = LastPlayer;
                    loser = nowPlayer;
                } else {
                    System.out.println(LastPlayer.getName()+"패배");
                    loser = LastPlayer;
                }
            } else System.out.println("가만히 있었습니다");
        }
    }

    boolean check() {
        if (this.winner == this.user || this.loser == this.user) {
            System.out.println("게임종료");
            return true;
        }else
            return false;
    }
}
