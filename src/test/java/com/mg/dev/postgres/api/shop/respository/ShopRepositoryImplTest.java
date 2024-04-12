package com.mg.dev.postgres.api.shop.respository;

import com.mg.dev.postgres.api.shop.dto.ShopReqDto;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ShopRepositoryImplTest {

    @Autowired
    ShopRepositoryImpl shopRepository;

    /**
     * dto 가 null 일 경우 동작 테스트
     */
    @Test
    void excepitonTest() {
//        ShopReqDto shopReqDto = ShopReqDto.builder()
//                .name("")
//                .addr("")
//                .number("")
//                .city("")
//                .build();

        // dot 가 null 일 경우
        ShopReqDto shopReqDto = ShopReqDto.builder().build();
        log.info("ShopReqDto log={}", shopReqDto);

        shopRepository.shopEntityList(shopReqDto);
//        try {
//            shopRepository.shopEntityList(shopReqDto);
//            log.info("정상");
//        }catch (IllegalArgumentException e){
//            log.info("오류");
//            Assertions.assertThrows(IllegalArgumentException.class,
//                    () -> shopRepository.shopEntityList(shopReqDto));
//        }

    }

}