package br.com.fiap.ganf.ganfapi.business;

import br.com.fiap.ganf.ganfapi.exception.ResponseBusinessException;
import br.com.fiap.ganf.ganfapi.model.AcaoModel;
import br.com.fiap.ganf.ganfapi.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExecucaoBusiness {

    @Value("${rest.exception.business.invalid-action}")
    private String invalidAction;

    @Autowired
    public AcaoRepository acaoRepository;

    public void verifyActionStatus(int actionId) throws ResponseBusinessException
    {
        AcaoModel acao = acaoRepository.findById(actionId).get();
        if(!acao.getAtivo())
            throw new ResponseBusinessException(invalidAction);
    }
}
