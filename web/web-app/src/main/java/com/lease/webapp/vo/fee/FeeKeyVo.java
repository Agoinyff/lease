package com.lease.webapp.vo.fee;


import com.lease.model.entity.FeeKey;
import com.lease.model.entity.FeeValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;


@Data
public class FeeKeyVo extends FeeKey {

    private List<FeeValue> feeValueList;
}
