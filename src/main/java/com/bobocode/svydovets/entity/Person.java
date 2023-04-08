package com.bobocode.svydovets.entity;

import com.bobocode.svydovets.bibernate.annotation.Column;
import com.bobocode.svydovets.bibernate.annotation.Entity;
import com.bobocode.svydovets.bibernate.annotation.GeneratedValue;
import com.bobocode.svydovets.bibernate.annotation.Id;
import com.bobocode.svydovets.bibernate.annotation.JoinColumn;
import com.bobocode.svydovets.bibernate.annotation.OneToMany;
import com.bobocode.svydovets.bibernate.annotation.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "notes")
@Table("persons")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column
    private String team;

    @OneToMany
    private List<Note> notes = new ArrayList<>();
}
