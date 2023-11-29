package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parent",orphanRemoval = true)
    //    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    // CascadeType.ALL을 하면 em.persist(child1),(child2)를 하지 않아도 persist됨
    // em.persist(parent)만 적어도 알아서 연관된 애들까지 persist 해줌
    private List<Child> ChildList = new ArrayList<>();

    public void addChild(Child child) {
        ChildList.add(child);
        child.setParent(this);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildList() {
        return ChildList;
    }

    public void setChildList(List<Child> childList) {
        ChildList = childList;
    }
}
