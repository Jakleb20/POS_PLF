package org.example.plf.repos;

import org.example.plf.models.Location;
import org.example.plf.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public int countProductByLocation(Location location);
    public Product getProductById(int id);
}
