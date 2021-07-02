package homeworks.basic_tasks.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coder {

    public static void main(String[] args) {

        Map<Character, int[]> coder = getDataForCoder();
        String text = "БАБА ГАД";
        char[] charArray = text.toCharArray();
        List<Integer> codedText = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            int[] codedChar = coder.get(charArray[i]);
            codedText.addAll(parseToList(codedChar));
        }
        System.out.println(codedText);
    }

    public static Map<Character, int[]> getDataForCoder() {
        Map<Character, int[]> coder = new HashMap<>();
        coder.put('А', new int[]{760, 128, 350, 201});
        coder.put('Б', new int[]{101});
        coder.put('В', new int[]{210, 106});
        coder.put('Г', new int[]{351});
        coder.put('Д', new int[]{129});
        coder.put(' ', new int[]{751, 769, 758, 801, 849});
        return coder;
    }

    public static List<Integer> parseToList(int[] codeArray) {
        List<Integer> codeList = new ArrayList<>();
        for (int i = 0; i < codeArray.length; i++) {
            codeList.add(codeArray[i]);
        }
        return codeList;
    }


}
