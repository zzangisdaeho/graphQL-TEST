package com.example.graphql.dto;

import com.example.graphql.entity.RoleEntity;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Integer id;

    private String role;

    public static List<RoleDto> from(Collection<RoleEntity> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream().map(RoleDto::from).collect(Collectors.toList());
    }

    public static RoleDto from(RoleEntity entity) {
        return RoleDto.builder()
                .id(entity.getId())
                .role(entity.getRole())
                .build();
    }
}
