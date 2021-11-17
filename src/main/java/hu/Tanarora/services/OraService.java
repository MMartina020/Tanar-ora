package hu.Tanarora.services;

import hu.Tanarora.domain.Ora;
import hu.Tanarora.repostories.OraRepository;
import hu.Tanarora.repostories.TanarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OraService {
    @Autowired
    private OraRepository repository;


    public List<Ora> getOrak() {
        return repository.findAllByOrderByOraname();
    }

    public Ora getOra(int id) {
        Optional<Ora> ora = repository.findById(id);
        if(ora.isPresent())
            return ora.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    public Ora addOra(Ora ora) {
        if(isUnique(ora.getOraname()))
            return repository.save(ora);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
    private boolean isUnique(String oraname) {
        List<Ora> orak = repository.findAll();
        for (Ora ora : orak) {
            if(ora.getOraname().equals(oraname))
                return false;
        }
        return true;
    }
}
