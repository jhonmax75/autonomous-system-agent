# Autonomous System Agent

Sistema local orientado por IA para planejamento, execução controlada e automação auditável.

## Visão Geral

O **Autonomous System Agent** é uma plataforma modular construída para executar tarefas locais de forma segura, rastreável e governada.

O modelo de IA participa apenas do **planejamento e interpretação**.

A execução permanece sob controle do ambiente local.

Princípio central:

```text
MODELO → PLANEJA
POLICY → VALIDA
EXECUTOR → EXECUTA
HUMANO → APROVA
AUDITOR → REGISTRA
```

---

## Objetivos

O sistema foi projetado para:

* navegar por diretórios autorizados;
* interpretar contexto de arquivos;
* gerar planos estruturados;
* executar ferramentas locais;
* aplicar governança operacional;
* manter rastreabilidade completa;
* operar em ambiente isolado.

---

# Arquitetura

```text
Usuário
   ↓

Planner (IA)
   ↓

Plan
   ↓

Policy Engine
   ↓

Executor
   ↓

Tool
   ↓

Audit
```

Regra fundamental:

```text
IA NÃO EXECUTA

IA → PLANO → VALIDAÇÃO → EXECUÇÃO
```

---

# Estrutura do Projeto

```text
autonomous-system-agent/

apps/
└── agent-cli

modules/
├── audit
├── context
├── executor
├── planner
├── policy
├── providers
├── runtime
├── sandbox
├── shared
└── tools

storage/
├── cache
├── logs
└── state

config/
scripts/
```

---

# Responsabilidades dos Módulos

## shared

Kernel conceitual do sistema.

Contém:

* contratos;
* modelos;
* tipos;
* exceções.

Exemplos:

```text
contracts/
models/
types/
exceptions/
```

---

## runtime

Camada de orquestração.

Responsável por conectar:

```text
Planner
↓
Policy
↓
Executor
↓
Audit
```

Não contém lógica de negócio.

---

## planner

Interpreta objetivos e produz planos.

Entrada:

```text
"refatorar imports"
```

Saída:

```json
{
  "goal":"refatorar imports",
  "steps":[]
}
```

---

## policy

Motor de governança.

Classificação prevista:

* LOW
* MEDIUM
* HIGH
* CRITICAL

---

## executor

Executa apenas operações aprovadas.

Nunca:

```text
shell irrestrito
sobrescrita direta
```

---

## audit

Responsável por rastreabilidade.

Eventos previstos:

```text
timestamp
ação
resultado
hash
rollback_id
```

---

## sandbox

Ambiente isolado.

Restrições previstas:

* sem root;
* sem acesso global;
* rede controlada.

---

# Estado Atual

## Concluído

* Estrutura multi-module
* Gradle configurado
* Módulo shared validado
* Organização de domínio
* Pipeline de build funcional

---

## Em andamento

* Runtime
* Orquestração inicial
* Integração CLI

---

## Planejado

* Ferramentas locais
* Executor controlado
* Auditoria persistente
* Recuperação e rollback

---

# Build

Compilar projeto:

```bash
./gradlew build
```

Compilar apenas shared:

```bash
./gradlew :modules:shared:build
```

---

# Roadmap

Fase 1 — Infraestrutura ✅

Fase 2 — Kernel Compartilhado 🔄

Fase 3 — Runtime

Fase 4 — Planejamento por IA

Fase 5 — Segurança

Fase 6 — Observabilidade

Fase 7 — Escala

---

# Filosofia

O objetivo não é construir um executor irrestrito.

O objetivo é construir um:

**Agente operacional controlado, auditável e reversível.**

---

Licença:

Definir posteriormente.
