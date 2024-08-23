package ra.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exception.CustomException;
import ra.model.dto.DateResponse;

import ra.model.entity.Category;
import ra.model.service.ICategoryService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController
{
	@Autowired
	private ICategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<DateResponse> getAllCategories()
	{
		return new ResponseEntity<>
				  (new DateResponse(categoryService.findAll(), HttpStatus.OK), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<? extends DateResponse> addCategory(@Valid @RequestBody Category category)
	{
//		return new ResponseEntity<>(
//				  new DateResponse(categoryService.insert(category), HttpStatus.CREATED)
//				  , HttpStatus.CREATED
//		);
		return ResponseEntity.created(URI.create("/api/v1/categories")).body(
				  new DateResponse(categoryService.insert(category), HttpStatus.CREATED)
		);
	}
	
	/**
	 * @param categoryId String
	 * @throws CustomException handle not found exception
	 * @apiNote handle find by id
	 */
	@GetMapping("/{categoryId}")
	public ResponseEntity<? extends DateResponse> findById(@PathVariable String categoryId) throws CustomException
	{
		return ResponseEntity.ok().body(
				  new DateResponse(categoryService.findById(categoryId), HttpStatus.OK)
		);
	}
	
	
}
