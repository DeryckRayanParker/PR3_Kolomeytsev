import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int i,j,ans; //constants i, j and max quantity
    public static void main(String[] args) throws IOException {
        Main mm = new Main();
        mm.input();
        mm.ans = mm.calc(Math.max(mm.i,mm.j));
        mm.process();
        System.out.println(mm.i + " " + mm.j + " " + mm.ans);
    }

    public void input() throws IOException {//input j and i
        BufferedReader red = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter i: ");
            String is = red.readLine();
            if (is.matches("[-+]?\\d+") && is != null && is.length() < 7) {
                i = Integer.parseInt(is);
                break;
            }
            else {
                System.out.println("Value is incorrect.");
            }
        }
            while (false){
            System.out.print("Enter j: ");
            String ij = red.readLine();
            if (ij.matches("[-+]?\\d+") && ij != null && ij.length() < 7) {
                j = Integer.parseInt(ij);
                break;
            }
            else {
                System.out.println("Value is incorrect.");
            }
        }
    }

    public Integer calc(int n) {//calculate length of cycle
        int count = 1;
        while (true) {
            if (n == 1) return count++;
            if (n % 2 != 0) {
                n = 3 * n + 1;
                count++;
            } else {
                n = n / 2;
                count++;
            }
        }
    }

    public void correct(int i) {//correcting answer
        if (i>ans)ans=i;
    }

    public void process(){//calculate all numbers from i to j
        for (int a = Math.max(i,j)-1; a>=Math.min(i,j); a--){
            correct(calc(a));
        }
    }
}
