public class Builder {
    static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("Hello");

        System.out.println(str1.append(" World!"));
        System.out.println(str1.insert(1, "i, H"));
        System.out.println(str1.deleteCharAt(0));
        System.out.println(str1.substring(9, 15));
    }
}