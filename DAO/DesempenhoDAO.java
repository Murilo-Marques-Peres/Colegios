package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import DTO.Desempenho;

public class DesempenhoDAO {
    Connection conn;
    PreparedStatement pstm;

    /*public void inserirDesempenho(Desempenho desempenho){
        String sql = "insert into Desempenho (cpfaluno) values (?)";
        conn = new ConexaoDAO().conectaDB();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, desempenho.getCpfAluno());
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"DesempenhoDAO" + erro);
        }
    }*/
    public void AtualizarDesempenho(Desempenho desempenho, int indexCaixa, String materia, String cpf){
        int idmateria = 0;
        int idturma = 0;
        conn = new ConexaoDAO().conectaDB();
        try {
            String sql3 = "select * from aluno where cpf = ?";
            pstm = conn.prepareStatement(sql3);
            pstm.setString(1, cpf);
            ResultSet rs2 = pstm.executeQuery();
            while(rs2.next()){
                idturma = rs2.getInt("turmaid");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro SQL: " + erro);
        }
        String sql2 = "select * from materia where nome = ? and idturma = ?";
        try {
            pstm = conn.prepareStatement(sql2);
            pstm.setString(1, materia);
            pstm.setInt(2, idturma);
            

            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                idmateria = rs.getInt("id");
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro SQL: " + erro);
        }
                
        if(indexCaixa == 0){

            String sql = "update desempenho set nota1 = ? where cpfaluno = ? and idmateria = ?";
            
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setFloat(1, desempenho.getNota1());   
                pstm.setString(2, cpf);
                pstm.setInt(3, idmateria);
                pstm.execute();
                pstm.close();

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "DesempenhoDAO" + erro);
            }
        }
        if(indexCaixa == 1){

            String sql = "update desempenho set nota2 = ? where cpfaluno = ? and idmateria = ?";
            
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setFloat(1, desempenho.getNota2());   
                pstm.setString(2, cpf);
                pstm.setInt(3, idmateria);  
                pstm.execute();
                pstm.close();           
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "DesempenhoDAO" + erro);
            }
        }
        if(indexCaixa == 2){

            String sql = "update desempenho set nota3 = ? where cpfaluno = ? and idmateria = ?";
            
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setFloat(1, desempenho.getNota3());
                pstm.setString(2, cpf);
                pstm.setInt(3, idmateria);
                pstm.execute();
                pstm.close();
                             
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "DesempenhoDAO" + erro);
            }
        }
    }
}
