package co.edu.usbcali.tiendaapp.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "productos")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Categoria categoria;

    @Column(length = 10, nullable = false)
    private String referencia;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column
    private String descripcion;

    @Column(name = "precio_unitario", length = 19, precision = 2, nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "unidades_disponibles", length = 19, precision = 2, nullable = false)
    private BigDecimal unidadesDisponibles;
}
