import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI {
    List<CharacterClass> characterClassList = CharacterClassCreator.ShowCharacterList(); //nazwy klass postaci zostaną zapisane na liście typu List<String>
    private JPanel panel;
    private JFrame fr;
    private TextField txtField, txtField2, txtField3;
    private JTextArea txtArea, txtAreaSorted;
    private JButton sortByClass, addButton, sortByName, sortByLvl, sortByNameTreeSet;


    public void doIt() {
        //FRAME AND PANEL
        fr = new JFrame("Character list");
        panel = new JPanel();

        //TXT FIELDS
        txtField = new TextField("Character class");
        txtField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtField.setText("");
            }
        });

        txtField2 = new TextField("Name");
        txtField2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtField2.setText("");
            }
        });

        txtField3 = new TextField("Lvl");
        txtField3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtField3.setText("");
            }
        });

        //BUTTONS
        addButton = new JButton("Add your character");
        addButton.addActionListener((new JButtonListener()));

        sortByName = new JButton("Sort by character name");
        sortByName.addActionListener(new JButtonListener2());

        sortByClass = new JButton("Sort by class");
        sortByClass.addActionListener(new JButtonListener3());

        sortByLvl = new JButton("Sort by lvl");
        sortByLvl.addActionListener(new JButtonListener4());

        sortByNameTreeSet = new JButton("Sort by name (TreeSet)");
        sortByNameTreeSet.addActionListener(new JButtonListener5());

        //TXT AREAS
        //USER LIST AREA
        txtArea = new JTextArea(20, 30);
        txtArea.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(txtArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //ALL CHARACTERS SORTED AREA
        txtAreaSorted = new JTextArea(20, 30);
        txtAreaSorted.setLineWrap(true);
        for (CharacterClass word : characterClassList) {
            txtAreaSorted.append((word) + "\n");
        }
        JScrollPane scrollSorted = new JScrollPane(txtAreaSorted);
        scrollSorted.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollSorted.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        //PANEL ADD
        panel.add(txtField);
        panel.add(txtField2);
        panel.add(txtField3);
        panel.add(addButton);
        panel.add(sortByClass);
        panel.add(sortByName);
        panel.add(sortByLvl);
        panel.add(sortByNameTreeSet);



        fr.getContentPane().add(BorderLayout.EAST, panel);
        fr.getContentPane().add(BorderLayout.WEST, scroll);
        fr.getContentPane().add(BorderLayout.CENTER, scrollSorted);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program will be closed when the window is closed
        fr.setSize(1500, 200);
        fr.setVisible(true);
    }


    //Add user character to the list
    class JButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {

            characterClassList.add(new CharacterClass(txtField.getText().toUpperCase() + " ", txtField2.getText().toUpperCase() + " ", Integer.valueOf(txtField3.getText())));
            txtArea.append(txtField.getText().toUpperCase() + " " + txtField2.getText().toUpperCase() + " "+ txtField3.getText() + "\n");

            txtField.setText("");
            txtField2.setText("");
            txtField3.setText("");
        }
    }

    //Method 1 (sort by name)
    class JButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            txtAreaSorted.setText("");

            Collections.sort(characterClassList);

            for (CharacterClass word : characterClassList) {
                txtAreaSorted.append((word) + "\n");
            }

        }
    }

    //Method 2 (sort by character class)
    class JButtonListener3 implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            txtAreaSorted.setText("");

            ClassComparator classComp = new ClassComparator();
            characterClassList.sort(classComp);

            for (CharacterClass word : characterClassList) {
                txtAreaSorted.append((word) + "\n");
            }
        }
    }

    //Method 3 (sort by lvl)
    class JButtonListener4 implements ActionListener {
        public void actionPerformed (ActionEvent ev){
            txtAreaSorted.setText("");

            characterClassList.sort((first, second) -> first.getCharLvl().compareTo(second.getCharLvl()));

            for (CharacterClass word : characterClassList) {
                txtAreaSorted.append((word) + "\n");
            }
        }
    }

    //Method 4 (sort by name)
    class JButtonListener5 implements ActionListener {
        public void actionPerformed (ActionEvent ev){
            txtAreaSorted.setText("");

            Set<CharacterClass> characterClassTreeSet = new TreeSet<>(characterClassList);

            for (CharacterClass word : characterClassTreeSet) {
                txtAreaSorted.append((word) + "\n");
            }
        }
    }
}