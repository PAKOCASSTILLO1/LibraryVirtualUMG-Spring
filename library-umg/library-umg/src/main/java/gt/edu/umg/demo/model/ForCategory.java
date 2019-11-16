package gt.edu.umg.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ForAuthor
 */
public class ForCategory {

    String category;
    List<String> documents = new ArrayList<>();


    public ForCategory() {
    }

    public ForCategory(String category, List<String> documents) {
        this.category = category;
        this.documents = documents;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getDocuments() {
        return this.documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public ForCategory category(String category) {
        this.category = category;
        return this;
    }

    public ForCategory documents(List<String> documents) {
        this.documents = documents;
        return this;
    }

}