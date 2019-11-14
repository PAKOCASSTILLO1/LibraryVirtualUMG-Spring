package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;

import gt.edu.umg.demo.model.Lenguaje;
import gt.edu.umg.demo.repository.LenguajeRepository;

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
@RequestMapping("/lenguaje")
public class LenguajeController {

    @Autowired
    LenguajeRepository lenguajeRepository;

    @GetMapping("/listar")
    public ResponseEntity<ApiResponse> listar(){
        List<Lenguaje> data = new ArrayList<>();
        List<Lenguaje> lenguajes =  lenguajeRepository.findAll();
        for (Lenguaje lenguaje : lenguajes) {
            if (lenguaje.getState()!=0) {
                data.add(lenguaje);                    
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
            List<Lenguaje> data = new ArrayList<>();
            if (lenguajeRepository.findById(id).orElse(null).equals(null)) {
                ApiResponse apiResponse = new ApiResponse("FAIL", "java.lang.NullPointerException"+" | No se ha encontrado el dato solicitado", null);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
            } else {
                data.add(lenguajeRepository.findById(id).orElse(null));
                ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
                return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
            }
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
    public ResponseEntity<ApiResponse> ver(@RequestBody Lenguaje lenguaje){
        try {
            List<Lenguaje> data = new ArrayList<>();
            data.add(lenguajeRepository.save(lenguaje));
            ApiResponse apiResponse = new ApiResponse("OK", "Proceso Exitoso", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.getMessage(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);  
        }
    }

    @PutMapping("/editar/{id}") // NOMBRE, USUARIO, STATE
    public ResponseEntity<ApiResponse> editar(@PathVariable int id, @RequestBody Lenguaje body){
        try {
            List<Lenguaje> data = new ArrayList<>();
            Lenguaje lenguaje = lenguajeRepository.findById(id).orElse(null);            
            data.add(lenguajeRepository.save(lenguaje.modified(body)));
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
            Lenguaje lenguaje = lenguajeRepository.findById(id).orElse(null);
            lenguaje.setState(0);
            lenguajeRepository.save(lenguaje);
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