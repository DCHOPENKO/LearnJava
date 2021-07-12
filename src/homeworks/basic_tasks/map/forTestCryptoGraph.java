package homeworks.basic_tasks.map;

public class forTestCryptoGraph {

        public static void main(String[] args) {
            Cryptograph crypto = new Cryptograph();
            String text = "БАБА ГАД";
            System.out.println(crypto.getCryptText(text));
            System.out.println(crypto.getDecryptText(crypto.getCryptText(text)));
        }
}
