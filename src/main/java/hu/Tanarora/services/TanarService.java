package hu.Tanarora.services;

import hu.Tanarora.domain.Tanar;
import hu.Tanarora.repostories.TanarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TanarService {
    @Autowired
    private TanarRepository repository;

    public List<Tanar> getTanarok() {
        return repository.findAll();
    }

    public Tanar getTanar(int id) {
        Optional<Tanar> tanar =  repository.findById(id);
        if(tanar.isPresent()) {
            return tanar.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Tanar addTanar(Tanar tanar) {
        if(isUnique(tanar.getName()))
            return repository.save(tanar);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    private boolean isUnique(String name) {
        List<Tanar> tanarok = repository.findAll();
        for (Tanar tanar : tanarok) {
            if(tanar.getName().equals(name))
                return false;
        }
        return true;
    }
    public void updateTanar(int id, int kor) {
        Optional<Tanar> optionalTanar =  repository.findById(id);
        if(optionalTanar.isPresent()) {
            Tanar tanar = optionalTanar.get();
            tanar.setKor(kor);
            repository.save(tanar);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public void deleteTanar(int id) {
        Optional<Tanar> tanar =  repository.findById(id);
        if(tanar.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
