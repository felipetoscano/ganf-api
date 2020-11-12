package br.com.fiap.ganf.ganfapi.controller;

import br.com.fiap.ganf.ganfapi.model.AcaoModel;
import br.com.fiap.ganf.ganfapi.repository.AcaoRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/acao")
public class AcaoController {

    @Autowired
    public AcaoRepository acaoRepository;

    @GetMapping()
    @ApiOperation(value = "Retorna uma lista de ações")
    public ResponseEntity<List<AcaoModel>> findAll(){
        List<AcaoModel> acoes = acaoRepository.findAll();
        return ResponseEntity.ok(acoes);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma ação por id")
    public ResponseEntity<AcaoModel> findById(@PathVariable("id") int id){
        AcaoModel acao = acaoRepository.findById(id).get();
        return ResponseEntity.ok(acao);
    }

    @PostMapping()
    @ApiOperation(value = "Salva um novo registro de ação")
    public ResponseEntity save(@RequestBody @Valid AcaoModel acaoModel){
        acaoRepository.save(acaoModel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(acaoModel.getIdAcao())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Altera uma ação pelo seu Id")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody @Valid AcaoModel acaoModel){
        acaoModel.setIdAcao(id);
        acaoRepository.save(acaoModel);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta uma ação pelo seu id")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        acaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
