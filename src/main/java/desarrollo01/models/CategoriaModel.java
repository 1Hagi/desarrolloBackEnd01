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
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoriaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_orden;

    private int id_usuario;
    private int id_empresa;

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

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_empresa() {
        return id_empresa;
    }
    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
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
