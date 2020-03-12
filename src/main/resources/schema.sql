CREATE TABLE rate (
  moneda_origen  VARCHAR(3) NOT NULL,       
  moneda_destino VARCHAR(3) NOT NULL,
  tipo_cambio   DECIMAL NOT NULL,
  PRIMARY KEY(moneda_origen, moneda_destino));