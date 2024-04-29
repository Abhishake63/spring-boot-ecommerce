package com.springboot.ecommerce.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.ecommerce.orderitem.OrderItem;
import com.springboot.ecommerce.wishlist.Wishlist;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    @Column(nullable = false)
    private BigDecimal price;

    @NonNull
    @Column(nullable = false)
    private Integer stockQuantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Wishlist> wishlist;
}
