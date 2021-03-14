# Primes number generator

### Pequeno web-app desenvolvido para o desafio do processo seletivo do [Laboratório Bridge](https://bridge.ufsc.br/).
#### O objetivo do desafio era desenvolver um web-app completo que recebesse dois números e retornasse todos os números primos entre eles.

---

O backend do aplicativo foi desenvolvido em Java 15 com [Spring Boot](https://spring.io/projects/spring-boot), usando MySQL como gerenciador de banco de dados.  
O primeiro passo foi aproveitar da ferramenta [spring initializr](https://start.spring.io/) que facilitou a criação de um projeto maven com as dependências necessárias para o mesmo. 
Para isso, bastou entar no site, selecionar as opções:
* Maven
* Java
* Versão 15 do Java
* Versão 2.4.3 do Spring Boot
* Empacotamento em JAR
* Dependências Spring Web, JPA e MySQL Driver  

e realizar o download.  

Depois de importado e configurado o projeto maven recebido do Spring Initializr no Eclipse (IDE escolhida), separei o desenvolvimento em 5 frentes:

* Controller (PrimeController.java)
  * Classe responsável pela ligação dos requisitos CRUD do BD às URLs que são usadas pelo frontend pra acesso, assim possibilitando a criação da API
* DTO (PrimeDTO.java)
  * Classe que faz a conversão de dados para um objeto Java (DTO -> Data To Object)
* Entity (Prime.java)
  * Classe de declaração do objeto Prime, objeto central desse web-app
* Repository (PrimeRepository.java)
  * Classe de acesso ao BD
* Utils (PrimeUtils.java)
  * Classe responsável pelas funções auxiliares do projeto. O cálculo dos números primos é feito nessa classe.

---

O frontend foi feito utilizando [angular](https://angular.io/) e [ionic](https://ionicframework.com/).  
Para facilitar o desenvolvimento, a página foco do web-app é a própria home, que contém a parte de envio pelo usuário dos números, escolha de um range já criado e apresentação dos números primos contidos no range.

Foi necessária a importação do cliente Http do angular para a comunicaçao com o backend.  

---

# Rodando o projeto localmente
### Você vai precisar de:
* Java 15
* [Node 14](https://nodejs.org/en/)
* [Angular 11](https://angular.io/guide/setup-local)
* [Ionic 5](https://ionicframework.com/docs/intro/cli)
* [MySQL Workbench](https://www.mysql.com/downloads/)
* IDEs
  * Recomendado [Eclipse](https://www.eclipse.org/) (para o backend) e [Visual Studio Code](https://code.visualstudio.com/) (para o frontend)
  
Em primeiro lugar, você terá que saber se vai rodar o backend usando o .jar disponibilizado (e nesse caso fazer a criação do banco de dados como será especificado aqui) ou se vai roda-lo direto pela IDE, assim podendo alterar as informações de acesso ao BD.
Caso você opte por rodar o .jar, deverá criar um server com o nome "bridgeSelective" pelo MySQL Workbench com as credenciais "root" e "root".
Caso opte por rodar pela IDE com o seu server, não esqueça de alterar essas informações no arquivo *application.properties*

Após o passo anterior, já é possível colocar as coisas para funcionar.  

### Rodando o backend
Para o backend, se desejar usar o .jar, baixe-o e rode pelo terminal. Vá até o local do arquivo e rode

```console
java -jar backend-0.0.1-SNAPSHOT.jar
```  
Se desejar rodar pela sua IDE, rode como *Java Application*.  

<b> O backend estará acessível no localhost na porta 8080 </b>

### Rodando o frontend  
Para rodar o frontend, acesse pelo terminal a pasta */frontend/primes* e rode o aplicativo com
```console
ionic serve
```  
Espere o comando abrir uma página no seu navegador padrão e você já se encontrará na página do aplicativo.  
<b> O Frontend estará acessível no localhost na porta 8100 </b>
