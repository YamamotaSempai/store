package kz.aa.store.global.model;

import kz.aa.store.global.model.base.BaseItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pants extends BaseItem {
    private String length;
    private String weight;
}
