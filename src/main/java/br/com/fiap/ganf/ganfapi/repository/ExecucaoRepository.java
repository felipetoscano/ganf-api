package br.com.fiap.ganf.ganfapi.repository;

import br.com.fiap.ganf.ganfapi.model.ExecucaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecucaoRepository extends JpaRepository<ExecucaoModel, Integer> {
}
