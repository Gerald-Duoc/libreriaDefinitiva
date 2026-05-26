package tienda_web.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda_web.libreria.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
