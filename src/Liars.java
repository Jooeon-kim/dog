import java.util.ArrayList;

public interface Liars {
    String getName();
    void DrawFirstDeck(Card card);
    ArrayList<Card> submitCard();
    ArrayList<Card> selectAct(ArrayList<Card> gameDeck );
    boolean StrikeLiar( ArrayList<Card> LastPlayerCard);
}
