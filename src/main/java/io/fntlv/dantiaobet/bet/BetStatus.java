package io.fntlv.dantiaobet.bet;

public enum BetStatus {

    TOWARD("进行中"),
    END("结束");

    private String name;

    BetStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
