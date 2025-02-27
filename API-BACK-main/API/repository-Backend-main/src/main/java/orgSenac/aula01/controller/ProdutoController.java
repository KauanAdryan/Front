package orgSenac.aula01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import orgSenac.aula01.Model.Produto;
import orgSenac.aula01.repository.ProdutoRepository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> get(@RequestParam(required = false, defaultValue = "nome") String order,
                            @RequestParam(required = false) String filter) {
        Sort s = Sort.by(order);
        switch (order) {
            case "valor_mais_alto":
                s = Sort.by(Sort.Order.desc("preco"));
                break;
            case "valor_mais_baixo":
                s = Sort.by(Sort.Order.asc("preco"));
                break;
            case "nome":
            default:
                s = Sort.by(Sort.Order.asc("nome"));
                break;
        }
    
        if (filter == null) {
            return repository.findAll(s);
        }
        return repository.findByNomeContains(filter, s);
    

    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }

}