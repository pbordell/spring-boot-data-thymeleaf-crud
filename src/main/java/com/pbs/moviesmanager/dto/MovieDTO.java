package com.pbs.moviesmanager.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Singular;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MovieDTO {

  private Long id;

  @NotEmpty(message = "Director cannot be null")
  private String name;

  @NotNull(message = "Year cannot be null.")
  @Min(value = 1895, message = "Year must be bigger than 1895")
  private Long year;

  @NotEmpty(message = "Director cannot be null")
  private String director;

  private MultipartFile coverMultipart;

  private byte[] cover;
}
