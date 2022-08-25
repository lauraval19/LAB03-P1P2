/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) {
        //Is reported in black lists more disperse
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        List<Integer> blackListOcurrences= null;
         blackListOcurrences= hblv.checkHost("200.24.34.55",50);
        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);



       /* // Is not in any black list
        List<Integer> blackListOcurrences2=hblv.checkHost("212.24.24.55",50);
        System.out.println("The host was found in the following blacklists:"+blackListOcurrences2);*/
    }

}
