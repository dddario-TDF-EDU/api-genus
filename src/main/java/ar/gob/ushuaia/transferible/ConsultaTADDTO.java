package ar.gob.ushuaia.transferible;

public class ConsultaTADDTO {

    //private final de appId y accion?
    private Integer ano;
    private Integer numero;
    private String tipo;

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
