package team.esprit.test;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import team.esprit.dao.VilleDAO;
import team.esprit.entities.Ville;

public class AutoCompleteTextField {

    JFrame frame = new JFrame();
    VilleDAO villeDAO = new VilleDAO();
    List<Ville> listVilles;
    List<String> listSomeStrings = new ArrayList<String>();
    AutoCompleteTextFieldController someTextField = new AutoCompleteTextFieldController(listSomeStrings);

    public AutoCompleteTextField() {
        listVilles = villeDAO.afficherVilles();
        listSomeStrings.add("Tapez quelque chose ..");
        for (Ville ville : listVilles) {
            listSomeStrings.add(ville.getGouvernorat() + ", " + ville.getDelegation() + ", " + ville.getLocalite());
        }
        someTextField.setDataList(listSomeStrings);
        frame.setTitle("AutoCompleteList");
        frame.setSize(300, 75);
        frame.add(someTextField);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                someTextField.setText("-");
                someTextField.grabFocus();
                someTextField.requestFocus();
                someTextField.selectAll();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AutoCompleteTextField autoCompleteTextField = new AutoCompleteTextField();
            }
        });
    }
}