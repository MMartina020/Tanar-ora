package hu.Tanarora.repostories;

import hu.Tanarora.domain.Ora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OraRepository extends JpaRepository<Ora , Integer> {
    public List<Ora> findAllByOrderByOraname();
}
