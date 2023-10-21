package com.lld.tictactoe.main.src.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class BoardCell {
    private Integer row;
    private Integer col;
    private GameSymbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.col = column;
    }
}
