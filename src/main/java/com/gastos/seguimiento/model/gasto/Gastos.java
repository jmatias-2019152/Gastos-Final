    package com.gastos.seguimiento.model.gasto;

    import org.springframework.data.annotation.Id;
    import org.springframework.data.mongodb.core.mapping.Document;

    import java.time.LocalDate;

    @Document(collection = "gastos")
    public class Gastos {
        @Id
        private String id;
        private String descripcion;
        private Double monto;
        private String categoria;
        private LocalDate fecha;

        public Gastos() {
        }

        public Gastos(String id, String descripcion, Double monto, String categoria, LocalDate fecha) {
            this.id = id;
            this.descripcion = descripcion;
            this.monto = monto;
            this.categoria = categoria;
            this.fecha = fecha;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Double getMonto() {
            return monto;
        }

        public void setMonto(Double monto) {
            this.monto = monto;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }
    }