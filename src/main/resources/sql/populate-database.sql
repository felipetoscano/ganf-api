insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Andar', 'Robo comecara a andar', 1);
insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Correr', 'Robo comecara a correr', 1);
insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Pular', 'Robo comecara a pular', 1);
insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Sentar', 'Robo ira sentar', 1);
insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Deitar', 'Robo ira deitar', 0);
insert into tb_acao (id_acao, nome, descricao, ativo) values (acao_seq.nextval, 'Falar', 'Robo ira falar', 0);

insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('01/01/2001 10:00:00', 'dd/mm/yyyy hh24:mi:ss')), 1);
insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('02/01/2001 10:00:00', 'dd/mm/yyyy hh24:mi:ss')), 2);
insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('03/01/2001 10:00:00', 'dd/mm/yyyy hh24:mi:ss')), 3);
insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('04/01/2001 10:00:00', 'dd/mm/yyyy hh24:mi:ss')), 4);
insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('05/01/2001 10:00:00', 'dd/mm/yyyy hh24:mi:ss')), 5);
insert into tb_execucao (id_execucao, data_execucao, id_acao) values (execucao_seq.nextval, (TO_DATE('05/01/2001 10:01:00', 'dd/mm/yyyy hh24:mi:ss')), 5);