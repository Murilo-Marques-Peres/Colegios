package DTO;

public class Desempenho {
    private int id;
    private int idMateria;
    private String cpfAluno;
    private int anoDesempenho;
    private int nota1;
    private int nota2;
    private int nota3;
    
    public int getIdMateria() {
        return idMateria;
    }
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpfAluno() {
        return cpfAluno;
    }
    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }
    public int getAnoDesempenho() {
        return anoDesempenho;
    }
    public void setAnoDesempenho(int anoDesempenho) {
        this.anoDesempenho = anoDesempenho;
    }
    public int getNota1() {
        return nota1;
    }
    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }
    public int getNota2() {
        return nota2;
    }
    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
    public int getNota3() {
        return nota3;
    }
    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }

    
}
