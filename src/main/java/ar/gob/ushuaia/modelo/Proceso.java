package ar.gob.ushuaia.modelo;


import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "asdasd", query = "asd")
})
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaProceso")
    @SequenceGenerator(name = "SecuenciaProceso", schema = "tad", sequenceName = "secuencia_proceso", allocationSize = 1)
    @Column(nullable = false)
    private Integer codigo;

    @Column(name = "id_proceso")
    private String idProceso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "modulo")
    private String modulo;

    @Column(name = "version")
    private Integer version;

    @Column(name = "usuario")
    private String usuario;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(String idProceso) {
        this.idProceso = idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
