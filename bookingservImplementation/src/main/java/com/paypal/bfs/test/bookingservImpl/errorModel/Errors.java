package com.paypal.bfs.test.bookingservImpl.errorModel;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Errors {
    private String code;
    private String message;
}
