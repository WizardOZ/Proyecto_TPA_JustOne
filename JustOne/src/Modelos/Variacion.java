package Modelos;

public enum Variacion {
    COLOR_ESTANDAR("Color estándar"),
    COLOR_ROJO("Color rojo"),
    COLOR_AZUL("Color azul"),
    EDICION_LIMITADA("Edición limitada");

    private final String descripcion;

    Variacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}