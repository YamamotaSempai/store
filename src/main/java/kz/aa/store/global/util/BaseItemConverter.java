package kz.aa.store.global.util;

import kz.aa.store.global.model.Pants;
import kz.aa.store.global.model.base.BaseItem;
import kz.aa.store.global.model.enumeration.ItemType;
import kz.aa.store.global.model.enumeration.Sex;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BaseItemConverter {

    public void convertToBaseItem(Map<String, Object> values, BaseItem source) {
        source.setId((Long) values.get("id"));
        source.setItemType(ItemType.values()[(int) values.get("item_type")]);
        source.setSex(Sex.values()[(int) values.get("sex")]);
        source.setTitle((String) values.get("title"));
    }

    public BaseItem convertToPants(Map<String, Object> values) {
        Pants pants = new Pants();
        convertToBaseItem(values, pants);
        pants.setLength((String) values.get("length"));
        pants.setWeight((String) values.get("weight"));
        return pants;
    }
}
