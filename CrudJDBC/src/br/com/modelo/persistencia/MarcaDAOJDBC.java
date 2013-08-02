/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo.persistencia;

import br.com.modelo.negocio.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author celio_henrique
 */
public class MarcaDAOJDBC implements MarcaDAO{
    private final String INSERT = "INSERT INTO MARCA (NOME) VALUES (?)";
    private final String UPDATE = "UPDATE MARCA SET NOME = ? WHERE ID = ?";
    private final String DELETE = "UPDATE FROM MARCA WHERE ID = ?";
    private final String LIST   = "SELECT * FROM MARCA";
    private final String LISTBYNOMES = "SELECT * FROM MARCA WHERE NOME LIKE ? ";
    private final String LISTBYID = "SELECT * FROM MARCA WHERE ID = ? ";
    
    public void inserir(Marca m) {
        Connection conn = null;
        try{
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(INSERT);
            pstm.setString(1, m.getNome());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar uma marca");
        }
    }

  
    public void atalizar(Marca m) {
     Connection conn = null;
        try{
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, m.getNome());
            pstm.setInt(2, m.getId());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Marca atualizada com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar uma marca");
        }
    }

    
    public void excluir(int id) {
     Connection conn = null;
        try{
            conn = FabricaConexao.getConnection();
            PreparedStatement pstm = conn.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Marca excluida com sucesso");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir uma marca");
        }
    }

 
    public List<Marca> getMarcas() {
      Connection conn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;
      ArrayList<Marca> marcas = new ArrayList<Marca>();
        try{
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar as marcas");
        }
        return marcas;
    }

    
    public List<Marca> getMarcasByNome(String nome) {
       Connection conn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;
      ArrayList<Marca> marcas = new ArrayList<Marca>();
        try{
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYNOMES);
            pstm.setString(1, '%' + nome + '%');
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar as marcas");
        }
        return marcas;
    }

    
    public Marca getMarcasById(int id) {
        Connection conn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;
      ArrayList<Marca> marcas = new ArrayList<Marca>();
      Marca marca = new Marca();
        try{
            conn = FabricaConexao.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            
            while (rs.next()){
                
                marca.setId(rs.getInt("id"));
                marca.setNome(rs.getString("nome"));
                
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar as marcas");
        }
        return marca;
    }
    
}
