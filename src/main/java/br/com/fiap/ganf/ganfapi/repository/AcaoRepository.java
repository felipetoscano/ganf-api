package br.com.fiap.ganf.ganfapi.repository;

import br.com.fiap.ganf.ganfapi.model.AcaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcaoRepository extends JpaRepository<AcaoModel, Integer> {
}
