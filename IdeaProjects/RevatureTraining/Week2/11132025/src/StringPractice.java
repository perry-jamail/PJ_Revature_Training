public class StringPractice {
    static void main(String[] args) {
        String s = " Hello World! ";
        String s2 = " hello world! ";

        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.charAt(4));
        System.out.println(s.equals(s2));
        System.out.println(s.equalsIgnoreCase(s2));
        System.out.println(s.length());
        System.out.println(s.replace('o', 'p'));
        System.out.println(s.trim());
    }
}
