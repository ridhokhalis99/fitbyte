package com.projectsprint_solo.fitbyte.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Column(name = "image_uri")
    private String imageUri;

    @Column
    private String preference;

    @Column(name = "weight_unit")
    private String weightUnit;

    @Column(name = "height_unit")
    private String heightUnit;

    @Column
    private Integer weight;

    @Column
    private Integer height;

    @CreatedDate
    @Column(name="created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name="updated_at", nullable = false)
    private Instant updatedAt;
}
