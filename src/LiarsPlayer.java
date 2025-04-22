import java.util.ArrayList;
import java.util.Random;

public class LiarsPlayer implements Liars {
    String name;
    ArrayList<Card> PlayerDeck = new ArrayList<>();
    Card FieldCard;
    Random random = new Random();

    public LiarsPlayer() {
        String[] FirstName = {"김", "이", "박", "최", "장", "조", "황"};
        String[] LastName = {"정태", "주언", "재호", "현범", "둘리", "흥민", "시현"};
        this.name = FirstName[random.nextInt(7)] + LastName[random.nextInt(7)];
        if (this.name.equals("조정태"))
            System.out.println("하이미디어 학생 조정태라고 한다 반갑노");
    }
    public ArrayList<Card> selectAct(ArrayList<Card> gameDeck  ){
        int select = random.nextInt(2);
        switch(select){
            case 0:
                DrawFirstDeck(gameDeck.remove(0));
                break;
            case 1:
                return submitCard();
        }
        return new ArrayList<>();
    }
    public void DrawFirstDeck(Card card) {
        this.PlayerDeck.add(card);
    }

    public ArrayList<Card> submitCard() {
        boolean choice = random.nextBoolean();
        ArrayList<Card> playerSelect = new ArrayList<>();
        if (choice) {
            int randomAct = random.nextInt(4);
            switch (randomAct) {
                case 0:
                    if (PlayerDeck.get(0).getRank().equals(PlayerDeck.get(1).getRank()) || PlayerDeck.get(1).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(1));
                        playerSelect.add(PlayerDeck.get(0));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(0).getRank() + ", " + "2장");
                        return playerSelect;
                    } else if (PlayerDeck.get(0).getRank().equals(PlayerDeck.get(2).getRank()) || PlayerDeck.get(2).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(2));
                        playerSelect.add(PlayerDeck.get(0));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(0).getRank() + ", " + "2장");
                        return playerSelect;
                    } else {
                        playerSelect.add(PlayerDeck.get(0));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(0).getRank() + ", " + "1장");
                        return playerSelect;
                    }
                case 1:
                    if (PlayerDeck.get(1).getRank().equals(PlayerDeck.get(2).getRank()) || PlayerDeck.get(2).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(2));
                        playerSelect.add(PlayerDeck.get(1));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(1).getRank() + ", " + "2장");
                        return playerSelect;
                    } else if (PlayerDeck.get(1).getRank().equals(PlayerDeck.get(3).getRank()) || PlayerDeck.get(3).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(3));
                        playerSelect.add(PlayerDeck.get(1));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(1).getRank() + ", " + "2장");
                        return playerSelect;
                    } else {
                        playerSelect.add(PlayerDeck.get(1));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(1).getRank() + ", " + "1장");
                    }
                case 2:
                    if (PlayerDeck.get(2).getRank().equals(PlayerDeck.get(3).getRank()) || PlayerDeck.get(3).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(3));
                        playerSelect.add(PlayerDeck.get(2));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(2).getRank() + ", " + "2장");
                        return playerSelect;
                    } else if (PlayerDeck.get(2).getRank().equals(PlayerDeck.get(4).getRank()) || PlayerDeck.get(4).getRank().equals("Joker")) {
                        playerSelect.add(PlayerDeck.get(4));
                        playerSelect.add(PlayerDeck.get(2));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(2).getRank() + ", " + "2장");
                        return playerSelect;
                    } else {
                        playerSelect.add(PlayerDeck.get(2));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(2).getRank() + ", " + "1장");
                        return playerSelect;
                    }
                case 3:
                    if (PlayerDeck.get(0).getRank().equals(PlayerDeck.get(1).getRank()) && (PlayerDeck.get(1).getRank().equals(PlayerDeck.get(2).getRank()) ||PlayerDeck.get(1).getRank().equals("Joker")) ) {
                        playerSelect.add(PlayerDeck.get(2));
                        playerSelect.add(PlayerDeck.get(1));
                        playerSelect.add(PlayerDeck.get(0));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(0).getRank() + ", " + "3장");
                        return playerSelect;
                    }else if (PlayerDeck.get(0).getRank().equals(PlayerDeck.get(2).getRank()) && (PlayerDeck.get(2).getRank().equals(PlayerDeck.get(3).getRank()) ||PlayerDeck.get(2).getRank().equals("Joker")) ){
                        playerSelect.add(PlayerDeck.get(3));
                        playerSelect.add(PlayerDeck.get(2));
                        playerSelect.add(PlayerDeck.get(0));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(0).getRank() + ", " + "3장");
                        return playerSelect;
                    }else if (PlayerDeck.get(1).getRank().equals(PlayerDeck.get(2).getRank()) && (PlayerDeck.get(2).getRank().equals(PlayerDeck.get(3).getRank()) ||PlayerDeck.get(3).getRank().equals("Joker")) ){
                        playerSelect.add(PlayerDeck.get(3));
                        playerSelect.add(PlayerDeck.get(2));
                        playerSelect.add(PlayerDeck.get(1));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(1).getRank() + ", " + "3장");
                        return playerSelect;
                    }else if (PlayerDeck.get(1).getRank().equals(PlayerDeck.get(3).getRank()) && (PlayerDeck.get(3).getRank().equals(PlayerDeck.get(4).getRank()) ||PlayerDeck.get(4).getRank().equals("Joker")) ){
                        playerSelect.add(PlayerDeck.get(4));
                        playerSelect.add(PlayerDeck.get(3));
                        playerSelect.add(PlayerDeck.get(1));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(1).getRank() + ", " + "3장");
                        return playerSelect;
                    }else{
                        playerSelect.add(PlayerDeck.get(3));
                        System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(3).getRank() + ", " + "1장");
                        return playerSelect;
                    }
                case 4:
                    playerSelect.add(PlayerDeck.get(4));
                    System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+PlayerDeck.get(4).getRank() + ", " + "1장");
                    return playerSelect;
            }

        }else{
            String [] rank = {"Q","K","A"};
            int randomIndex = random.nextInt(3);
            int anyNumber = random.nextInt(3);
            for(int i = anyNumber ; i >= 0 ; i--){
                playerSelect.add(PlayerDeck.get(i));
            }
            System.out.println(this.name+"(이)가 카드를 내면서 말합니다! 😁 "+rank[randomIndex] + ", " + (anyNumber+1)+"장");
            return playerSelect;
        }return null;
    }
    void callLiar(){

    }
    void showMyDeck() {
        System.out.println(this.name + "의 패");
        for (Card card : PlayerDeck) {
            card.toCardString();
        }
        System.out.println();
    }

    public String getName() {
        return this.name;
    }
}
