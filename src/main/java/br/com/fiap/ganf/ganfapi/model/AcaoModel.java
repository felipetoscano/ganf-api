package br.com.fiap.ganf.ganfapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_acao")
public class AcaoModel {

    private int idAcao;
    private String nome;
    private String descricao;
    private boolean ativo;
    private List<ExecucaoModel> execucoes;
    
    public AcaoModel(int idAcao, String nome, String descricao, boolean ativo) {
		super();
		this.idAcao = idAcao;
		this.nome = nome;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public AcaoModel(){

    }

    @Id
    @Column(name = "id_acao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acao_seq")
    @SequenceGenerator(name = "acao_seq", sequenceName = "acao_seq", allocationSize = 1)
    @ApiModelProperty(value = "Id da ação")
    public int getIdAcao() {
        return idAcao;
    }

    public void setIdAcao(int idAcao) {
        this.idAcao = idAcao;
    }

    @Size(min = 1, max = 40, message = "O tamanho deve ser de no máximo 40 caracteres e mínimo de 1")
    @Column(name = "nome")
    @ApiModelProperty(value = "Nome da ação")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Size(min = 1, max = 100, message = "O tamanho deve ser de no máximo 100 caracteres e mínimo de 1")
    @Column(name = "descricao")
    @ApiModelProperty(value = "Descrição da ação")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "ativo")
    @ApiModelProperty(value = "Flag de verificação se o a ação está ativa ou não")
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "acao")
    public List<ExecucaoModel> getExecucoes() {
        return execucoes;
    }

    public void setExecucoes(List<ExecucaoModel> execucoes) {
        this.execucoes = execucoes;
    }
}
