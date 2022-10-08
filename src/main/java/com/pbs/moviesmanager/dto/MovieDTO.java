package com.pbs.moviesmanager.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MovieDTO {

  private Long id;

  @NotEmpty
  private String name;

  @NotEmpty
  private String year;

  @NotEmpty
  private String director;

  private MultipartFile coverMultipart;

  private byte[] cover;
}
