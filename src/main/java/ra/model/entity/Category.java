package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @NotBlank(message = "id không được để trống")
    private String categoryId;
    @NotBlank(message = "name không được để trống")
    private String categoryName;
    @NotNull(message = "status không được để trống")
    private Boolean categoryStatus;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> productList;
}
