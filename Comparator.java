import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
class Checker implements Comparator<Player> {
  	// complete this method

    static final Comparator<Player> compareScore = new Comparator<Player>() {
        public int compare(Player a, Player b) {
            return b.score - a.score;
        }
    };
	public int compare(Player a, Player b) {
        int i = compareScore.compare(a, b);
        if (i == 0) {
            i = a.name.compareTo(b.name);
        }
        return i;
    }

}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
