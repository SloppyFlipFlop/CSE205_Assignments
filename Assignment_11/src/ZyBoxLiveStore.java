/* 
 * Assignment #: 11
 * Name: David Nevarez
 * StudentID: 1225929460
 * Lecture: Mondays, Wednesdays, and Fridays, 11:15 AM –12:05 PM
 * Description: 
*/

public class ZyBoxLiveStore {

    private Node root; // Binary Search Tree root node

    // Constructor
    public ZyBoxLiveStore() {
        this.root = null;
    }

    public Node addGameToStore(Node node, Game gameToAdd) {
        if (node == null) {
            return new Node(gameToAdd);
        }

        double nodePrice = node.getGame().getPrice();

        if (gameToAdd.getPrice() < nodePrice) {
            node.setLeft(addGameToStore(node.getLeft(), gameToAdd));
        } else if (gameToAdd.getPrice() > nodePrice) {
            node.setRight(addGameToStore(node.getRight(), gameToAdd));
        } else {
            // Game already exists in the store
            return node;
        }
        return node;
    }

    // * removeGameFromStore(...) METHOD PROVIDED AS PART OF TEMPLATE
    // Removes a game from the BST based on the game's price (the BST key)
    public Node removeGameFromStore(Node node, double price) {
        if (node == null) {
            return null;
        }

        double nodePrice = node.getGame().getPrice();

        if (price < nodePrice) {
            node.setLeft(removeGameFromStore(node.getLeft(), price));
        } else if (price > nodePrice) {
            node.setRight(removeGameFromStore(node.getRight(), price));
        } else {
            // Found the node to be removed
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                // Node has two children, find successor and replace node
                Node successor = findMinNode(node.getRight());
                node.setGame(successor.getGame());
                node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
            }
        }
        return node;
    }

    private Node findMinNode(Node right) {
        Node current = right;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    // * searchByName(...) METHOD PROVIDED AS PART OF TEMPLATE
    // Searches for a game (by name) in the store. Returns null if there are no
    // games in the store or the game was not found. Otherwise, returns the Game
    // object with the game's matching name
    public Game searchByName(Node node, String name) {
        /*
         * This method returns a Game object if the game with the specified name is
         * found in the store. If the game is not found, the method returns null. The
         * method is needed because a game’s name is not the key in our BST, but we need
         * to find the node with a given name in the tree to remove it based on the
         * actual key (price).
         */

        if (node == null) {
            return null;
        }

        if (node.getGame().getName().equals(name)) {
            return node.getGame();
        }

        Game left = searchByName(node.getLeft(), name);
        Game right = searchByName(node.getRight(), name);

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    public String listGamesByPrice(Node node) {
        // This recursive method lists all the games in the store sorted by their prices
        // (in ascending order). You can achieve this by traversing the BST in-order.
        if (node == null) {
            return "";
        }

        String outputString = "";

        outputString += listGamesByPrice(node.getLeft());
        outputString += node.getGame().toString();
        outputString += listGamesByPrice(node.getRight());

        return outputString;

    }

    public int countGamesInStore(Node node) {

        /*
         * This method returns the number of games in the store. It does this by
         * recursively traversing the binary search tree and counting the number of
         * nodes. If the root node is null, the method returns 0.
         */

        if (node == null) {
            return 0;
        }

        return 1 + countGamesInStore(node.getLeft()) + countGamesInStore(node.getRight());

    }

    public Game searchByPrice(Node root, double price) {
        /*
         * This method searches for a game in the store based on the specified price.
         * Remember that prices in MS ZyBox Live are unique! Please traverse the BST to
         * find the game that matches the price and return the game stored in that node.
         * If the method traversed the entire BST without finding a game with the
         * specified price, it returns null (and the menu in Assignment11.java will take
         * care of the message that no price match was found, see driver class code).
         * Your algorithm should have an average case time complexity of O(log n).
         */

        if (root == null) {
            return null;
        }

        double nodePrice = root.getGame().getPrice();

        if (price < nodePrice) {
            return searchByPrice(root.getLeft(), price);
        } else if (price > nodePrice) {
            return searchByPrice(root.getRight(), price);
        } else {
            return root.getGame();
        }

    }

    public Node searchMostPopularGame(Node node) {

        /*
         * This method returns the game with the highest number of downloads. It does
         * this by recursively traversing the binary search tree and comparing the
         * number of downloads of each node. If the root node is null, the method
         * returns null.
         */

        if (node == null) {
            return null;
        }

        Node left = searchMostPopularGame(node.getLeft());
        Node right = searchMostPopularGame(node.getRight());

        if (left != null && left.getGame().getDownloads() > node.getGame().getDownloads()) {
            return left;
        }

        if (right != null && right.getGame().getDownloads() > node.getGame().getDownloads()) {
            return right;
        }

        return node;

    }

    public double calculateStoreValue(Node node) {
        /*
         * This method calculates the total value of the store. The total value of the
         * store is the sum of the prices of all games in the store. Please traverse the
         * BST and add up the prices of all games in the store. The method should not
         * return anything, but should print the total value of the store to the console
         * (see driver class code).
         */

        if (node == null) {
            return 0;
        }

        return node.getGame().getPrice() + calculateStoreValue(node.getLeft()) + calculateStoreValue(node.getRight());

    }

    // * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
    // getters and setters for the BST root
    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

}