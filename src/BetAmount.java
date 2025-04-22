public class BetAmount {
    User user;
    Deck deck;
    public BetAmount(User user,Deck deck){
     this.user = user;
     this.deck = deck;
    }
    public int doubleDown(int userMoney , int dealerMoney){
    return this.user.setUserMoney(user.getUserMoney()*2);
    }
    public int split(int userMoney ,int dealerMoney){
    return this.user.setUserMoney(userMoney + dealerMoney);
    }
//    public int blackjack(int userMoney){
//
//    }

}
