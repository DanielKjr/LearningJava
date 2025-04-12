/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DKJ.Fritid.LearningJava;

import java.io.Serializable;

import javax.persistence.Entity;

import java.util.*;

import javax.persistence.OneToMany;
/**
 *
 * @author danie
 */
@Entity (name="BasicClasses")
public class BasicClass implements Serializable{
    
public UUID BasicClassId;

public String TestField;

public int Refnr;

@OneToMany
public Collection<BasicEntry> BasicEntries;
public Date Oprettet;

public BasicClass(String testField, int refnr) {
    super();
    BasicClassId = UUID.randomUUID();
    TestField = testField;
    Refnr = refnr;
    
  
}
}
