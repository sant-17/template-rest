package io.swagger.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDataModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("category")
    private Category category;

    @JsonProperty("name")
    private String name;

    @JsonProperty("photoUrls")
    private List<String> photoUrls;

    @JsonProperty("tags")
    private List<Tags> tags;

    @JsonProperty("status")
    private String status;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category {

        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tags {

        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;
    }
}
