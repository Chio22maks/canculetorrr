import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        String first = "";
        String znak = "";
        String second = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (counter == 0) {
                first = scanner.next();
                counter++;
            } else if (counter == 1) {
                znak = scanner.next();
                counter++;
            } else if (counter == 2) {
                second = scanner.next();
                counter++;
            }
            if (counter == 3) {
                canculeted(first, second, znak, counter);
                counter = 0;
            }
        }
    }

    public static void canculeted  (String first, String second, String znak, int counter) {
        Integer integer;
        Integer integer2;
        String a = "V";
        String b = "I";
        String c = "X";  // все римские которые могут быть

        // получаем  каждый символ из строки


            boolean flag = false; //и так фолс если с маленькой
            if (Roman.I.name().equals(first)) flag = true;
            if (Roman.II.name().equals(first)) flag = true;
            if (Roman.III.name().equals(first)) flag = true;
            if (Roman.IV.name().equals(first)) flag = true;
            if (Roman.V.name().equals(first)) flag = true;
            if (Roman.VI.name().equals(first)) flag = true;
            if (Roman.VIII.name().equals(first)) flag = true;
            if (Roman.VIV.name().equals(first)) flag = true;
            if (Roman.X.name().equals(first)) flag = true;

            boolean flag2 = false;
            if (Roman.I.name().equals(second)) flag2 = true;
            if (Roman.II.name().equals(second)) flag2 = true;
            if (Roman.III.name().equals(second)) flag2 = true;
            if (Roman.IV.name().equals(second)) flag2 = true;
            if (Roman.V.name().equals(second)) flag2 = true;
            if (Roman.VI.name().equals(second)) flag2 = true;
            if (Roman.VIII.name().equals(second)) flag2 = true;
            if (Roman.VIV.name().equals(second)) flag2 = true;
            if (Roman.X.name().equals(second)) flag2 = true;
            if (flag && flag2 || !flag && !flag2) {

                boolean flag3 = false;
                if (first.startsWith(a) || first.startsWith(b) || first.startsWith(c)) {
                    flag3 = true;
                    Roman roman = Roman.valueOf(first);
                    int firstArab = roman.value;
                    integer = firstArab;
                    Roman secondRoman = Roman.valueOf(second);
                    integer2 = secondRoman.getValue();


                } else {
                    integer = Integer.valueOf(first);
                    integer2 = Integer.valueOf(second);
                }
                if (integer > 10 && integer2 < 10) {
                    throw new RuntimeException();
                } // если больше 10 то шибка

                switch (znak) {
                    case "+" -> { if(flag3) System.out.println(toRomanNumeral(integer + integer2));
                    else  System.out.println(integer + integer2);
                    }
                    case "-" -> { if(flag3) System.out.println(toRomanNumeral(integer - integer2));
                    else  System.out.println(integer - integer2);
                    }
                    case "*" -> { if(flag3) System.out.println(toRomanNumeral(integer * integer2));
                    else   System.out.println(integer * integer2);
                    }
                    case "/" -> { if(flag3) System.out.println(toRomanNumeral(integer / integer2));
                       else  System.out.println(integer / integer2);
                    }

                }
            } else {
                throw new RuntimeException();
            }
    }
    public enum Roman {
        I(1),
        II(2),
        III(3),
        IV(4),
        V(5),
        VI(6),
        VII(7),
        VIII(8),
        VIV(9),
        X(10);

          // РУГАЛОСЬ НА ЦИФРЫ ДОБАВИЛ


        private int value;

        Roman(int i) {
            value = i;
        }

        void Roman(int i) { /// добавил void
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }
    public static String toRomanNumeral(int number) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                sb.append(romanNumerals[i]);
            }
        }
        return sb.toString();
    }}
