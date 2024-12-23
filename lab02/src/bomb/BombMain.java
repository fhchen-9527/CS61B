package bomb;

import common.IntList;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BombMain {
    public static void answers(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct inputs (passwords) to each phase using debugging techniques
        Bomb b = new Bomb();
        if (phase >= 0) {
            String password1 = b.shufflePassword("hello");
            b.phase0(password1);
        }
        if (phase >= 1) {
            IntList password1 = b.shufflePasswordIntList("bye");
            b.phase1(password1); // Figure this out too
        }
        if (phase >= 2) {
            String password2 = "";
            Random r = new Random(1337);
            Set<Integer> numbers = new HashSet<>();
            while (numbers.size() < 100000) {
                numbers.add(r.nextInt());
            }
            int i = 0;
            for (int number : numbers) {
                if (i == 1337) {
                    password2 = String.valueOf(number);
                }
                i++;
            }
            b.phase2(password2);
        }
    }
}
