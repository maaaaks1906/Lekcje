package com.company.Zadania.library;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {

    private List<Lend> lends;

    public Member(String firstName, String lastName, String login, String password) {
        super(firstName, lastName, login, password);
        this.lends = new ArrayList<>();
    }

    public List<Lend> getLends() {
        return lends;
    }

    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }

    public void displayMemberLendList() {
        for (int i = 0; i < lends.size(); i++) {
            System.out.println((i + 1) + ". " + lends.get(i).getBook());
        }
    }

    @Override
    public String toString() {
        return super.toString(); // super - odnosi sie do klasy, którą dziedziczy
    }
}
