package DTO;

import java.util.Date;

public class Aluno{
    private String cpfAluno;
    private String nomeAluno;
    private Date nascimentoAluno;
    public String getCpfAluno() {
        return cpfAluno;
    }
    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }
    public String getNomeAluno() {
        return nomeAluno;
    }
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    public Date getNascimentoAluno() {
        return nascimentoAluno;
    }
    public void setNascimentoAluno(Date nascimentoAluno) {
        this.nascimentoAluno = nascimentoAluno;
    }
}
