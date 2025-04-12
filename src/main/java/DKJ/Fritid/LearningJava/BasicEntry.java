package DKJ.Fritid.LearningJava;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.persistence.Entity;
import javax.persistence.MapKey;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;


/**
 *
 * @author danie
 */
@Entity (name="BasicEntries")
public class BasicEntry implements Serializable {

    @MapKey
    private UUID basicEntryId;
    
    private UUID BasicClassId;

    private String valueToLoad;
    public UUID GetID(){
        return basicEntryId;
    }
    public void SetId(UUID value){
        basicEntryId = value;
    }

    public UUID GetBasicClassId(){
        return BasicClassId;
    }

    public void SetBasicClassId(UUID value){
        BasicClassId = value;
    }
    public String GetValueToLoad(){
        return valueToLoad;
    }
    public void SetValueToLoad(String value){
        valueToLoad = value;
    }

    public BasicEntry() {
       basicEntryId = UUID.randomUUID();
    }
}
