import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    public Deck() {
        cards = new ArrayList<>();
        String[] suit = {"♠", "◆", "♥", "♣"};
        String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int[] value = {1,2,3,4,5,6,7,8,9,10,10,10,10};
        for (int i = 0 ; i<suit.length; i++){
            for (int j = 0 ; j< rank.length;j++){
                cards.add(new Card(suit[i],rank[j],value[j]));
            }
        }
        Collections.shuffle(cards);
    }
    public ArrayList<Card> LiarsDecK(){
        ArrayList <Card> LiarsCards = new ArrayList<>();
        String [] suit = {"♠", "◆", "♥", "♣"};
        String [] rank = {"A", "K", "Q" };
        Random random = new Random();
        for(int i = 0 ; i < 6 ; i++){
            LiarsCards.add(new Card(suit[random.nextInt(4)],rank[0]));
            LiarsCards.add(new Card(suit[random.nextInt(4)],rank[1]));
            LiarsCards.add(new Card(suit[random.nextInt(4)],rank[2]));
        }
        LiarsCards.add(new Card("R","Joker"));
        LiarsCards.add(new Card("B","Joker"));
        Collections.shuffle(LiarsCards);
        return LiarsCards;
    }
    public Card drawCard(){
        return cards.remove(0);
    }
}
