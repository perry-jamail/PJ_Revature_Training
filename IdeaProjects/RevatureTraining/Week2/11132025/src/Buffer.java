public class Buffer {
    static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("Hello");

        System.out.println(str1.append(" World!"));
        System.out.println(str1.insert(1, "i, H"));
        System.out.println(str1.deleteCharAt(0));
        System.out.println(str1.substring(9, 15));
    }
}
