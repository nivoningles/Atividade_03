package Cadastro_De_Contatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroContatos {
    private JPanel panelInferior;
    private JPanel panelTelaContatos;
    private JPanel panelSuperior;
    private JPanel panelSupEsquerdo;
    private JPanel panelSupDireito;
    private JTextField txtfNome;
    private JTextField txtfTelefone;
    private JTextField txtfEmail;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JList<String> listContatos;
    private String nomeContato;
    private String telefoneContato;
    private String emailContato;
    private DefaultListModel<String> listModel;
    private ControleDeContatos controle;

    public TelaCadastroContatos() {

        controle = new ControleDeContatos();
        listModel = new DefaultListModel<>();
        listContatos.setModel(listModel);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomeContato = txtfNome.getText();
                telefoneContato = txtfTelefone.getText();
                emailContato = txtfEmail.getText();

                if (nomeContato.equals("") && telefoneContato.equals("") && emailContato.equals("")) {
                    txtfNome.setText("");
                    txtfTelefone.setText("");
                    txtfEmail.setText("");
                }else {

                    controle.contatos(txtfNome.getText(), txtfTelefone.getText(), txtfEmail.getText());
                    atualizaTabela();

                    txtfEmail.setText("");
                    txtfTelefone.setText("");
                    txtfNome.setText("");
                }


            }
        });
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selecindice = listContatos.getSelectedIndex();

                if (selecindice != -1) {

                    controle.removeComprimisso(selecindice);
                    atualizaTabela();

                }else {
                    JOptionPane.showMessageDialog(null, "Selecione um contato para remover.");
                }


            }
        });
    }

    public void atualizaTabela(){

        listModel.clear();
        String[] contatos = controle.getTodosContatos();
        for(String contato : contatos){
            listModel.addElement(contato);
        }

    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new TelaCadastroContatos().panelTelaContatos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

    }

}
