package com.codefarm.codefarmer.service.alba;

import com.codefarm.codefarmer.repository.alba.AlbaRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class AlbaListServiceTest {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private AlbaListService albaListService;

    @Autowired
    private AlbaRepository albaRepository;


    //    곧 마감인 아르바이트
    @Test
    public void showListByRecentEndDateTest() {
        albaListService.showListByRecentEndDate().forEach(a -> log.info("곧 마감인 아르바이트 : " + a.toString()));
    }

    //    아르바이트 게시글 총 개수
    @Test
    public void showAlbaTotalCountTest() {
        log.info("아르바이트 게시글 총 개수 : " + albaListService.showAlbaTotalCount());
    }

    @Test
    public void showCountTest() {
        log.info("count : " + albaListService.showCount());
    }
    //    최신순
    @Test
    public void showListByRecentTest() {
        albaListService.showListByRecent().forEach(a -> log.info("최신순 : " + a.toString()));
    }

    //    시급순
    @Test
    public void showListByHighPayTest(Pageable pageable) {
        albaListService.showListByHighPay(pageable).forEach(a -> log.info("시급순 : " + a.getAlbaPrice()));
    }

    //    모집중
    @Test
    public void showListByGatheringListTest(Pageable pageable) {
        albaListService.showListByEndDate(pageable).forEach(a -> log.info("모집중 : " + a.toString()));
    }

    @Test
    public void albaShowAllTest(Pageable pageable){
        albaListService.albaShowAll(pageable).stream().forEach(a -> log.info("" + a));
    }
}
