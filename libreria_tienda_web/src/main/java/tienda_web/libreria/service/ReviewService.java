package tienda_web.libreria.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda_web.libreria.model.Review;
import tienda_web.libreria.repository.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public List<Review> getReviews() {
		return reviewRepository.findAll();
	}

	public Review postReview(Review review) {
		review.setFecha(new Date());
		return reviewRepository.save(review);
	}

	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);
	}

	public Review modificarReview(Long id, Review review) {
		Review reviewCambiar = reviewRepository.findById(id).orElse(null);
		if (reviewCambiar != null) {
			reviewCambiar.setComentario(review.getComentario());
			reviewCambiar.setCalificacion(review.getCalificacion());
			reviewCambiar.setFecha(review.getFecha());
		}
		return null;
	}

}
