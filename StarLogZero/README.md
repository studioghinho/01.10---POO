# StarLog-Zero — solução da atividade de POO

Projeto Java organizado nos pacotes exigidos pelo enunciado:

- `br.com.starlog.model`: `Carga`, `ModuloCarga` e `BaseLancamento`.
- `br.com.starlog.exception`: `CapacidadeExcedidaException`.
- `br.com.starlog.main`: `MainResgate`, com os quatro ataques do Chaos Monkey.

## Compilação e execução — comandos do enunciado

Execute os comandos a partir da pasta raiz `StarLogZero`:

```bash
javac src/br/com/starlog/model/*.java src/br/com/starlog/exception/*.java src/br/com/starlog/main/*.java
java -cp src br.com.starlog.main.MainResgate
```

A saída esperada contém quatro linhas de sucesso (os ataques 1 a 4). O quarto ataque deve calcular `R$ 100.0`.

## Diagrama no StarUML

O enunciado determina que a arquitetura seja desenhada no StarUML antes da codificação. O arquivo `diagrama/arquitetura-starlog.puml` é uma referência textual das classes, atributos, operações e relacionamentos. Para cumprir literalmente a etapa do professor, crie no StarUML um Class Diagram com:

1. `Carga`, `ModuloCarga` e `BaseLancamento` no pacote `br.com.starlog.model`.
2. `CapacidadeExcedidaException` no pacote `br.com.starlog.exception`, com generalização para `java.lang.Exception`.
3. `MainResgate` no pacote `br.com.starlog.main`.
4. Composição de `ModuloCarga` para `Carga` (um módulo contém zero ou muitas cargas) e agregação de `BaseLancamento` para `ModuloCarga` (uma base gerencia zero ou muitos módulos).
5. Dependências de `MainResgate` para as classes usadas nos testes e de `ModuloCarga` para `CapacidadeExcedidaException`.

## Observações de implementação

- `Carga.codigoRastreio` é `final` e não possui setter.
- `equals` e `hashCode` consideram somente `codigoRastreio`.
- `CapacidadeExcedidaException` herda diretamente de `Exception`.
- Os três métodos analíticos de `ModuloCarga` usam Streams API, sem `for` ou `if`.
- O enunciado não exige comentário com RA e nome; por isso, os dados de identificação não foram acrescentados ao código como requisito inexistente.
