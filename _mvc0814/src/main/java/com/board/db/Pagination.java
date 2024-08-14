package com.board.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pagination {
    
    private String display; // 화면에 보여지는것
    private int pageNo;  // 페이지번호
    private boolean curPage; // 현재 페이지인지 아닌지 여부

}
