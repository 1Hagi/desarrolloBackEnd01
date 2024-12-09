package desarrollo01.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoModel {
    
    private int id_producto;
    private String nombre;
    private String descripcion;
    private Long precio;
    private int stock;
    private int id_empresa;
    private CategoriaModel categoria;

}
