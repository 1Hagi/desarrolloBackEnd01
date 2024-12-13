package desarrollo01.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import desarrollo01.models.ProductoModel;
import desarrollo01.repositories.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> obtenerProductoPorID(Long id_producto) {
        return productoRepository.findById(id_producto);
    }

    public boolean eliminarProducto(Long id_producto) {
        try {
            productoRepository.deleteById(id_producto);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
