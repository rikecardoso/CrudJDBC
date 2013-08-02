/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo.controller;

import br.com.modelo.negocio.Marca;
import br.com.modelo.persistencia.MarcaDAO;
import br.com.modelo.persistencia.MarcaDAOJDBC;
import java.util.List;

/**
 *
 * @author celio_henrique
 */
public class MarcaController {
    public void inserir(Marca m){
        MarcaDAO md = new MarcaDAOJDBC();
        md.inserir(m);
    }
    public void atualizar(Marca m){
        MarcaDAO md = new MarcaDAOJDBC();
        md.atalizar(m);
    }
    public void excluir(int id){
        MarcaDAO md = new MarcaDAOJDBC();
        md.excluir(id);
    }
    public List<Marca> getMarca(){
        MarcaDAO md = new MarcaDAOJDBC();
        return md.getMarcas();
    }
    public List<Marca> getMarcaByNome(String nome){
        MarcaDAO md = new MarcaDAOJDBC();
        return md.getMarcasByNome(nome);
    }
    public Marca getMarcaById(int id){
        MarcaDAO md = new MarcaDAOJDBC();
        return md.getMarcasById(id);
    }
}
