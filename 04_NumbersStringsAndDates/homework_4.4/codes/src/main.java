public class main {
    public static void main(String[] args) {
        {
            String alphabetEng = "abcdifghijklmnopqrstuvwxwzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String alphabetRus = "абвгдеёжзиклмнопрстуфхчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЧШЩЪЫЬЭЮЯ";


            for (int i = 0 ; i <= alphabetRus.length(); i++) {
                if(i < alphabetEng.length()) {
                    char charEng = alphabetEng.charAt(i);
                    char charRus = alphabetRus.charAt(i);
                    System.out.println(charRus + " - " + (int) charRus + " " + charEng + " - " + (int) charEng);
                }
                if(i > alphabetEng.length() && i < alphabetRus.length()){
                    char charRus = alphabetRus.charAt(i);
                    System.out.println(charRus + " - " + (int) charRus);
                }
            }
        }
    }
}

