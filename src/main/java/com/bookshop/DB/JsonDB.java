package com.bookshop.DB;

import com.bookshop.Entities.Genre;
import io.jsondb.InvalidJsonDbApiUsageException;
import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.Default1Cipher;
import io.jsondb.crypto.ICipher;


public class JsonDB {
    private static JsonDBTemplate jsonDBTemplate;

    private static JsonDBTemplate getJsonDBTemplate() {
        if (jsonDBTemplate == null) {
            try {
                ICipher cipher = new Default1Cipher("1r8+24pibarAWgS85/Heeg==");
                jsonDBTemplate = new JsonDBTemplate("./", "com.bookshop.Entities", cipher);
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        return jsonDBTemplate;
    }

    public static void createCollection(Object o) {
        try {
            getJsonDBTemplate().createCollection(o.getClass());
        } catch (InvalidJsonDbApiUsageException e) {
            return;
        }
    }

    public static void insert(Object o) {
        getJsonDBTemplate().insert(o);
    }

    public static void get(String id, Class objectClass) {
        System.out.println("\n" + getJsonDBTemplate().findById(id, objectClass) +"\n");
    }

    public static void remove(Object o) {
        getJsonDBTemplate().remove(o, o.getClass());
    }
}
