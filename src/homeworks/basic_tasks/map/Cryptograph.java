package homeworks.basic_tasks.map;

import java.util.*;

public class Cryptograph {
    private Map<Character, int[]> crypto;

    Cryptograph() {
        crypto = initCryptoSourceData();
    }

    private static Map<Character, int[]> initCryptoSourceData() {
        Map<Character, int[]> crypto = new HashMap<>();
        crypto.put('А', new int[]{760, 128, 350, 201});
        crypto.put('Б', new int[]{101});
        crypto.put('В', new int[]{210, 106});
        crypto.put('Г', new int[]{351});
        crypto.put('Д', new int[]{129});
        crypto.put(' ', new int[]{760, 769, 758, 801, 849});
        return crypto;
    }

    private static List<Integer> parseToList(int[] codeArray) {
        List<Integer> codeList = new ArrayList<>();
        for (int j : codeArray) {
            codeList.add(j);
        }
        return codeList;
    }

    public List<Integer> getCryptText(String text) {
        text = text.toUpperCase();
        char[] charArray = text.toCharArray();
        List<Integer> codedText = new ArrayList<>();
        for (char c : charArray) {
            int[] codedChar = crypto.get(c);
            codedText.addAll(parseToList(codedChar));
        }
        return codedText;
    }

    public String getDecryptText(List<Integer> codedText) {
        StringBuilder result = new StringBuilder();
        while (codedText.size() != 0) {
            Map.Entry<Character, int[]> decryptedSymbol = getDecryptSymbol(codedText);
            result.append(decryptedSymbol.getKey());
            codedText = deleteDecryptSymbol(codedText, decryptedSymbol);
        }
        return result.toString();
    }

    private Map.Entry<Character, int[]> getDecryptSymbol(List<Integer> codedText) {
        for (Map.Entry<Character, int[]> element : crypto.entrySet()) {
            boolean isTrue = false;
            for (int i = 0; i < codedText.size(); i++) {
                if (element.getValue().length >= i + 1) {
                    isTrue = (codedText.get(i) == element.getValue()[i]);
                }
            }
            if (isTrue) {
                return element;
            }
        }
        return ((Map.Entry<Character, int[]>) Collections.EMPTY_MAP);
    }

    private List<Integer> deleteDecryptSymbol(List<Integer> codedText, Map.Entry<Character, int[]> list) {
        int[] intArray = list.getValue();
        Integer[] text = codedText.toArray(new Integer[0]);
        Integer[] text1 = Arrays.copyOfRange(text, intArray.length, text.length);
        return Arrays.asList(text1);
    }

}
