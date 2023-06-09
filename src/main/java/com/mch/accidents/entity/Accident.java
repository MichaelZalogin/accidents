package com.mch.accidents.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Accident {

    private int id;

    private String name;

    private String text;

    private String address;

    private AccidentType type;

}