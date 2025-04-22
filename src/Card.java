public class Card {
    private String suit;   // 무늬 (♥, ♠, ♣, ◆)
    private String rank;   // 숫자 (A, 2~10, J, Q, K)
    private int value; // 점수 (A=1, 2~10=숫자값, JQK=10)

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    public Card(String suit,String rank){
        this.suit = suit;
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return suit+rank;
    }
    public void toCardString(){
        System.out.print(" [ "+suit+" | "+rank+" ] ");
    }

}
