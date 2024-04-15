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
curl --request POST \
  --url http://localhost:8080/phone-call/categorize \
  --header 'Content-Type: text/plain; charset=utf-8' \
  --data 'Bom dia, meu nome é Fulano. Não estou conseguindo acessar o app do meu banco. Quando tento entrar aparece a mensagem "senha inválida". Também quero saber como conseguir um empréstimo.'
```

Você deverá receber uma resposta no seguinte formato:

```json
{
  "title": "Problemas de acesso ao aplicativo e solicitação de empréstimo",
  "category": [
    "Acesso ao aplicativo",
    "Senha inválida",
    "Empréstimo"
  ]
}
```
