package algorithm.search;

public class Main {
    public static void main(String[] args) {
        Search<String> search = new BinarySearch<String>();

        String[] a = {"a","b","c","d"};
        System.out.println(search.search(a,"d"));
    }
}
