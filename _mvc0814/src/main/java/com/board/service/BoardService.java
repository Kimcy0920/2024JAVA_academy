package com.board.service;

import java.util.ArrayList;

import com.board.db.*;

public class BoardService {

    private static final int listSize = 3;
    private static final int paginationSize = 3;

    public ArrayList<BoardDto> getMsgList(int pageNo) {
       return new BoardDao().selectList((pageNo - 1) * listSize, listSize);
    }

    public ArrayList<Pagination> getPagination(int pageNo) {

        ArrayList<Pagination> pgnList = new ArrayList<Pagination>();

        int numRecords = new BoardDao().getNumRecords();
        int numPages = (int)Math.ceil((double)numRecords / listSize);
        //                      나누고 나온 몪을 ceil로 올림함.

        int firstLink = ((pageNo - 1) / paginationSize)
                        * paginationSize + 1;
        int lastLink = firstLink + paginationSize - 1;
        if (lastLink > numPages) {
            lastLink = numPages;
        }

        if (firstLink > 1) {
            pgnList.add(
                   new Pagination("이전", pageNo - paginationSize, false));
        }

        for (int i = firstLink; i <= lastLink; i++) {
            pgnList.add(new Pagination("" + i, i, i == pageNo));
        }

        if (lastLink < numPages) {
            int tmpPageNo = pageNo + paginationSize;
            if (tmpPageNo > numPages) {
                tmpPageNo = numPages;
            }
            pgnList.add(new Pagination("다음", tmpPageNo, false));
            // paginationSize보다 리스트가 더 클 경우
        }

        return pgnList;
    }


    public BoardDto getMsg(int num) {
        BoardDto dto = new BoardDao().selectOne(num, true);

        dto.setTitle(dto.getTitle().replace (" ",  "&nbsp;")); // 공백은 html공백으로
        dto.setContent(dto.getContent().replace(" ",  "&nbsp;")
                                       .replace("\n", "<br>")); // \n 줄바꿈을 html <br>태그로

        return dto;
    }

    public BoardDto getMsgForWrite(int num) {
        return new BoardDao().selectOne(num, false);
    }

    public void writeMsg(String writer, String title, String content)
            throws Exception {

        if (writer  == null || writer.length()  == 0 ||
            title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setWriter (writer );
        dto.setTitle  (title  );
        dto.setContent(content);

        new BoardDao().insertOne(dto);
    }

    public void updateMsg(
            String writer, String title, String content, int num)
                    throws Exception {

        if (writer  == null || writer.length()  == 0 ||
            title   == null || title.length()   == 0 ||
            content == null || content.length() == 0) {

           throw new Exception("모든 항목이 빈칸 없이 입력되어야 합니다.");
        }

        BoardDto dto = new BoardDto();
        dto.setNum    (num    );
        dto.setWriter (writer );
        dto.setTitle  (title  );
        dto.setContent(content);

        new BoardDao().updateOne(dto);
    }

    public void deleteMsg(int num) {
        new BoardDao().deleteOne(num);
    }
}