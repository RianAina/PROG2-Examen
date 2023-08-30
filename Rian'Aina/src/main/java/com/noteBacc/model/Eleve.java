package com.noteBacc.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Eleve {
    private int id;
    private String first_name;
    private String last_name;
    private String serie;
}
