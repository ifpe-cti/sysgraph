# Gráfica SB
Prática Profissional Orientada (PPO) em desenvolvimento por Pedro Barros, Matheus Dionísio e Vinícius Henrique.
Aplicação desenvolvida afim de gerenciar e facilitar vendas na gráfica SB, do município de Iati-PE.

## Como contribuir?

  Siga os seguintes passos:

  1. Faça um fork do projeto (basta clicar no botão de fork do GitHub)
  2. Clone o seu fork deste projeto (`$ git clone https://github.com/seu-login/grafica.git`)
  3. Abra uma issue (no projeto original) descrendo do que se trata a sua contribuição
  4. Pegue o ID (código) da issue que você abriu e crie um branch na sua máquina com este código (`$ git checkout -b ID`)
  5. Realize as mudanças que você deseja fazer
  6. Faça os commits dessas mudanças
  7. Verifique se não há conflitos entre o seu branch local com o branch master upstream (o código original) (`$ git fetch upstream` e `$ git rebase upstream/master`)
  8. Verifique se o código está compilando e passando nos testes (`$ mvn clean package`)
  9. Envie o branch modificado para o seu repositório (`$ git push origin ID`)
  10. No GitHub, vá ao site do projeto original, e abra um Pull Request (PR). No comentário do PR, faça a referência a issue aberta (Escreva "Conforme a issue #ID" (sem as aspas))

  Para sincronizar as bases, siga os seguintes passos:

  1. Adicione (apenas uma vez) o repositório original na lista de seus repositórios remotos (`$ git remote add upstream https://github.com/ifpe-cti/grafica.git`)
  2. Baixe o código do repositório original (`$ git fetch upstream`)
  3. Vá para o branch que você quer sincronizar (`$ git checkout master`)
  4. Faça um rebase do repositório original com o seu (`$ git rebase upstream/master`)
  5. Sincronize o seu repositório remoto com o seu local (`$ git push origin master`)


## Executando

  Para executar a aplicação, primeiro utilize o maven para construir a aplicação:
  ```bash
  $ ./mvnw clean package
  ```

  Depois de construido, utilize o `jar` que se encontra no diretório `target`, assim:
  ```bash
  $ java -jar target/grafica-1.0-SNAPSHOT.jar
  ```

## Documentação

  A documentação do sistema é composta do arquivo README.md (este arquivo) e dos diagramas UML que são gerados pelo [PlantUML](http://plantuml.com) que estão armazenados na pasta `docs/uml`. Caso precise gerar a documentação, deverá utilizar o seguinte comando:  
  ```
  $ ./mvnw clean package -Pdocs
  ```

### Diagrama de Classes
  Em produção


## Convenções

  - Utilizar notação camelCase
  - Nome do método no infinitivo e em português
  - Constantes com MAIÚSCULO
  - Cobertura de 80% de testes
  - Utilizar Hibernate
  - Utilizar PrimeFaces 
  - Utilizar Maven + Git
  - Utilizar MySQL
  - Utilizar NetBeans
  - Utilizar o padrão DAO
  - Utilizar o padrão MVC


## Contribuidores

  - [@viniciussoaresti](https://github.com/viniciussoaresti) como Vinícius Henrique
  - [@MatheusDias18](https://github.com/MatheusDias18) como Matheus Dionísio

## Licença

Licença padrão do MIT.
