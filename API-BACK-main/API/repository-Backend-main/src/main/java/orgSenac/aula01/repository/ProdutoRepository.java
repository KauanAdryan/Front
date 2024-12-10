package orgSenac.aula01.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import orgSenac.aula01.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

    List<Produto> findByNomeContains(String filter, Sort s);

    
}