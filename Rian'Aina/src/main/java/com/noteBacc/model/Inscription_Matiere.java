package com.noteBacc.model;


import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Inscription_Matiere {
    private int id_eleves;
    private int id_matiere;
    private  int note;
};
