# DesafioTexoIt

## pré requisitos
* java 8 
* node 8
* H2 (DataBase)
* maven


## Como executar
* clone o repositórios a partit do comando `git clone https://github.com/bernardoXavier/DesafioTexoIt.git && cd DesafioTexoIt`
* acesse a pasta `cd server/src/main/resources` e substitua os dados de acesso ao banco no arquivo 
*application.properties* 

- spring.datasource.url=jdbc:mysql://localhost:3306/desafioTexoIt
- spring.datasource.username=root
- spring.datasource.password=root

* Caso seja necessário criar a dataBaseName desafioTexoIt

* após configurar o banco acesse o diretório `cd server` executar o comando `mvn spring-boot:run` para iniciar a aplicação.
* Acessar o endereço *http://localhost:8080* caso desejar confirmar se inseriu os registros

* Para executar chamada da API inserir link: http://localhost:8080/rest/films/listOfNominees via PostMan ou afins.