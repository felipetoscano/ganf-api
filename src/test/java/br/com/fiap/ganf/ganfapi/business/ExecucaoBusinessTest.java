package br.com.fiap.ganf.ganfapi.business;

import br.com.fiap.ganf.ganfapi.exception.ResponseBusinessException;
import br.com.fiap.ganf.ganfapi.model.AcaoModel;
import br.com.fiap.ganf.ganfapi.repository.AcaoRepository;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExecucaoBusinessTest {

    @InjectMocks
    public ExecucaoBusiness execucaoBusiness;

    @Mock
    public AcaoRepository acaoRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerifyActionStatusSucess() throws ResponseBusinessException {
        int id = 1;
        AcaoModel acao = new AcaoModel(id, "Andar", "Robo comecara a andar", true);
        Mockito.when(acaoRepository.findById(id)).thenReturn(Optional.of(acao));
        execucaoBusiness.verifyActionStatus(id);
    }

    @Test(expected = ResponseBusinessException.class)
    public void testVerifyActionStatusError() throws ResponseBusinessException {
        int id = 5;
        AcaoModel acao = new AcaoModel(id, "Falar", "Robo comecara a falar", false);
        Mockito.when(acaoRepository.findById(id)).thenReturn(Optional.of(acao));
        execucaoBusiness.verifyActionStatus(id);
    }

}
