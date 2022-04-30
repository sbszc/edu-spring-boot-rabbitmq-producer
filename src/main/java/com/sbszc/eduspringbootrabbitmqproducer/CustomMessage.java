package com.sbszc.eduspringbootrabbitmqproducer;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {
    private String messageId;
    private String message;
    private Date messageDate;
}
