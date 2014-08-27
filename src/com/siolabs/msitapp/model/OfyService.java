package com.siolabs.msitapp.model;

import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.*;


public class OfyService {
    static {
        factory().register(StudentMarksEntity.class);
        factory().register(StudentAttendanceEntity.class);
               
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}