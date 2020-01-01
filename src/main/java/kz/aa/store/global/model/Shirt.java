package kz.aa.store.global.model;

import kz.aa.store.global.model.base.BaseItem;
import kz.aa.store.global.model.enumeration.ShirtType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Shirt extends BaseItem {
    @Enumerated(EnumType.ORDINAL)
    private ShirtType  shirtType;
}
