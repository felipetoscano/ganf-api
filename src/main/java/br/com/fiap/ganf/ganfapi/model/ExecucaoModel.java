package br.com.fiap.ganf.ganfapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tb_execucao")
public class ExecucaoModel {

    private int idExecucao;
    private AcaoModel acao;
    private int idAcao;
    private Date dataExecucao;

    public ExecucaoModel(AcaoModel acao, Date dataExecucao) {
        this.acao = acao;
        this.dataExecucao = dataExecucao;
    }

    public ExecucaoModel(){

    }

    @Id
    @Column(name = "id_execucao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "execucao_seq")
    @SequenceGenerator(name = "execucao_seq", sequenceName = "execucao_seq", allocationSize = 1)
    @ApiModelProperty(value = "Id da execução")
    public int getIdExecucao() {
        return idExecucao;
    }

    public void setIdExecucao(int idExecucao) {
        this.idExecucao = idExecucao;
    }

    @ManyToOne
    @JoinColumn(name = "id_acao")
    @ApiModelProperty(value = "Id da ação")
    public AcaoModel getAcao() {
        return acao;
    }

    public void setAcao(AcaoModel acao) {
        this.acao = acao;
    }

    @NotNull
    @Column(name = "data_execucao")
    @ApiModelProperty(value = "Data da execução")
    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }
}
