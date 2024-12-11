package desarrollo01.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import desarrollo01.models.enums.Estado;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes")
public class OrdenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_orden;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

    @CreationTimestamp
    private LocalDateTime fecha_orden;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public int getId_orden() {
        return id_orden;
    }
    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }
    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public LocalDateTime getFecha_orden() {
        return fecha_orden;
    }
    public void setFecha_orden(LocalDateTime fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
