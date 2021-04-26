# Serviço 01 (ds1)
O projeto foi criado usando a seguinte stack:
 - Golang
 - gRPC
 - pgx para conexão com base de dados Postgres
 - Postgres

# Serviço 02 (ds2)
O projeto foi criado usando a seguinte stack:

 - Maven
 - Kotlin
 - Docker
 - Javalin (microframework) para HTTP
 - gRPC para integração com serviço 01
 - Postgres
 - pgjdbc para conexão com base de dados Postgres


# Como rodar

Para executar o sistema completo é necessário estar com os seguintes recursos rodando:

- Base de dados
- Serviço 01 - Go
- Serviço 02 - Kotlin

Podemos fazer isso usando Docker Compose:

- buildar imagens:

Serviço 01:
``$ cd ds1``  
``$ ./docker-build.sh``  

Serviço 02:
``$ cd ds2``  
``$ ./build-service-02.sh``  
``$ ./docker-build.sh``

E rodar na raiz do repositório:
``$ ./run.sh``

# Como testar

Após os serviços estarem rodando você pode testar com dados que já estão na base, alterando as datas para
coincidirem com a de hoje (caso queira desconto) e então usar o script:

``$ ./tests/list-products.sh``
Caso necessário criar/consultar dados para teste pode ser feito através de conexão com a base de dados
ou resetar a base e inserir novos dados no /sql.

## Design
Pode ser utilizado alguma leitor de Plantuml para ender os arquivos .uml.

# Problemas
- Acredito que o nome dos serviços estão invertidos devido a ordem de uso.
- Os nomes das entidades estão em português e os atributos em inglês.
