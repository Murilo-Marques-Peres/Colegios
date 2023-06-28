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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    JTextField campoCPF = new JTextField();
    JTextField campoTroca = new JTextField();
    JTextField campoDiaNascimento = new JTextField();
    JTextField campoMesNascimento = new JTextField();
    JTextField campoAnoNascimento = new JTextField();

    Date dataFormatada;

    JComboBox<String> caixaTurma;
    JComboBox<String> caixaEnsino;
    JComboBox<String> caixaOpcInsEdi;
    JComboBox<String> caixaOpcInsEdi2;
    JComboBox<String> caixaOpcMaterias;
    JLabel labelSerie = new JLabel();
    JLabel labelTurma = new JLabel();
    JLabel labelGrau = new JLabel();
    JLabel labelAno = new JLabel();
    JLabel labelEnsino = new JLabel();
    JLabel labelTroca = new JLabel();
    JLabel labelNome = new JLabel("Nome:");
    JLabel labelCPF = new JLabel("CPF:");
    JLabel labelDia = new JLabel("Dia:");
    JLabel labelMes = new JLabel("Mês:");
    JLabel labelAno2 = new JLabel("Ano:");
    JButton botaoPesquisar = new JButton("Pesquisar");
    JButton botaoInserirAluno = new JButton("Inserir Aluno");
    JButton botaoEditar = new JButton("Editar");
    JButton botaoConfirmarInserirAluno = new JButton("Confirmar Aluno");
    JButton botaoConfirmarEditar = new JButton("Confirmar Edição");
    JButton botaoConfirmarInserirNota = new JButton("Confirmar Nota");
    String[] exemplos = {"A","B"};
    String[] ensinos = {"Fundamental", "Médio"};
    String[] opcoesInsEdi = {"Nota 1","Nota 2","Nota 3"};
    String[] opcoesInsEdi2 = {"Nota 1","Nota 2","Nota 3"};
    String[] opcoesMaterias1 = {"Português", "Matemática","Literatura", "Inglês", "Espanhol", "História",
    "Sociologia", "Ciências Naturais"};
    
    String nome;
    String cpf;
    String dataNascimento;
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
        campoCPF.setBounds(335,500, 250,30);
        campoDiaNascimento.setBounds(280,580, 35,30);
        campoDiaNascimento.setHorizontalAlignment(JLabel.CENTER);
        campoMesNascimento.setHorizontalAlignment(JLabel.CENTER);
        campoMesNascimento.setBounds(335,580, 35,30);
        campoAnoNascimento.setBounds(385,580, 80,30);
        campoAnoNascimento.setHorizontalAlignment(JLabel.CENTER);
        labelSerie.setText("Série");
        labelSerie.setBounds(70,30,60,30);
        labelTurma.setText("Turma");
        labelTurma.setBounds(177,30,60,30);
        labelGrau.setText("o");
        labelGrau.setBounds(110,42,10,30);
        labelAno.setText("Ano");
        labelAno.setBounds(120,60,40,30);
        labelAno.setFont(new Font("Comic Sans", Font.BOLD, 14));
        labelEnsino.setText("Ensino");
        labelEnsino.setBounds(310,30,60,30);
        labelTroca.setText("Mudar para: (ID)");
        labelTroca.setBounds(120,450,100,30);
        labelNome.setBounds(70, 460, 250, 30);
        labelNome.setHorizontalAlignment(JLabel.CENTER);
        labelNome.setFont(new Font("Comic Sans", Font.BOLD, 14));
        labelCPF.setBounds(335,460,250,30);
        labelCPF.setHorizontalAlignment(JLabel.CENTER);
        labelCPF.setFont(new Font("Comic Sans", Font.BOLD, 14));
        labelDia.setBounds(280,540,35,30);
        labelDia.setFont(new Font("Comic Sans", Font.BOLD, 14));
        labelDia.setHorizontalAlignment(JLabel.CENTER);
        labelMes.setBounds(335,540,35,30);
        labelMes.setFont(new Font("Comic Sans", Font.BOLD, 14));
        labelMes.setHorizontalAlignment(JLabel.CENTER);
        labelAno2.setBounds(385,540,80,30);
        labelAno2.setHorizontalAlignment(JLabel.CENTER);
        labelAno2.setFont(new Font("Comic Sans", Font.BOLD, 14));
        caixaTurma = new JComboBox<String>(exemplos);
        caixaTurma.setBounds(176,60,50,30);
        caixaEnsino = new JComboBox<String>(ensinos);
        caixaEnsino.setBounds(260,60,150,30);
        caixaOpcInsEdi = new JComboBox<>(opcoesInsEdi);
        caixaOpcInsEdi.setBounds(350,500,100,30);
        caixaOpcInsEdi2 = new JComboBox<>(opcoesInsEdi2);
        caixaOpcInsEdi2.setBounds(350,500,100,30);
        caixaOpcMaterias = new JComboBox<String>(opcoesMaterias1);
        caixaOpcMaterias.setBounds(470,500,100,30);
        botaoPesquisar.setBounds(450,60,120,30);
        botaoPesquisar.addActionListener(this);
        botaoInserirAluno.setBounds(0,250,180,30);
        botaoInserirAluno.addActionListener(this);
        botaoEditar.setBounds(0,290,100,30);
        botaoEditar.addActionListener(this);
        botaoConfirmarInserirAluno.setBounds(600,540,130,30);
        botaoConfirmarInserirAluno.addActionListener(this);
        botaoConfirmarEditar.setBounds(600,500,140,30);
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
        c.add(campoCPF);
        c.add(campoDiaNascimento);
        c.add(campoMesNascimento);
        c.add(campoAnoNascimento);
        c.add(caixaTurma);
        c.add(caixaEnsino);
        c.add(caixaOpcInsEdi);
        c.add(caixaOpcInsEdi2);
        c.add(caixaOpcMaterias);
        c.add(labelSerie);
        c.add(labelTurma);
        c.add(labelGrau);
        c.add(labelAno);
        c.add(labelEnsino);
        c.add(labelTroca);
        c.add(labelNome);
        c.add(labelCPF);
        c.add(labelDia);
        c.add(labelMes);
        c.add(labelAno2);
        c.add(botaoPesquisar);
        c.add(botaoInserirAluno);
        c.add(botaoEditar);
        c.add(botaoConfirmarInserirAluno);
        c.add(botaoConfirmarEditar);
        c.add(botaoConfirmarInserirNota);
        c.add(campoTroca);
        
        campoInserirAluno.setVisible(false);
        campoTroca.setVisible(false);
        campoCPF.setVisible(false);
        campoDiaNascimento.setVisible(false);
        campoMesNascimento.setVisible(false);
        campoAnoNascimento.setVisible(false);
        caixaOpcInsEdi.setVisible(false);
        caixaOpcInsEdi2.setVisible(false);
        caixaOpcMaterias.setVisible(false);
        botaoConfirmarInserirAluno.setVisible(false);
        botaoConfirmarEditar.setVisible(false);
        botaoConfirmarInserirNota.setVisible(false);
        labelTroca.setVisible(false);
        labelNome.setVisible(false);
        labelCPF.setVisible(false);
        labelAno2.setVisible(false);
        labelMes.setVisible(false);
        labelDia.setVisible(false);
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
            caixaOpcMaterias.setVisible(false);
            campoTroca.setVisible(false);
            labelTroca.setVisible(false);

            campoDiaNascimento.setVisible(true);
            campoMesNascimento.setVisible(true);
            campoAnoNascimento.setVisible(true);
            labelDia.setVisible(true);
            labelMes.setVisible(true);
            labelAno2.setVisible(true);
            labelCPF.setVisible(true);
            labelNome.setVisible(true);
            campoCPF.setVisible(true);
            campoInserirAluno.setVisible(true);
            botaoConfirmarInserirAluno.setVisible(true);
        }
        if(e.getSource()==botaoConfirmarInserirAluno){
            nome = campoInserirAluno.getText();
            cpf = campoCPF.getText();

            dataNascimento = campoAnoNascimento.getText().concat("-").concat(campoMesNascimento.getText()).
            concat("-").concat(campoDiaNascimento.getText());
            System.out.println(dataNascimento);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno = new Aluno();
            aluno.setNomeAluno(nome);
            aluno.setCpfAluno(cpf);
            
            
            
            try {
                dataFormatada = formato.parse(dataNascimento);
                
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            aluno.setNascimentoAluno(dataFormatada);
            System.out.println(dataFormatada);
            alunoDAO.inserirAluno(aluno);
            campoInserirAluno.setText("");
            campoCPF.setText("");
            campoDiaNascimento.setText("");
            campoMesNascimento.setText("");
            campoAnoNascimento.setText("");
            //dataNascimento = 
            //SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            //try {
              //  Date dataFormatada = formato.parse(dataNascimento);
            //} catch (ParseException e1) {
                // TODO Auto-generated catch block
              //  e1.printStackTrace();
            //}


            /*colegioDAO objColegioDAO = new colegioDAO();
            objColegioDAO.funcaoInserirAlunoBD(objcolegioDTO);
            campoInserirAluno.setText("");
            atualizarTable();*/
        }
        if(e.getSource()==botaoEditar){
            campoInserirAluno.setVisible(false);
            botaoConfirmarInserirAluno.setVisible(false);
            caixaOpcInsEdi.setVisible(false);
            campoCPF.setVisible(false);
            labelNome.setVisible(false);
            labelCPF.setVisible(false);
            labelDia.setVisible(false);
            labelMes.setVisible(false);
            labelAno2.setVisible(false);
            campoDiaNascimento.setVisible(false);
            campoMesNascimento.setVisible(false);
            campoAnoNascimento.setVisible(false);
            
            caixaOpcMaterias.setVisible(true);
            labelTroca.setVisible(true);
            caixaOpcInsEdi2.setVisible(true);
            campoInserirAluno.setVisible(true);
            botaoConfirmarEditar.setVisible(true);
            campoTroca.setVisible(true);
            

            
        }
    }
}
