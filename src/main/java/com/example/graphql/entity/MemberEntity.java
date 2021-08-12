package com.example.graphql.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String loginId;

    private String password;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    @JoinColumn(name = "memberId", referencedColumnName = "id", insertable = false, updatable = false)
    private List<RoleEntity> roles = new ArrayList<>();

    public void addRole(RoleEntity... roleEntities){
        for (RoleEntity roleEntity : roleEntities) {
            this.roles.add(roleEntity);
            roleEntity.setMember(this);
        }
    }
}