public class Question_2 {
    static void coinChanging(int amount){
        int[] coins = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};
        for (int i=0; i<coins.length; i++){
            if (amount>=coins[i]){
                int count = amount/coins[i];
               System.out.println(coins[i] + "X" + count);
                amount = amount% coins[i];
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("COIN CHANGING ");
        coinChanging(1988);
    }
}
