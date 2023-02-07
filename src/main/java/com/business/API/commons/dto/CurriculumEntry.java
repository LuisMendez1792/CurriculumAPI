package com.business.API.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumEntry {

    private String fullName;

    private String university;

    private String career;

    private String address;
}
