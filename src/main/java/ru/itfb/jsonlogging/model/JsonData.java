package ru.itfb.jsonlogging.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "json_data")
public class JsonData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;
    @Column(name = "uuid", nullable = false, unique = true)
    private UUID uuid;
    @Lob
    @Column(name = "json_data")
    private String jsonData;



}