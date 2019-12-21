package kz.aa.store.items.model;

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
    private long length;
    private long weight;

}
