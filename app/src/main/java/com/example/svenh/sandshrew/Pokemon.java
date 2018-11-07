package com.example.svenh.sandshrew;

public class Pokemon {
    private int _id, stat;
    private String name, type1, type2, ability, nature;


    public Pokemon (int _id, String name, String type1, String type2, String ability, String nature, int stat){
        this._id = _id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.nature = nature;
        this.stat = stat;

    }

    public void set_id(int _id) {
            this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setStat(int stat) { this.stat = stat; }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getAbility() {
        return ability;
    }

    public String getNature() {
        return nature;
    }

    public int getStat() {
        return stat;
    }
}
