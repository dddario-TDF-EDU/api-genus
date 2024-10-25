package ar.gob.ushuaia.modelo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SecuenciaRespuesta")
    @SequenceGenerator(name = "SecuenciaRespuesta", schema = "tad", sequenceName = "secuencia_respuesta", allocationSize = 1)
    @Column(nullable = false)
    private Integer codigo;

    @Column(name = "pregunta")
    private String pregunta;

    @Column(name = "id_pregunta")
    private String idPregunta;

    @Column(name = "respuesta")
    private String respuesta;

    @Column(name = "tarea")
    private String tarea;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private Date fechaHora;

    @Column(name = "usuario")
    private String usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tramite")
    private Tramite tramite;

    @Column(name = "id_instancia_tarea")
    private String idInstanciaTarea;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getIdInstanciaTarea() {
        return idInstanciaTarea;
    }

    public void setIdInstanciaTarea(String idInstanciaTarea) {
        this.idInstanciaTarea = idInstanciaTarea;
    }
}
