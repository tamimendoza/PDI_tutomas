package com.tutomas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImagenColor {
    private static final int TIPO_RGB = 3;
    private static final int TIPO_BN = 1;
    private BufferedImage imagen;
    private int filas;
    private int columnas;
    private Matriz img;
    private RGB rgb;
    private WritableRaster wr;
    private int nroBands;

    public ImagenColor() {
        this.imagen = null;
        this.filas = 0;
        this.columnas = 0;
    }

    public void imread(File archivo) throws IOException {
        this.imagen = ImageIO.read(archivo);
        this.filas = this.imagen.getWidth();
        this.columnas = this.imagen.getHeight();
        this.wr = this.imagen.getRaster();
        this.nroBands = this.wr.getNumBands();
        this.img = new Matriz(this.filas, this.columnas);
        this.rgb = new RGB(this.filas, this.columnas);
        this.matriciarImagen();
    }

    public void matriciarImagen() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                if (this.nroBands == TIPO_RGB) {
                    double r = this.wr.getSampleDouble(j, i, 0);
                    double g = this.wr.getSampleDouble(j, i, 1);
                    double b = this.wr.getSampleDouble(j, i, 2);
                    this.img.addM(i, j, (r + g + b) / 3);
                    this.rgb.addR(i, j, r);
                    this.rgb.addG(i, j, g);
                    this.rgb.addB(i, j, b);
                }
                if (this.nroBands == TIPO_BN) {
                    this.img.addM(i, j, this.wr.getSampleDouble(j, i, 0));
                }
            }
        }
    }

    public BufferedImage imshow(int tipo) {
        int tipoImagen = (tipo == 1) ? BufferedImage.TYPE_3BYTE_BGR : BufferedImage.TYPE_BYTE_GRAY;

        BufferedImage imgSalida = new BufferedImage(filas, columnas, tipoImagen);
        WritableRaster raster = imgSalida.getRaster();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tipo == 1) {
                    raster.setSample(j, i, 0, rgb.getR(i, j));
                    raster.setSample(j, i, 1, rgb.getG(i, j));
                    raster.setSample(j, i, 2, rgb.getB(i, j));
                } else if (tipo == 2) {
                    raster.setSample(j, i, 0, img.getM(i, j));
                } else if (tipo == 3) {
                    raster.setSample(j, i, 0, img.getBinario(i, j));
                }
            }
        }
        imgSalida.setData(raster);

        return imgSalida;
    }

    public void im2bw() {
        img.binarizar();
    }

    public BufferedImage imhist() {
        int[] histograma = img.getHistograma();
        int ancho = 270;
        int alto = img.getMayorH() + 200;
        BufferedImage imgSalida = new BufferedImage(ancho, alto, BufferedImage.TYPE_3BYTE_BGR);
        Graphics dibujo = imgSalida.createGraphics();
        Graphics2D g2D = (Graphics2D) dibujo;
        g2D.translate(ancho, alto);
        g2D.rotate(Math.toRadians(180));
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, ancho, alto);
        g2D.setColor(Color.BLUE);
        int k = 0;
        for (int i = 255; i > 0; i--) {
            g2D.drawRect(k, 0, 5, histograma[i]);
            k++;
        }
        return imgSalida;
    }
}
