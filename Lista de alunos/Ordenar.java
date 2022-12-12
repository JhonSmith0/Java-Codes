import java.util.HashMap;

public class Ordenar {
    private static HashMap<Character, Integer> dict = new HashMap<Character, Integer>();    
    private static char alf[] = {
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't',
        'u',
        'v',
        'w',
        'x',
        'y',
        'z',
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
    };

    static {

        for (int i = 0; i < alf.length; i++) {
            dict.put(alf[i], i + 1);
        }
    }


    public static int sort(String a, String b) {
        String novo_a = a.replace(" ", "").toLowerCase();
        String novo_b = b.replace(" ", "").toLowerCase();

        int calc = 0;
        for (int i = 0; i < novo_a.length(); i++) {
            Integer a_letter_value = dict.get(novo_a.charAt(i));
            Integer b_letter_value = 0;

            if (i < novo_b.length()) {
                b_letter_value =  dict.get(novo_b.charAt(i));
            };


            calc += a_letter_value - b_letter_value;
        }


        return calc;




    }
}
