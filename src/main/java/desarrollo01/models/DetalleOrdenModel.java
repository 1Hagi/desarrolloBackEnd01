package desarrollo01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_ordenes")
public class DetalleOrdenModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_detalle;
    
    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private OrdenModel orden;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)    
    private ProductoModel producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private Long precio_unitario;

    public int getId_detalle() {
        return id_detalle;
    }
    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public OrdenModel getOrden() {
        return orden;
    }
    public void setOrden(OrdenModel orden) {
        this.orden = orden;
    }

    public ProductoModel getProducto() {
        return producto;
    }
    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio_unitario() {
        return precio_unitario;
    }
    public void setPrecio_unitario(Long precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public double getTotal() {
        return this.precio_unitario * this.cantidad;
    }
}
