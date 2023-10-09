package com.tutomas;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FormularioPDI extends JFrame {
    private JPanel panelHistograma;
    private JPanel panelImagenBinaria;
    private JPanel panelImagenGray;
    private JPanel panelImagenOriginal;

    public FormularioPDI() {
        initComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new FormularioPDI().setVisible(true));
    }

    private void initComponents() {
        JPanel panelPrincipal = new JPanel();
        JButton btnLeerImagen = new JButton();
        JPanel panelSalida = new JPanel();
        panelImagenOriginal = new JPanel();
        panelImagenGray = new JPanel();
        panelImagenBinaria = new JPanel();
        JPanel panelHist = new JPanel();
        panelHistograma = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDI ::: tutomas");
        setResizable(false);
        getContentPane().setLayout(new GridLayout(1, 0));

        btnLeerImagen.setText("leer imagen");
        btnLeerImagen.addActionListener(evt -> {
            try {
                btnLeerImagenActionPerformed();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        panelSalida.setBorder(BorderFactory.createTitledBorder(""));
        panelSalida.setLayout(new GridLayout(1, 3, 10, 10));

        panelImagenOriginal.setBackground(Color.lightGray);

        GroupLayout panelImagenOriginalLayout = new GroupLayout(panelImagenOriginal);
        panelImagenOriginal.setLayout(panelImagenOriginalLayout);
        panelImagenOriginalLayout.setHorizontalGroup(
                panelImagenOriginalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 246, Short.MAX_VALUE)
        );
        panelImagenOriginalLayout.setVerticalGroup(
                panelImagenOriginalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 259, Short.MAX_VALUE)
        );

        panelSalida.add(panelImagenOriginal);

        panelImagenGray.setBackground(Color.lightGray);

        GroupLayout panelImagenGrayLayout = new GroupLayout(panelImagenGray);
        panelImagenGray.setLayout(panelImagenGrayLayout);
        panelImagenGrayLayout.setHorizontalGroup(
                panelImagenGrayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 246, Short.MAX_VALUE)
        );
        panelImagenGrayLayout.setVerticalGroup(
                panelImagenGrayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 259, Short.MAX_VALUE)
        );

        panelSalida.add(panelImagenGray);

        panelImagenBinaria.setBackground(java.awt.Color.lightGray);

        GroupLayout panelImagenBinariaLayout = new GroupLayout(panelImagenBinaria);
        panelImagenBinaria.setLayout(panelImagenBinariaLayout);
        panelImagenBinariaLayout.setHorizontalGroup(
                panelImagenBinariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 246, Short.MAX_VALUE)
        );
        panelImagenBinariaLayout.setVerticalGroup(
                panelImagenBinariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 259, Short.MAX_VALUE)
        );

        panelSalida.add(panelImagenBinaria);

        panelHistograma.setBackground(Color.white);
        panelHistograma.setBorder(BorderFactory.createTitledBorder(""));

        GroupLayout panelHistogramaLayout = new GroupLayout(panelHistograma);
        panelHistograma.setLayout(panelHistogramaLayout);
        panelHistogramaLayout.setHorizontalGroup(
                panelHistogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 390, Short.MAX_VALUE)
        );
        panelHistogramaLayout.setVerticalGroup(
                panelHistogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 270, Short.MAX_VALUE)
        );

        GroupLayout panelHistLayout = new GroupLayout(panelHist);
        panelHist.setLayout(panelHistLayout);
        panelHistLayout.setHorizontalGroup(
                panelHistLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 426, Short.MAX_VALUE)
                        .addGroup(panelHistLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, panelHistLayout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelHistograma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        panelHistLayout.setVerticalGroup(
                panelHistLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 308, Short.MAX_VALUE)
                        .addGroup(panelHistLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelHistLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelHistograma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnLeerImagen))
                                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                                .addGap(185, 185, 185)
                                                .addComponent(panelHist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(199, Short.MAX_VALUE))
                        .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelSalida, GroupLayout.PREFERRED_SIZE, 774, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(26, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLeerImagen)
                                .addGap(309, 309, 309)
                                .addComponent(panelHist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                        .addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(panelSalida, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(350, Short.MAX_VALUE)))
        );

        getContentPane().add(panelPrincipal);
        pack();
    }

    private void btnLeerImagenActionPerformed() throws IOException {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setCurrentDirectory(new File("."));
        int opcion = jfc.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = jfc.getSelectedFile();
            ImagenColor imagen = new ImagenColor();
            imagen.imread(archivo);
            imagen.im2bw();
            panelImagenOriginal.setBorder(new GraficarEnPanel(imagen.imshow(1)));
            panelImagenGray.setBorder(new GraficarEnPanel(imagen.imshow(2)));
            panelImagenBinaria.setBorder(new GraficarEnPanel(imagen.imshow(3)));
            panelHistograma.setBorder(new GraficarEnPanel(imagen.imhist()));
        }
    }
}
