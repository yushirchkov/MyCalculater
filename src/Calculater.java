import java.io.IOException;
import java.util.Scanner;

public class Calculater {

    public String calculate(final String in) throws IOException {
        Scanner scanner = new Scanner(in);

        int operandCount = 0;
        String firstOp = "";
        String operator = "";
        String secondOp = "";

        scanner.useDelimiter("\\s");
        while (scanner.hasNext()) {
            operandCount++;

            if (operandCount == 1) {
                firstOp = scanner.next();
            } else if (operandCount == 2) {
                operator = scanner.next();
            } else if (operandCount == 3) {
                secondOp = scanner.next();
            } else {
                scanner.next();
            }

            // 1. �������� ���-�� ���������
            if (operandCount > 3)
                throw new IOException("�������� ���������� ���������");
        }
        scanner.close();

        // 2. �������� ���������
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")))
            throw new IOException("������������ ��������: '" + operator + "'");

        try {
            // ��������� �������� �����:
            final int firstNumber = Integer.parseInt(firstOp);
            final int secondNumber = Integer.parseInt(secondOp);

            // 3. �������� ��������� �������� �����:
            if (firstNumber < 1 || firstNumber > 10)
                throw new IOException("������������ �������� ��������: '" + firstOp + "'");

            if (secondNumber < 1 || secondNumber > 10)
                throw new IOException("������������ �������� ��������: '" + secondOp + "'");

            if (operator.equals("+"))
                return String.valueOf(firstNumber + secondNumber);
            if (operator.equals("-"))
                return String.valueOf(firstNumber - secondNumber);
            if (operator.equals("*"))
                return String.valueOf(firstNumber * secondNumber);
            if (operator.equals("/"))
                return String.valueOf(firstNumber / secondNumber);
        } catch (NumberFormatException ex) {

            return "ERROR";
        }

        return firstOp;
    }

}
