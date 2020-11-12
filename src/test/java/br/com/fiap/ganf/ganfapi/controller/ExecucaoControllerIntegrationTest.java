package br.com.fiap.ganf.ganfapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.ganf.ganfapi.GanfApiApplication;

@SpringBootTest(classes = GanfApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ExecucaoControllerIntegrationTest {
	
	@Autowired
    public MockMvc mvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Test
    @DisplayName("Busca de todas as execuções")
    void shouldFindAll() throws Exception {
        mvc.perform(get("/execucao")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Busca de uma execução por id")
    void shouldFindById() throws Exception {
        mvc.perform(get("/execucao/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{"
                		+ "\"idExecucao\":1,"
                		+ "\"acao\":{"
                		+ "\"idAcao\":1,"
                		+ "\"nome\":\"Andar\","
                		+ "\"descricao\":\"Robo comecara a andar\","
                		+ "\"ativo\":true"
                		+ "},"
                		+ "\"dataExecucao\":\"2001-01-01T12:00:00.000+0000\""
                		+ "}"));
    }
    
    @Test
	@DisplayName("Deve salvar uma execução, retornar status 201 e Location no Header")
	public void shouldSaveAction() throws Exception {
		
		mvc.perform(post("/execucao")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{"
            		+ "\"acao\":{"
            		+ "\"idAcao\":1,"
            		+ "\"nome\":\"Andar\","
            		+ "\"descricao\":\"Robo comecara a andar\","
            		+ "\"ativo\":true"
            		+ "},"
            		+ "\"dataExecucao\":\"2001-01-03T12:00:00.000+0000\""
            		+ "}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
}
