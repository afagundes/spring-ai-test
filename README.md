# Spring AI Test

Exemplo baseado no tutorial: https://www.baeldung.com/spring-ai

## Requisitos

- Java 21 (17 suportado, mas precisa editar o pom.xml)
- Uma chave válida da OpenAI

## Utilização

Edite o arquivo `application.properties` e adicione sua chave da OpenAI no campo `spring.ai.openai.api-key`.

Execute no terminal:

```shell
mvn spring-boot:run
```

Abra outra janela do terminal e execute:

```shell
curl localhost:8080/phone-call/categorize
```
