-- Acessar o sistema com o usuário postgres (é necessario alterar a senha com o comando passwd).
-- Criar estrutura de diretórios para um tablespace... no meu caso foi criado /ps01/jano.
-- Cria o table space e define o tablespace para o banco.
createdb jano
/
createdb teste
/
psql teste
/
create tablespace JANO location '/ps01/jano';
/
alter database jano set tablespace JANO;
/
\q
/
-- Foi definido o tablespace JANO para o db jano. Foi criado um banco com o nome de teste para alterar o tablespace do banco jano pois não é perimitido alterar o tablespace do banco recorrente. Após este procedimento pode ser excluído o banco teste.
-- Agora vamos criar um usuário para o banco de dados e após isso um schema. Depois vamos definir as permissões para o usuário e aí poderemos conectar pela IDE de banco de dados. No meu caso uso o aqua.
create user usuario with password 'password';
/
alter database jano owner to usuario;
/
create schema jano authorization usuario;
/
drop database teste;
/

