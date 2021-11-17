package hu.Tanarora.controllers;

import hu.Tanarora.domain.Ora;
import hu.Tanarora.domain.Tanar;
import hu.Tanarora.services.OraService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OraController {
    private final OraService service;

    public OraController(OraService service) {
        this.service = service;
    }
    @GetMapping("/orak")
    public List<Ora> getOrak(){
        return service.getOrak();
    }

    @GetMapping("/orak/{id}")
    public Ora getOra(@PathVariable("id") int id){
        return service.getOra(id);
    }

    @PostMapping("/orak")
    @ResponseStatus(HttpStatus.CREATED)
    public Ora addOra(@RequestBody Ora ora){
        return service.addOra(ora);
    }

    @PutMapping("/orak/{id}")
    public Ora replaceOra(@PathVariable("id") int id, @RequestBody Ora ora){
        return service.replaceOra(id, ora);
    }
    @RequestMapping(method=RequestMethod.DELETE, path="/orak/{id}")
    public void deleteOra(@PathVariable("id") int id){
        service.deleteOra(id);
    }
}
