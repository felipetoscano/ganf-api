package br.com.fiap.ganf.ganfapi.controller;

import br.com.fiap.ganf.ganfapi.business.ExecucaoBusiness;
import br.com.fiap.ganf.ganfapi.exception.ResponseBusinessException;
import br.com.fiap.ganf.ganfapi.model.ExecucaoModel;
import br.com.fiap.ganf.ganfapi.repository.ExecucaoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/execucao")
public class ExecucaoController {

    @Autowired
    public ExecucaoRepository execucaoRepository;

    @Autowired
    public ExecucaoBusiness execucaoBusiness;

    @GetMapping()
    @ApiOperation(value = "Retorna uma lista de execuções")
    public ResponseEntity<List<ExecucaoModel>> findAll(){
        List<ExecucaoModel> execucoes = execucaoRepository.findAll();
        return ResponseEntity.ok(execucoes);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma execução por id")
    public ResponseEntity<ExecucaoModel> findById(@PathVariable("id") int id){
        ExecucaoModel execucao = execucaoRepository.findById(id).get();
        return ResponseEntity.ok(execucao);
    }

    @PostMapping()
    @ApiOperation(value = "Salva um novo registro de execução")
    public ResponseEntity save(@RequestBody @Valid ExecucaoModel execucaoModel) throws ResponseBusinessException  {
        execucaoBusiness.verifyActionStatus(execucaoModel.getAcao().getIdAcao());
        execucaoRepository.save(execucaoModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(execucaoModel.getIdExecucao())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
