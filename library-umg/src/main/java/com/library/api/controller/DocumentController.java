package com.library.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.library.api.entity.Author;
import com.library.api.entity.Category;
import com.library.api.entity.Document;
import com.library.api.entity.Editorial;
import com.library.api.entity.Lenguaje;
import com.library.api.entity.SystemUser;
import com.library.api.repository.AuthorRepository;
import com.library.api.repository.CategoryRepository;
import com.library.api.repository.DocumentRepository;
import com.library.api.repository.EditorialRepository;
import com.library.api.repository.LenguajeRepository;
import com.library.api.repository.SystemUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    EditorialRepository editorialRepository;

    @Autowired
    LenguajeRepository lenguajeRepository;

    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/busqueda/{dato}")
    public ResponseEntity<ApiResponse> busqueda(@PathVariable String dato){
        try {
            List<Document> documents =  documentRepository.busqueda(dato);
            List<Document> data = new ArrayList<>();
            for (Document document : documents) {
                if (document.getState()==1) {
                    data.add(document.nullable());             
                }
            }
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ApiResponse> listarCategoria(@PathVariable int id){
        List<Document> data = new ArrayList<>();
        List<Document> documents =  documentRepository.findByCategoryId(id);
        for (Document document : documents) {
            if (document.getState()!=0) {
                data.add(document.nullable());
            }
        }
        try {
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar(){
        List<Document> data = new ArrayList<>();
        List<Document> documents =  documentRepository.findAll();
        for (Document document : documents) {
            if (document.getState()!=0) {
                data.add(document.nullable());               
            }
        }
        try {
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<ApiResponse> ver(@PathVariable int id){
        try {
            List<Document> data = new ArrayList<>();
            data.add(documentRepository.findById(id).orElse(null));
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    
    @PostMapping("/crear") // NOMBRE, USUARIO
    public ResponseEntity<ApiResponse> ver(@RequestBody Document body){
        try {
            List<Document> data = new ArrayList<>();

            SystemUser systemUser = systemUserRepository.findById(body.getUserId()).orElse(null);
            Category category = categoryRepository.findById(body.getCategoryId()).orElse(null);
            Author author = authorRepository.findById(body.getAuthorId()).orElse(null);
            Editorial editorial = editorialRepository.findById(body.getEditorialId()).orElse(null);
            Lenguaje lenguaje =lenguajeRepository.findById(body.getLenguajeId()).orElse(null);

            Document document = body.crear(systemUser, category, author, editorial, lenguaje);
            documentRepository.save(document);
            data.add(document.nullable());
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);  
        }
    }

    @PutMapping("/editar/{id}") // NOMBRE, USUARIO, STATE
    public ResponseEntity<ApiResponse> editar(@PathVariable int id, @RequestBody Document body){
        try {
            List<Document> data = new ArrayList<>();
            Document document = documentRepository.findById(id).orElse(null);
            SystemUser systemUser = systemUserRepository.findById(body.getUserId()).orElse(null);
            Category category = categoryRepository.findById(body.getCategoryId()).orElse(null);
            Author author = authorRepository.findById(body.getAuthorId()).orElse(null);
            Editorial editorial = editorialRepository.findById(body.getEditorialId()).orElse(null);
            Lenguaje lenguaje =lenguajeRepository.findById(body.getLenguajeId()).orElse(null);

            Document document1 = documentRepository.save(document.modified(body, systemUser, category, author, editorial, lenguaje));
            data.add(document1.nullable());
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<ApiResponse> borrar(@PathVariable int id){
        try {
            Document document = documentRepository.findById(id).orElse(null);
            document.setState(0);
            documentRepository.save(document);
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}