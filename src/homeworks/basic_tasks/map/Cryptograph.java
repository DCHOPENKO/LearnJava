package homeworks.basic_tasks.map;

import java.util.*;

public class Cryptograph {
    private static final Map<Character, int[]> CRYPTO = initCryptoSourceData();

    private static Map<Character, int[]> initCryptoSourceData() {
        Map<Character, int[]> crypto = new HashMap<>();
/*        crypto.put('А', new int[]{760, 128, 350, 201});
        crypto.put('Б', new int[]{101});
        crypto.put('В', new int[]{210, 106});
        crypto.put('Г', new int[]{351});
        crypto.put('Д', new int[]{129});
        crypto.put(' ', new int[]{760, 769, 758, 801, 849});*/
        return crypto;
    }

    private List<Integer> parseToList(int[] codeArray) {
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
            int[] codedChar = CRYPTO.get(c);
            codedText.addAll(parseToList(codedChar));
        }
        return codedText;
    }

    public String getDecryptText(List<Integer> codedText) {
        StringBuilder result = new StringBuilder();
        while (codedText.size() != 0) {

            Character decryptedSymbol = getDecryptSymbol(codedText);
            if (decryptedSymbol.equals(Character.MIN_VALUE)) {
                return "Text contains not supported symbols";
            }
            result.append(decryptedSymbol);
            codedText = deleteDecryptSymbol(codedText, decryptedSymbol);
        }
        return result.toString();
    }

    private Character getDecryptSymbol(List<Integer> codedText) {
        for (Map.Entry<Character, int[]> element : CRYPTO.entrySet()) {
            boolean isTrue = false;
            for (int i = 0; i < codedText.size(); i++) {
                if (element.getValue().length >= i + 1) {
                    isTrue = codedText.get(i) == element.getValue()[i];
                }
            }
            if (isTrue) {
                return element.getKey();
            }
        }
        return Character.MIN_VALUE;
    }

    private List<Integer> deleteDecryptSymbol(List<Integer> codedText, Character symbol) {
        int[] intArray = CRYPTO.get(symbol);
        Integer[] text = codedText.toArray(new Integer[0]);
        Integer[] text1 = Arrays.copyOfRange(text, intArray.length, text.length);
        return Arrays.asList(text1);
    }

}
