//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Search Engine Project
// Files: SearchEngine WebPageNode
// Course: CS 300 Spring 2018
//
// Author: Samuel Topel
// Email: stopel2@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: n/a
// Online Sources: n/a
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the class that creates a new SearchEngine, it allows WebPageNodes to be stored.
 *
 *
 * 
 * @author Samuel Topel
 */
public class SearchEngine {
    private WebPageNode root;

    /**
     * Constructs a new null SearchEnginge
     */
    public SearchEngine() {
        this.root = null;
    }

    /**
     * This method checks to see if the SearchEngine is empty.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Helps create new webPageNodes
     * 
     * @param String id
     * @param WebPadeNode node
     * @return WebPageNode parent
     */
    private WebPageNode insertionH(String id, WebPageNode node) throws Exception {

        int compared = id.compareTo(node.getId());
        // Duplicate check
        if (compared == 0)
            throw new Exception();
        if (compared > 0) {
            // Right child null
            if (node.getRightChild() == null) {
                return node;
            } else {
                // recursive call
                return insertionH(id, node.getRightChild());
            }
        }
        // left child null
        if (node.getLeftChild() == null) {
            return node;
        } else {
            // recursive call
            return insertionH(id, node.getLeftChild());
        }

    }

    /**
     * This method inserts the webPageNode onto the binary tree.
     * 
     * @param String id
     * @param WebPadeNode node
     * 
     */
    public void insert(String id, String webLink) throws Exception {

        if (root == null) {
            root = new WebPageNode(id, webLink);
            return;
        }
        // gets parent node
        WebPageNode parentNode = insertionH(id, root);
        int compared = id.compareTo(parentNode.getId());
        if (compared > 0) {
            // (after) sets the right
            parentNode.setRightChild(new WebPageNode(id, webLink));
        } else {
            // sets the left child
            parentNode.setLeftChild(new WebPageNode(id, webLink));

        }
    }

    /**
     * Recursive Search helper
     * 
     * @param String id
     * @param WebPadeNode node
     * @return String webLink
     */
    private String searchHelper(String id, WebPageNode node) {
        if (node == null) {
            return "No web link found for the web page " + id;
        }
        // checks if id is equal to the current id
        if (id.equals(node.getId())) {
            return node.getWebLink();
        }
        // checks if the id is before the current in alphabet
        if (id.compareTo(node.getId()) > 0) {
            // search right child
            return searchHelper(id, node.getRightChild());
        } else {
            // search left child
            return searchHelper(id, node.getLeftChild());

        }
    }

    /**
     * Searches for the id in the binary tree
     * 
     * @param String id
     * @param WebPadeNode node
     * @return String webLink
     */
    public String searchWebPage(String id) {

        return searchHelper(id, root);
    }

    /**
     * Helps count
     * 
     * @param WebPadeNode node
     * @return int count
     */
    private int countHelper(WebPageNode node) {
        int count = 1;
        // checks if right child exists
        if (node.getRightChild() != null) {
            count += countHelper(node.getRightChild());
        }
        // checks if left child exists
        if (node.getLeftChild() != null) {
            count += countHelper(node.getLeftChild());
        }

        return count;
    }

    /**
     * This method counts the nodes in the binary tree
     * 
     * @param String id
     * @param WebPadeNode node
     * @return int
     */
    public int getWebPageCount() {

        // checks if the root not null
        if (root != null) {
            return countHelper(root);
        } else {
            return 0;
        }

    }

    /**
     * This method helps getAllWebPages by putting them all in an array
     * 
     * @param ArrayList<String> nodeList
     * @param WebPadeNode node
     * @return ArrayList<String> nodeList
     */
    private ArrayList<String> getAllHelper(WebPageNode node, ArrayList<String> nodeList) {
        // checks if the current node is the root
        if (node.equals(root)) {
            nodeList.add(root.getId());
        }
        // checks if the current node has a right child
        if (node.getRightChild() != null) {
            nodeList.add(node.getRightChild().getId());
            getAllHelper(node.getRightChild(), nodeList);
        }
        // checks if the current node has left child
        if (node.getLeftChild() != null) {
            nodeList.add(node.getLeftChild().getId());
            getAllHelper(node.getLeftChild(), nodeList);
        }
        return nodeList;
    }

    /**
     * This method finds the minimum
     * 
     * @param ArrayList<String> nodeList
     * @return int minimum
     */
    private int findMinIndex(ArrayList<String> nodeList) {
        int count = 0;
        int minimum = 0;
        // loops through items in list
        while (count < nodeList.size()) {
            if (nodeList.get(minimum).compareTo(nodeList.get(count)) > 0) {
                // sets the minimum to index j
                minimum = count;
            }
            count++;
        }
        return minimum;
    }

    /**
     * Sorts the ids
     * 
     * @param ArrayList<String> nodeList
     * @return ArrayList<String> newNodeList
     */
    private ArrayList<String> getAllWebPagesSort(ArrayList<String> nodeList) {
        ArrayList<String> newNodeList = new ArrayList<String>();
        // gets the size of the array at beginning
        int times = nodeList.size();
        for (int i = 0; i < times; i++) {
            // gets the index of the minimum
            int x = findMinIndex(nodeList);
            newNodeList.add(nodeList.get(x));
            nodeList.remove(x);
        }
        return newNodeList;


    }

    /**
     * Creates an array with all the ids
     * 
     * @return ArrayList<String> newNodeList
     */
    public ArrayList<String> getAllWebPages() {
        ArrayList<String> newNodeList = new ArrayList<String>();
        newNodeList = getAllHelper(root, newNodeList);
        newNodeList = getAllWebPagesSort(newNodeList);

        return newNodeList;
    }

    /**
     * Main method to execute the program
     * 
     * @param String[] args
     */
    public static void main(String[] args) {
        System.out.println();
        System.out.println(
                        "=========================== Search Engine ============================");
        System.out.println("1. Enter 'i <id> <webLink>' to insert a web page in the search engine");
        System.out.println("2. Enter 's <id>' to search a web link in the search engine");
        System.out.println("3. Enter 'p' to print all the web page ids in the search engine");
        System.out.println("4. Enter 'c' to get the count of all web pages in the search engine");
        System.out.println("5. Enter 'q' to quit the program");
        System.out.println(
                        "======================================================================");
        System.out.println();
        System.out.print("Please enter your command:");
        SearchEngine se = new SearchEngine();
        Scanner scr = new Scanner(System.in);
        String id = null;
        String webLink = null;
        String[] userInput = scr.nextLine().trim().split(" ");
        // gets the character command
        String input = userInput[0].trim().toLowerCase();
        while (!input.equals("q")) {
            // Insert command
            if (input.equals("i")) {
                // checks for blanks
                if (userInput.length <= 2) {
                    System.out.println(
                                    "WARNING: failed to insert web page: Id/web link can’t be blank!");
                } else {
                    id = userInput[1].trim();
                    webLink = userInput[2].trim();
                    try {
                        // sees if duplicate is inserted
                        se.insert(id, webLink);
                    } catch (Exception e) {
                        System.out.println("WARNING: failed to insert duplicate web page: " + id);
                    }
                    System.out.println();
                }
                // search command
            } else if (input.equals("p")) {
                if (se.isEmpty()) {
                    System.out.println("Search Engine is empty");
                } else {
                    ArrayList<String> array = se.getAllWebPages();
                    // Goes through the array
                    for (int i = 0; i < array.size(); i++) {
                        // checks if last item
                        if (i == array.size() - 1) {
                            System.out.println(array.get(i));
                        } else {
                            System.out.print(array.get(i) + ", ");
                        }
                    }
                    System.out.println();
                }
                // quit command
            } else if (input.equals("c")) {
                System.out.println(se.getWebPageCount());
                System.out.println();
                // print command
            } else if (input.equals("s")) {
                // Checks for blanks
                if (userInput.length <= 1) {
                    System.out.println(
                                    "WARNING: Invalid syntax for search operation: Id link can’t be blank!");
                } else {
                    id = userInput[1].trim();
                    webLink = se.searchWebPage(id);
                    System.out.println(id + " - " + webLink);
                    System.out.println();
                }
                // count command
            } else if (input.equals("q")) {
                break;
            } else {
                System.out.println("WARNING: Unrecognized command.");
            }
            System.out.println(
                            "=========================== Search Engine ============================");
            System.out.println(
                            "1. Enter 'i <id> <webLink>' to insert a web page in the search engine");
            System.out.println("2. Enter 's <id>' to search a web link in the search engine");
            System.out.println("3. Enter 'p' to print all the web page ids in the search engine");
            System.out.println(
                            "4. Enter 'c' to get the count of all web pages in the search engine");
            System.out.println("5. Enter 'q' to quit the program");
            System.out.println(
                            "======================================================================");
            System.out.println();
            System.out.print("Please enter your command:");
            userInput = scr.nextLine().trim().split(" ");
            input = userInput[0].trim().toLowerCase();
        }
        scr.close();
    }
}
