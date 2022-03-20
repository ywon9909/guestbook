package org.zerock.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repositroy.GuestbookRepositroy;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepositroy guestbookRepositroy;

//    @Test
//    public void insertDummies(){
//        IntStream.rangeClosed(1,300).forEach(i->{
//            Guestbook guestbook = Guestbook.builder()
//                    .title("Title...."+i)
//                    .content("Content...."+i)
//                    .writer("user "+(i%10))
//                    .build();
//            System.out.println(guestbookRepositroy.save(guestbook));
//        });
//    }

//    @Test
//    public void updateTest(){
//        Optional<Guestbook> result = guestbookRepositroy.findById(300L);
//        if(result.isPresent()){
//            Guestbook guestbook = result.get();
//            guestbook.changeTitle("Changed Title....");
//            guestbook.changeContent("Changed Content...");
//
//            guestbookRepositroy.save(guestbook);
//        }
//    }

//    @Test
//    public void testQuery1(){
//        Pageable pageable = PageRequest.of(0,10, Sort.by("gno").descending());
//        QGuestbook qGuestbook = QGuestbook.guestbook;//Q도메인 클래스를 얻어와서 이용하면 엔티티 클래스에 선언된 title,content 같은 필드들을 변수로 활용 가능
//        String keyword = "1";
//        BooleanBuilder builder = new BooleanBuilder();//BooleanBuilder는 where문에 들어가는 조건들을 넣어주는 컨테이너
//        BooleanExpression expression = qGuestbook.title.contains(keyword);//원하는 조건은 필드 값과 같이 결합해서 생성
//        builder.and(expression);//만들어진 조건은 where문에 and/or 키워드로 결합
//        Page<Guestbook> result = guestbookRepositroy.findAll(builder,pageable);
//
//        result.stream().forEach(guestbook -> {
//            System.out.println(guestbook);
//        });
//    }

//    @Test
//    public void testQuery2(){
//        Pageable pageable = PageRequest.of(0,10,Sort.by("gno").descending());
//        QGuestbook qGuestbook = QGuestbook.guestbook;
//        String keyword = "1";
//        BooleanBuilder builder = new BooleanBuilder();
//        BooleanExpression exTitle = qGuestbook.title.contains(keyword);
//        BooleanExpression exContent = qGuestbook.content.contains(keyword);
//        BooleanExpression exWriter = qGuestbook.writer.contains("2");//writer에 2가 있는지 검색
//        BooleanExpression exAll = exTitle.or(exContent).or(exWriter);//Expression을 결합
//        builder.and(exAll);//결합한 부분은 BooleanBuilder에 추가
//        builder.and(qGuestbook.gno.gt(0L));//gno가 0보다 크다라는 조건 추가
//
//        Page<Guestbook> result = guestbookRepositroy.findAll(builder,pageable);
//        result.stream().forEach(guestbook -> {
//            System.out.println(guestbook);
//        });
//    }
}
