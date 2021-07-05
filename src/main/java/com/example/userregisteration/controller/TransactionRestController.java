package com.example.userregisteration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.example.userregisteration.model.Response;
import com.example.userregisteration.repository.util.InputValidator;
import com.example.userregisteration.repository.util.TransactionUtil;
import com.example.userregisteration.service.TransactionService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class TransactionRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRestController.class);

	private static final String INVALID_TRANSACTION = "Account information is invalid .";

	private final TransactionService transactionService;

	@Autowired
	public TransactionRestController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping(value = "/transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> makeTransfer(@Valid @RequestBody TransactionUtil transactionUtil) {
		if (InputValidator.isSearchTransactionValid(transactionUtil)) {
			Response makeTransfer = transactionService.makeTransfer(transactionUtil);
			return new ResponseEntity<>(makeTransfer, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(INVALID_TRANSACTION, HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}