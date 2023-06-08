package com.mch.accidents.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class AccidentType {

    private int id;

    private String name;

}