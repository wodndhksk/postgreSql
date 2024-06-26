package com.mg.dev.postgres.api.postgresql;

import com.mg.dev.postgres.api.postgresql.service.PostgresService;
import com.mg.dev.postgres.dto.PostgresqlDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class PostgresController {
    private final PostgresService postgresService;

    /**
     * 테스트 데이터 insert
     */
    @PostConstruct
    public void testInsert() {
        List<PostgresqlDto> list = new ArrayList<>();
        int max = 10;
        String testNm = "test-";
        String testTitle = "TEST TITLE-";

        for(int i=0; i<max; i++){
            PostgresqlDto dto = PostgresqlDto.builder()
                    .num(i)
                    .title(testTitle + i)
                    .name(testNm + i)
                    .description(UUID.randomUUID().toString())
                    .build();
            list.add(dto);
        }
        postgresService.insert(list);
    }

    @GetMapping("")
    public String index() {
        return "ok";
    }

    @GetMapping("/search")
    public List<PostgresqlDto> search() {
        return postgresService.search();
    }



}
