package gt.edu.umg.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Document
 */
@Entity
public class Document implements Serializable{

    private static final long serialVersionUID = 1375649973745823416L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "documentId")
    @SequenceGenerator(name = "documentId", sequenceName = "ID_DOCUMENT")
    public int documentId;
    
    @NotNull
    @NotBlank
    public String title;

    @NotNull
    @NotBlank
    public String description;

    @NotNull
    @NotBlank
    public String imagenPath;

    @NotNull
    @NotBlank
    public String pdfPath;

    public int privated=0;

    public int userId;

    public int categoryId;

    public int authorId;

    public int editorialId;

    public int lenguajeId;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_SYSTEM_USER", nullable = false, updatable = false)
    public TcUser systemUser;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false, updatable = false)
    public Category category;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_AUTOR", nullable = false, updatable = false)
    public Author author;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_EDITORIAL", nullable = false, updatable = false)
    public Editorial editorial;

    // FOREIGN KEY
    @ManyToOne
    @JoinColumn(name = "FK_LENGUAJE", nullable = false, updatable = false)
    public Lenguaje lenguaje;

    public Date publicationDate;

    public int state = 1;
    public Date createdOn = new Date();

    @NotNull
    @NotBlank
    public String createdUser;

    public Date modifiedOn;
    public String modifiedUser;

    public Document nullable(){
        this.systemUser=null;
        this.category=null;
        this.author=null;
        this.editorial=null;
        this.lenguaje=null;
        return this;
    }

    public Document crear(TcUser systemUser, Category category, Author author, Editorial editorial, Lenguaje lenguaje){
        this.systemUser = systemUser;
        this.category = category;
        this.author = author;
        this.editorial = editorial;
        this.lenguaje = lenguaje;
        return this;
    }

    public Document modified(Document body, TcUser systemUser, Category category, Author author, Editorial editorial, Lenguaje lenguaje) {
        this.title = body.getTitle();
        this.description = body.getDescription();
        this.imagenPath = body.getImagenPath();
        this.pdfPath = body.getPdfPath();
        this.userId = systemUser.getUserId();
        this.categoryId = category.getCategoryId();
        this.authorId = author.getAuthorId();
        this.editorialId = editorial.getCountryId();
        this.lenguajeId = lenguaje.getLanguageId();
        this.systemUser = systemUser;
        this.category = category;
        this.author = author;
        this.editorial = editorial;
        this.lenguaje = lenguaje;
        this.publicationDate = body.getPublicationDate();
        this.modifiedOn = new Date();
        if (body.getModifiedUser()==null) {
            this.modifiedUser = body.getCreatedUser();
        }else{
            this.modifiedUser = body.getModifiedUser();
        }
        return this;
    }


    public Document() {
    }

    public Document(int documentId, String title, String description, String imagenPath, String pdfPath, int privated, int userId, int categoryId, int authorId, int editorialId, int lenguajeId, TcUser systemUser, Category category, Author author, Editorial editorial, Lenguaje lenguaje, Date publicationDate, int state, Date createdOn, String createdUser, Date modifiedOn, String modifiedUser) {
        this.documentId = documentId;
        this.title = title;
        this.description = description;
        this.imagenPath = imagenPath;
        this.pdfPath = pdfPath;
        this.privated = privated;
        this.userId = userId;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.editorialId = editorialId;
        this.lenguajeId = lenguajeId;
        this.systemUser = systemUser;
        this.category = category;
        this.author = author;
        this.editorial = editorial;
        this.lenguaje = lenguaje;
        this.publicationDate = publicationDate;
        this.state = state;
        this.createdOn = createdOn;
        this.createdUser = createdUser;
        this.modifiedOn = modifiedOn;
        this.modifiedUser = modifiedUser;
    }

    public int getDocumentId() {
        return this.documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagenPath() {
        return this.imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public String getPdfPath() {
        return this.pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public int getPrivated() {
        return this.privated;
    }

    public void setPrivated(int privated) {
        this.privated = privated;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getEditorialId() {
        return this.editorialId;
    }

    public void setEditorialId(int editorialId) {
        this.editorialId = editorialId;
    }

    public int getLenguajeId() {
        return this.lenguajeId;
    }

    public void setLenguajeId(int lenguajeId) {
        this.lenguajeId = lenguajeId;
    }

    public TcUser getSystemUser() {
        return this.systemUser;
    }

    public void setSystemUser(TcUser systemUser) {
        this.systemUser = systemUser;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editorial getEditorial() {
        return this.editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Lenguaje getLenguaje() {
        return this.lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Date getPublicationDate() {
        return this.publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreatedOn() {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedUser() {
        return this.createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getModifiedUser() {
        return this.modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Document documentId(int documentId) {
        this.documentId = documentId;
        return this;
    }

    public Document title(String title) {
        this.title = title;
        return this;
    }

    public Document description(String description) {
        this.description = description;
        return this;
    }

    public Document imagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
        return this;
    }

    public Document pdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
        return this;
    }

    public Document privated(int privated) {
        this.privated = privated;
        return this;
    }

    public Document userId(int userId) {
        this.userId = userId;
        return this;
    }

    public Document categoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Document authorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    public Document editorialId(int editorialId) {
        this.editorialId = editorialId;
        return this;
    }

    public Document lenguajeId(int lenguajeId) {
        this.lenguajeId = lenguajeId;
        return this;
    }

    public Document systemUser(TcUser systemUser) {
        this.systemUser = systemUser;
        return this;
    }

    public Document category(Category category) {
        this.category = category;
        return this;
    }

    public Document author(Author author) {
        this.author = author;
        return this;
    }

    public Document editorial(Editorial editorial) {
        this.editorial = editorial;
        return this;
    }

    public Document lenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
        return this;
    }

    public Document publicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public Document state(int state) {
        this.state = state;
        return this;
    }

    public Document createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Document createdUser(String createdUser) {
        this.createdUser = createdUser;
        return this;
    }

    public Document modifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }

    public Document modifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
        return this;
    }

}