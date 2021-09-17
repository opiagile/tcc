alter table usuario drop column nome
/
alter table pessoa drop column dataemissao
/
alter table pessoa drop column idempersa
/

--- inserts
alter table usuario drop column nome
insert into endereco values(1, 1, 123, null)
insert into contato values(1, '33333333', '99999999', 'admin@dominio.com.br')
insert into pessoa values(1, 'Admin', '21/11/1985', 1, 1, '000000', 'SSP/PR', null, null, now(), '1234', now(), null)

insert into usuario values(1,'admin', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', 1)
select * from USUARIOPERMISSAO
INSERT INTO USUARIOPERMISSAO VALUES(1,1)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,2)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,3)
/
insert into usuariopermissao values(1, 4)
/
insert into usuariopermissao values(1, 5)
/
INSERT INTO USUARIOPERMISSAO VALUES(1,1000)
/