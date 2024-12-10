package orgSenac.aula01.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;
    private double preco;

    @Column(columnDefinition = "TEXT")
    private String url;

    // Construtor padrão
    public Produto() {
    }

    // Construtor com argumentos
    public Produto(int ID, String nome, String descricao, double preco, String url) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.url = url;
    }

    // Getters e setters
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
    public String geturl() {
        return url;
    }

}