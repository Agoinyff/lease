package com.lease.webapp.controller.apartment;

import com.lease.common.result.Result;
import com.lease.webapp.service.ApartmentInfoService;
import com.lease.webapp.vo.apartment.ApartmentDetailVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "公寓信息")
@RequestMapping("/app/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentInfoService apartmentInfoService;

    @Operation(summary = "根据id获取公寓信息")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {

        ApartmentDetailVo apartmentDetailVo = apartmentInfoService.getDetailById(id);


        return Result.ok(apartmentDetailVo);
    }
}
