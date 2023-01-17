import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


class StartApp {

    public static void main(String[] args) {
        Icon trash = new ImageIcon("C:/Users/ivan/IdeaProjects/Practice2/img/trash.png");
        Icon pencil = new ImageIcon("C:/Users/ivan/IdeaProjects/Practice2/img/pencil.png");

        JComboBox<Department> departments = new JComboBox<>();

        Shop shop1 = new Shop("Магазин мяса");

        JFrame mainApp = new JFrame(shop1.getNameShop());

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        JPanel pn = new JPanel();
        pn.setLayout(gridbag);

        JScrollPane pane = new JScrollPane();
        pane.setBounds(10, 100, 465, 300);
        pane.setViewportView(pn);

        JPanel panel = new JPanel();
        panel.setBounds(150, 0, 200 ,65);

        JButton addDepart = new JButton("Добавить отдел");
        addDepart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDepart(shop1);
            }
        });

        JButton addProduct = new JButton("Добавить продукт");
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newProduct(shop1);
            }
        });

        ButtonGroup RButtonGroup = new ButtonGroup();

        JRadioButton showAll = new JRadioButton("Показать все товары");
        showAll.setBounds(10, 425, 150, 25);
        JRadioButton showDep = new JRadioButton("Показать отделы");
        showDep.setBounds(160, 425, 130, 25);
        JRadioButton showProductInDep = new JRadioButton("Показать товары в отделе");
        showProductInDep.setBounds(290, 425, 200, 25);

        RButtonGroup.add(showAll);
        RButtonGroup.add(showDep);
        RButtonGroup.add(showProductInDep);

        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departments.setEnabled(false);
                pn.removeAll();
                int n = 0;

                for (int i = 0; i < shop1.Departments.size(); i++){
                    for (int j = 0; j < shop1.Departments.get(i).Products.size(); j++){
                        Product product = shop1.Departments.get(i).Products.get(j);
                        Department dep = shop1.Departments.get(i);

                        JButton btn = new JButton(product.getNameProduct());
                        btn.setPreferredSize(new Dimension(300, 30));


                        JButton btnTrash = new JButton(trash);
                        btnTrash.setPreferredSize(new Dimension(30,30));
                        btnTrash.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deleter(mainApp, dep.Products, product);
                            }
                        });

                        JButton btnPencil = new JButton(pencil);
                        btnPencil.setPreferredSize(new Dimension(30,30));
                        btnPencil.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                editProd(product);
                            }
                        });

                        ArrayList<JButton> btns = new ArrayList<JButton>(
                                Arrays.asList(btn, btnTrash, btnPencil));

                        for (int k = 0; k < btns.size(); k++){
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.gridx = k;
                            c.gridy = n;
                            pn.add(btns.get(k), c);
                        }

                        n += 1;
                    }
                }
                pn.setPreferredSize(new Dimension(100 ,30 * n));
                mainApp.add(pane);

                SwingUtilities.updateComponentTreeUI(mainApp);
            }
        });
        showDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departments.setEnabled(false);
                pn.removeAll();

                int n = 0;

                for (int i = 0; i < shop1.Departments.size(); i++){
                    Department dep = shop1.Departments.get(i);

                    n += 1;
                    JButton btn = new JButton(dep.getNameDepart());
                    btn.setPreferredSize(new Dimension(300, 30));


                    JButton btnTrash = new JButton(trash);
                    btnTrash.setPreferredSize(new Dimension(30,30));
                    btnTrash.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            deleter(mainApp, shop1.Departments, dep);
                        }
                    });

                    JButton btnPencil = new JButton(pencil);
                    btnPencil.setPreferredSize(new Dimension(30,30));
                    btnPencil.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            editDepart(dep);
                        }
                    });

                    ArrayList<JButton> btns = new ArrayList<JButton>(
                            Arrays.asList(btn, btnTrash, btnPencil));

                    for (int j = 0; j < btns.size(); j++){
                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.gridx = j;
                        c.gridy = i;
                        pn.add(btns.get(j), c);
                    }
                }

                pn.setPreferredSize(new Dimension(100 ,30 * n));
                mainApp.add(pane);

                SwingUtilities.updateComponentTreeUI(mainApp);
            }
        });
        showProductInDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pn.removeAll();
                departments.setEnabled(true);

                try {
                    departments.removeAllItems();
                }catch (Exception E){}

                for (int i = 0; i < shop1.Departments.size(); i++){
                    System.out.println(shop1.Departments.get(i));
                    departments.addItem(shop1.Departments.get(i));
                }

                departments.setBounds(150, 75, 200, 25);
                mainApp.add(departments);
                SwingUtilities.updateComponentTreeUI(mainApp);

                departments.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pn.removeAll();
                        Department selectedDep = (Department) departments.getSelectedItem();

                        int n = 0;
                        for (int i = 0; i < selectedDep.Products.size(); i++) {
                            Product prod = selectedDep.Products.get(i);

                            n += 1;
                            JButton btn = new JButton(prod.getNameProduct());
                            btn.setPreferredSize(new Dimension(300, 30));


                            JButton btnTrash = new JButton(trash);
                            btnTrash.setPreferredSize(new Dimension(30, 30));
                            btnTrash.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    deleter(mainApp, selectedDep.Products, prod);
                                }
                            });

                            JButton btnPencil = new JButton(pencil);
                            btnPencil.setPreferredSize(new Dimension(30, 30));
                            btnPencil.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    editProd(prod);
                                }
                            });

                            ArrayList<JButton> btns = new ArrayList<JButton>(
                                    Arrays.asList(btn, btnTrash, btnPencil));

                            for (int j = 0; j < btns.size(); j++) {
                                c.fill = GridBagConstraints.HORIZONTAL;
                                c.gridx = j;
                                c.gridy = i;
                                pn.add(btns.get(j), c);
                            }
                        }

                        pn.setPreferredSize(new Dimension(100, 30 * n));
                        mainApp.add(pane);

                        SwingUtilities.updateComponentTreeUI(mainApp);
                    }
                });
            }
        });

        panel.add(addDepart);
        panel.add(addProduct);

        mainApp.add(panel);
        mainApp.add(showAll);
        mainApp.add(showDep);
        mainApp.add(showProductInDep);

        mainApp.setLayout(null);
        mainApp.setSize(500,500);
        mainApp.setVisible(true);

        mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void deleter(JFrame App, ArrayList list, Object item){
        if ((JOptionPane.showConfirmDialog(App, "Вы действительно хотите удалить " + item + " ?")) == 0){
            list.remove(item);
            System.out.println(list);
        }
    }

    public static void editDepart(Department dep){
        JFrame addApp = new JFrame("Редактирование отдела");

        JLabel label1 = new JLabel("Введите название отдела");
        label1.setBounds(50, 5, 200, 25);
        JLabel label2 = new JLabel("Введите время работы");
        label2.setBounds(50, 50, 200, 25);

        JTextField enterName = new JTextField(dep.getNameDepart());
        enterName.setBounds(50,25,200,25);
        JTextField enterOHours = new JTextField(dep.getOHours());
        enterOHours.setBounds(50,75,200,25);

        JButton saveData = new JButton("Сохранить");
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dep.setNameDepart(enterName.getText());
                dep.setOHours(enterOHours.getText());

                JOptionPane.showMessageDialog(addApp, "Изменения сохранены!");
                addApp.dispose();
            }
        });
        saveData.setBounds(75, 110, 150, 25);


        addApp.add(enterName);
        addApp.add(enterOHours);
        addApp.add(label1);
        addApp.add(label2);
        addApp.add(saveData);

        addApp.setLayout(null);
        addApp.setSize(300,200);
        addApp.setVisible(true);
    }

    public static void editProd(Product prod){
        JFrame editApp = new JFrame("Редактирование продукта");

        JLabel label1 = new JLabel("Введите новое название");
        label1.setBounds(50, 5, 200, 25);
        JLabel label2 = new JLabel("Введите новую цену");
        label2.setBounds(50, 50, 200, 25);

        JTextField enterName = new JTextField(prod.getNameProduct());
        enterName.setBounds(50,25,200,25);
        JTextField enterPrice = new JTextField(prod.getPrice());
        enterPrice.setBounds(50,75,200,25);

        JButton saveData = new JButton("Сохранить");
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prod.setNameProduct(enterName.getText());
                prod.setPrice(enterPrice.getText());

                JOptionPane.showMessageDialog(editApp, "Информация успешно изменена!");
                editApp.dispose();
            }
        });

        saveData.setBounds(75, 110, 150, 25);

        editApp.add(label1);
        editApp.add(label2);
        editApp.add(enterName);
        editApp.add(enterPrice);
        editApp.add(saveData);

        editApp.setLayout(null);
        editApp.setSize(300,200);
        editApp.setVisible(true);
    }


    public static void newDepart(Shop shop){
        JFrame addApp = new JFrame("Добавление отдела");

        JLabel label1 = new JLabel("Введите название отдела");
        label1.setBounds(50, 5, 200, 25);
        JLabel label2 = new JLabel("Введите время работы");
        label2.setBounds(50, 50, 200, 25);

        JTextField enterName = new JTextField();
        enterName.setBounds(50,25,200,25);
        JTextField enterOHours = new JTextField();
        enterOHours.setBounds(50,75,200,25);

        JButton saveData = new JButton("Сохранить");
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.Departments.add(new Department(enterName.getText(), enterOHours.getText()));
                System.out.println(shop.Departments);

                JOptionPane.showMessageDialog(addApp, "Отдел добавлен!");
                addApp.dispose();
            }
        });
        saveData.setBounds(75, 110, 150, 25);


        addApp.add(enterName);
        addApp.add(enterOHours);
        addApp.add(label1);
        addApp.add(label2);
        addApp.add(saveData);

        addApp.setLayout(null);
        addApp.setSize(300,200);
        addApp.setVisible(true);
    }

    public static void newProduct(Shop shop){
        JFrame addApp = new JFrame("Добавление отдела");

        JLabel label1 = new JLabel("Введите название продукта");
        label1.setBounds(50, 5, 200, 25);
        JLabel label2 = new JLabel("Введите цену продукта");
        label2.setBounds(50, 50, 200, 25);

        JTextField enterDep = new JTextField();
        enterDep.setBounds(50,25,200,25);
        JTextField enterPrice = new JTextField();
        enterPrice.setBounds(50,75,200,25);

        JComboBox<Department> departments = new JComboBox<>();
        for (int i = 0; i < shop.Departments.size(); i++){
            System.out.println(shop.Departments.get(i));
            departments.addItem(shop.Departments.get(i));
        }
        departments.setBounds(50, 125, 200, 25);

        JButton saveData = new JButton("Сохранить");
        saveData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department selectedDep = (Department) departments.getSelectedItem();
                System.out.println(selectedDep.getOHours());
                selectedDep.Products.add(new Product(enterDep.getText(), enterPrice.getText()));

                JOptionPane.showMessageDialog(addApp, "Продукт добавлен!");
                addApp.dispose();
            }
        });
        saveData.setBounds(75, 160, 150, 25);

        addApp.add(departments);
        addApp.add(enterDep);
        addApp.add(enterPrice);
        addApp.add(label1);
        addApp.add(label2);
        addApp.add(saveData);


        addApp.setLayout(null);
        addApp.setSize(300,250);
        addApp.setVisible(true);
    }
}