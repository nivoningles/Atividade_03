package AgendaDiaria;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class LocalDeAgendamento {


    private JButton btnRemoveComp;
    private JButton btnAddComp;
    private JTable tbCompromissos;
    private JTextField txtfCompromisso;
    private JSpinner jsContDias;
    private JPanel panelInferior;
    private JPanel panelSuperior;
    private JPanel panelSupEsquerdo;
    private JPanel panelSupDireito;
    private JPanel panelAgendamento;
    private JSpinner jsContAnos;
    private JSpinner jsContMes;
    private String infComprimisso;
    private String infDia;
    private String infAno;
    private String infMes;
    private int contador = 0;

    public LocalDeAgendamento() {

        executNoInicio();
        SalvadorDeAgendamento salv = new SalvadorDeAgendamento();

        btnAddComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                infComprimisso = txtfCompromisso.getText();
                infDia = jsContDias.getValue().toString();
                infAno = jsContAnos.getValue().toString();
                infMes = jsContMes.getValue().toString();

                if (infComprimisso.equals("")){
                    txtfCompromisso.setText("");
                }else {

                    salv.salvador(infComprimisso, infDia, infMes, infAno);

                    DefaultTableModel model = (DefaultTableModel) tbCompromissos.getModel();

                    model.addRow(new Object[]{salv.comprimisso(contador), salv.data(contador)});

                    contador++;

                    txtfCompromisso.setText("");

                }

            }
        });
        btnRemoveComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) tbCompromissos.getModel();

                int selectRow = tbCompromissos.getSelectedRow();

                if (selectRow != -1){

                    String comprimisso = (String) tbCompromissos.getModel().getValueAt(selectRow, 0);
                    String data = (String) tbCompromissos.getModel().getValueAt(selectRow, 1);

                    model.removeRow(selectRow);

                }

            }
        });
    }

    public void executNoInicio(){

        DefaultTableModel model = (DefaultTableModel) tbCompromissos.getModel();

        if (model.getColumnCount() == 0) {
            model.setColumnIdentifiers(new String[]{"Compromisso", "Data"});
        }

        jsContDias.setModel(new SpinnerNumberModel(1,1,31,1));

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        jsContMes.setModel(new SpinnerListModel(meses));

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

        jsContAnos.setModel(new SpinnerNumberModel(2024,2024,anoAtual + 100,1));

    }


    public static void main(String[] args) {


        JFrame frame = new JFrame("Local de Agendamento");
        frame.setContentPane(new LocalDeAgendamento().panelAgendamento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

}
