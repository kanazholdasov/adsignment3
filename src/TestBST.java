public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "Five");
        bst.put(3, "Three");
        bst.put(7, "Seven");
        bst.put(2, "Two");
        bst.put(4, "Four");
        bst.put(6, "Six");
        bst.put(8, "Eight");

        System.out.println("In-order traversal:");
        for (var elem : bst.iterator()) {
            System.out.println("key is " + elem);
        }

        System.out.println("\nKey-Value Pair:");
        for (var elem : bst.keyValueIterator()) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }
    }
}
