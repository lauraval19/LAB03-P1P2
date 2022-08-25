package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;
import java.util.List;

public class MyBlackListValidator extends Thread{

    private int start;
    private int end;
    private HostBlacklistsDataSourceFacade skds;
    private Integer badOcurrences;
    private Integer badOcurr = 0;
    private String ipAdress;
    private static final int ALARM_COUNT = 5;
    private List<Integer> blackList;

    private int checkedListsCount;



    public MyBlackListValidator(int start, int end, HostBlacklistsDataSourceFacade skds, String ipAdress) {
        this.start = start;
        this.end = end;
        this.skds = skds;
        this.badOcurrences = 0;
        this.ipAdress = ipAdress;
        this.blackList = new LinkedList<>();
        this.checkedListsCount = 0;
    }

    public void run(){
        synchronized (blackList){
            synchronized (badOcurr){
                for (int i =start; this.badOcurrences < ALARM_COUNT && i < this.end; i++) {
                    checkedListsCount++;
                    if (skds.isInBlackListServer(i, ipAdress)){

                        this.blackList.add(i);

                        this.badOcurrences += 1;
                        badOcurr =+ 1;

                    }
                }
                try {
                    if(badOcurr == HostBlackListsValidator.getAlarmCount()){
                        blackList.wait();
                    }
                }catch(InterruptedException e){
                    System.out.println("Error");
                }

            }
        }

    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public HostBlacklistsDataSourceFacade getSkds() {
        return skds;
    }

    public int getBadOcurrences() {
        return badOcurrences;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public List<Integer> getBlackList() {
        return blackList;
    }

    public int getCheckedListsCount() {
        return checkedListsCount;
    }
}
