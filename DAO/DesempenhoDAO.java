package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.Desempenho;

public class DesempenhoDAO {
    Connection conn;
    PreparedStatement pstm;

    public void inserirDesempenho(Desempenho desempenho){
        String sql = "insert into Desempenho (cpfaluno) values (?)";
        conn = new ConexaoDAO().conectaDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, desempenho.getCpfAluno());
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"DesempenhoDAO" + erro);
        }
    }
    public void AtualizarDesempenho(Desempenho desempenho, String pedidoAtualizar){
        if(pedidoAtualizar.equals("nota1")){

            String sql = "update desempenho set nota1 = ? where cpfaluno = ?";
            conn = new ConexaoDAO().conectaDB();
            
            try {
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, desempenho.getNota1());                
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "DesempenhoDAO" + erro);
            }
        }
    }
}
