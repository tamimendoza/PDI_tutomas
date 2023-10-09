package com.tutomas;

public class RGB {
    private double[][] r;
    private double[][] g;
    private double[][] b;

    public RGB(int f, int c) {
        r = new double[f][c];
        g = new double[f][c];
        b = new double[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                r[i][j] = 0;
                g[i][j] = 0;
                b[i][j] = 0;
            }
        }
    }

    public void addR(int f, int c, double agregado) {
        r[f][c] = agregado;
    }

    public double getR(int f, int c) {
        return r[f][c];
    }

    public void addG(int f, int c, double agregado) {
        g[f][c] = agregado;
    }

    public double getG(int f, int c) {
        return g[f][c];
    }

    public void addB(int f, int c, double agregado) {
        b[f][c] = agregado;
    }

    public double getB(int f, int c) {
        return b[f][c];
    }
}
