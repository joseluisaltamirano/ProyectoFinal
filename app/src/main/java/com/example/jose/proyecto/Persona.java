package com.example.jose.proyecto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by jose on 29/06/2017.
 */

public class Persona implements Parcelable {

    private String Id;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private int Edad;
    private boolean Activo;
    private String DNI;
    private String Tipo;
    private String Fecha;

    public Persona() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Id);
        dest.writeString(this.Nombre);
        dest.writeString(this.Apellido);
        dest.writeString(this.Direccion);
        dest.writeInt(this.Edad);
        dest.writeByte(this.Activo ? (byte) 1 : (byte) 0);
        dest.writeString(this.DNI);
        dest.writeString(this.Tipo);
        dest.writeString(this.Fecha);
    }

    protected Persona(Parcel in) {
        this.Id = in.readString();
        this.Nombre = in.readString();
        this.Apellido = in.readString();
        this.Direccion = in.readString();
        this.Edad = in.readInt();
        this.Activo = in.readByte() != 0;
        this.DNI = in.readString();
        this.Tipo = in.readString();
        this.Fecha = in.readString();
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel source) {
            return new Persona(source);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
