package org.programacion3.examenfinal;

import java.io.*;
import java.util.ArrayList;

public class Producto {

    private int IDproducto;
    private String tipoActivo;
    private String marca;
    private String modelo;
    private String serial;
    private String pResponsable;

    public Producto(){}

    public Producto(int IDproducto,String tipoActivo, String marca, String modelo, String serial, String pResponsable) {
        this.IDproducto = IDproducto;
        this.tipoActivo = tipoActivo;
        this.marca = marca;
        this.modelo = modelo;
        this.serial = serial;
        this.pResponsable = pResponsable;
    }

    public int getIDproducto() {
        return IDproducto;
    }

    public void setIDproducto(int IDproducto) {
        this.IDproducto = IDproducto;
    }

    public String getTipoActivo() {
        return tipoActivo;
    }

    public void setTipoActivo(String tipoActivo) {
        this.tipoActivo = tipoActivo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getPResponsable() {
        return pResponsable;
    }

    public void setpResponsable(String pResponsable) {
        this.pResponsable = pResponsable;
    }

    @Override
    public String toString() {
        return
                IDproducto + ";"
                 + tipoActivo + ';'
                 + marca + ';' +
                 modelo + ';'  + serial + ';' +
                  pResponsable + ";" + '.' ;
    }

    public void CrearArchivo(Producto p){
        String rutaArchivo = "/Users/erick/IdeaProjects/ExamenFinal/src/main/resources/org/programacion3/Archivo/productos.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(p.toString());
            writer.write("\n");
            System.out.println("Producto guardado en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error creando archivo manito " + e.getMessage());
        }
    }


        public static Producto fromString(String linea) {
            String[] datos = linea.split(";");
            return new Producto(
                    Integer.parseInt(datos[0].trim()),
                    datos[1].trim(),
                    datos[2].trim(),
                    datos[3].trim(),
                    datos[4].trim(),
                    datos[5].trim()

            );
        }
    }




