# transacciones-service

Microservicio de operaciones monetarias para una base bancaria. Este servicio concentra la lógica de negocio de retiros, depósitos, transferencias, pagos con tarjeta, consulta de movimientos y reversos.

## Idea del servicio

Este microservicio no existe por una sola tabla. Existe porque resuelve un área de negocio: mover dinero y dejar evidencia del movimiento.

Por eso usa tres agregados/tablas principales:

- `CUENTAS`: se consulta, valida y modifica el saldo.
- `TARJETAS`: se valida cuando el pago se hace con tarjeta.
- `MOVIMIENTOS`: se registra la evidencia contable de cada operación.

## Endpoints

```http
POST /api/v1/transacciones/retiros
POST /api/v1/transacciones/depositos
POST /api/v1/transacciones/transferencias
POST /api/v1/transacciones/pagos
GET  /api/v1/cuentas/{cuentaId}/movimientos
GET  /api/v1/cuentas/{cuentaId}/saldo/validar?monto=100
POST /api/v1/movimientos/{movimientoId}/revertir
```

Swagger:

```http
http://localhost:8095/swagger-ui.html
```

## Ejemplos de requests

### Retiro

```json
{
  "cuentaId": 1,
  "monto": 200,
  "descripcion": "Retiro en cajero"
}
```

### Depósito

```json
{
  "cuentaId": 1,
  "monto": 500,
  "descripcion": "Depósito en ventanilla"
}
```

### Transferencia

```json
{
  "cuentaOrigenId": 1,
  "cuentaDestinoId": 2,
  "monto": 300,
  "descripcion": "Pago personal"
}
```

### Pago con tarjeta

```json
{
  "numeroTarjeta": "4111111111111111",
  "monto": 150,
  "comercio": "Cafetería Central",
  "descripcion": "Consumo"
}
```

## Por qué hay varios repositories inyectados

La clase `TransaccionService` necesita consultar y modificar más de una entidad durante un mismo caso de uso.

Ejemplo: una transferencia necesita:

1. Cargar cuenta origen.
2. Cargar cuenta destino.
3. Validar estados.
4. Validar saldo.
5. Descontar saldo origen.
6. Aumentar saldo destino.
7. Registrar movimiento de salida.
8. Registrar movimiento de entrada.

Por eso el servicio inyecta `CuentaRepository`, `TarjetaRepository` y `MovimientoRepository`.

## Por qué se usa @Transactional

Las operaciones monetarias deben comportarse como una sola unidad.

Si una transferencia descuenta la cuenta origen pero falla al registrar el movimiento destino, la operación queda inconsistente. Con `@Transactional`, si algo falla, Spring hace rollback de todos los cambios realizados dentro del método.

## Base de datos

Ejecutar primero:

```sql
db/schema-oracle.sql
```

Después:

```sql
db/data-oracle.sql
```
