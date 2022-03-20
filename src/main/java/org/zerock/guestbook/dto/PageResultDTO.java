package org.zerock.guestbook.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<DTO, EN> {

    private List<DTO> dtoList;//DTO 리스트
    private int totalPage;//총 페이지 번호
    private int page;//현재 페이지 번호
    private int size;//목록 사이즈
    private int start, end;//시작,끝 페이지 번호
    private boolean prev, next;//이전, 다음
    private List<Integer> pageList;//페이지 번호 목록


    public PageResultDTO(Page<EN> result, Function<EN, DTO> fn){//엔티티 객체들을 DTO로 변환해 주는 기능
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber()+1;//0부터 시작하므로 +1
        this.size = pageable.getPageSize();

        int tempEnd = (int)(Math.ceil(page/10.0))*10; //끝번호를 먼저 계산(10페이지씩 보인다고 가정)
        start = tempEnd-9;//10개씩 보여준다면 시작번호는 무조건 끝 번호-9
        prev = start>1;//시작이 1보다 크다면 존재
        end = totalPage > tempEnd ? tempEnd: totalPage;//총페이지가 끝번호보다 작다면 end는 총페이지
        next = totalPage >tempEnd;//총 페이지가 끝번호보다 큰 경우 존재

        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
