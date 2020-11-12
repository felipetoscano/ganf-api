package br.com.fiap.ganf.ganfapi.controller;

import br.com.fiap.ganf.ganfapi.GanfApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = GanfApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AcaoControllerIntegrationTest {

    @Autowired
    public MockMvc mvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Test
    @DisplayName("Busca de todas as ações")
    void shouldFindAll() throws Exception {
        mvc.perform(get("/acao")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Busca de uma ação por id")
    void shouldFindById() throws Exception {
        mvc.perform(get("/acao/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{" +
                        "\"idAcao\":1," +
                        "\"nome\":\"Andar\"," +
                        "\"descricao\":\"Robo comecara a andar\"," +
                        "\"ativo\":true" +
                        "}"));
    }
    
    @Test
	@DisplayName("Deve salvar uma ação, retornar status 201 e Location no Header")
	public void shouldSaveAction() throws Exception {
		
		mvc.perform(post("/acao")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{"
					+ "\"nome\":\"pular\","
					+ "\"descricao\":\"o robô da um pulo\","
					+ "\"ativo\":true"
					+ "}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
	
	@Test
	@DisplayName("Deve atualizar uma ação pelo id e retornar status 200")
	public void shouldUpdateAction() throws Exception {
		
		mvc.perform(put("/acao/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"
						+ "\"nome\":\"pular\","
						+ "\"descricao\":\"o robô da um pulo\","
						+ "\"ativo\":false"
						+ "}"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve deletar uma ação pelo id e retornar status 204")
	public void shouldDeleteActionById() throws Exception {
		
		mvc.perform(delete("/acao/6")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	
	@Test
	@DisplayName("Não deve deletar uma ação associada a uma execução e retornar status 500")
	public void shouldNotDeleteCategoryByIdWithConstraints() throws Exception {
		
		mvc.perform(delete("/acao/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}
}
