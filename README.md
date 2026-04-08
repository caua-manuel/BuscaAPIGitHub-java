# ConsultaGitHub

Aplicação Java que consulta a API pública do GitHub e exibe informações de um usuário de forma organizada no terminal.

## 📋 Funcionalidades

- Busca dados de qualquer usuário público do GitHub
- Exibe nome, bio, número de repositórios e seguidores
- Tratamento de erros customizado para usuário não encontrado e falhas de conexão

## 🗂️ Estrutura do Projeto

```
src/
├── Main.java                       # Entrada do programa e exibição dos dados
├── ConsultaGitHub.java             # Requisição HTTP e parsing do JSON
├── GitHubUsuario.java              # Modelo com os dados do usuário
└── ErroConsultaGitHubException.java # Exceção customizada
```

## ▶️ Como executar

**Pré-requisitos:** Java 11 ou superior (usa `java.net.http.HttpClient`)

```bash
# Compilar
javac src/*.java -d out/

# Executar
java -cp out/ Main
```

## 💡 Exemplo de uso

```
Digite o nome do usuário: torvalds

=== Perfil GitHub ===
Login:        torvalds
Nome:         Linus Torvalds
Bio:          N/A
Repositórios: 7
Seguidores:   245000
```

## ⚠️ Tratamento de Erros

| Situação | Comportamento |
|---|---|
| Usuário não encontrado (404) | Lança `ErroConsultaGitHubException` com mensagem clara |
| Falha de conexão | Captura `IOException` / `InterruptedException` |

## 📚 Conceitos praticados

- Requisições HTTP com `HttpClient`
- Parsing manual de JSON
- Exceções customizadas
- Separação de responsabilidades entre classes

## 🔧 Possíveis melhorias

- Usar **Gson** ou **Jackson** para parsing de JSON mais robusto
- Adicionar mais campos (localização, empresa, URL do perfil)
- Listar repositórios do usuário
