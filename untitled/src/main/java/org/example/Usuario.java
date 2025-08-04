package org.example;

public class Usuario {
    private String primerNombre;
    private String segundoNombre;
    private String apellidos;
    private String direccion;
    private String correo;
    private String tipoDocumento;
    private String numeroDocumento;
    private String telefono;
    private String ciudadResidencia;

    public Usuario(String primerNombre, String segundoNombre,
                   String apellidos, String direccion, String correo,
                   String tipoDocumento, String numeroDocumento,
                   String telefono, String ciudadResidencia) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo = correo;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.telefono = telefono;
        this.ciudadResidencia = ciudadResidencia;
    }
    public String getPrimerNombre() { return primerNombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public String getApellidos() { return apellidos; }
    public String getDireccion() { return direccion; }
    public String getCorreo() { return correo; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public String getTelefono() { return telefono; }
    public String getCiudadResidencia() { return ciudadResidencia; }
}
