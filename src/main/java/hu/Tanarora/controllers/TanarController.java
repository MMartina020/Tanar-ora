package hu.Tanarora.controllers;

import hu.Tanarora.domain.Tanar;
import hu.Tanarora.services.TanarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TanarController {
    private TanarService service;

    @Autowired
    public void setService(TanarService service) {
        this.service = service;
    }

    @GetMapping("/tanarok")
    public List<Tanar> getTanarok(){
        return service.getTanarok();
    }

    @GetMapping("/tanarok/{id}")
    public Tanar getTanar(@PathVariable("id") int id){
        return service.getTanar(id);
    }

    @PostMapping("/tanarok")
    @ResponseStatus(HttpStatus.CREATED)
    public Tanar addTanar(@RequestBody Tanar tanar){
        return service.addTanar(tanar);
    }

    @PatchMapping("tanarok/{id}/{kor}")
    public void updateTanar(@PathVariable("id") int id, @PathVariable("kor") int kor){
        service.updateTanar(id, kor);
    }

    @DeleteMapping("tanarok/{id}")
    public void deleteTanar(@PathVariable("id") int id){ service.deleteTanar(id);
    }
}
