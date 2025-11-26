# Desafio Target

Para iniciar podemos baixar e utilizar a imagem Docker do projeto executando o seguinte comando:

```bash
docker pull miqueiasr/desafio-target
```

Após baixar a imagem, você pode executá-la com:

```bash
docker run -p 8075:8075 miqueiasr/desafio-target
```

A API ficará disponível na porta **8075**, conforme descrito abaixo.


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