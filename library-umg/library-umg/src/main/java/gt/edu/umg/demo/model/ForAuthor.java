package gt.edu.umg.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ForAuthor
 */
public class ForAuthor {

    String author;
    List<String> documents = new ArrayList<>();


    public ForAuthor() {
    }

    public ForAuthor(String author, List<String> documents) {
        this.author = author;
        this.documents = documents;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public ForAuthor author(String author) {
        this.author = author;
        return this;
    }

    public ForAuthor documents(List<String> documents) {
        this.documents = documents;
        return this;
    }

}