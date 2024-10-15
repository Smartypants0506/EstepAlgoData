package Java;

import java.lang.Math;

public class RollDice {
    public static void main(String[] args) {
        int two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0, eleven = 0, twelve = 0;

        for ( int i = 0; i < 1000; i++){
            switch (rollDice()){
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                case 10:
                    ten++;
                    break;
                case 11:
                    eleven++;
                    break;
                case 12:
                    twelve++;
                    break;
            }
        }


    }

    public static int rollDice() {
        return ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
    }
}
