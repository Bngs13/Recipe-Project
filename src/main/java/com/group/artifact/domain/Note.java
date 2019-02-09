package com.group.artifact.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data //20190101
@EqualsAndHashCode(exclude = {"recipe"})//20190101
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne//20181225, cascade is not required,if notes are deleted, recipe should not deleted
    private Recipe recipe;
    @Lob//20181225, for large columns, clob
    private String recipeNotes;

}
