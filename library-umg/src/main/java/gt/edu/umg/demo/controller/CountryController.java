package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;

import gt.edu.umg.demo.model.Country;
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
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar(){
        List<Country> data = new ArrayList<>();
        List<Country> countrys =  countryRepository.findAll();
        for (Country country : countrys) {
            if (country.getState()!=0) {
                data.add(country);                    
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
            List<Country> data = new ArrayList<>();
            data.add(countryRepository.findById(id).orElse(null));
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
    public ResponseEntity<ApiResponse> ver(@RequestBody Country country){
        try {
            List<Country> data = new ArrayList<>();
            data.add(countryRepository.save(country));
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);  
        }
    }

    @PutMapping("/editar/{id}") // NOMBRE, USUARIO, STATE
    public ResponseEntity<ApiResponse> editar(@PathVariable int id, @RequestBody Country body){
        try {
            List<Country> data = new ArrayList<>();
            Country country = countryRepository.findById(id).orElse(null);            
            data.add(countryRepository.save(country.modified(body)));
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
            Country country = countryRepository.findById(id).orElse(null);
            country.setState(0);
            countryRepository.save(country);
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