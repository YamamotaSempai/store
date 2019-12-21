package kz.aa.store.items.model;

import kz.aa.store.items.model.enumeration.ItemType;
import kz.aa.store.items.model.enumeration.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity(name = "base_entity")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private ItemType itemType;
    private Sex sex;
}
