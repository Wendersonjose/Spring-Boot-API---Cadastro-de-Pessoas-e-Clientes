package br.com.java.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
public class Pessoa {


    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int codigo;
    private String nome;
    private int idade;


    //Get e Set

    public String getNome() {
        return nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public int getIdade() {
        return idade;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
}
