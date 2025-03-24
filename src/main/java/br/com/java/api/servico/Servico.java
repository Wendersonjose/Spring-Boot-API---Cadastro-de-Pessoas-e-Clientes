package br.com.java.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.java.api.modelo.Mensagem;
import br.com.java.api.modelo.Pessoa;
import br.com.java.api.repositorio.Repositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Service
public class Servico {

    @Autowired
    private Repositorio acao;


    //Método para Cadastrar pessoas

    public ResponseEntity<?> cadastrar(Pessoa obj){
        Mensagem mensagem = new Mensagem();

        if(obj.getNome().equals("")){
            mensagem.setMensagem("Nome não pode ser vazio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if(obj.getIdade() < 0){
            mensagem.setMensagem("Idade não pode ser negativa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
        }
    }

    //Método para Selecionar pessoas

    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }

    //Método para selecionar pessoas por ID
    public ResponseEntity<?> selecionarPeloCodigo(int codigo){

        if(acao.countByCodigo(codigo) == 0){
            Mensagem mensagem = new Mensagem();
            mensagem.setMensagem("Código não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Método para Editar dados

    public ResponseEntity<?> editar(Pessoa obj) {
        Mensagem mensagem = new Mensagem(); // instância manual
    
        if (acao.countByCodigo(obj.getCodigo()) == 0) {
            mensagem.setMensagem("Código não encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        } else if (obj.getNome().equals("")) {
            mensagem.setMensagem("É necessário informar um nome");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Informe uma idade válida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(obj), HttpStatus.OK);
        }
    }

    //Método para remover registros

    public ResponseEntity<?> remover(int codigo){
        Mensagem mensagem = new Mensagem();

        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{

            Pessoa obj = acao.findByCodigo(codigo);
            acao.delete(obj);

            mensagem.setMensagem("Registro removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    
}
