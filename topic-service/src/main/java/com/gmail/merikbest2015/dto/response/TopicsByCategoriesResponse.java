package com.gmail.merikbest2015.dto.response;

import com.gmail.merikbest2015.repository.projection.TopicProjection;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopicsByCategoriesResponse {
    private String topicCategory;
    private List<TopicProjection> topicsByCategories;
}