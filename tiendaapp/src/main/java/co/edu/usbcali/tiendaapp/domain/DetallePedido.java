package co.edu.usbcali.tiendaapp.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detallepedido")
public class DetallePedido {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @ManyToOne
    @JoinColumn(name = "pedi_id",referencedColumnName = "id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "prod_id",referencedColumnName = "id")
    private Producto producto;

    @Column(name="cantidad",length = 19,precision = 2)
    private BigDecimal cantidad;

    @Column(name="valor",length = 19,precision = 2)
    private BigDecimal valor;

}
