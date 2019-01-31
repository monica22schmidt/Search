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
/**
 * This is the class that creates new WebPageNode.
 *
 *
 * @author Samuel Topel
 */
public class WebPageNode {

    private final String id; // The id of the web page
    private final String webLink; // The web link of the web page
    private WebPageNode leftChild; // The leftChild of the the current WebPageNode
    private WebPageNode rightChild; // The rightChild of the the current WebPageNode

    /**
     * Constructs a webPageNode
     * 
     * @param String id
     * @param String webLink
     */
    public WebPageNode(String id, String webLink) {
        this.id = id;
        this.webLink = webLink;
    }

    /**
     * Return Left
     * 
     * @return WebPageNode leftChild
     */
    public WebPageNode getLeftChild() {
        return this.leftChild;
    }

    /**
     * Set Left
     * 
     * @param WebPageNode leftChild
     */
    public void setLeftChild(WebPageNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Return Right
     * 
     * @return WebPageNode rightChild
     */
    public WebPageNode getRightChild() {
        return this.rightChild;
    }

    /**
     * Set Right
     * 
     * @param WebPageNode rightChild
     */
    public void setRightChild(WebPageNode rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Return Id
     * 
     * @return String id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Return webLink
     * 
     * @return String webLink
     */
    public String getWebLink() {
        return this.webLink;
    }
}
