import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Aceasta metoda calculeaza suma dintre x ridicat la puterea a-5a si y ridicat la putearea a-7a.
     * @return Returneaza rezultatul calculat.
     * @throws IOException Arunca exceptie daca datele introduse nu au formatul corect.
     */
    public double calculateXLa5PlusYLa5() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean inputSuccesFlag = false;
        System.out.println("Tastati valoarea pentru X:");
        double x = 1;
        while(!inputSuccesFlag) {
            try {
                x = Double.parseDouble(reader.readLine());
                inputSuccesFlag = true;
            } catch (NumberFormatException e) {
                System.out.println("Retestati valoarea pentru X:");
            }
        }

        inputSuccesFlag = false;
        System.out.println("Tastati valoarea pentru Y:");
        double y=1;
        while(!inputSuccesFlag) {
            try {
                y = Double.parseDouble(reader.readLine());
                inputSuccesFlag = true;
            } catch (NumberFormatException e) {
                System.out.println("Retestati valoarea pentru Y:");
            }
        }


        double x5 = putere5(x);
        double y7 = putere7(y);
        double suma = x5 + y7;

        return suma;

    }
    public static double putere5(double x) {
        double x5 = x;
        for(int i=1; i<5; i++) {
            x5 *= x;
        }
        return x5;
    }

    public static double putere7(double x) {
        double x7 = x;
        for(int i=1; i<7;i++) {
            x7 *= x;
        }
        return x7;
    }
}