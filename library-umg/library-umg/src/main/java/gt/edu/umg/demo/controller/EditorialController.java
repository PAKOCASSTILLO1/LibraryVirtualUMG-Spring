package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;

import gt.edu.umg.demo.model.Editorial;
import gt.edu.umg.demo.repository.EditorialRepository;
import gt.edu.umg.demo.repository.CountryRepository;

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
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    EditorialRepository editorialRepository;
    
    @Autowired
    CountryRepository countryRepository;
    
    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar2(){
        try {
            final List<Editorial> editorials =  editorialRepository.findAll();
            final List<Editorial> data = new ArrayList<>();
            for (final Editorial editorial : editorials) {
                if (editorial.getState()==1) {
                    editorial.setCountry(null);
                    data.add(editorial);
                }
            }
            final ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (final Exception e) {
            final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);            
        }
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<ApiResponse> ver(@PathVariable final int id){
        final List<Editorial> data = new ArrayList<>();
        try {
            final Editorial editorial = editorialRepository.findById(id).orElse(null);
            editorial.setCountry(null);
            data.add(editorial);
            final ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (final Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<ApiResponse> crear2(@RequestBody final Editorial body){
        final List<Editorial> data = new ArrayList<>();
        try {
            // NAME, COUNTRY_ID, CREATED_USER
            body.setCountry(countryRepository.findById(body.getCountryId()).orElse(null));
            editorialRepository.save(body);
            body.setCountry(null);
            data.add(body);
            final ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (final Exception e) {
            final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ApiResponse> editar2(@RequestBody final Editorial body, @PathVariable final int id){
        final List<Editorial> data = new ArrayList<>();
        try {
            final Editorial editorial = editorialRepository.findById(id).orElse(null);
            editorialRepository.save(editorial.modified(body, countryRepository.findById(body.getCountryId()).orElse(null)));
            editorial.setCountry(null);
            data.add(editorial);
            final ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (final Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<ApiResponse> editar(@PathVariable final int id){
        try {
            final Editorial editorial = editorialRepository.findById(id).orElse(null);
            editorial.setState(0);
            editorialRepository.save(editorial);
            final ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (final Exception e) {
            if (e.toString().equals("java.lang.NullPointerException")) {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                final ApiResponse apiResponse = new ApiResponse("FAIL", e.toString()+" | ERROR DESCONOCIDO", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}