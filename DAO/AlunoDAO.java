package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.Aluno;

public class AlunoDAO {
    Connection conn;
    PreparedStatement pstm;

    public void inserirAluno(Aluno aluno){
        String sql = "insert into aluno (cpf, nome, nascimento) values (?,?,?)";
        
        java.sql.Date sqlDate = new java.sql.Date(aluno.getNascimentoAluno().getTime());

        conn = new ConexaoDAO().conectaDB();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getCpfAluno());
            pstm.setString(2, aluno.getNomeAluno());
            pstm.setDate(3, sqlDate);
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "AlunoDAO" + erro);
        }
         
    }
    
    
}
