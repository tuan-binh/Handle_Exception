package ra.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.ProductRequest;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@PostMapping
	public ResponseEntity<?> addProduct(@Valid @ModelAttribute ProductRequest productRequest)
	{
		System.out.println(productRequest.getImage().getSize() > 0);
		return ResponseEntity.ok().body("Add successfully");
	}
	
}
