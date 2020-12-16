package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
//        if (!users.containsKey(user)) {
//            users.put(user, new ArrayList<Account>());
//        }
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        Optional<User> ret = Optional.empty();
        ret = Optional.of(users.keySet().stream()
                .filter((usr) -> usr.getPassport().equals(passport))
                .findFirst().orElse(null));
        return ret.get();
    }

    public Account findByRequisite(String passport, String requisite) {
        User findUser = findByPassport(passport);
        Optional<User> usr = Optional.empty();
        usr = Optional.of(findUser);
        Optional<Account> ret = Optional.empty();
        if (usr.isPresent()) {
            ret = Optional.of(users.get(findUser).stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst().orElse(null));
            return ret.get();
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account dstAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && dstAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            dstAcc.setBalance(dstAcc.getBalance() + amount);
            return true;
        }
        return rsl;
    }
}