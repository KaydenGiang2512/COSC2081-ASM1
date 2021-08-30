package com.company;

public class Group {
    enum groupMethod {
        NO_GROUP,
        NUM_OF_GROUPS,
        NUM_OF_DAYS
    }

    enum metric {
        CASES,
        DEATHS,
        VACCINATED
    }

    enum resultType {
        TOTAL,
        UP_TO
    }

    public groupMethod method;
    public int groupNum = 0;

    //if there is no parameter passes, the first grouping method is procedured
    public Group() {
        this.method = groupMethod.NO_GROUP;
    }

    public Group(groupMethod method, int groupNum) {
        this.method = method;
        this.groupNum = groupNum;
    }

    //get method variable
    public groupMethod getMethod() {
        return this.method;
    }

    //get group number variable
    public int getGroupNum() {
        return this.groupNum;
    }
}
