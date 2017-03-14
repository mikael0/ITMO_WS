package com.mikael0.juddiclient;

/**
 * Created by mikael0 on 09.03.17.
 */
public class App {

    public static void main(String[] args) {
        SimplePublish sp = new SimplePublish();
        sp.publish();

        SimpleBrowse sb = new SimpleBrowse();
        String[] strs ={"PersonService"};
        sb.Browse(strs);
    }

}
