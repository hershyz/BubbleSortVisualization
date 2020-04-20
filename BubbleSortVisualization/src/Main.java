import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter integers separated by a ', ': ");
        String raw = scn.nextLine();
        String[] rawArr = raw.split(", ");
        int[] vals = new int[rawArr.length];

        for (int i = 0; i < rawArr.length; i++) {
            vals[i] = Integer.valueOf(rawArr[i]);
        }

        run(vals);
    }

    public static void run(int[] vals) {

        int i;
        for (i = 0; i < vals.length; i++) {

            int cycle = i + 1;

            if (isSorted(vals)) {
                System.out.println("Cycle " + cycle + ":");
                displayBars(vals);
                break;
            }

            System.out.println("Cycle " + cycle + ":");
            displayBars(vals);

            int j;
            for (j = 0; j < vals.length - 1; j++) {
                if (vals[j + 1] < vals[j]) {
                    int temp;
                    temp = vals[j];
                    vals[j] = vals[j + 1];
                    vals[j + 1] = temp;
                }
            }

            System.out.println("---------------------------------------------------------------");
        }
    }

    public static boolean isSorted(int[] vals) {

        for (int i = 1; i < vals.length; i++) {
            if (vals[i] < vals[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void displayBars(int[] vals) {

        int i;
        for (i = 0; i < vals.length; i++) {

            String bar = "";
            int j;
            for (j = 0; j < vals[i]; j++) {
                bar = bar + "| ";
            }

            System.out.println("n[" + i + "]:        " + bar);
        }
    }
}