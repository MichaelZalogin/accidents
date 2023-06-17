package com.mch.accidents.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String text;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "accident_type_id")
    private AccidentType type;

    @ManyToOne
    @JoinColumn(name = "accident_id")
    private Set<Rule> rules;

}