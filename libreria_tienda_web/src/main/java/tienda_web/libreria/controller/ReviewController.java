package tienda_web.libreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda_web.libreria.model.Review;
import tienda_web.libreria.service.ReviewService;

@RestController
@RequestMapping("api/v1/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public List<Review> getReviews() {
		return reviewService.getReviews();
	}

	@PostMapping
	public Review PostReview(@RequestBody Review review) {
		return reviewService.postReview(review);
	}

	@DeleteMapping("delete/{id}")
	public void deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
	}

	@PutMapping("modificar/{id}")
	public Review modificarReview(@PathVariable Long id, @RequestBody Review review) {
		return reviewService.modificarReview(id, review);
	}

}
