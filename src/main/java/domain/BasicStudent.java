package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonString jName = new JsonString(this.name);
        JsonPair name = new JsonPair("name", jName);
        JsonString jSurname = new JsonString(this.surname);
        JsonPair surname = new JsonPair("surname", jSurname);
        JsonNumber jYear = new JsonNumber(this.year);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject result = new JsonObject(name, surname, year);
        return result;
    }
}
