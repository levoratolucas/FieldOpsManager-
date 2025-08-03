# Preparação do Ambiente para Projeto Java com Hibernate

## Requisitos do Projeto

- Linguagem: Java  
- ORM: Hibernate  
- Banco de dados: PostgreSQL (relacional) e MongoDB (não relacional — uso futuro)  
- IDE recomendada: IntelliJ IDEA (ou Eclipse/VSCode)  
- Gerenciador de dependências: Maven  

---

## Instalações Necessárias

### 1. Instalar Java JDK 17+

1. Acesse: https://jdk.java.net  
2. Baixe o JDK 17 (ou superior)  
3. Instale e configure a variável de ambiente `JAVA_HOME`  
4. Verifique a instalação com o comando no terminal:

```bash
java -version
```

### 2. Instalar PostgreSQL

1. Acesse: https://www.postgresql.org/download/  
2. Instale o PostgreSQL e anote:  
   - Usuário: `postgres`  
   - Senha definida durante a instalação  
3. Instale também o **pgAdmin** (interface gráfica para o PostgreSQL)

### 3. Instalar Maven

1. Verifique se já está instalado com:

```bash
mvn -v
```

2. Se não estiver instalado:  
   - Acesse: https://maven.apache.org/download.cgi  
   - Baixe e extraia o Maven  
   - Configure a variável de ambiente `MAVEN_HOME` e adicione ao `PATH`

### 4. Instalar IntelliJ IDEA

1. Acesse: https://www.jetbrains.com/idea/  
2. Baixe a versão **Community** (gratuita)  
3. Após instalar:  
   - Crie um novo projeto Java  
   - Selecione Maven como gerenciador de dependências  
   - Escolha o JDK instalado

---

## Criar Estrutura Inicial do Projeto

1. Crie um novo projeto Maven no IntelliJ com a seguinte estrutura:

```
src/
 └── main/
     ├── java/
     │    └── com.seuprojeto
     └── resources/
```

2. No arquivo `pom.xml`, adicione as dependências básicas:

```xml
<dependencies>
  <!-- Hibernate Core -->
  <dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.15.Final</version>
  </dependency>

  <!-- PostgreSQL Driver -->
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.3.1</version>
  </dependency>

  <!-- JPA API -->
  <dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>2.2.3</version>
  </dependency>
</dependencies>
```

---

## Testar Configuração

1. Crie uma classe Java simples:

```java
public class TesteAmbiente {
    public static void main(String[] args) {
        System.out.println("Ambiente OK!");
    }
}
```

2. Execute o programa.  
3. Se a mensagem aparecer, seu ambiente está pronto para iniciar o desenvolvimento com Hibernate.

---
