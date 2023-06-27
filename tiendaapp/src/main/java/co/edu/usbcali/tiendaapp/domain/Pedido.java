package co.edu.usbcali.tiendaapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "clie_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "espe_id")
    private EstadoPedido estadoPedido;


    @Column(nullable=false)
    private Date fecha;

    @Column(nullable=false)
    private BigDecimal total;
}