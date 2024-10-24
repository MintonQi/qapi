package com.minton.qapi.common.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to update the status, where status must be 0 or 1.")
public class StatusUpdateRequest {

    @Min(0)
    @Max(1)
    @Schema(description = "Status value, must be either 0 or 1.", example = "1")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
