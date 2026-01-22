package com.lease.webadmin.controller.apartment;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lease.common.result.Result;
import com.lease.model.entity.PaymentType;
import com.lease.webadmin.service.PaymentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "支付方式管理")
@RequestMapping("/admin/payment")
@RestController // 等价于使用 @Controller + @ResponseBody
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "查询全部支付方式列表")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {
        // LambdaQueryWrapper<PaymentType> paymentTypeLambdaQueryWrapper = new
        // LambdaQueryWrapper<>();
        // paymentTypeLambdaQueryWrapper.eq(PaymentType::getIsDeleted,0);
        // 配置了逻辑删除之后，上面的过滤条件就不再需要了
        List<PaymentType> list = paymentTypeService.list();

        return Result.ok(list);
    }

    @Operation(summary = "保存或更新支付方式")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        paymentTypeService.saveOrUpdate(paymentType);
        return Result.ok();
    }

    @Operation(summary = "根据ID删除支付方式")
    @DeleteMapping("deleteById")
    public Result deletePaymentById(@RequestParam Long id) {
        paymentTypeService.removeById(id);
        return Result.ok();
    }

}
