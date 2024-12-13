package desarrollo01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManagerFactory;

@RestController
public class CacheController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/clear-cache")
    public String clearCache() {
        entityManagerFactory.getCache().evictAll();
        return "Cache de Hibernate limpiada correctamente.";
    }
}