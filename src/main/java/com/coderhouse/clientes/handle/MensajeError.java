package com.coderhouse.clientes.handle;

public class MensajeError {
    private String error;

    public MensajeError(String error) {
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}