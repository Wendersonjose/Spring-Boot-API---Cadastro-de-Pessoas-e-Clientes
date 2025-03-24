package br.com.java.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.java.api.modelo.Cliente;
import br.com.java.api.modelo.Pessoa;
import br.com.java.api.repositorio.Repositorio;
import br.com.java.api.servico.Servico;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    // Removed duplicate method and corrected annotation case

    @GetMapping("/status")
    public ResponseEntity <?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(40);
    }

    @GetMapping("/api/somaIdade")
    public int somaIdades(){
        return acao.somaIdades();
    }


    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("m");
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("s");
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("l");
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Ana Laura");
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNome();
    }
    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
    }
    public long contador(){
        return acao.count();
    }

    
    @PutMapping("/api/editar")
        public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    @GetMapping("/api/{codigo}")
     public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
  }
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }
    
    
    @GetMapping("/")
    public String mensagem(){
        return "Hello, world!";
    }

    @GetMapping("/BoasVindas/{nome}")
    public String BoasVindas(@PathVariable String nome){
        return "Seja bem-vindo(a) " + nome;
    }
    @PostMapping("/Pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){
        

    }


    
}
