package com.tg.createupdate.dto;

import com.tg.createupdate.enums.MarketingPreference;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String userName;
    private String customerName;
    private MarketingPreference marketingPreference;
}
