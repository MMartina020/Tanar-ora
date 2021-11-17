package hu.Tanarora.repostories;

import hu.Tanarora.domain.Tanar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanarRepository  extends JpaRepository<Tanar, Integer> {
}
