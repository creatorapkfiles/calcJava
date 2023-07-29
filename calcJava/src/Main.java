import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String[] calc(String stringInput) {
        String[] inputData = stringInput.split(" ");
        if (inputData.length != 3) {
            Scanner newlyEnteredString = new Scanner(System.in);
            System.out.println("Неверный формат ввода данных, попробуйте еще раз(убедитесь что введенное вами арифметическое действие соответствует формату(опреанд_пробел_оператор_пробел_операнд))");
            stringInput = newlyEnteredString.nextLine();
            return calc(stringInput);
        } else {
            return inputData;
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String stringInput = scanner.nextLine();
        String[] stringsArray = calc(stringInput);

        int out;

        try {
            if (stringsArray.length == 3) {

                if (checkingForAMatch(stringsArray[0]) && checkingForAMatch(stringsArray[2])) {
                    switch (stringsArray[1]) {
                        case "+" -> {
                            out = Integer.parseInt(enumSolutionWithRoman(stringsArray[0])) + Integer.parseInt(enumSolutionWithRoman(stringsArray[2]));
                            outputWithRoman(out);
                        }
                        case "-" -> {
                            out = Integer.parseInt(enumSolutionWithRoman(stringsArray[0])) - Integer.parseInt(enumSolutionWithRoman(stringsArray[2]));
                            if (out <= 0) {
                                throw new IOException("в римской системе нет отрицательных чисел");
                            }
                            outputWithRoman(out);
                        }
                        case "*" -> {
                            out = Integer.parseInt(enumSolutionWithRoman(stringsArray[0])) * Integer.parseInt(enumSolutionWithRoman(stringsArray[2]));
                            outputWithRoman(out);
                        }
                        case "/" -> {
                            out = Integer.parseInt(enumSolutionWithRoman(stringsArray[0])) / Integer.parseInt(enumSolutionWithRoman(stringsArray[2]));
                            outputWithRoman(out);
                        }
                        default ->
                                throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                } else {
                    if (Integer.parseInt(stringsArray[0]) < 11 && Integer.parseInt(stringsArray[2]) < 11) {
                        switch (stringsArray[1]) {
                            case "+" ->
                                    System.out.println(Integer.parseInt(stringsArray[0]) + Integer.parseInt(stringsArray[2]));
                            case "-" ->
                                    System.out.println(Integer.parseInt(stringsArray[0]) - Integer.parseInt(stringsArray[2]));
                            case "*" ->
                                    System.out.println(Integer.parseInt(stringsArray[0]) * Integer.parseInt(stringsArray[2]));
                            case "/" ->
                                    System.out.println(Integer.parseInt(stringsArray[0]) / Integer.parseInt(stringsArray[2]));
                            default ->
                                    throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }
                    } else System.out.println("Введенное число больше десяти!!!");
                }
            } else System.out.println("Введенное выражение неверно!");
        } catch (NumberFormatException exception){
            if (checkingForAMatch(stringsArray[0]) && !checkingForAMatch(stringsArray[2]) || !checkingForAMatch(stringsArray[0]) && checkingForAMatch(stringsArray[2]))
                throw new IOException("используются одновременно разные системы счисления");
            else
                throw new IOException("строка не является математической операцией");
        }
    }
    static String enumSolutionWithRoman(String theStringBeingChecked) {
        for (Rim string : Rim.values()) {
            if (string.name().equals(theStringBeingChecked)) {
                theStringBeingChecked = Integer.toString(string.getInteger());
                return theStringBeingChecked;
            }
        }
        return theStringBeingChecked;
    }
    static boolean checkingForAMatch(String theStringBeingChecked) {
        for (Rim string : Rim.values()) if (string.name().equals(theStringBeingChecked)) return true;
        return false;
    }
    static String solutionWithRoman(String theStringBeingChecked) {
        for (Rim string : Rim.values()) {
            if (string.getInteger() == Integer.parseInt(theStringBeingChecked)) {
                theStringBeingChecked = string.toString();
                return theStringBeingChecked;
            }
        }
        return theStringBeingChecked;
    }
    static void outputWithRoman (int output){
        if (output >= 10)
        {
            int a, b;
            a = output / 10;
            b = output % 10;
            switch (a) {
                case 1 -> {
                    if (b == 0) System.out.print("X");
                    else System.out.print("X" + solutionWithRoman(Integer.toString(b)));
                }
                case 2 -> {
                    if (b == 0) System.out.print("XX");
                    else System.out.print("XX" + solutionWithRoman(Integer.toString(b)));
                }
                case 3 -> {
                    if (b == 0) System.out.print("XXX");
                    else System.out.print("XXX" + solutionWithRoman(Integer.toString(b)));
                }
                case 4 -> {
                    if (b == 0) System.out.print("XL");
                    else System.out.print("XL" + solutionWithRoman(Integer.toString(b)));
                }
                case 5 -> {
                    if (b == 0) System.out.print("L");
                    else System.out.print("L" + solutionWithRoman(Integer.toString(b)));
                }
                case 6 -> {
                    if (b == 0) System.out.print("LX");
                    else System.out.print("LX" + solutionWithRoman(Integer.toString(b)));
                }
                case 7 -> {
                    if (b == 0) System.out.print("LXX");
                    else System.out.print("LXX" + solutionWithRoman(Integer.toString(b)));
                }
                case 8 -> {
                    if (b == 0) System.out.print("LXXX");
                    else System.out.print("LXXX" + solutionWithRoman(Integer.toString(b)));
                }
                case 9 -> {
                    if (b == 0) System.out.print("XC");
                    else System.out.print("XC" + solutionWithRoman(Integer.toString(b)));
                }
                case 10 -> {
                    if (b == 0) System.out.print("C");
                    else System.out.print("C" + solutionWithRoman(Integer.toString(b)));
                }
            }
        } else {
            String outputResult;
            for (Rim string : Rim.values()) {
                if (string.getInteger() == output) {
                    outputResult = string.toString();
                    System.out.println(outputResult);
                }
            }
        }
    }
}