# Sistema de Simulação Bancária

Este projeto simula as operações de uma conta corrente, com foco em Programação Orientada a Objetos (POO) e lógica de negócios financeira.

### 🛠️ Estrutura do Projeto:
- **`Conta.java`**: Classe que contém os atributos (saldo, cheque especial) e métodos (sacar, depositar, pagar boleto).
- **`Caixa.java`**: Classe principal que inicia a aplicação, calcula o limite de crédito inicial e gerencia o loop do menu.

### 🌟 Diferenciais Técnicos:
- **Encapsulamento**: Uso de modificadores de acesso `private` para proteção de dados.
- **Manipulação de Datas**: Uso da API `java.time.OffsetDateTime` para simular cobranças de taxas mensais automáticas.
- **Interatividade**: Sistema de menus aninhados para uma experiência de usuário fluida via console.

### 🎮 Como rodar:
1. Certifique-se de ter os dois arquivos na mesma pasta.
2. Compile o projeto através da classe principal:
   ```bash
   javac Caixa.java Conta.java
