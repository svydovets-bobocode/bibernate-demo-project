package com.bobocode.svydovets.entity;

import com.bobocode.svydovets.bibernate.annotation.Entity;
import com.bobocode.svydovets.bibernate.annotation.GeneratedValue;
import com.bobocode.svydovets.bibernate.annotation.Id;
import com.bobocode.svydovets.bibernate.annotation.JoinColumn;
import com.bobocode.svydovets.bibernate.annotation.ManyToOne;
import com.bobocode.svydovets.bibernate.annotation.OneToMany;
import com.bobocode.svydovets.bibernate.annotation.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table("notes")
public class Note {
    @Id
    @GeneratedValue
    private Long id;

    private String body;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
