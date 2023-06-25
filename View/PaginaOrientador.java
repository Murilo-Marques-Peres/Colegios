package View;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import DAO.AlunoDAO;
import DTO.Aluno;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class PaginaOrientador implements ActionListener{
    JFrame frame1 = new JFrame();
    DefaultTableModel model;
    JTable table1 = new JTable();
    JPanel painel1 = new JPanel();
    JPanel painel2 = new JPanel();
    JPanel painel3 = new JPanel();
    JTextField campoSerie = new JTextField();
    JTextField campoInserirAluno = new JTextField();
    
    JTextField campoTroca = new JTextField();
    JComboBox<String> caixaTurma;
    JComboBox<String> caixaEnsino;
    JComboBox<String> caixaOpcInsEdi;
    JComboBox<String> caixaOpcInsEdi2;
    JLabel labelSerie = new JLabel();
    JLabel labelTurma = new JLabel();
    JLabel labelGrau = new JLabel();
    JLabel labelAno = new JLabel();
    JLabel labelEnsino = new JLabel();
    JLabel labelTroca = new JLabel();
    JButton botaoPesquisar = new JButton("Pesquisar");
    JButton botaoInserirAluno = new JButton("Inserir Aluno");
    JButton botaoEditar = new JButton("Editar");
    JButton botaoConfirmarInserirAluno = new JButton("Confirmar Nome");
    JButton botaoConfirmarEditar = new JButton("Confirmar Edição");
    JButton botaoConfirmarInserirNota = new JButton("Confirmar Nota");
    String[] exemplos = {"A","B"};
    String[] ensinos = {"Fundamental", "Médio"};
    String[] opcoesInsEdi = {"Nota 1","Nota 2","Nota 3"};
    String[] opcoesInsEdi2 = {"Nome", "Nota 1","Nota 2","Nota 3"};
    String nome;
    boolean confirmacaoRepeticao = false;
    int referenciaListaAnterior;
    String pulledId;
    int pulledIdInt;
    int indexCaixa2;

    
    public void backgroundFrame1(){
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void backgroundFrame2(){
        frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame1.setSize(1500, 1000);
        frame1.setLayout(null);
        frame1.setVisible(true);
    }
    public void componentsMethod(){
        campoSerie.setHorizontalAlignment(JTextField.CENTER);
        campoSerie.setFont(new Font("Comic Sans", Font.BOLD, 14));
        campoSerie.setBounds(70,60,30,30);
        campoInserirAluno.setBounds(70,500,250,30);
        campoTroca.setBounds(240,450,50,30);
        labelSerie.setText("Série");
        labelSerie.setBounds(70,30,60,30);
        labelTurma.setText("Turma");
        labelTurma.setBounds(177,30,60,30);
        labelGrau.setText("o");
        labelGrau.setBounds(110,42,10,30);
        labelAno.setText("Ano");
        labelAno.setBounds(120,60,40,30);
        labelAno.setFont(new Font("Comic Sans", Font.BOLD, 16));
        labelEnsino.setText("Ensino");
        labelEnsino.setBounds(310,30,60,30);
        labelTroca.setText("Mudar para: (ID)");
        labelTroca.setBounds(120,450,100,30);
        caixaTurma = new JComboBox<String>(exemplos);
        caixaTurma.setBounds(176,60,50,30);
        caixaEnsino = new JComboBox<String>(ensinos);
        caixaEnsino.setBounds(260,60,150,30);
        caixaOpcInsEdi = new JComboBox<>(opcoesInsEdi);
        caixaOpcInsEdi.setBounds(350,500,100,30);
        caixaOpcInsEdi2 = new JComboBox<>(opcoesInsEdi2);
        caixaOpcInsEdi2.setBounds(350,500,100,30);
        botaoPesquisar.setBounds(450,60,120,30);
        botaoPesquisar.addActionListener(this);
        botaoInserirAluno.setBounds(0,250,180,30);
        botaoInserirAluno.addActionListener(this);
        botaoEditar.setBounds(0,290,100,30);
        botaoEditar.addActionListener(this);
        botaoConfirmarInserirAluno.setBounds(470,500,130,30);
        botaoConfirmarInserirAluno.addActionListener(this);
        botaoConfirmarEditar.setBounds(460,500,140,30);
        botaoConfirmarEditar.addActionListener(this);
        botaoConfirmarInserirNota.setBounds(470,500,130,30);
        botaoConfirmarInserirNota.addActionListener(this);
    }
    public void tableMethod(){
        String columnNames[] = {"ID", "Nome", "Nota1","Nota2","Nota3", "Media", "condicao"};
        String[][] data = {{"ID", "Nome", "Nota 1","Nota 2","Nota 3", "Média", "Condição"}};
        model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);

        table1.setRowHeight(25);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(60);
        columnModel.getColumn(3).setPreferredWidth(60);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(60);

        columnModel.getColumn(0).setCellRenderer(rightRenderer);
        columnModel.getColumn(1).setCellRenderer(rightRenderer);
        columnModel.getColumn(2).setCellRenderer(rightRenderer);
        columnModel.getColumn(3).setCellRenderer(rightRenderer);
        columnModel.getColumn(4).setCellRenderer(rightRenderer);
        columnModel.getColumn(5).setCellRenderer(rightRenderer);
        table1.setEnabled(false);
    }
    public void positionMethod(){
        frame1.getContentPane().setLayout(null);//over ride default
        Container c = frame1.getContentPane();
        c.add(campoSerie);
        c.add(campoInserirAluno);
        c.add(caixaTurma);
        c.add(caixaEnsino);
        c.add(caixaOpcInsEdi);
        c.add(caixaOpcInsEdi2);
        c.add(labelSerie);
        c.add(labelTurma);
        c.add(labelGrau);
        c.add(labelAno);
        c.add(labelEnsino);
        c.add(labelTroca);
        c.add(botaoPesquisar);
        c.add(botaoInserirAluno);
        c.add(botaoEditar);
        c.add(botaoConfirmarInserirAluno);
        c.add(botaoConfirmarEditar);
        c.add(botaoConfirmarInserirNota);
        c.add(campoTroca);
        
        campoInserirAluno.setVisible(false);
        caixaOpcInsEdi.setVisible(false);
        caixaOpcInsEdi2.setVisible(false);
        botaoConfirmarInserirAluno.setVisible(false);
        botaoConfirmarEditar.setVisible(false);
        botaoConfirmarInserirNota.setVisible(false);
        campoTroca.setVisible(false);
        labelTroca.setVisible(false);
    }
    PaginaOrientador(){
        backgroundFrame1();
        componentsMethod();
        tableMethod();
        positionMethod();

        painel1.add(table1);

        frame1.add(painel1);
        frame1.add(painel2);
        frame1.add(painel3);

        backgroundFrame2();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botaoInserirAluno){
            botaoConfirmarInserirNota.setVisible(false);
            botaoConfirmarEditar.setVisible(false);
            caixaOpcInsEdi.setVisible(false);
            caixaOpcInsEdi2.setVisible(false);
            campoTroca.setVisible(false);
            labelTroca.setVisible(false);

            campoInserirAluno.setVisible(true);
            botaoConfirmarInserirAluno.setVisible(true);
        }
        if(e.getSource()==botaoConfirmarInserirAluno){
            nome = campoInserirAluno.getText();

            Aluno aluno = new Aluno();
            aluno.setNomeAluno(nome);

            String CpfGenerico = "037565989";
            aluno.setCpfAluno(CpfGenerico);

            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.inserirAluno(aluno);

            

            /*colegioDAO objColegioDAO = new colegioDAO();
            objColegioDAO.funcaoInserirAlunoBD(objcolegioDTO);
            campoInserirAluno.setText("");
            atualizarTable();*/
        }
    }
}
