package br.com.alura.recyclerview.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.recyclerview.model.Nota;

public class NotaDAO {
private final static ArrayList<Nota> notas = new ArrayList<>();
    public void insere(Nota nota){
        notas.add(nota);
    }
    public void deleta(int posicao ){
        notas.remove(posicao);
    }
    public void atualiza(){}
    public List<Nota> todos(){
        return (List<Nota>) notas.clone();
    }


    public void removeTodos() {
        notas.clear();
    }



}
