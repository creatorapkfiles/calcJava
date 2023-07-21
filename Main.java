import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String strArray[] = str.split(" ");

        int out;

        try {
            if (strArray.length == 3) {

                if (contains(strArray[0]) == true && contains(strArray[2]) == true) {
                    switch (strArray[1]) {
                        case "+":
                            out = Integer.parseInt(pre(strArray[0])) + Integer.parseInt(pre(strArray[2]));
                            reshenIe(out);
                            break;
                        case "-":
                            out = Integer.parseInt(pre(strArray[0])) - Integer.parseInt(pre(strArray[2]));
                            if (out <= 0) {
                                throw new IOException("в римской системе нет отрицательных чисел");
                            }
                            reshenIe(out);
                            break;
                        case "*":
                            out = Integer.parseInt(pre(strArray[0])) * Integer.parseInt(pre(strArray[2]));
                            reshenIe(out);
                            break;
                        case "/":
                            out = Integer.parseInt(pre(strArray[0])) / Integer.parseInt(pre(strArray[2]));
                            reshenIe(out);
                            break;
                        default:
                            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }
                } else {
                    if (Integer.parseInt(strArray[0]) < 11 && Integer.parseInt(strArray[2]) < 11) {
                        switch (strArray[1]) {
                            case "+":
                                System.out.println(Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]));
                                break;
                            case "-":
                                System.out.println(Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]));
                                break;
                            case "*":
                                System.out.println(Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]));
                                break;
                            case "/":
                                System.out.println(Integer.parseInt(strArray[0]) / Integer.parseInt(strArray[2]));
                                break;
                            default:
                                throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }
                    } else System.out.println("Введенное число больше десяти!!!");
                }
            } else System.out.println("Введенное выражение неверно!");
        } catch (NumberFormatException exception){
            if (contains(strArray[0]) == true && contains(strArray[2]) == false || contains(strArray[0]) == false && contains(strArray[2]) == true)
                throw new IOException("используются одновременно разные системы счисления");
            else
                throw new IOException("строка не является математической операцией");
        }
    }
    public static String pre(String test) {
        for (Rim c : Rim.values()) {
            if (c.name().equals(test)) {
                test = Integer.toString(c.getInteger());
                return test;
            }
        }
        return test;
    }
    public static boolean contains(String test) {
        for (Rim c : Rim.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
    public static String pre1(String test) {
        for (Rim c : Rim.values()) {
            if (c.getInteger() == Integer.parseInt(test)) {
                test = c.toString();
                return test;
            }
        }
        return test;
    }
    public static void reshenIe (int out){
        if (out >= 10)
        {
            int a, b;
            a = out / 10;
            b = out % 10;
            switch (a){
                case 1 :
                    if (b == 0) System.out.print("X");
                    else System.out.print("X"+pre1(Integer.toString(b)));
                    break;
                case 2 :
                    if (b == 0) System.out.print("XX");
                    else System.out.print("XX"+pre1(Integer.toString(b)));
                    break;
                case 3 :
                    if (b == 0) System.out.print("XXX");
                    else System.out.print("XXX"+pre1(Integer.toString(b)));
                    break;
                case 4 :
                    if (b == 0) System.out.print("XL");
                    else System.out.print("XL"+pre1(Integer.toString(b)));
                    break;
                case 5 :
                    if (b == 0) System.out.print("L");
                    else System.out.print("L"+pre1(Integer.toString(b)));
                    break;
                case 6 :
                    if (b == 0) System.out.print("LX");
                    else System.out.print("LX"+pre1(Integer.toString(b)));
                    break;
                case 7:
                    if (b == 0) System.out.print("LXX");
                    else System.out.print("LXX"+pre1(Integer.toString(b)));
                    break;
                case 8:
                    if (b == 0) System.out.print("LXXX");
                    else System.out.print("LXXX"+pre1(Integer.toString(b)));
                    break;
                case 9:
                    if (b == 0) System.out.print("XC");
                    else System.out.print("XC"+pre1(Integer.toString(b)));
                    break;
                case 10:
                    if (b == 0) System.out.print("C");
                    else System.out.print("C"+pre1(Integer.toString(b)));
                    break;
            }
        }
    }
}