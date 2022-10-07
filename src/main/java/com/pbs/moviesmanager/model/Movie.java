package com.pbs.moviesmanager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "MOVIE")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ID_MOVIE")
  @SequenceGenerator(name = "SEQ_ID_MOVIE", sequenceName = "SEQ_ID_MOVIE")
  private Long id;

  @Column(name = "NAME", length = 50, nullable = false)
  private String name;

  @Column(name = "YEAR", length = 50, nullable = false)
  private String year;

  @Column(name = "DIRECTOR", length = 50)
  private String director;

  @Lob
  @Column(name = "COVER", length = Integer.MAX_VALUE)
  private byte[] cover;
}
