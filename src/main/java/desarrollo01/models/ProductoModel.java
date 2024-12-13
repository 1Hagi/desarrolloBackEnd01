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
@Table(name = "producto")
public class ProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_producto;

    private String nombre;

    private String descripcion;

    private Long precio;

    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaModel categoria;

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }
    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }
    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

}
