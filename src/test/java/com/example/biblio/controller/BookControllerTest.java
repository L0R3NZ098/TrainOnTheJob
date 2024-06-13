package com.example.biblio.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.biblio.enums.StateEnum;
import com.example.biblio.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles(value = "Test")
public class BookControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper obj;

	@Test
	@Order(1)
	public void createBook() throws Exception {

		// Mock del libro
		Book mockBook = new Book(null, "TitoloProva", "AutoreProva", 2000, StateEnum.DISPONIBILE, null);

		// Richiesta Post
		mvc.perform(MockMvcRequestBuilders.post("/book/create").contentType(MediaType.APPLICATION_JSON)
				.content(obj.writeValueAsString(mockBook))).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	@Order(2)
	public void getById() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/book/getbyid/{id}", 1).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

	}

	@Test
	@Order(3)
	public void getAll() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/book/getall").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.[*]").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty()).andReturn();

	}

	@Test
	@Order(4)
	public void updateBook() throws Exception {

		Book mockBook = new Book(null, "TitoloProva", "AutoreProva", 2000, StateEnum.DISPONIBILE, null);

		mockBook.setTitolo("TitoloAggiornato");
		mockBook.setAutore("AutoreAggiornato");
		mockBook.setAge(2010);
		mockBook.setStato(StateEnum.PRESTATO);

		mvc.perform(MockMvcRequestBuilders.put("/book/update/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(obj.writeValueAsString(mockBook))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(5)
	public void deleteBook() throws Exception {
		
	    mvc.perform(MockMvcRequestBuilders.delete("/book/delete/{id}", 1))
	            .andExpect(MockMvcResultMatchers.status().isOk());
	    
	}

}