package DTO;

public class Desempenho {
    private int id;
    private int idMateria;
    private String cpfAluno;
    private int anoDesempenho;
    private float nota1;
    private float nota2;
    private float nota3;
    
    public float getNota1() {
        return nota1;
    }
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }
    public float getNota2() {
        return nota2;
    }
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
    public float getNota3() {
        return nota3;
    }
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
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
    
}
