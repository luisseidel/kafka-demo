# KAFKA DEMO PROJECT

Objetivo: 
* Publicar no Kafka, tweets recebidos por meio de uma requisição POST. 
* Após, consumir esses tweets, para realizar uma análise de sentimento das palavras contidas nas mensagens.
* A análise dos sentimentos é feita por meio de uma comparação das palavras de cada mensagem, com uma lista pré-definida, conforme segue:
```java
private static final Set<String> positivos = new HashSet<>(Arrays.asList("bom", "excelente", "ótimo", "otimo", "ok"));
private static final Set<String> negativos = new HashSet<>(Arrays.asList("ruim", "péssimo", "pessimo", "horrível", "horrivel"));
```
* A cada tweet enviado e consumido é feita análise e um log é mostrado no terminal, com as estatísticas:
* Exemplo:
```json
{
    "text": "este evento, estava horrivel, mas com qualidade ok"
}
```
* No exemplo acima, há duas palavras das listas positivas e negativas, logo, o tweet conta como ambos: 
```text
Tweets Capturados: 1, Tweets Positivos: 1, Tweets Negativos: 1
```

## Get Started

### 1. Instale o Maven
```shell
sudo apt install maven
```
### 2. Instale o SDKMAN
Obs: SDKMAN é um gestor de diversas versões de Software Development Kit, entre elas o Java.
```shell
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
### 3. No terminal, navegue até a pasta do projeto e instale o Java 17, com o SDKMAN 
```shell
sdk env init
```

## Run the project

### 1. Abra dois terminais, no primeiro, navegue até a pasta kafka-container
```shell
cd ./kafka-container
```

### 2. No segundo terminal, abra a pasta raiz do projeto e execute:
```shell
./mvnw spring-boot:run
```


## Testing

### 1. Para enviar uma mensagem ao tópico, realize uma requisição post ao enpoint `/kafka/send`:
```shell
curl -X POST https://localhost:8080/kafka/send -H 'Content-Type: application/json' -d '{"text": "este evento é bom"}'
curl -X POST https://localhost:8080/kafka/send -H 'Content-Type: application/json' -d '{"text": "este evento é ruim"}'
```