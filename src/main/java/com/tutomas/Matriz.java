package com.tutomas;

public class Matriz {
    private double[][] m;
    private double[][] binario;
    private int[] histograma;
    private int f;
    private int c;
    private int mayorH;

    public Matriz(int f, int c) {
        m = new double[f][c];
        this.f = f;
        this.c = c;
        binario = new double[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = 0;
                binario[i][j] = 0;
            }
        }
        histograma = new int[256];
        for (int i = 0; i < 256; i++) {
            histograma[i] = 0;
        }
        mayorH = 0;
    }

    public void addM(int i, int j, double agregado) {
        m[i][j] = agregado;
    }

    public double getM(int i, int j) {
        return m[i][j];
    }

    public double[][] binarizar() {
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] >= 128) {
                    binario[i][j] = 255;
                } else {
                    binario[i][j] = 0;
                }
            }
        }
        return binario;
    }

    public double getBinario(int i, int j) {
        return binario[i][j];
    }

    public int[] getHistograma() {
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                histograma[(int) (m[i][j] + 0.5)]++;
            }
        }
        int mayor = 0;
        for (int i = 0; i < 256; i++) {
            if (histograma[i] > mayor) {
                mayor = histograma[i];
            }
        }
        mayorH = mayor;
        return histograma;
    }

    public int getMayorH() {
        return mayorH;
    }
}
