package com.example.parcialacostadam.model;

public class Empleado {
    private Integer IdEmpleado;
    private String nombre;
    private String apellido;
    private boolean activo;

    public Empleado(Integer idEmpleado, String nombre, String apellido, boolean activo) {
        this.IdEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.activo = activo;
    }

    public Integer getIdEmpleado() {
        return IdEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean isActivo() {
        return activo;
    }

}
