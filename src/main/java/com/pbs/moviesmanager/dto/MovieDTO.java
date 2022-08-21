package com.pbs.moviesmanager.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MovieDTO {

  private Long id;

  @NotEmpty
  private String name;

  @NotEmpty
  private String year;

  @NotEmpty
  private String director;

  private byte[] cover;
}
