import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    public static void main(String[] args) {
        Program program = new Program();

        program.findPrimeNumber();
    }

    private void findPrimeNumber() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String textLine = reader.readLine();

                if (textLine.equals("exit")) {
                    break;
                }

                try {
                    int orderNumber = Integer.parseInt(textLine);
                    int primeNumber = findPrimeNumberByOrderNumber(orderNumber);
                    System.out.println(primeNumber);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findPrimeNumberByOrderNumber(int orderNumber) {
        int number = 1;
        int i = 0;

        while(true) {
            if (isPrimeNumber(number)) {
                i++;
            }

            if (i == orderNumber) {
                return number;
            }

            number++;
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        int rootNumber = (int) Math.sqrt(number);

        for (int i = 3; i <= rootNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
