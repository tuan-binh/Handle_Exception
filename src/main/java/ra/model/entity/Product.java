package ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private Double productPrice;
    private Integer productQuantity;
    private Boolean productStatus;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
