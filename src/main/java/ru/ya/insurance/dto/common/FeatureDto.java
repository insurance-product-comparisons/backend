package ru.ya.insurance.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FeatureDto {
    private String featureName;
    private String featureDescription;
}
