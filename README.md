# Desafio Target

API executando na porta **8075**.
Base URL: `http://localhost:8075/api`

## Atividade 1

### **GET /atividade1/buscar-comissoes**
**URL:** `http://localhost:8075/api/atividade1/buscar-comissoes`

## Atividade 2

### **POST /atividade2/movimentar-estoque**
**URL:** `http://localhost:8075/api/atividade2/movimentar-estoque`
**RequestBody esperado:**
```
{
  "codigoProduto": "101",
  "quantidade": 10,
  "tipoMovimentacao": "ENTRADA"
}
```
ou
```
{
  "codigoProduto": "101",
  "quantidade": 10,
  "tipoMovimentacao": "SAIDA"
}
```

## Atividade 3

### **GET /atividade3/valor-corrigido**
**URL:** `http://localhost:8075/api/atividade3/valor-corrigido?valor=100&dataVencimento=2025-01-10`