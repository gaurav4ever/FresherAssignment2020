package com.company;

import jdk.dynalink.Operation;

import java.security.KeyStore;
import java.security.cert.TrustAnchor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Boolean flag = Boolean.TRUE;
        operations op = new operations();
        while(flag){
            flag = op.menu();
        }
    }
}
