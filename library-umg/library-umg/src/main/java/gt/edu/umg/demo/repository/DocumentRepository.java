package gt.edu.umg.demo.repository;

import java.util.List;

import gt.edu.umg.demo.model.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * DocumentRepository
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{

    @Query("select a from Document a where a.title like %?1%")
    List<Document> busqueda(String data);

    List<Document> findByCategoryId(int id);

    List<Document> findByAuthorId(int id);

    // @Query("SELECT Author.name, Document.title FROM Document d JOIN Author a ON Author.authorId = Document.authorId")
    // List<?> bookAuthor();
}