import Problems.HackerRank;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> list = List.of(100, 90, 90, 80, 75, 60);
        List<Integer> player = List.of(50, 65, 77, 90, 102);
        System.out.println( HackerRank.climbingLeaderboard(list, player ));

    }
}