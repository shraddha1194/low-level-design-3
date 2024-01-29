package com.example.expensemanagementsystem.strategies;

import com.example.expensemanagementsystem.dto.SettleUpTransaction;
import com.example.expensemanagementsystem.models.Expense;
import com.example.expensemanagementsystem.models.User;
import com.example.expensemanagementsystem.models.UserExpense;
import org.springframework.data.util.Pair;

import java.util.*;

public class GreedySettlementStrategy implements SettlementStrategy {
    @Override
    public List<SettleUpTransaction> settleUp(List<Expense> expense) {
        // Calculate the net balance from expenses
        Map<Long, Double> initialState = calculateNetBalance(expense);
        TreeSet<Pair<Long, Double>> heap = new TreeSet<>((left, right) -> (int) (left.getSecond() - right.getSecond()));

        for (Map.Entry<Long, Double> entry : initialState.entrySet()) {
            heap.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        List<SettleUpTransaction> transactions = new ArrayList<>();

        while (heap.size() > 1) {
            Pair<Long, Double> smallestPair = heap.last();
            Pair<Long, Double> largestPair = heap.first();

            // create a settle up transaction
            SettleUpTransaction transaction = SettleUpTransaction.builder()
                    .from(smallestPair.getFirst())
                    .to(largestPair.getFirst())
                    .amount(smallestPair.getSecond())
                    .build();

            heap.remove(smallestPair);
            heap.remove(largestPair);

            // calculate for the underflow and overflow
            heap.add(Pair.of(largestPair.getFirst(), largestPair.getSecond() - smallestPair.getSecond()));
            transactions.add(transaction);
        }
        return transactions;

    }

    private static Map<Long, Double> calculateNetBalance(List<Expense> expenses) {
        Map<Long, Double> transactions = new HashMap<>();
        for (Expense expense: expenses) {
            // Owed By
            for (UserExpense userExpense : expense.getOwedBy()) {
                User user = userExpense.getUser();
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) - userExpense.getAmount());
            }
            // Paid By
            for (UserExpense userExpense: expense.getPaidBy()) {
                User user = userExpense.getUser();
                if (!transactions.containsKey(user.getId())) {
                    transactions.put(user.getId(), 0.0);
                }

                transactions.put(user.getId(), transactions.get(user.getId()) + userExpense.getAmount());

            }
        }
        return transactions;
    }
}
