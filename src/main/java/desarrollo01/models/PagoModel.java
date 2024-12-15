package desarrollo01.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import desarrollo01.models.enums.Estado;
import desarrollo01.models.enums.MetodoPago;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")
public class PagoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_pago;

    @OneToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;

    private double monto;

    @CreationTimestamp
    private LocalDateTime fecha_pago;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodo_pago;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public int getId_pago() {
        return id_pago;
    }
    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public OrdenModel getOrden() {
        return orden;
    }
    public void setOrden(OrdenModel orden) {
        this.orden = orden;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(LocalDateTime fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}
